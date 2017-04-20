(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('AdvertisementController', ['$scope', '$state', '_', 'AdvertisementResource',
			function($scope, $state, _, AdvertisementResource) {

				AdvertisementResource.getAdvertisements().then(function(items) {
						$scope.advertisements = items;
				});

			}
		]);
})();
