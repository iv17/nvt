(function() {
	angular
	.module('nvtApp')
	.factory('HeatingTypeResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};

		retVal.getHeatingTypes = function() {
			return Restangular.all("heatingTypes").getList().then(function(entries) {
				return entries;
			});
		};
		return retVal;
	}]);

})();
