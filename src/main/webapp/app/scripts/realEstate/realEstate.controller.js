(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('RealEstateController', ['$scope', '$rootScope', '$state', '_', 'RealEstateResource', '$log', '$stateParams',
		function($scope, $rootScope, $state, _, RealEstateResource, $log, $stateParams) {

		$scope.rate = 0;
		$scope.realEstateRatings1 = $rootScope.ratings1;
		$scope.realEstateRatings2 = $rootScope.ratings2;
		$scope.realEstateRatings3 = $rootScope.ratings3;
		$scope.realEstateRatings4 = $rootScope.ratings4;
		$scope.realEstateRatings5 = $rootScope.ratings5;
		$scope.ukupno = $rootScope.ukupno;
		$scope.srednjaVrednost = $rootScope.srednjaVrednost;
		$rootScope.ratings1 = null;
		$rootScope.ratings2 = null;
		$rootScope.ratings3 = null;
		$rootScope.ratings4 = null;
		$rootScope.ratings5 = null;
		$rootScope.ukupno = null;
		$rootScope.srednjaVrednost = null;
		
		var realEstateId = $stateParams.realEstateId;
		var realEstate = {
			id: realEstateId
		};

		RealEstateResource.getRealEstate(realEstateId).then(function(item) {
			$scope.realEstate = item;
		});

		RealEstateResource.comments(realEstateId).then(function(items) {
			$scope.realEstateComments = items;
		});


		RealEstateResource.indoors(realEstateId).then(function(items) {
			$scope.indoors = items;
			for (var i = 0; i < items.length; i++) {
				if(items[i].name === "Floorboards") { $scope.floorboards = "Floorboards"; }
				if(items[i].name === "Built-in Wardrobes") { $scope.builtInWardrobes = "Built-in Wardrobes"; }
				if(items[i].name === "Dishwasher") { $scope.dishwasher = "Dishwasher"; }
				if(items[i].name === "Air Conditioning") { $scope.airConditioning = "Air Conditioning"; }
				if(items[i].name === "Indoor Spa") { $scope.indoorSpa = "Indoor Spa"; }
				if(items[i].name === "Broadband Internet Available") { $scope.broadbandInternetAvailable = "Broadband Internet Available"; }
				if(items[i].name === "Ducted Heating") { $scope.ductedHeating = "Ducted Heating"; }
				if(items[i].name === "Ducted Cooling") { $scope.ductedCooling = "Ducted Cooling"; }
				if(items[i].name === "Rumpus Room") { $scope.rumpusRoom = "Rumpus Room"; }
				if(items[i].name === "Alarm System") { $scope.alarmSystem = "Alarm System"; }
				if(items[i].name === "Dusted vacum system") { $scope.dustedVacumSystem = "Dusted vacum system"; }
				if(items[i].name === "Open fireplace") { $scope.openFireplace = "Open fireplace"; }
			}
		});
		RealEstateResource.outdoors(realEstateId).then(function(items) {
			$scope.outdoors = items;
			for (var i = 0; i < items.length; i++) {
				if(items[i].name === "Secure Parking") { $scope.secureParking = "Secure Parking"; }
				if(items[i].name === "Courtyard") { $scope.courtyard = "Courtyard"; }
				if(items[i].name === "Shed") { $scope.shed = "Shed"; }
				if(items[i].name === "Deck") { $scope.deck = "Deck"; }
				if(items[i].name === "Balcony") { $scope.balcony = "Balcony"; }
				if(items[i].name === "Swimming Pool") { $scope.swimmingPool = "Swimming Pool"; }
				if(items[i].name === "Carpot") { $scope.carpot = "Carpot"; }
				if(items[i].name === "Garage") { $scope.garage = "Garage"; }
				if(items[i].name === "Tenis court") { $scope.tenisCourt = "Tenis court"; }
				if(items[i].name === "Outside spa") { $scope.outsideSpa = "Outside spa"; }
			}
		});


	}
	]);
})();
