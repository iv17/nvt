(function() {
	angular
	.module('nvtApp')
	.factory('UserResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};	//JSON objekat koji prosledjujemo controller-u

		retVal.login = function(user)	{
			return Restangular.all("users/login").post(user).then(function(response) {
				return response;
			});
		};

		retVal.register = function(user)	{
			return Restangular.all("users/registration").post(user).then(function(response) {
				return response;
			});
		};

		retVal.getUsers = function() {
			return Restangular.all("users").getList().then(function(responses) {
				return responses;
			});
		};


		retVal.getUser = function(email) {
			return Restangular.one("users", email).get().then(function(response) {
				return response;
			});
		};

		retVal.getUserById = function(id) {
			return Restangular.one("users", id).get().then(function(response) {
				return response;
			});
		};

		retVal.getUserRealEstates = function(id) {
			return Restangular.one("users", id).getList("realEstates").then(function(response) {
				return response;
			});
		};

		retVal.getUserRealEstates = function(id) {
			return Restangular.one("users", id).getList("realEstates").then(function(response) {
				return response;
			});
		};

		retVal.getUserComments = function(id) {
			return Restangular.one("users", id).getList("comments").then(function(response) {
				return response;
			});
		};

		retVal.getUserRatings = function(id) {
			return Restangular.one("users", id).getList("ratings").then(function(response) {
				return response;
			});
		};

		retVal.getUserReports = function(id) {
			return Restangular.one("users", id).getList("reports").then(function(response) {
				return response;
			});
		};

		return retVal;
	}]);

})(); //odmah se izvrsava
