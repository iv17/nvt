(function() {
	angular
		.module('nvtApp')
		.factory('RateResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var retVal = {};	//JSON objekat koji prosledjujemo controller-u

			retVal.rate = function(createRatingRequest)	{
				return Restangular.all("realEstateRatings/create").post(createRatingRequest).then(function(response) {
					return response;
				});
			};

			return retVal;
		}]);

})(); //odmah se izvrsava
