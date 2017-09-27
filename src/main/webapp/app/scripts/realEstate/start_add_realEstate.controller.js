(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('StartAddRealEstateController', ['$scope', '$state', '_', 'AdvertisementTypeResource',
		'RealEstateTypeResource', 'HeatingTypeResource', 'IndoorResource', 'OutdoorResource', '$log',
		function($scope, $state, _, AdvertisementTypeResource, RealEstateTypeResource, HeatingTypeResource,
			IndoorResource, OutdoorResource, $log) {

  		//$scope.center = [44.7992456, 20.4023128];
			$scope.getpos = function (event) {
					$scope.lat = event.latLng.lat();
					$scope.lng = event.latLng.lng();
					$scope.latlng = [event.latLng.lat(), event.latLng.lng()];


			};

			$scope.placeMarker = function(){
					var loc = this.getPlace().geometry.location;
					$scope.latlng = [loc.lat(), loc.lng()];
					$scope.center = [loc.lat(), loc.lng()];
			};

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

			IndoorResource.getIndoors().then(function(items) {
				var indoors = items;
				var indoorLabels = [];

				for(var i=0; i< indoors.length; i++) {
					var labeled = { 'id': indoors[i].id, 'label': indoors[i].name };

					indoorLabels.push(labeled);
				}
				$scope.indoorLabels = indoorLabels;
			});

			OutdoorResource.getOutdoors().then(function(items) {
				var outdoors = items;
				var outdoorLabels = [];

				for(var i=0; i< outdoors.length; i++) {
					var labeled = { 'id': outdoors[i].id, 'label': outdoors[i].name };

					outdoorLabels.push(labeled);
				}
				$scope.outdoorLabels = outdoorLabels;
			});

			$scope.selectedAdvertisementTypes = [];
			$scope.selectedRealEstateTypes = [];
			$scope.selectedHeatingTypes = [];
			$scope.selectedIndoors = [];
			$scope.selectedOutdoors = [];

			$scope.button = {
					smartButtonMaxItems: 3,
					smartButtonTextConverter: function(itemText, originalItem) {
						return itemText;
					}
			};

	}
	]);
})();
