(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('RealEstateDialogController', RealEstateDialogController);

    RealEstateDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'DataUtils', 'entity', 'RealEstate', 'UserComment', 'UserRating', 'Report', 'User', 'RealEstateType', 'Principal'];

    function RealEstateDialogController ($timeout, $scope, $stateParams, $uibModalInstance, DataUtils, entity, RealEstate, UserComment, UserRating, Report, User, RealEstateType, Principal) {
        var vm = this;

        vm.realEstate = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;
        vm.save = save;
        vm.usercomments = UserComment.query();
        vm.userratings = UserRating.query();
        vm.reports = Report.query();
        vm.users = User.query();
        
        vm.realestatetypes = RealEstateType.query();
        
        vm.settingsAccount = null;
        
        /**
         * Store the "settings account" in a separate variable, and not in the shared "account" variable.
         */
        var copyAccount = function (account) {
            return {
                activated: account.activated,
                email: account.email,
                firstName: account.firstName,
                langKey: account.langKey,
                lastName: account.lastName,
                login: account.login
            };
        };
     
        Principal.identity().then(function(account) {
            vm.settingsAccount = copyAccount(account);
            //vm.users = [];
            //vm.users.push(vm.settingsAccount);
            //vm.logedUser = vm.settingsAccount.login;    
        });
        

       $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.realEstate.id !== null) {
                RealEstate.update(vm.realEstate, onSaveSuccess, onSaveError);
            } else {
                RealEstate.save(vm.realEstate, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('realestateApp:realEstateUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }

        vm.datePickerOpenStatus.created = false;
        vm.datePickerOpenStatus.updated = false;

        vm.setImage = function ($file, realEstate) {
            if ($file && $file.$error === 'pattern') {
                return;
            }
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        realEstate.image = base64Data;
                        realEstate.imageContentType = $file.type;
                    });
                });
            }
        };

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
