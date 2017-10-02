(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('MapController', ['$scope', '$state', '_', 'RealEstateResource', '$log',
		'$http', '$locale',
		function($scope, $state, _, RealEstateResource, $log, $http, $locale) {

		$scope.center = [44.7992456, 20.4023128];
		RealEstateResource.getRealEstates().then(function(items) {
			$scope.realEstates = items;
			var lls = [];
			for (var i = 0; i < $scope.realEstates.length; i++) {
				var lat = $scope.realEstates[i].location.coord1;
				var lng = $scope.realEstates[i].location.coord2;
				var latlng = [lat, lng];
				lls.push(latlng);
			}
			$scope.lls = lls;


			$scope.getpos = function (event) {
				$scope.lat = event.latLng.lat();
				$scope.lng = event.latLng.lng();
				$scope.latlng = [event.latLng.lat(), event.latLng.lng()];
				$state.go('realEstateLatLng',
						{latlng: {
							lat: event.latLng.lat(),
							lng: event.latLng.lng()
						}});
			};

			$scope.placeMarker = function(){
				var loc = this.getPlace().geometry.location;
				$scope.latlng = [loc.lat(), loc.lng()];
				$scope.center = [loc.lat(), loc.lng()];
			};

		});

	}
	]);
})();
