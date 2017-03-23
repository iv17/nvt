(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('ReportController', ReportController);

    ReportController.$inject = ['$scope', '$state', 'Report', 'RealEstate'];

    function ReportController ($scope, $state, Report, RealEstate) {
        var vm = this;

        vm.reports = [];

        vm.realEstate = RealEstate;
        
        loadAll();

        function loadAll() {
            Report.query(function(result) {
                vm.reports = result;
                vm.searchQuery = null;
            });
        }
    }
})();
