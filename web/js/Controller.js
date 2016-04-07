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

app.factory("services", ['$http', function ($http) {
        var serviceBase = 'api/v1/newGame/';
        var obj = {};
        obj.newGame = function () {
            return $http.get(serviceBase + 'startNewGame');
        };
        obj.newHand = function () {
            return $http.get(serviceBase + 'startNewHand');
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
        obj.processGame = function () {
            return $http.get(serviceBase + 'processGame');
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

app.controller('homeCtrl', function ($scope, $http, $location, services) {
    $scope.currentPath = $location.path();
    $scope.startNewGame = function () {
        services.newGame().then(function () {
            $location.path("/game");
        });
    };
});
app.controller('gameCtrl', function ($scope, $location, $window, services) {



    services.getPlayerTotal().then(function () {
    }, function () {
        $window.location.href = "";
    });

$scope.doubleDown = function() {
        services.doubleDown().then(function() {
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
            $scope.getPlayerBet();
            $scope.getBalance();
            $scope.getPreviousWin();
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
        services.processGame().then(function (data) {
            $scope.gameWinner = data.data;

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
            $scope.betAmount = data.data.bet;
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
        services.newHand().then(function () {
            $scope.refreshGame();
            $scope.refreshPlayer();
            $scope.refreshDealer();
        });
    };

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
        }).when('/game', {
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
