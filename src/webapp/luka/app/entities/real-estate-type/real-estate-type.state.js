(function() {
    'use strict';

    angular
        .module('realestateApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('real-estate-type', {
            parent: 'entity',
            url: '/real-estate-type',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'RealEstateTypes'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/real-estate-type/real-estate-types.html',
                    controller: 'RealEstateTypeController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('real-estate-type-detail', {
            parent: 'entity',
            url: '/real-estate-type/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'RealEstateType'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/real-estate-type/real-estate-type-detail.html',
                    controller: 'RealEstateTypeDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'RealEstateType', function($stateParams, RealEstateType) {
                    return RealEstateType.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'real-estate-type',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('real-estate-type-detail.edit', {
            parent: 'real-estate-type-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/real-estate-type/real-estate-type-dialog.html',
                    controller: 'RealEstateTypeDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RealEstateType', function(RealEstateType) {
                            return RealEstateType.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('real-estate-type.new', {
            parent: 'real-estate-type',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/real-estate-type/real-estate-type-dialog.html',
                    controller: 'RealEstateTypeDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                name: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('real-estate-type', null, { reload: 'real-estate-type' });
                }, function() {
                    $state.go('real-estate-type');
                });
            }]
        })
        .state('real-estate-type.edit', {
            parent: 'real-estate-type',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/real-estate-type/real-estate-type-dialog.html',
                    controller: 'RealEstateTypeDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RealEstateType', function(RealEstateType) {
                            return RealEstateType.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('real-estate-type', null, { reload: 'real-estate-type' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('real-estate-type.delete', {
            parent: 'real-estate-type',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/real-estate-type/real-estate-type-delete-dialog.html',
                    controller: 'RealEstateTypeDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RealEstateType', function(RealEstateType) {
                            return RealEstateType.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('real-estate-type', null, { reload: 'real-estate-type' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
