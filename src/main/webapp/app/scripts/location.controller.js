(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('LocationController', ['$scope', '$state', '_', 'LocationResource', '$log',
			function($scope, $state, _, LocationResource, $log) {

				LocationResource.getLocations().then(function(items) {
						$scope.locations = items;
				});
			}
		]);
})();
