(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('RealEstateController', ['$scope', '$state', '_', 'RealEstateResource', '$log', '$stateParams',
			function($scope, $state, _, RealEstateResource, $log, $stateParams) {

				var realEstateId = $stateParams.realEstateId;

				RealEstateResource.getRealEstate(realEstateId).then(function(item) {
				  $scope.realEstate = item;
				});
			}
		]);
})();
