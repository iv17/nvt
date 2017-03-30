(function() {
    'use strict';

    angular
        .module('nvtApp')
        .controller('PropertyController', PropertyController);

    PropertyController.$inject = ['$scope', '$state', 'DataUtils', 'Advertisement', 'RealEstate'];

    function PropertyController ($scope, $state, DataUtils, Advertisement, RealEstate) {

        var property = this;

        property.advertisements = [];

        loadAll();

        function loadAll() {
            PropertyController.query(function(result) {
                property.advertisements = result;
                property.searchQuery = null;
            });
        }
    }
})();
