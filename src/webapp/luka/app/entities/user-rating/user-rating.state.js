(function() {
    'use strict';

    angular
        .module('realestateApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('user-rating', {
            parent: 'entity',
            url: '/user-rating',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'UserRatings'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/user-rating/user-ratings.html',
                    controller: 'UserRatingController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('user-rating-detail', {
            parent: 'entity',
            url: '/user-rating/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'UserRating'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/user-rating/user-rating-detail.html',
                    controller: 'UserRatingDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'UserRating', function($stateParams, UserRating) {
                    return UserRating.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'user-rating',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('user-rating-detail.edit', {
            parent: 'user-rating-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-rating/user-rating-dialog.html',
                    controller: 'UserRatingDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['UserRating', function(UserRating) {
                            return UserRating.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('user-rating.new', {
            parent: 'user-rating',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-rating/user-rating-dialog.html',
                    controller: 'UserRatingDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                value: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('user-rating', null, { reload: 'user-rating' });
                }, function() {
                    $state.go('user-rating');
                });
            }]
        })
        .state('user-rating.edit', {
            parent: 'user-rating',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-rating/user-rating-dialog.html',
                    controller: 'UserRatingDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['UserRating', function(UserRating) {
                            return UserRating.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('user-rating', null, { reload: 'user-rating' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('user-rating.delete', {
            parent: 'user-rating',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-rating/user-rating-delete-dialog.html',
                    controller: 'UserRatingDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['UserRating', function(UserRating) {
                            return UserRating.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('user-rating', null, { reload: 'user-rating' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
