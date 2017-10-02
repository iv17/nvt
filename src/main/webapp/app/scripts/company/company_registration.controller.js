(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('CompanyRegistrationController', ['$scope', '$state', '_', 'CompanyResource', '$stateParams',
		'$log', '$window','toastr',
		function($scope, $state, _, CompanyResource, $stateParams, $log, $window, toastr) {

		var username = $stateParams.myParams.username;
		var propertyNo = $stateParams.myParams.propertyNo;
		var email = $stateParams.myParams.email;
		var webAddress = $stateParams.myParams.webAddress;
		var phoneNumber = $stateParams.myParams.phoneNumber;
		var password = $stateParams.myParams.password;
		var repeated_password = $stateParams.myParams.repeated_password;

		var company = {
				username: username,
				propertyNo: propertyNo,
				email: email,
				webAddress: webAddress,
				phoneNumber: phoneNumber,
				password: password,
				repeated_password: repeated_password
		};

		CompanyResource.register(company)
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
