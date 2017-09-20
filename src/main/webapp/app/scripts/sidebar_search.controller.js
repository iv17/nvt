(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('SidebarSearchController', ['$scope', '$state', '_', 'AdvertisementTypeResource','LocationResource',
    'HeatingTypeResource', '$log',
			function($scope, $state, _, AdvertisementTypeResource, LocationResource, HeatingTypeResource, $log) {

        AdvertisementTypeResource.getAdvertisementTypes().then(function(items) {
            $scope.advertisementTypes = items;
        });

				LocationResource.getLocations().then(function(items) {
						$scope.locations = items;
				});

        HeatingTypeResource.getHeatingTypes().then(function(items) {
            $scope.heatingTypes = items;
        });
			}
		]);
})();
