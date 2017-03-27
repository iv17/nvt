
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
              },
                'profile@': {
                    templateUrl: 'app/home/profile.html',
                    controller: 'ProfileController',
                    controllerAs: 'profile'
                }
            },
            views: {
                'filter@': {
                    templateUrl: 'app/home/filter.html',
                    controller: 'FilterController',
                    controllerAs: 'filter'
                }
            },
            views: {
                'footer@': {
                    templateUrl: 'app/home/footer.html',
                    controller: 'FooterController',
                    controllerAs: 'footer'
                }
            },
            views: {
                'content@': {
                    templateUrl: 'app/advertisement/advertisements.html',
                    controller: 'AdvertisementController',
                    controllerAs: 'ad'
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
