(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('UserRatingDialogController', UserRatingDialogController);

    UserRatingDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'UserRating', 'User', 'RealEstate'];

    function UserRatingDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, UserRating, User, RealEstate) {
        var vm = this;

        vm.userRating = entity;
        vm.clear = clear;
        vm.save = save;
        vm.users = User.query();
        vm.realestates = RealEstate.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.userRating.id !== null) {
                UserRating.update(vm.userRating, onSaveSuccess, onSaveError);
            } else {
                UserRating.save(vm.userRating, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('realestateApp:userRatingUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
