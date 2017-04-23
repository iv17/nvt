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

/*
			retVal.getRealEstateComments = function(id) {
          return Restangular.one("realEstates", id).
	       	 getList("comments").then(function(entries) {
		       	return entries;
	       	});
    	};
*/
			return retVal;
		}]);

})();
