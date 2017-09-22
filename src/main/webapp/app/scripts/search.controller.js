(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('SearchController', ['$scope', '$state', '_', 'RealEstateResource', '$log', '$stateParams',
		'toastr',
		function($scope, $state, _, RealEstateResource, $log, $stateParams, toastr) {

		var selectedZipCodes = $stateParams.search.selectedZipCodes;
		var selectedCities = $stateParams.search.selectedCities;
		var selectedBlocks = $stateParams.search.selectedBlocks;
		var selectedAdvertisementTypes = $stateParams.search.selectedAdvertisementTypes;
		var selectedRealEstateTypes = $stateParams.search.selectedRealEstateTypes;
		var minPrice = $stateParams.search.minPrice;
		var maxPrice = $stateParams.search.maxPrice;
		var minSurface = $stateParams.search.minSurface;
		var maxSurface = $stateParams.search.maxSurface;


		var search = {
			selectedZipCodes: selectedZipCodes,
			selectedCities: selectedCities,
			selectedBlocks: selectedBlocks,
			selectedAdvertisementTypes: selectedAdvertisementTypes,
			selectedRealEstateTypes: selectedRealEstateTypes,
			minPrice: minPrice,
			maxPrice: maxPrice,
			minSurface: minSurface,
			maxSurface: maxSurface
		};


		RealEstateResource.search(search)
		.then(function(items) {
			$scope.realEstates = items;
			toastr.success('');
		})
		.catch(function(error){
				toastr.error("Greska!");
		});

	}
	]);
})();
