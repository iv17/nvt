(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('RealEstateTypeDetailController', RealEstateTypeDetailController);

    RealEstateTypeDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'RealEstateType', 'RealEstate'];

    function RealEstateTypeDetailController($scope, $rootScope, $stateParams, previousState, entity, RealEstateType, RealEstate) {
        var vm = this;

        vm.realEstateType = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('realestateApp:realEstateTypeUpdate', function(event, result) {
            vm.realEstateType = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
