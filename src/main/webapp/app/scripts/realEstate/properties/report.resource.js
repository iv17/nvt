(function() {
	angular
	.module('nvtApp')
	.factory('ReportResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};	

		retVal.create = function(createReportRequest)	{
			return Restangular.all("realEstateReports/create").post(createReportRequest).then(function(response) {
				return response;
			});
		};

		return retVal;
	}]);

})();
