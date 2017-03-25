(function() {
    'use strict';

    angular
        .module('nvtApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        <!-- u app.state.js je vec postavljeno za advertisement -->
        .state('advertisement.detail', {
            parent: 'home',
            url: '/advertisement/{id}',
            data: {
                pageTitle: 'Advetisement'
            },
            views: {
                'content@': {
                    templateUrl: 'app/advertisement/advertisement.detail.html',
                    controller: 'AdvertisementDetailController',
                    controllerAs: 'detail'
                }
            },
            resolve: {
                entity: ['$stateParams', 'Advetisement', function($stateParams, Advetisement) {
                    return Advetisement.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'home',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('advertisement.new', {
            parent: 'home',
            url: '/new',
            data: {
                <!--authorities: ['ROLE_USER'] -->
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/advertisement/advertisement.add.html',
                    controller: 'AdvertisementAddController',
                    controllerAs: 'add',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                name: null,
                                posted: null,
                                agentId: null,
                                realEstate: null,
                                advertisementType: null,
                                name: null,
                                description: null,
                                price: null,
                                surface: null,
                                floor: null,
                                rooms: null,
                                bathrooms: null,
                                constructedYear: null,
                                filed: null,
                                furnished: null,
                                location: null,
                                heatingType: null
                                <!-- treba jos-->
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('home', null, { reload: 'home' });
                }, function() {
                    $state.go('home');
                });
            }]
        })
        .state('advertisement.edit', {
            parent: 'advertisement.detail',
            url: '/{id}/edit',
            data: {
                <!-- authorities: ['ROLE_USER'] -->
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/advertisement/advertisement.edit.html',
                    controller: 'AdvertisementEditController',
                    controllerAs: 'edit',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Advertisement', function(Advertisement) {
                            return Advertisement.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('advertisement.detail', null, { reload: 'advertisement.detail' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('advertisement.delete', {
            parent: 'home',
            url: '/{id}/delete',
            data: {
                <!-- authorities: ['ROLE_USER'] -->
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/advertisement/advertisement.delete.html',
                    controller: 'AdvertisementDeleteController',
                    controllerAs: 'delete',
                    size: 'md',
                    resolve: {
                        entity: ['Advertisement', function(Advertisement) {
                            return Advertisement.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('home', null, { reload: 'home' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
