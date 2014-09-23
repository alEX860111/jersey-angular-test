var app = angular.module("myapp", []);

app.controller("myctrl", function($scope, $http) {
	$http.get("/testapp/rest/products").success(function(products) {
		$scope.products = products;
	});
});