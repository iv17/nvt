(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('RealEstateController', RealEstateController);

    RealEstateController.$inject = ['$scope', '$state', 'DataUtils', 'RealEstate'];

    function RealEstateController ($scope, $state, DataUtils, RealEstate) {
        var vm = this;

        vm.realEstates = [];
        vm.openFile = DataUtils.openFile;
        vm.byteSize = DataUtils.byteSize;

        loadAll();

        function loadAll() {
            RealEstate.query(function(result) {
                vm.realEstates = result;
                vm.searchQuery = null;
            });
        }
    }
})();
