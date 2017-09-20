(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('LogoutController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				$localStorage.token = null;
        $scope.loggedUser = null;
				$localStorage.loggedUser = null;
        $window.location.href = '/#/home';

			}
		]);
})();
