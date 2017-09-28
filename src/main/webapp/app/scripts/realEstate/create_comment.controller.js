(function() {
	'use strict';

	angular
		.module('nvtApp')
		.controller('CreateCommentController', ['$scope', '$rootScope', '$state', '_', 'CommentResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, CommentResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var realEstateId = $stateParams.realEstateId;
				var commentText = $stateParams.commentText;

				var createCommentRequest = {   // I NA SPRINGU OVAKAV OBJEKAT ZA PREUZIMANJE PARAMETARA
          realEstateId: realEstateId,
					text: commentText
				};

				CommentResource.create(createCommentRequest)
				.then(function(items) {
          $scope.realEstate = items.realEstate;
					$scope.realEstateComments = items.comments;
					toastr.success('Dodali ste novi komentar!');
				})
				.catch(function(error){
						toastr.error("Greska!");
				});

			}
		]);
})();
