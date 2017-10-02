(function() {
	angular
	.module('nvtApp')
	.factory('LocationResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};

		retVal.getLocations = function() {
			return Restangular.all("locations").getList().then(function(entries) {
				return entries;
			});
		};

		retVal.getZipCodes = function() {
			return Restangular.all("locations/zipCodes").getList().then(function(entries) {
				return entries;
			});
		};

		retVal.getCities = function() {
			return Restangular.all("locations/cities").getList().then(function(entries) {
				return entries;
			});
		};

		retVal.getBlocks = function() {
			return Restangular.all("locations/blocks").getList().then(function(entries) {
				return entries;
			});
		};

		retVal.getStreets = function() {
			return Restangular.all("locations/streets").getList().then(function(entries) {
				return entries;
			});
		};

		return retVal;

	}]);

})();
