(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('RealEstateDetailController', RealEstateDetailController);

    RealEstateDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'RealEstate', 'UserComment', 'UserRating', 'Report', 'User', 'RealEstateType'];

    function RealEstateDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, RealEstate, UserComment, UserRating, Report, User, RealEstateType) {
        var vm = this;

        vm.realEstate = entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('realestateApp:realEstateUpdate', function(event, result) {
            vm.realEstate = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
