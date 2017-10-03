(function() {
	'use strict';

	angular
	.module('nvtApp')
	.controller('RateAgentController', ['$scope', '$rootScope', '$state', '_', 'AgentRateResource',
	 	'$stateParams', '$log', '$window','toastr',  '$localStorage',
		function($scope, $rootScope, $state, _, AgentRateResource, $stateParams, $log, $window,
				toastr, $localStorage) {

		var agentId = $stateParams.agentId;
		var rate = $stateParams.rate;

		var rateRequest = {
				agentId: agentId,
				rate: rate
		};

		AgentRateResource.rate(rateRequest)
		.then(function(items) {
			$scope.agent = items.agent;
			$scope.agentRatings1 = items.ratings.ratings1;
			$scope.agentRatings2 = items.ratings.ratings2;
			$scope.agentRatings3 = items.ratings.ratings3;
			$scope.agentRatings4 = items.ratings.ratings4;
			$scope.agentRatings5 = items.ratings.ratings5;
			$scope.agentUkupno = items.ratings.ukupno;
			$rootScope.agentSrednjaVrednost = items.ratings.srednjaVrednost;

			toastr.success('Ostavili ste ocenu!');
		})
		.catch(function(error){
			toastr.error("Greska!");
		});
		$scope.rate = 0;
		$scope.agentSrednjaVrednost = $rootScope.agentSrednjaVrednost;
		$rootScope.agentSrednjaVrednost = null;
	}
]);
})();
