var myApp=angular.module("myApp",["ngRoute","ngAnimate"]);
myApp.config(function ($routeProvider) {
    $routeProvider
        .when('/reg',{
            templateUrl:'user/reg',
        })
        .when('/login',{
            templateUrl:'user/tologin',
        })
        .when('/cpu',{
            templateUrl:'tocpu',
        })
        .when('/cpus',{
            templateUrl:'tocpus',
        })
        .when('/disk',{
            templateUrl:'todisk',
        })
        .when('/memory',{
            templateUrl:'tomem',
        })
        .when('/swap',{
            templateUrl:'toswap',
        })
        .otherwise({
            redirectTo:'/login'
        })
});