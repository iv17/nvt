(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('UserRatingDetailController', UserRatingDetailController);

    UserRatingDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'UserRating', 'User', 'RealEstate'];

    function UserRatingDetailController($scope, $rootScope, $stateParams, previousState, entity, UserRating, User, RealEstate) {
        var vm = this;

        vm.userRating = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('realestateApp:userRatingUpdate', function(event, result) {
            vm.userRating = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
