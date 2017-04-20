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
                  'content@': {
                      templateUrl: 'app/views/content/advertisements_list.html',
                      controller: 'AdvertisementController',
                      controllerAs: 'advertisements'
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
