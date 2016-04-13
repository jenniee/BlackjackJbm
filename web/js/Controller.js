var app = angular.module('blackjack', ['ui.bootstrap', 'ngRoute', 'ngAudio']);

app.directive('ngRightClick', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngRightClick);
        element.bind('contextmenu', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});


app.factory("login", ['$http', function ($http) {
        var serviceBase = 'api/v1/login/';
        var obj = {};
        obj.isLoggedIn = function () {
            return $http.get(serviceBase + 'getLoggedIn');
        };
        obj.doLogin = function() {
            return $http.get(serviceBase + 'doLogin');
        };
        obj.registerNewUser = function(username, password) {
            return $http.get(serviceBase + 'registerNewUser?username=' + username + '&password=' + password );
        };
        obj.loginWithParams = function(username, password) {
            return $http.get(serviceBase + 'loginWithParams?username=' + username + '&password=' + password );
        };
        return obj;
    }]);

app.factory("services", ['$http', function ($http) {
        var serviceBase = 'api/v1/newGame/';
        var obj = {};
        obj.newGame = function (username) {
            return $http.get(serviceBase + 'startNewGame?username=' + username);
        };
        obj.newHand = function (username) {
            return $http.get(serviceBase + 'startNewHand?username=' + username);
        };
        obj.getPlayerHand = function () {
            return $http.get(serviceBase + 'getPlayerHand');
        };
        obj.getDealerHand = function () {
            return $http.get(serviceBase + 'getDealerHand');
        };
        obj.getPlayerCard = function () {
            return $http.get(serviceBase + 'getPlayerCard');
        };
        obj.getPlayerTotal = function () {
            return $http.get(serviceBase + 'getPlayerTotal');
        };
        obj.getDealerTotal = function () {
            return $http.get(serviceBase + 'getDealerTotal');
        };
        obj.playerStand = function () {
            return $http.get(serviceBase + 'playerStand');
        };
        obj.getOptions = function () {
            return $http.get(serviceBase + 'returnOptions');
        };
        obj.processGame = function (username) {
            return $http.get(serviceBase + 'processGame?username=' + username);
        };
        obj.getBalance = function () {
            return $http.get(serviceBase + 'getPlayerBalance');
        };
        obj.getPlayerBet = function () {
            return $http.get(serviceBase + 'getPlayerBet');
        };
        obj.setPlayerBet = function (input) {
            return $http.get(serviceBase + 'setBetAmount?betamount=' + input);
        };
        obj.setBalance = function (username) {
            return $http.get(serviceBase + 'setBalance?username=' + username);
        };
        obj.previousWin = function () {
            return $http.get(serviceBase + 'getPreviousWin');
        };
        obj.resetChips = function () {
            return $http.get(serviceBase + 'resetChips');
        };
        obj.doubleDown = function () {
            return $http.get(serviceBase + 'playerDoubleDown');
        };
        return obj;
    }]);

app.filter('lengthObj', function () {
    return function (input) {
        if (input !== null) {
            var keys = Object.keys(input);
            var len = keys.length;
        } else {
            len = 0;
        }
        return len;
    };
});

