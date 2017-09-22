(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('SearchController', ['$scope', '$state', '_', 'RealEstateResource', '$log', '$stateParams',
		function($scope, $state, _, RealEstateResource, $log, $stateParams) {

		var selectedZipCodes = $stateParams.search.selectedZipCodes;
		var selectedCities = $stateParams.search.selectedCities;
		var selectedBlocks = $stateParams.search.selectedBlocks;
		var selectedAdvertisementTypes = $stateParams.search.selectedAdvertisementTypes;
		var selectedRealEstateTypes = $stateParams.search.realEstateTypes;
		var minPrice = $stateParams.search.minPrice;
		var maxPrice = $stateParams.search.maxPrice;
		var minSurface = $stateParams.search.minSurface;
		var maxSurface = $stateParams.search.maxSurface;

	}
	]);
})();
