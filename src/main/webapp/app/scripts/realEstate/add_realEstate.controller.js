(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('AddRealEstateController', ['$scope', '$rootScope', '$state', '_', 'RealEstateResource', '$log', '$stateParams',
		'$window','toastr',  '$localStorage', 'Upload',
		function($scope, $rootScope, $state, _, RealEstateResource, $log, $stateParams, $window, toastr, $localStorage, Upload) {

		var name = $stateParams.myParams.name;
		var description = $stateParams.myParams.description;
		var selectedRealEstateTypes = $stateParams.myParams.selectedRealEstateTypes;
		var surface = $stateParams.myParams.surface;
		var floor = $stateParams.myParams.floor;
		var rooms =  $stateParams.myParams.rooms;
		var bathrooms = $stateParams.myParams.bathrooms;
		var constructedYear =  $stateParams.myParams.constructedYear;
		var selectedHeatingTypes =  $stateParams.myParams.selectedHeatingTypes;
		var filed = $stateParams.myParams.filed;
		var furnished = $stateParams.myParams.furnished;
		var selectedAdvertisementTypes = $stateParams.myParams.selectedAdvertisementTypes;
		var price = $stateParams.myParams.price;
		var latlng = $stateParams.myParams.latlng;
		var selectedIndoors = $stateParams.myParams.selectedIndoors;
		var selectedOutdoors = $stateParams.myParams.selectedOutdoors;

		var images = $rootScope.namesArr;

		var realestate = {
				name: name,
				description: description,
				selectedRealEstateTypes: selectedRealEstateTypes,
				surface: surface,
				floor: floor,
				bathrooms: bathrooms,
				constructedYear: constructedYear,
				selectedHeatingTypes: selectedHeatingTypes,
				filed: filed,
				furnished: furnished,
				selectedAdvertisementTypes: selectedAdvertisementTypes,
				price: price,
				latlng: latlng,
				selectedIndoors: selectedIndoors,
				selectedOutdoors: selectedOutdoors,
				images: images
		};


		RealEstateResource.addRealEstate(realestate).then(function(item) {
			$scope.realEstate = item;

			$log.log($scope.realEstate);
			$window.location.href = '/#/home';
			toastr.success('Dodali ste nekretninu!');
		})
		.catch(function(error){
			$window.location.href = '/#/home';
			toastr.error("Greska!");
		});


	}
	]);

})();
