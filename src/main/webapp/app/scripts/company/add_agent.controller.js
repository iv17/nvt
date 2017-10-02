(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('AddAgentController', ['$scope', '$rootScope', '$state', '_', 'CompanyResource', '$log', '$stateParams',
		'$window','toastr',  '$localStorage',
		function($scope, $rootScope, $state, _, CompanyResource, $log, $stateParams, $window, toastr, $localStorage) {

		var name = $stateParams.myParams.name;
    var lastname = $stateParams.myParams.lastname;
    var email = $stateParams.myParams.email;
    var phoneNumber = $stateParams.myParams.phoneNumber;
    var username = $stateParams.myParams.username;
    var password = $stateParams.myParams.password;
    var companyId = $stateParams.myParams.companyId;

		var agent = {
				name: name,
				lastname: lastname,
        email: email,
        phoneNumber: phoneNumber,
        username: username,
        password: password,
        companyId: companyId
		};


		CompanyResource.addAgent(agent).then(function(item) {
			$scope.company = item;

			toastr.success('Dodali ste novog agenta!');
		})
		.catch(function(error){
			$window.location.href = '/#/home';
			toastr.error("Greska!");
		});


	}
	]);

})();
