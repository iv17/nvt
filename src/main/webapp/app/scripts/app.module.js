(function() {
  'use strict';

  angular
    .module('nvtApp', [
      'ui.router',
      'ngRoute',
      'ngResource',
      'restangular',
      'ui.bootstrap',
      'lodash'
    ])
    .config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
      function($stateProvider, $urlRouterProvider, $locationProvider) {
      $locationProvider.hashPrefix('');
      $urlRouterProvider.otherwise('/');
      $stateProvider
      .state('advertisements', {
        url: "/",
        views: {
          'main_nav@': {
            templateUrl: 'app/views/main_nav/main_nav.html',
            controller: 'UserController',
            controllerAs: 'vm_users'
          },
          'content@': {
            templateUrl: 'app/views/content/realEstatesList.html',
            controller: 'RealEstateController'
            //templateUrl: 'app/views/content/test.html',
            //controller: 'LocationController'
            //controllerAs: 'vm_realEstates'
          }
        }

      });
    }])
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
