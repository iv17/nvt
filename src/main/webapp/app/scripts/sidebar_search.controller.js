(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('SidebarSearchController', ['$scope', '$state', '_', 'AdvertisementTypeResource', 'RealEstateTypeResource',
		'LocationResource', 'HeatingTypeResource', '$log',
		function($scope, $state, _, AdvertisementTypeResource, RealEstateTypeResource, LocationResource, HeatingTypeResource, $log) {

		AdvertisementTypeResource.getAdvertisementTypes().then(function(items) {
			var advertisementTypes = items;
			var advertisemntTypeLabels = [];
			for(var i=0; i< advertisementTypes.length; i++) {
				var labeled = {
						'id': advertisementTypes[i].id,
						'label': advertisementTypes[i].name
				};
				advertisemntTypeLabels.push(labeled);
			}
			$scope.advertisemntTypeLabels = advertisemntTypeLabels;
		});

		RealEstateTypeResource.getRealEstateTypes().then(function(items) {
			var realEstateTypes = items;
			var realEstateTypeLabels = [];
			for(var i=0; i< realEstateTypes.length; i++) {
				var labeled = {
						'id': realEstateTypes[i].id,
						'label': realEstateTypes[i].name
				};
				realEstateTypeLabels.push(labeled);
			}
			$scope.realEstateTypeLabels = realEstateTypeLabels;
		});

		LocationResource.getZipCodes().then(function(items) {
			var locations = items;
			var zipCodeLabels = [];

			for(var i=0; i< locations.length; i++) {
				var zipCode = { 'id': locations[i].id, 'label': locations[i].label };

				zipCodeLabels.push(zipCode);

			}

			$scope.zipCodeLabels = zipCodeLabels;

		});

		LocationResource.getCities().then(function(items) {
			var locations = items;
			var cityLabels = [];

			for(var i=0; i< locations.length; i++) {
				var city = { 'id': locations[i].id, 'label': locations[i].label };

				cityLabels.push(city);

			}

			$scope.cityLabels = cityLabels;

		});

		LocationResource.getBlocks().then(function(items) {
			var locations = items;
			var blockLabels = [];

			for(var i=0; i< locations.length; i++) {
				var block = { 'id': locations[i].id, 'label': locations[i].label };
				$log.log(block);
				blockLabels.push(block);

			}

			$scope.blockLabels = blockLabels;

		});
		LocationResource.getStreets().then(function(items) {
			var locations = items;
			var streetLabels = [];

			for(var i=0; i< locations.length; i++) {
				var street = { 'id': locations[i].id, 'label': locations[i].label };
				$log.log(street);
				streetLabels.push(street);

			}

			$scope.streetLabels = streetLabels;

		});
		HeatingTypeResource.getHeatingTypes().then(function(items) {
			var heatingTypes = items;
			var heatingTypeLabels = [];
			for(var i=0; i< heatingTypes.length; i++) {
				var labeled = {
						'id': heatingTypes[i].id,
						'label': heatingTypes[i].name
				};
				heatingTypeLabels.push(labeled);
			}
			$scope.heatingTypeLabels = heatingTypeLabels;
		});

		$scope.selectedAdvertisementTypes = [];
		$scope.selectedRealEstateTypes = [];
		$scope.selectedHeatingTypes = [];

		$scope.selectedZipCodes = [];
		$scope.selectedCities= [];
		$scope.selectedBlocks = [];
		$scope.selectedStreets = [];


		$scope.button = {
				smartButtonMaxItems: 3,
				smartButtonTextConverter: function(itemText, originalItem) {
					return itemText;
				}
		};
	}
	]);
})();
