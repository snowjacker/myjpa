var userModule = angular.module("userModule", []);
userModule.controller("findAll", [ "$http", "$scope", function($http, $scope) {
    $http({
        method : "GET",
        url : 'ju/findAll'
    }).then(function successCallBack(response) {
        $scope.users = response.data;
    }, function errorCallBack(response) {
    });
} ]);