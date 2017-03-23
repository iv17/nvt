(function() {
    'use strict';
    angular
        .module('realestateApp')
        .factory('RealEstate', RealEstate);

    RealEstate.$inject = ['$resource', 'DateUtils'];

    function RealEstate ($resource, DateUtils) {
        var resourceUrl =  'api/real-estates/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.created = DateUtils.convertDateTimeFromServer(data.created);
                        data.updated = DateUtils.convertDateTimeFromServer(data.updated);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
