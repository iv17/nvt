(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('AdvertisementTypeController', ['$scope', '$state', '_', 'AdvertisementTypeResource', '$log',
			function($scope, $state, _, AdvertisementTypeResource, $log) {

				AdvertisementTypeResource.getAdvertisementTypes().then(function(items) {
						$scope.advertisementTypes = items;
				});
			}
		]);
})();
