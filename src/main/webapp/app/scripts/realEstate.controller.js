(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('RealEstateController', ['$scope', '$state', '_', 'RealEstateResource', 'AdvertisementResource',
			function($scope, $state, _, RealEstateResource, AdvertisementResource) {

				RealEstateResource.getRealEstates().then(function(items) {
						$scope.realEstates = items;
				});

			}
		]);
})();
