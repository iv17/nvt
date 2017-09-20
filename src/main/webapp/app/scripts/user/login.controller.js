(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('LoginController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var username = $stateParams.username;
				var password = $stateParams.password;

				var logginUser = {
					username: username,
					email: username,
					password: password
				};

				UserResource.login(logginUser)
				.then(function(item) {

					$scope.loggedUser = item.user;
					$localStorage.loggedUser = item.user;
					$localStorage.token = item.token;

					$window.location.href = '/#/home';
					toastr.success('Ulogovali ste se kao: ' + item.user.username);

				})
				.catch(function(error){
						$window.location.href = '/#/start_login';
						toastr.error("Greska!");
				});




			}
		]);
})();
