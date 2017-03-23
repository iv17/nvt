(function() {
    'use strict';

    angular
        .module('realestateApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('report', {
            parent: 'entity',
            url: '/report',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Reports'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/report/reports.html',
                    controller: 'ReportController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
            }
        })
        .state('report-detail', {
            parent: 'entity',
            url: '/report/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Report'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/report/report-detail.html',
                    controller: 'ReportDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                entity: ['$stateParams', 'Report', function($stateParams, Report) {
                    return Report.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'report',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('report-detail.edit', {
            parent: 'report-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/report/report-dialog.html',
                    controller: 'ReportDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Report', function(Report) {
                            return Report.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('report.new', {
            parent: 'report',
            url: '/new/{id}',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/report/report-dialog.html',
                    controller: 'ReportDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                reason: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('report', null, { reload: 'report' });
                }, function() {
                    $state.go('report');
                });
            }]
        })
        .state('report.edit', {
            parent: 'report',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/report/report-dialog.html',
                    controller: 'ReportDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Report', function(Report) {
                            return Report.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('report', null, { reload: 'report' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('report.delete', {
            parent: 'report',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/report/report-delete-dialog.html',
                    controller: 'ReportDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Report', function(Report) {
                            return Report.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('report', null, { reload: 'report' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
