(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('RegistrationController', ['$scope', '$state', '_', 'UserResource', '$stateParams',
		'$log', '$window','toastr',
		function($scope, $state, _, UserResource, $stateParams, $log, $window, toastr) {

		var name = $stateParams.myParams.name;
		var lastname = $stateParams.myParams.lastName;
		var email = $stateParams.myParams.email;
		var username = $stateParams.myParams.username;
		var password = $stateParams.myParams.password;
		var repeated_password = $stateParams.myParams.repeated_password;
		var companyId = $stateParams.myParams.selectedCompany;

		var user = {
				name: name,
				lastname: lastname,
				email: email,
				username: username,
				password: password,
				repeated_password: repeated_password,
				companyId: companyId
		};

		UserResource.register(user)
		.then(function(item) {
			$scope.registratedUser = item;

			$window.location.href = '/#/home';
			toastr.success('Uspesno ste se registrovali! Molimo Vas da se sada prijavite!');
		})
		.catch(function(error){
			$window.location.href = '/#/home';
			toastr.error("Greska!");
		});

	}
	]);
})();
