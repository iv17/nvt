(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('AdvertisementController', ['$scope', '$state', '_', 'AdvertisementResource', 'RealEstateResource',
			function($scope, $state, _, AdvertisementResource, RealEstateResource) {

				AdvertisementResource.getAdvertisements().then(function(items) {
						$scope.advertisements = items;
				});

			}
		]);
})();
