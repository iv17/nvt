(function() {
    'use strict';

    angular
        .module('realestateApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('real-estate', {
            parent: 'entity',
            url: '/real-estate',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'RealEstates'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/real-estate/real-estates.html',
                    controller: 'RealEstateController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('real-estate-detail', {
            parent: 'entity',
            url: '/real-estate/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'RealEstate'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/real-estate/real-estate-detail.html',
                    controller: 'RealEstateDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'RealEstate', function($stateParams, RealEstate) {
                    return RealEstate.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'real-estate',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('real-estate-detail.edit', {
            parent: 'real-estate-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/real-estate/real-estate-dialog.html',
                    controller: 'RealEstateDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RealEstate', function(RealEstate) {
                            return RealEstate.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('real-estate.new', {
            parent: 'real-estate',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/real-estate/real-estate-dialog.html',
                    controller: 'RealEstateDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                name: null,
                                advertisementType: null,
                                location: null,
                                area: null,
                                technicalEquipment: null,
                                heatingType: null,
                                created: null,
                                updated: null,
                                durationInHours: null,
                                phone: null,
                                price: null,
                                image: null,
                                imageContentType: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('real-estate', null, { reload: 'real-estate' });
                }, function() {
                    $state.go('real-estate');
                });
            }]
        })
        .state('real-estate.edit', {
            parent: 'real-estate',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/real-estate/real-estate-dialog.html',
                    controller: 'RealEstateDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['RealEstate', function(RealEstate) {
                            return RealEstate.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('real-estate', null, { reload: 'real-estate' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('real-estate.delete', {
            parent: 'real-estate',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/real-estate/real-estate-delete-dialog.html',
                    controller: 'RealEstateDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['RealEstate', function(RealEstate) {
                            return RealEstate.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('real-estate', null, { reload: 'real-estate' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
