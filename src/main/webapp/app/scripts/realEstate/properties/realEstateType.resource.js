(function() {
	angular
	.module('nvtApp')
	.factory('RealEstateTypeResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};

		retVal.getRealEstateTypes = function() {
			return Restangular.all("realEstateTypes").getList().then(function(entries) {
				return entries;
			});
		};
		return retVal;
	}]);

})();
