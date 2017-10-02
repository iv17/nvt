(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('CreateCommentController', ['$scope', '$rootScope', '$state', '_', 'CommentResource',
		'RealEstateResource', '$stateParams', '$log', '$window','toastr',  '$localStorage',
		function($scope, $rootScope, $state, _, CommentResource, RealEstateResource, $stateParams, $log, $window,
				toastr, $localStorage) {


		var realEstateId = $stateParams.realEstateId;
		var commentText = $stateParams.commentText;

		var createCommentRequest = {
				realEstateId: realEstateId,
				text: commentText
		};

		CommentResource.create(createCommentRequest)
		.then(function(items) {
			$scope.realEstate = items.realEstate;
			$scope.realEstateComments = items.comments;
			$scope.realEstateRating = items.ratings;
			$scope.realEstateRatings1 = items.ratings.ratings1;
			$scope.realEstateRatings2 = items.ratings.ratings2;
			$scope.realEstateRatings3 = items.ratings.ratings3;
			$scope.realEstateRatings4 = items.ratings.ratings4;
			$scope.realEstateRatings5 = items.ratings.ratings5;
			$scope.ukupno = items.ratings.ukupno;
			$rootScope.srednjaVrednost = items.ratings.srednjaVrednost;
			$scope.realEstateReports = items.reports;
			$scope.indoors = items.indoors;
			$scope.outdoors = items.outdoors;
			for (var i = 0; i < items.indoors.length; i++) {
				if(items.indoors[i].indoorFeature.name === "Floorboards") { $scope.floorboards = "Floorboards"; }
				if(items.indoors[i].indoorFeature.name === "Built-in Wardrobes") { $scope.builtInWardrobes = "Built-in Wardrobes"; }
				if(items.indoors[i].indoorFeature.name === "Dishwasher") { $scope.dishwasher = "Dishwasher"; }
				if(items.indoors[i].indoorFeature.name === "Air Conditioning") { $scope.airConditioning = "Air Conditioning"; }
				if(items.indoors[i].indoorFeature.name === "Indoor Spa") { $scope.indoorSpa = "Indoor Spa"; }
				if(items.indoors[i].indoorFeature.name === "Broadband Internet Available") { $scope.broadbandInternetAvailable = "Broadband Internet Available"; }
				if(items.indoors[i].indoorFeature.name === "Ducted Heating") { $scope.ductedHeating = "Ducted Heating"; }
				if(items.indoors[i].indoorFeature.name === "Ducted Cooling") { $scope.ductedCooling = "Ducted Cooling"; }
				if(items.indoors[i].indoorFeature.name === "Rumpus Room") { $scope.rumpusRoom = "Rumpus Room"; }
				if(items.indoors[i].indoorFeature.name === "Alarm System") { $scope.alarmSystem = "Alarm System"; }
				if(items.indoors[i].indoorFeature.name === "Dusted vacum system") { $scope.dustedVacumSystem = "Dusted vacum system"; }
				if(items.indoors[i].indoorFeature.name === "Open fireplace") { $scope.openFireplace = "Open fireplace"; }
			}
			for (var i = 0; i < items.outdoors.length; i++) {
				if(items.outdoors[i].outdoorFeature.name === "Secure Parking") { $scope.secureParking = "Secure Parking"; }
				if(items.outdoors[i].outdoorFeature.name === "Courtyard") { $scope.courtyard = "Courtyard"; }
				if(items.outdoors[i].outdoorFeature.name === "Shed") { $scope.shed = "Shed"; }
				if(items.outdoors[i].outdoorFeature.name === "Deck") { $scope.deck = "Deck"; }
				if(items.outdoors[i].outdoorFeature.name === "Balcony") { $scope.balcony = "Balcony"; }
				if(items.outdoors[i].outdoorFeature.name === "Swimming Pool") { $scope.swimmingPool = "Swimming Pool"; }
				if(items.outdoors[i].outdoorFeature.name === "Carpot") { $scope.carpot = "Carpot"; }
				if(items.outdoors[i].outdoorFeature.name === "Garage") { $scope.garage = "Garage"; }
				if(items.outdoors[i].outdoorFeature.name === "Tenis court") { $scope.tenisCourt = "Tenis court"; }
				if(items.outdoors[i].outdoorFeature.name === "Outside spa") { $scope.outsideSpa = "Outside spa"; }
			}

			toastr.success('Dodali ste novi komentar!');
		})
		.catch(function(error){
			toastr.error("Greska!");
		});

		$scope.rate = 0;
		$scope.srednjaVrednost = $rootScope.srednjaVrednost;
		$rootScope.srednjaVrednost = null;
	}
	]);
})();
