(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('UserRatingDeleteController',UserRatingDeleteController);

    UserRatingDeleteController.$inject = ['$uibModalInstance', 'entity', 'UserRating'];

    function UserRatingDeleteController($uibModalInstance, entity, UserRating) {
        var vm = this;

        vm.userRating = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            UserRating.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
