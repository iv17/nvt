(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('RatingsController', ['$scope', '$rootScope', '$state', '_', 'RealEstateResource', '$log', '$stateParams',
		function($scope, $rootScope, $state, _, RealEstateResource, $log, $stateParams) {

		var realEstateId = $stateParams.realEstateId;
		var realEstate = {
				id: realEstateId
		};

		RealEstateResource.ratings(realEstate).then(function(items) {
			$rootScope.ratings1 = items.ratings1;
			$rootScope.ratings2 = items.ratings2;
			$rootScope.ratings3 = items.ratings3;
			$rootScope.ratings4 = items.ratings4;
			$rootScope.ratings5 = items.ratings5;
			$rootScope.ukupno = items.ukupno;
			$rootScope.srednjaVrednost = items.srednjaVrednost;

			$state.go('realEstate2', {realEstateId});
		});


	}
	]);
})();
