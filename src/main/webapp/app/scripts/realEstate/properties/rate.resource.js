(function() {
	angular
	.module('nvtApp')
	.factory('RateResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};

		retVal.rate = function(createRatingRequest)	{
			return Restangular.all("realEstateRatings/create").post(createRatingRequest).then(function(response) {
				return response;
			});
		};

		return retVal;
	}]);

})(); 
