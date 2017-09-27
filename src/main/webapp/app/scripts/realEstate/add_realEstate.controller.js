(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('AddRealEstateController', ['$scope', '$state', '_', 'RealEstateResource', '$log', '$stateParams',
		function($scope, $state, _, RealEstateResource, $log, $stateParams) {


		var params = $stateParams.myParams;
		$log.log(params);

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

		var realestate = {

		};
		RealEstateResource.addRealEstate(realestate).then(function(items) {
			$scope.realEstates = items;
		});

	}
	]);
})();
