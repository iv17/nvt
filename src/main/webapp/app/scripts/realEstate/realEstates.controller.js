(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('RealEstatesController', ['$scope', '$state', '_', 'RealEstateResource', '$log',
		function($scope, $state, _, RealEstateResource, $log) {

		RealEstateResource.getRealEstates().then(function(items) {
			$scope.realEstates = items;
		});

	}
	]);
})();
