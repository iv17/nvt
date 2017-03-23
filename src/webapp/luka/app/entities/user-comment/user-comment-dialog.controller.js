(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('UserCommentDialogController', UserCommentDialogController);

    UserCommentDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'UserComment', 'User', 'RealEstate'];

    function UserCommentDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, UserComment, User, RealEstate) {
        var vm = this;

        vm.userComment = entity;
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
            if (vm.userComment.id !== null) {
                UserComment.update(vm.userComment, onSaveSuccess, onSaveError);
            } else {
                UserComment.save(vm.userComment, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('realestateApp:userCommentUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
