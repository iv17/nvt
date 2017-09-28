(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('RateRealEstateController', ['$scope', '$rootScope', '$state', '_', 'RateResource',
		 'RealEstateResource', '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, RateResource, RealEstateResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var realEstateId = $stateParams.realEstateId;
				var rate = $stateParams.rate;

				var rateRequest = {   // I NA SPRINGU OVAKAV OBJEKAT ZA PREUZIMANJE PARAMETARA
          realEstateId: realEstateId,
					rate: rate
				};

				RateResource.rate(rateRequest)
				.then(function(items) {
          $scope.realEstate = items.realEstate;
					$scope.realEstateComments = items.comments;
          $scope.realEstateRatings = items.ratings;
					toastr.success('Ostavili ste ocenu!');
				})
				.catch(function(error){
						toastr.error("Greska!");
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
		])

		.directive('starRating', function () {
		    return {
		        scope: {
		            rating: '=',
		            maxRating: '@',
		            readOnly: '@',
		            click: "&",
		            mouseHover: "&",
		            mouseLeave: "&"
		        },
		        restrict: 'EA',
		        template:
		            "<div style='display: inline-block; margin: 0px; padding: 0px; cursor:pointer;' ng-repeat='idx in maxRatings track by $index'> \
		                    <img ng-src='{{((hoverValue + _rating) <= $index) && \"http://www.codeproject.com/script/ratings/images/star-empty-lg.png\" || \"http://www.codeproject.com/script/ratings/images/star-fill-lg.png\"}}' \
		                    ng-Click='isolatedClick($index + 1)' \
		                    ng-mouseenter='isolatedMouseHover($index + 1)' \
		                    ng-mouseleave='isolatedMouseLeave($index + 1)'></img> \
		            </div>",
		        compile: function (element, attrs) {
		            if (!attrs.maxRating || (Number(attrs.maxRating) <= 0)) {
		                attrs.maxRating = '5';
		            };
		        },
		        controller: function ($scope, $element, $attrs) {
		            $scope.maxRatings = [];

		            for (var i = 1; i <= $scope.maxRating; i++) {
		                $scope.maxRatings.push({});
		            };

		            $scope._rating = $scope.rating;

					$scope.isolatedClick = function (param) {
						if ($scope.readOnly == 'true') return;

						$scope.rating = $scope._rating = param;
						$scope.hoverValue = 0;
						$scope.click({
							param: param
						});
					};

					$scope.isolatedMouseHover = function (param) {
						if ($scope.readOnly == 'true') return;

						$scope._rating = 0;
						$scope.hoverValue = param;
						$scope.mouseHover({
							param: param
						});
					};

					$scope.isolatedMouseLeave = function (param) {
						if ($scope.readOnly == 'true') return;

						$scope._rating = $scope.rating;
						$scope.hoverValue = 0;
						$scope.mouseLeave({
							param: param
						});
					};
		        }
		    };
		});
})();
