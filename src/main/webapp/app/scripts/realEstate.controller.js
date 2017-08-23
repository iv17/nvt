(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('RealEstateController', ['$scope', '$state', '_', 'RealEstateResource', '$log', '$stateParams',
			function($scope, $state, _, RealEstateResource, $log, $stateParams) {

				var realEstateId = $stateParams.realEstateId;

				RealEstateResource.getRealEstate(realEstateId).then(function(item) {
				  $log.log('RealEstateController	- start');
					$log.log(realEstateId);
					$log.log('RealEstateController	- end');
					$scope.realEstate = item;
				});
			}
		]);
})();
