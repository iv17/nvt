(function() {
	angular
	.module('nvtApp')
	.factory('AgentRateResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};

		retVal.rate = function(createRatingRequest)	{
			return Restangular.all("agentRatings/create").post(createRatingRequest).then(function(response) {
				return response;
			});
		};

		return retVal;
	}]);

})();
