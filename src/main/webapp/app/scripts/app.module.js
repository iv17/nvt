(function() {
  'use strict';

  angular
    .module('nvtApp', [
      'ui.router',
      'ngResource',
      'restangular',
      'ui.bootstrap',
      'lodash'
    ])
    .config(function($stateProvider) {
      $stateProvider.state('app', {
        abstract: true,
        url: "/",
        views: {
          'content@': {
            templateUrl: 'app/views/content/advertisements_list.html',
            controller: 'AdvertisementController',
            controllerAs: 'advertisements'
          }
        },
        resolve: {
          authorize: ['Auth',
            function(Auth) {
              return Auth.authorize();
            }
          ]
        }
      });
    })
      // run se izvrsava pre svega ostalog
    .run(['Restangular', '$log', function(Restangular, $log) {
      Restangular.setBaseUrl("api");
      $log.info("started");
      Restangular.setErrorInterceptor(function(response) {
        if (response.status === 500) {
          $log.info("internal server error");
          return true;
        }
        return true;
      });
    }]);
})();
