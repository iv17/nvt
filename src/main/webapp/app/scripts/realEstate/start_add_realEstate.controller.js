(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('StartAddRealEstateController', ['$scope', '$state', '_', 'AdvertisementTypeResource',
		'RealEstateTypeResource', 'HeatingTypeResource', '$log',
		function($scope, $state, _, AdvertisementTypeResource, RealEstateTypeResource, HeatingTypeResource, $log) {

			AdvertisementTypeResource.getAdvertisementTypes().then(function(items) {
				var advertisementTypes = items;
				var advertisemntTypeLabels = [];

				for(var i=0; i< advertisementTypes.length; i++) {
					var labeled = { 'id': advertisementTypes[i].id, 'label': advertisementTypes[i].name };

					advertisemntTypeLabels.push(labeled);
				}
				$scope.advertisemntTypeLabels = advertisemntTypeLabels;
			});

			RealEstateTypeResource.getRealEstateTypes().then(function(items) {
				var realEstateTypes = items;
				var realEstateTypeLabels = [];

				for(var i=0; i< realEstateTypes.length; i++) {
					var labeled = { 'id': realEstateTypes[i].id, 'label': realEstateTypes[i].name };

					realEstateTypeLabels.push(labeled);
				}
				$scope.realEstateTypeLabels = realEstateTypeLabels;
			});

			HeatingTypeResource.getHeatingTypes().then(function(items) {
				var heatingTypes = items;
				var heatingTypeLabels = [];

				for(var i=0; i< heatingTypes.length; i++) {
					var labeled = { 'id': heatingTypes[i].id, 'label': heatingTypes[i].name };

					heatingTypeLabels.push(labeled);
				}
				$scope.heatingTypeLabels = heatingTypeLabels;
			});

			$scope.selectedAdvertisementTypes = [];
			$scope.selectedRealEstateTypes = [];
			$scope.selectedHeatingTypes = [];


			$scope.button = {
					smartButtonMaxItems: 3,
					smartButtonTextConverter: function(itemText, originalItem) {
						return itemText;
					}
			};

	}
	]);
})();
