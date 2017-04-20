(function() {
    'use strict';

    angular
        .module('nvtApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('app', {
            abstract: true,
            views: {
                  'main_nav@': {
                      templateUrl: 'app/views/main_nav/main_nav.html',
                      controller: 'MainNavController',
                      controllerAs: 'mainNav'
                  }
            },
            views: {
                  'sidebar_menu@': {
                      templateUrl: 'app/views/sidebar_menu.html',
                      controller: 'SidebarMenuController',
                      controllerAs: 'sidebarMenu'
                  }
            },
            views: {
                  'content@': {
                      templateUrl: 'app/views/content/advertisements_list.html',
                      controller: 'AdvertisementController',
                      controllerAs: 'vm_advertisement'
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
