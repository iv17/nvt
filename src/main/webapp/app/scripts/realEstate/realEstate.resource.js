(function() {
	angular
	.module('nvtApp')
	.factory('RealEstateResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var realEstates = [];
		var realEstate = {};
		var retVal = {};	//JSON objekat koji prosledjujemo controller-u

		retVal.getRealEstates = function() {
			// realEstates je naziv endpoin-a za RealEstateController u spring-u,
			// gore anotacija  api/realEstates
			return Restangular.all("realEstates").getList().then(function(entries) {
				realEstates = entries;
				return realEstates;
			});
		};	// kraj funkcije getRealEstates


		retVal.getRealEstate = function(id) {
			return Restangular.one("realEstates", id).get().then(function(entry) {
				//realEstate = entry;
				return entry;
			});
		};	//kraj funkcije getRealEstate

		return retVal;
	}]);	//kraj Restangular-a

})(); //odmah se izvrsava
