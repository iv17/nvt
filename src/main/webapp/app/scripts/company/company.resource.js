(function() {
	angular
	.module('nvtApp')
	.factory('CompanyResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};

		retVal.register = function(Company)	{
			return Restangular.all("companies/registration").post(Company).then(function(response) {
				return response;
			});
		};

		retVal.getCompanies = function() {
			return Restangular.all("companies").getList().then(function(responses) {
				return responses;
			});
		};

		retVal.getCompany = function(id) {
			return Restangular.one("companies", id).get().then(function(response) {
				return response;
			});
		};

		retVal.getCompanyAgents = function(id) {
			return Restangular.one("companies", id).getList("agents").then(function(response) {
				return response;
			});
		};

		retVal.getCompanyRealEstates = function(id) {
			return Restangular.one("companies", id).getList("realEstates").then(function(response) {
				return response;
			});
		};

		retVal.addAgent = function(agent)	{
			return Restangular.all("companies/add").post(agent).then(function(response) {
				return response;
			});
		};

		retVal.getCompanyComments = function(id) {
			return Restangular.one("companies", id).getList("comments").then(function(response) {
				return response;
			});
		};

		retVal.getCompanyRatings = function(id) {
			return Restangular.one("companies", id).getList("ratings").then(function(response) {
				return response;
			});
		};

		retVal.getCompanyReports = function(id) {
			return Restangular.one("companies", id).getList("reports").then(function(response) {
				return response;
			});
		};
		return retVal;
	}]);

})(); 
