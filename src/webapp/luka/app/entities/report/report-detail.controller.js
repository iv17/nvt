(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('ReportDetailController', ReportDetailController);

    ReportDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Report', 'User', 'RealEstate'];

    function ReportDetailController($scope, $rootScope, $stateParams, previousState, entity, Report, User, RealEstate) {
        var vm = this;

        vm.report = entity;
        vm.previousState = previousState.name;
        

        var unsubscribe = $rootScope.$on('realestateApp:reportUpdate', function(event, result) {
            vm.report = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
