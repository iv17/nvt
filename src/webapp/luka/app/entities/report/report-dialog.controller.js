(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('ReportDialogController', ReportDialogController);

    ReportDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Report', 'User', 'RealEstate'];

    function ReportDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Report, User, RealEstate) {
        var vm = this;

        vm.report = entity;
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
            if (vm.report.id !== null) {
                Report.update(vm.report, onSaveSuccess, onSaveError);
            } else {
                Report.save(vm.report, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('realestateApp:reportUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
