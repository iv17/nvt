(function() {
	angular
		.module('nvtApp')
		.factory('ReportResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var retVal = {};	//JSON objekat koji prosledjujemo controller-u

			retVal.create = function(createReportRequest)	{
				return Restangular.all("realEstateReports/create").post(createReportRequest).then(function(response) {
					return response;
				});
			};

			return retVal;
		}]);

})(); //odmah se izvrsava
