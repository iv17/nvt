(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('MapController', ['$scope', '$state', '_', 'RealEstateResource', '$log',
    '$http', '$locale',
		function($scope, $state, _, RealEstateResource, $log, $http, $locale) {

    $scope.center = [44.7823568, 20.4166448];
		RealEstateResource.getRealEstates().then(function(items) {
			$scope.realEstates = items;
      var lls = [];
      for (var i = 0; i < $scope.realEstates.length; i++) {
        $log.log($scope.realEstates[i].location.coord1 + " " + $scope.realEstates[i].location.coord2);
        var lat = $scope.realEstates[i].location.coord1;
        var lng = $scope.realEstates[i].location.coord2;
        var latlng = [lat, lng];
        lls.push(latlng);
        $scope.lls = lls;


        $scope.getpos = function (event) {
            $scope.lat = event.latLng.lat();
            $scope.lng = event.latLng.lng();
            $scope.latlng = [event.latLng.lat(), event.latLng.lng()];
        };

        $scope.placeMarker = function(){
            console.log(this.getPlace());
            var loc = this.getPlace().geometry.location;
            $scope.latlng = [loc.lat(), loc.lng()];
            $scope.center = [loc.lat(), loc.lng()];
        };
      }
		});



	}
	]);
})();
