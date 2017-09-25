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
				return entry;
			});
		};	//kraj funkcije getRealEstate

		retVal.getRealEstateLatLng = function(latlng) {
			return Restangular.all("realEstates/latlng").post(latlng).then(function(entry) {
				return entry;
			});
		};	//kraj funkcije getRealEstate

		retVal.search = function(search)	{
			return Restangular.all("realEstates/search").post(search).then(function(response) {
				return response;
			});
		};

		retVal.indoors = function(id)	{
			return Restangular.one("realEstates", id).getList("indoors").then(function(response) {
				return response;
			});
		};

		retVal.outdoors = function(id)	{
			return Restangular.one("realEstates", id).getList("outdoors").then(function(response) {
				return response;
			});
		};

		retVal.comments = function(id)	{
			return Restangular.one("realEstates", id).getList("comments").then(function(response) {
				return response;
			});
		};

		return retVal;
	}]);	//kraj Restangular-a

})(); //odmah se izvrsava
