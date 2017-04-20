(function() {
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
    .config(['$stateProvider', function($stateProvider) {
      $stateProvider.state('app', {
        abstract: true,
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
    }])
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
})();
