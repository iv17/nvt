(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('UserController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		'$stateParams', '$log', '$window','toastr',  '$localStorage',
		function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

		var userId = $stateParams.userId;

		UserResource.getUserById(userId)
		.then(function(item) {
			$scope.user = item;
		});

    UserResource.getUserRealEstates(userId)
		.then(function(items) {
			$scope.userRealEstates = items;
			$scope.numRealEstates = items.length;
		});

		UserResource.getUserComments(userId)
		.then(function(items) {
			$scope.numComments = items.length;
		});

		UserResource.getUserRatings(userId)
		.then(function(items) {
			$scope.numRatings = items.length;
		});

		UserResource.getUserReports(userId)
		.then(function(items) {
			$scope.numReports = items.length;
		});

	}
	]);
})();