app.controller('homeCtrl', function ($scope, $http, $location, services, login) {
    
    $scope.currentPath = $location.path();
    $scope.hasTried = false;
    $scope.loggedInUsername = "";
    
    $scope.startNewGame = function (username) {
        services.newGame(username).then(function (data) {
            $location.path("/game");
        });
    };
    
    $scope.doLogin = function() {
        login.doLogin().then(function(data) {
            console.log(data.data);
        });
    };
    
    $scope.registerNewUser = function(username, password) {
        login.registerNewUser(username, password).then(function(data) {
            console.log(data.data);
            $scope.hasTried = true;
            $scope.registerUserSuccess = data.data.registered;
        });
    };
    
    $scope.loginWithParams = function(username, password) {
        login.loginWithParams(username, password).then(function(data) {
            console.log(data.data);
            $scope.loggedInSuccess = data.data.loggedIn;

            if($scope.loggedInSuccess === true) {
                $scope.isLoggedIn = true;
            } else {
                $scope.isLoggedIn = false;
            }
            $scope.checkIfLoggedIn();
        });
    };
    $scope.checkIfLoggedIn = function() {
        login.isLoggedIn().then(function(data) {
        $scope.isLoggedIn = data.data.loggedIn;
        $scope.loggedInUsername = data.data.username;
    });  
    };

$scope.checkIfLoggedIn();
    

    
});
app.controller('gameCtrl', function ($scope, $location, $window, services, login) {

    services.getPlayerTotal().then(function () {
    }, function () {
        $window.location.href = "";
    });

    $scope.doubleDown = function () {
        services.doubleDown().then(function () {
            $scope.refreshPlayer();
            $scope.refreshGame();
            $scope.getPlayerBet();
            $scope.getBalance();
            $scope.refreshDealer();
        });
    };

    //
    //Initialization
    //
    $scope.currentPath = $location.path();
    $scope.bjcheck = 0;
    $scope.previousWin = 0;
    $scope.switcher = false;

    //
    //Dealer/Player Functions
    //
    $scope.getPlayerTotal = function () {
        services.getPlayerTotal().then(function (data) {
            $scope.playerTotal = parseInt(data.data.total);
        });
    };
    $scope.getDealerTotal = function () {
        services.getDealerTotal().then(function (data) {
            $scope.dealerTotal = parseInt(data.data.total);
        });
    };
    $scope.getPlayerHand = function () {
        services.getPlayerHand().then(function (data) {
            $scope.getOptions();
            if (data && data.data && data.data.hand) {
                $scope.player = data.data.hand;
            } else {
                services.getPlayerHand().then(function (data) {
                    $scope.player = data.data.hand;
                });
            }
            var keys = Object.keys($scope.player).length;
            $scope.shouldAnimate = keys;
        });
    };
    $scope.getDealerHand = function (input) {
        services.getDealerHand(input).then(function (data) {
            $scope.dealer = data.data.hand;
            var keys = Object.keys($scope.dealer).length;
            $scope.shouldAnimateD = keys;
        });
    };
    //
    //Player -> Dealer Functions
    //
    $scope.getPlayerCard = function () {

        services.getPlayerCard().then(function () {
            $scope.refreshPlayer();
            $scope.refreshGame();
            $scope.getPlayerBet();
            $scope.getBalance();
            $scope.refreshDealer();
        });         
    };
    $scope.playerStand = function () {
        services.playerStand().then(function () {
            $scope.refreshPlayer();
            $scope.refreshDealer();
            $scope.refreshGame();
            $scope.getBalance();
            $scope.getPreviousWin();
            $scope.getPlayerBet();
        });
    };
    //
    //Pre-Game Functions
    //
    $scope.getPreviousWin = function () {
        services.previousWin().then(function (data) {
            $scope.previousWin = data.data.pwin;
        });
    };
    $scope.newGame = function () {
        services.newGame().then(function () {
            $scope.refreshGame();
            $scope.refreshPlayer();
            $scope.refreshDealer();
        });
    };
    //
    //Post-Game Functions
    //
    $scope.refreshPlayer = function () {
        $scope.getPlayerHand();
        $scope.getPlayerTotal();
        $scope.getBalance();
        $scope.getPlayerBet();
    };
    $scope.refreshDealer = function () {
        $scope.getDealerHand();
        $scope.getDealerTotal();
    };
    $scope.refreshGame = function () {
        $scope.getPlayerBet();
        $scope.getOptions();
        $scope.processGame();
        $scope.getPreviousWin();
    };
    //
    //Blackjack, Winner, Bust, and Process the Game functions
    //
    $scope.getOptions = function () {
        services.getOptions().then(function (data) {
            $scope.doWhat = data.data.option;
        });
    };
    $scope.processGame = function () {
        services.processGame($scope.loggedInUsername).then(function (data) {
            $scope.gameWinner = data.data;
            console.log($scope.gameWinner);
            console.log($scope.gameWinner.handcheck[2].message);
            if($scope.gameWinner.handcheck[2].message === "true") {
                services.setBalance($scope.loggedInUsername).then(function() {
                    console.log("balance has been set");
                });
            } else {
                 console.log("balance has not been set");
            }
            $scope.getPlayerBet();
        });
    };
    //
    //Player Bank Functions
    //
    $scope.getBalance = function () {
        services.getBalance().then(function (data) {
            $scope.balance = data.data.balance;
        });
    };
    $scope.getPlayerBet = function () {
        services.getPlayerBet().then(function (data) {
            if($scope.doWhat === "newhand" && $scope.balance < 1) {
                $scope.betAmount = $scope.balance;
            } else {
            $scope.betAmount = data.data.bet;
            }
              
        });
    };
    $scope.addToBet = function (input) {
        $scope.getBalance();
        $scope.getPlayerBet();
        $scope.betAmount = parseFloat($scope.betAmount);
        $scope.balance = parseFloat($scope.balance);
        $scope.check = $scope.gameWinner.handcheck[0].handcheck;

        $scope.betAmount += input;


        services.setPlayerBet($scope.betAmount).then(function () {
            $scope.getPlayerBet();
        });
    };

    $scope.resetChips = function () {
        services.resetChips().then(function () {
            $scope.getBalance();
        });
    };
    $scope.removeFromBet = function (input) {
        $scope.betAmount -= input;
        if ($scope.betAmount < 0) {
            $scope.betAmount = 0;
        }
        if ($scope.betAmount > $scope.balance) {
            $scope.betAmount = 0;
        }
        if ($scope.balance > 0 && $scope.betAmount < 1) {
            $scope.betAmount = 0;
        }
        services.setPlayerBet($scope.betAmount).then(function () {
            $scope.getPlayerBet();
        });
    };
    //
    //If someone refreshes the page angular doesn't persist it's
    //Scope so we need to recall these functions.
    //

    $scope.newHand = function () {
        services.newHand($scope.loggedInUsername).then(function () {
            $scope.refreshGame();
            $scope.refreshPlayer();
            $scope.refreshDealer();
        });
    };
    
    $scope.checkIfLoggedIn = function() {
        login.isLoggedIn().then(function(data) {
        $scope.isLoggedIn = data.data.loggedIn;
        $scope.loggedInUsername = data.data.username;
    });  
    };

$scope.checkIfLoggedIn();

    $scope.refreshGame();
    $scope.refreshPlayer();
    $scope.refreshDealer();
    $scope.refreshGame();
});
app.config(['$routeProvider', '$locationProvider',
    function ($routeProvider, $locationProvider) {
        $routeProvider.when('/', {
            title: 'Home',
            templateUrl: 'home.html',
            controller: 'homeCtrl'
        })
        .when('/game', {
            title: 'Welcome to Blackjack',
            templateUrl: 'game.html',
            controller: 'gameCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
        if (window.history && window.history.pushState) {

            $locationProvider.html5Mode(false);
        }
    }
]);
