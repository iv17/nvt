'use strict';

angular
  .module('nvtApp', [
    'ngResource',
    'ngRoute',
    'restangular',
    'ui.bootstrap',
    'ui.router',
    'lodash'
  ])
  // run se izvrsava pre svega ostalog
  .run(['Restangular', '$log', function(Restangular, $log) {
    Restangular.setBaseUrl("api");
    Restangular.setErrorInterceptor(function(response) {
      if (response.status === 500) {
        $log.info("internal server error");
        return true;
      }
      return true;
    });
  }]);
