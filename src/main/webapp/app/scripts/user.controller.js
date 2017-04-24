(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('UserController', ['$scope', '$state', '_', '$log', 'UserResource',
			function($scope, $state, _, $log, UserResource) {

				UserResource.getUsers().then(function(items) {
						$scope.users = items;
						for (var i = 0; i < $scope.users.length; i++) {
							if ($scope.users[i].loged == true) {
									$scope.logedUser = $scope.users[i];
							}
						}
				});

			}
		]);
})();
