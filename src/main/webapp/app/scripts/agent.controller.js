(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('AgentController', ['$scope', '$state', '_', 'AgentResource',
			function($scope, $state, _, AgentResource) {

				AgentResource.getAgents().then(function(items) {
						$scope.agents = items;
				});

			}
		]);
})();
