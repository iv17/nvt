(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('RealEstateTypeDeleteController',RealEstateTypeDeleteController);

    RealEstateTypeDeleteController.$inject = ['$uibModalInstance', 'entity', 'RealEstateType'];

    function RealEstateTypeDeleteController($uibModalInstance, entity, RealEstateType) {
        var vm = this;

        vm.realEstateType = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            RealEstateType.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
