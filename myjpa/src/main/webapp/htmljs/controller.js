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
userModule.controller("login", [ "$http", "$scope", "$location",function($http, $scope,$location) {
	$scope.user = {
		"userName" : "QQ",
		"userPassword" : "adminadmin"
	};
	$scope.login = function() {
		$http({
			method : "POST",
			url : 'ju/login',
			data : $scope.user
		}).then(function successCallBack(response) {
			$location.path("/findAll");
		}, function errorCallBack(response) {
			alert(response);
		});
	}
} ]);