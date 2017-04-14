
(function() {
    'use strict';

    angular
        .module('nvtApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('home', {
            abstract: true,
            views: {
                  'main_nav@': {
                      templateUrl: 'app/home/account/main_nav.html',
                      controller: 'MainNavController',
                      controllerAs: 'mainNav'
                  }
            },
            views: {
                  'sidebar_menu@': {
                      templateUrl: 'app/home/sidebar_menu.html',
                      controller: 'SidebarMenuController',
                      controllerAs: 'sidebarMenu'
                  }
            },
            views: {
                  'content@': {
                      templateUrl: 'app/map_property/map.html',
                      controller: 'MapController',
                      controllerAs: 'map'
                  }
            },
            views: {
                  'pop_up@': {
                      templateUrl: 'app/map_property/map.html',
                      controller: 'MapController',
                      controllerAs: 'map'
                  }
            },
            resolve: {
                authorize: ['Auth',
                    function (Auth) {
                        return Auth.authorize();
                    }
                ]
            }
        });
    }
})();
