var hardModule = angular.module("hardModule", []);
hardModule.controller("cpu", [ "$http", "$scope", function($http, $scope) {
	$scope.checkCPU = function() {
		$http({
			method : "GET",
			url : 'hard/cpu'
		}).then(function successCallBack(response) {
			$scope.cpus = response.data;
			var rate=($scope.cpus*100).toFixed(2);
			
			var myChart = echarts.init(document.getElementById('cpu'));
			var option = {
					tooltip : {
						formatter : "{a} <br/>{b} : {c}%"
					},
					toolbox : {
						feature : {
							restore : {},
							saveAsImage : {}
						}
					},
					series : [
						{
							name : 'CPU',
							type : 'gauge',
							detail : {
								formatter : '{value}%'
							},
							data : [ {
								value : rate,
								name : 'CPU总体运行情况'
							} ]
						}
					]
				};
			myChart.setOption(option);
		}, function errorCallBack(response) {
		});
	}
	setInterval($scope.checkCPU,1000);
} ]);
hardModule.controller("cpus", [ "$http", "$scope", function($http, $scope) {
	$http({
		method : "GET",
		url : 'hard/cpus'
	}).then(function successCallBack(response) {
		$scope.cpus = response.data;
	}, function errorCallBack(response) {
	});
} ]);
hardModule.controller("disk", [ "$http", "$scope", function($http, $scope) {
	$http({
		method : "GET",
		url : 'hard/disk'
	}).then(function successCallBack(response) {
		$scope.cpus = response.data;
	}, function errorCallBack(response) {
	});
} ]);
hardModule.controller("memory", [ "$http", "$scope", function($http, $scope) {
	$http({
		method : "GET",
		url : 'hard/memory'
	}).then(function successCallBack(response) {
		$scope.cpus = response.data;
	}, function errorCallBack(response) {
	});
} ]);
hardModule.controller("swap", [ "$http", "$scope", function($http, $scope) {
	$http({
		method : "GET",
		url : 'hard/swap'
	}).then(function successCallBack(response) {
		$scope.cpus = response.data;
	}, function errorCallBack(response) {
	});
} ]);
