(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('UserCommentDetailController', UserCommentDetailController);

    UserCommentDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'UserComment', 'User', 'RealEstate'];

    function UserCommentDetailController($scope, $rootScope, $stateParams, previousState, entity, UserComment, User, RealEstate) {
        var vm = this;

        vm.userComment = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('realestateApp:userCommentUpdate', function(event, result) {
            vm.userComment = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
