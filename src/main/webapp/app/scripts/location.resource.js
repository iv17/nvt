(function() {
	angular
		.module('nvtApp')
		.factory('LocationResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var locations = [];
			var retVal = {};

			retVal.getLocations = function() {
				return Restangular.all("locations").getList().then(function(entries) {
					locations = entries;
					return locations;
				});
			};
			return retVal;
		}]);

})();
