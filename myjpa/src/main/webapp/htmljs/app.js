var myApp=angular.module("myApp",["userModule","ngRoute","ngAnimate"]);
myApp.config(function ($routeProvider) {
    $routeProvider
        .when('/findAll',{
            templateUrl:'html/allUser.html',
            controller:"findAll"
        })
         .when('/login',{
            templateUrl:'html/login.html'
        })
        .otherwise({
            redirectTo:'/findAll'
        })
});