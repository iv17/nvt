(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('RealEstateController', ['$scope', '$state', '_', 'RealEstateResource',
			function($scope, $state, _, RealEstateResource) {

				RealEstateResource.getRealEstates().then(function(items) {
						$scope.realEstates = items;
				});

			}
		]);
})();
