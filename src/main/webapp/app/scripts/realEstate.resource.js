(function() {
	angular
		.module('nvtApp')
		.factory('RealEstateResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var realEstates = [];
			var retVal = {};

			retVal.getRealEstates = function() {
				return Restangular.all("realEstates").getList().then(function(entries) {
					realEstates = entries;				
					return realEstates;
				});
			};

			return retVal;
		}]);

})();
