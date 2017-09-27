(function() {
	angular
	.module('nvtApp')
	.factory('OutdoorResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};

		retVal.getOutdoors = function() {
			return Restangular.all("outdoorFeatures").getList().then(function(entries) {
				return entries;
			});
		};
		return retVal;
	}]);

})();
