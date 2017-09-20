(function() {
  'use strict';

  angular
    .module('nvtApp', [
      'toastr',
      'ui.router',
      'ngRoute',
      'ngResource',
      'restangular',
      'ui.bootstrap',
      'lodash',
      'ngStorage'
    ])
    .config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
      function($stateProvider, $urlRouterProvider, $locationProvider) {
      $locationProvider.hashPrefix('');
      $urlRouterProvider.otherwise('/');
      $stateProvider
      .state('home', {
        url: "/",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html'
          },
          'sidebar_menu@': {
            templateUrl: 'app/views/sidebar_menu.html'
          },
          'sidebar_search@': {
            templateUrl: 'app/views/sidebar_search.html'
          },
          'content@': {
            templateUrl: 'app/views/content/realEstatesList.html',
            controller: 'RealEstatesController'
          }
        }
      })
      .state('login', {
        url: "/login/:username/:password",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html',
            controller: 'UserController'
          },
          'sidebar_menu@': {
            templateUrl: 'app/views/sidebar_menu.html'
          },
          'sidebar_search@': {
            templateUrl: 'app/views/sidebar_search.html',
            controller: 'SidebarSearchController'
          },
          'content@': {
            controller: 'LoginController'
          }
        }
      })
      .state('logout', {
          url: "/logout",
          views: {
            'navbar@': {
              templateUrl: 'app/views/navbar.html',
              controller: 'UserController'
            },
            'sidebar_menu@': {
              templateUrl: 'app/views/sidebar_menu.html'
            },
            'sidebar_search@': {
              templateUrl: 'app/views/sidebar_search.html',
              controller: 'SidebarSearchController'
            },
            'content@': {
              controller: 'LogoutController'
            }
          }
      })
      .state('register', {
        url: "/register/:name/:lastname/:email/:username/:password/:repeated_password",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html',
            controller: 'UserController'
          },
          'sidebar_menu@': {
            templateUrl: 'app/views/sidebar_menu.html'
          },
          'sidebar_search@': {
            templateUrl: 'app/views/sidebar_search.html',
            controller: 'SidebarSearchController'
          },
          'content@': {
            controller: 'RegistrationController'
          }
        }
      })
      .state('realEstate', {
        url: "/realEstate/:realEstateId",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html',
            controller: 'UserController'
          },
          'sidebar_menu@': {
            templateUrl: 'app/views/sidebar_menu.html'
          },
          'sidebar_search@': {
            templateUrl: 'app/views/sidebar_search.html',
            controller: 'SidebarSearchController'
          },
          'content@': {
            templateUrl: 'app/views/content/property_details/property_detail.html',
            controller: 'RealEstateController'
          }
        }

      });
    }])
    // run se izvrsava pre svega ostalog
  .run(['Restangular', '$log', '$localStorage',
  function(Restangular, $log, $localStorage) {
    Restangular.setBaseUrl("api");

    Restangular.addFullRequestInterceptor(
      function (element, operation, route, url, headers, params, httpConfig) {

          headers = {'X-Auth-Token':  $localStorage.token };

          return {
              element: element,
              params: params,
              headers: headers,
              httpConfig: httpConfig
          };

      });
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
