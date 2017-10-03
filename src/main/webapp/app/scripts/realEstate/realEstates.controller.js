(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('RealEstatesController', ['$scope', '$rootScope', '$state', '_', 'RealEstateResource', '$log',
		function($scope, $rootScope, $state, _, RealEstateResource, $log) {

		RealEstateResource.getRealEstates().then(function(items) {
			$scope.realEstates = items;
		});

	}
	]);
})();
