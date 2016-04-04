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
    var serviceBase = 'api/v1/';
    var obj = {};
    obj.newGame = function () {
        return $http.get(serviceBase + 'newGame');
    };
    obj.getPlayerHand = function () {
        return $http.get(serviceBase + 'getPlayerHand');
    };
    obj.getDealerHand = function (check) {
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
        return $http.get(serviceBase + 'getBalance');
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
app.controller('gameCtrl', function ($scope, $http, $location, $timeout, services, ngAudio) {

    //
    //Initialization
    //
    $scope.currentPath = $location.path();
    $scope.bjcheck = 0;
    $scope.previousWin = 0;
    $scope.switcher = false;
    $scope.sound = ngAudio.load("assets/deckDeal.mp3"); // returns NgAudioObject
    //
    //Dealer/Player Functions
    //
    $scope.getPlayerTotal = function () {
        services.getPlayerTotal().then(function (data) {
            $scope.playerTotal = data.data.total;
        });
    };
    $scope.getDealerTotal = function () {
        services.getDealerTotal().then(function (data) {
            $scope.dealerTotal = data.data.total;
        });
    };
    $scope.getPlayerHand = function () {
        services.getPlayerHand().then(function (data) {
            $scope.getOptions();
            if (data && data.data && data.data.player && data.data.player.hand) {
                $scope.player = data.data.player.hand;
            } else {
                services.getPlayerHand().then(function (data) {
                    $scope.player = data.data.player.hand;
                });
            }
            var keys = Object.keys($scope.player).length;
            $scope.shouldAnimate = keys;
        });
    };
    $scope.getDealerHand = function (input) {
        services.getDealerHand(input).then(function (data) {
            $scope.dealer = data.data.dealer.hand;

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
            $scope.getBalance();
            $scope.refreshDealer();
            $scope.sound.play();
        });
    };
    $scope.playerStand = function () {
        services.playerStand().then(function () {
            $scope.refreshPlayer();
            $scope.refreshDealer();
            $scope.refreshGame();
            $scope.getBalance();
            $scope.sound.play();
        });
    };
    //
    //Pre-Game Functions
    //
    $scope.getPreviousWin = function () {
        services.previousWin().then(function (data) {
            $scope.previousWin = data.data.previous;
        });
    };
    $scope.newGame = function () {
        services.newGame().then(function () {
            $scope.sound.play();
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
        $scope.getGameHash();
        $scope.showPlayerSecret();
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
            $scope.gameWinner = data.data.response;
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
        $scope.betAmount += input;

        if ($scope.betAmount === input) {
            alert("Please lower your bet");
        } else {
            if ($scope.betAmount > 1000) {
                $scope.betAmount = 1000;
            }
            if ($scope.betAmount > $scope.balance) {
                $scope.betAmount = $scope.balance;
            }
            services.setPlayerBet($scope.betAmount).then(function (data) {
                $scope.getPlayerBet();
            });
        }

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
            $scope.betAmount = 1;
        }
        services.setPlayerBet($scope.betAmount).then(function () {
            $scope.getPlayerBet();
        });
    };
    //
    //If someone refreshes the page angular doesn't persist it's
    //Scope so we need to recall these functions.
    //
    $scope.refreshPlayer();
    $scope.refreshDealer();
    $scope.refreshGame();
});
app.config(['$routeProvider', '$locationProvider',
    function ($routeProvider, $locationProvider) {
        $routeProvider.when('/', {
            title: 'Home',
            templateUrl: 'Web Pages/index.html',
            controller: 'homeCtrl'
        }).when('/game', {
                title: 'Welcome to Blackjack',
                templateUrl: 'Web Pages/game.xhtml',
                controller: 'gameCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
        if (window.history && window.history.pushState) {

            $locationProvider.html5Mode(true);
        }
    }
]);
