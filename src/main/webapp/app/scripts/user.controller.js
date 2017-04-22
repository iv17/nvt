(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('UserController', ['$scope', '$state', '_', 'UserResource',
			function($scope, $state, _, UserResource) {

				UserResource.getUsers().then(function(items) {
						$scope.users = items;
				});

			}
		]);
})();
