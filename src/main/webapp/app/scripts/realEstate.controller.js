(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('RealEstateController', ['$scope', '$state', '_', 'RealEstateResource', 'AgentResource', '$log',
			function($scope, $state, _, RealEstateResource, AgentResource, $log) {

				RealEstateResource.getRealEstates().then(function(items) {
						$scope.realEstates = items;
				});

			}
		]);
})();
