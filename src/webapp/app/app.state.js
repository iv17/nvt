
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
              views: {
                  'topNav@': {
                    <!-- unutar topNav-a postoje posebni view-evi-->
                      templateUrl: 'app/home/topNav.html',
                      controller: 'TopNavController',
                      controllerAs: 'topNav'
                  }
              }
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
