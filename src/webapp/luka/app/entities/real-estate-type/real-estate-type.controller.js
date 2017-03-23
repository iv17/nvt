(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('RealEstateTypeController', RealEstateTypeController);

    RealEstateTypeController.$inject = ['$scope', '$state', 'RealEstateType'];

    function RealEstateTypeController ($scope, $state, RealEstateType) {
        var vm = this;

        vm.realEstateTypes = [];

        loadAll();

        function loadAll() {
            RealEstateType.query(function(result) {
                vm.realEstateTypes = result;
                vm.searchQuery = null;
            });
        }
    }
})();
