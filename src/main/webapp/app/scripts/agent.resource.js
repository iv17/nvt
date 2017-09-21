(function() {
	angular
	.module('nvtApp')
	.factory('AgentResource', ['Restangular', '_',
		function(Restangular, _) {
		'use strict';

		var agents = [];
		var retVal = {};

		retVal.getAgents = function() {
			return Restangular.all("agents").getList().then(function(entries) {
				agents = entries;
				return agents;
			});
		};

		return retVal;
	}]);

})();
