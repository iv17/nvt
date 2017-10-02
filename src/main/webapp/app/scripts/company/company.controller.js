(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('CompanyController', ['$scope', '$rootScope', '$state', '_', 'CompanyResource',
		'$stateParams', '$log', '$window','toastr',  '$localStorage',
		function($scope, $rootScope, $state, _, CompanyResource, $stateParams, $log, $window,
				toastr, $localStorage) {

		var companyId = $stateParams.companyId;

		CompanyResource.getCompany(companyId)
		.then(function(item) {
			$scope.company = item;
		});

		CompanyResource.getCompanyAgents(companyId)
		.then(function(items) {
			$scope.companyAgents = items;
			$scope.numAgents = items.length;
		});

    CompanyResource.getCompanyRealEstates(companyId)
		.then(function(items) {
			$scope.companyRealEstates = items;
			$scope.numRealEstates = items.length;
		});

		CompanyResource.getCompanyRatings(companyId)
		.then(function(items) {
			$scope.numRatings = items.length;
		});


	}
	]);
})();
