(function() {
	angular
		.module('nvtApp')
		.factory('UserResource', ['Restangular', '_',
			function(Restangular, _) {
			'use strict';

			var users = [];
			var retVal = {}; //JSON objekat koji prosledjujemo controller-u

			retVal.getUsers = function() {
				return Restangular.all("users").getList().then(function(entries) {
					users = entries;
					return users;
				});
			};

			return retVal;
		}]);

})();
