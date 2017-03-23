(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('RealEstateDeleteController',RealEstateDeleteController);

    RealEstateDeleteController.$inject = ['$uibModalInstance', 'entity', 'RealEstate'];

    function RealEstateDeleteController($uibModalInstance, entity, RealEstate) {
        var vm = this;

        vm.realEstate = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RealEstate.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
