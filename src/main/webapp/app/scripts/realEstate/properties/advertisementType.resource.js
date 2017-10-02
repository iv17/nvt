(function() {
	angular
	.module('nvtApp')
	.factory('AdvertisementTypeResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};

		retVal.getAdvertisementTypes = function() {
			return Restangular.all("advertisementTypes").getList().then(function(entries) {
				return entries;
			});
		};
		return retVal;
	}]);

})();
