(function() {
	angular
	.module('nvtApp')
	.factory('CommentResource', ['Restangular', '_', '$log',
		function(Restangular, _, $log) {
		'use strict';

		var retVal = {};

		retVal.create = function(createCommentRequest)	{
			return Restangular.all("realEstateComments/create").post(createCommentRequest).then(function(response) {
				return response;
			});
		};

		return retVal;
	}]);

})(); 
