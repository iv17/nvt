(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('RealEstateTypeDialogController', RealEstateTypeDialogController);

    RealEstateTypeDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'RealEstateType', 'RealEstate'];

    function RealEstateTypeDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, RealEstateType, RealEstate) {
        var vm = this;

        vm.realEstateType = entity;
        vm.clear = clear;
        vm.save = save;
        vm.realestates = RealEstate.query();

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.realEstateType.id !== null) {
                RealEstateType.update(vm.realEstateType, onSaveSuccess, onSaveError);
            } else {
                RealEstateType.save(vm.realEstateType, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('realestateApp:realEstateTypeUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
