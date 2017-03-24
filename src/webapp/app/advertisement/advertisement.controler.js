(function() {
    'use strict';

    angular
        .module('nvtApp')
        .controller('AdvertisementController', AdvertisementController);

    AdvertisementController.$inject = ['$scope', '$state', 'Advertisement'];

    function AdvertisementController ($scope, $state, RealEstate) {
        var ad = this;

        ad.advertisements = [];

        loadAll();

        function loadAll() {
            Advertisement.query(function(result) {
                ad.advertisements = result;
                ad.searchQuery = null;
            });
        }
    }
})();
