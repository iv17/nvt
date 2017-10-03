(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('NavBarController', ['$scope', '$rootScope', '$state', '_', 'CompanyResource',
		'$stateParams', '$log', '$window','toastr',  '$localStorage',
		function($scope, $rootScope, $state, _, CompanyResource, $stateParams, $log, $window,
				toastr, $localStorage) {

		$scope.loggedUser = $rootScope.loggedUser;
		CompanyResource.getCompanies()
		.then(function(items) {
			$scope.companies = items;
		});

	}
	]);
})();
