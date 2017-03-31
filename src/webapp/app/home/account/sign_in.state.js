(function() {
    'use strict';

    angular
        .module('nvtApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('signIn', {
            parent: 'home',
            url: '/signIn',
            data: {
                authorities: [],
                pageTitle: 'sign in'
            },
            views: {
                '@': {
                    templateUrl: 'app/account/sign_in.html',
                    controller: 'SignInController',
                    controllerAs: 'signIn'
                }
            }
        });
    }
})();
