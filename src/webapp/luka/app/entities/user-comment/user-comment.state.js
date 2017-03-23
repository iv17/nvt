(function() {
    'use strict';

    angular
        .module('realestateApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('user-comment', {
            parent: 'entity',
            url: '/user-comment',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'UserComments'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/user-comment/user-comments.html',
                    controller: 'UserCommentController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('user-comment-detail', {
            parent: 'entity',
            url: '/user-comment/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'UserComment'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/user-comment/user-comment-detail.html',
                    controller: 'UserCommentDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'UserComment', function($stateParams, UserComment) {
                    return UserComment.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'user-comment',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('user-comment-detail.edit', {
            parent: 'user-comment-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-comment/user-comment-dialog.html',
                    controller: 'UserCommentDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['UserComment', function(UserComment) {
                            return UserComment.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('user-comment.new', {
            parent: 'user-comment',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-comment/user-comment-dialog.html',
                    controller: 'UserCommentDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                text: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('user-comment', null, { reload: 'user-comment' });
                }, function() {
                    $state.go('user-comment');
                });
            }]
        })
        .state('user-comment.edit', {
            parent: 'user-comment',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-comment/user-comment-dialog.html',
                    controller: 'UserCommentDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['UserComment', function(UserComment) {
                            return UserComment.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('user-comment', null, { reload: 'user-comment' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('user-comment.delete', {
            parent: 'user-comment',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/user-comment/user-comment-delete-dialog.html',
                    controller: 'UserCommentDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['UserComment', function(UserComment) {
                            return UserComment.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('user-comment', null, { reload: 'user-comment' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
