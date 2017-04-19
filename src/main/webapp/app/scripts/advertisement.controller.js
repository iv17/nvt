'use strict';

angular
  .module('nvtApp')
  .controller('AdvertisementController', ['$scope', '$state', '_', 'AdvertisementResource',
    function($scope, $state, _, AdvertisementResource) {

      var vm_advertisement = this;
      vm_advertisement.$state = $state;


    AdvertisementResource.getAdvertisements().then(function(items) {
      $scope.advertisements = items;
      vm_advertisement = items;
    });

    $scope.deleteAdvertisement = function(id) {
      AdvertisementResource.deleteAdvertisement(id);
    };
  }]);
