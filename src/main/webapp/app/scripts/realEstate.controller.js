(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('RealEstateController', ['$scope', '$state', '_', 'RealEstateResource', '$log',
			function($scope, $state, _, RealEstateResource, $log) {

				RealEstateResource.getRealEstates().then(function(items) {
						$scope.realEstates = items;
						for (var i = 0; i < $scope.realEstates.length; i++) {
							$log.info($scope.realEstates[i]);

						}
				});
			}
		]);
})();
