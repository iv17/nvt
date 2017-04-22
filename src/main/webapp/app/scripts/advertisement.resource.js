(function() {
	angular
		.module('nvtApp')
		.factory('AdvertisementResource', ['Restangular', '_',
			function(Restangular, _) {
			'use strict';

			var advertisements = [];
			var retVal = {};

			retVal.getAdvertisements = function() {
				return Restangular.all("realestates").getList().then(function(entries) {
					advertisements = entries;
					return advertisements;
				});
			};

			return retVal;
		}]);

})();
