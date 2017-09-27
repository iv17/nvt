(function() {
	angular
	.module('nvtApp')
	.factory('IndoorResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};

		retVal.getIndoors = function() {
			return Restangular.all("indoorFeatures").getList().then(function(entries) {
				return entries;
			});
		};
		return retVal;
	}]);

})();
