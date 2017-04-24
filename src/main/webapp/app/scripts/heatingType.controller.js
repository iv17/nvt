(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('HeatingTypeController', ['$scope', '$state', '_', 'HeatingTypeResource', '$log',
			function($scope, $state, _, HeatingTypeResource, $log) {

				HeatingTypeResource.getHeatingTypes().then(function(items) {
						$scope.heatingTypes = items;
				});
			}
		]);
})();
