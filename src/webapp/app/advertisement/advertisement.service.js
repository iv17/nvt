(function() {
    'use strict';
    angular
        .module('nvtApp')
        .factory('Advertisement', Advertisement);

    Advertisement.$inject = ['$resource', 'DateUtils'];

    function Advertisement ($resource, DateUtils) {
        var resourceUrl =  'api/advertisement/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);

                    }
                    return data;
                }
            },
            'save': { method:'POST' }
            'update': { method:'PUT' },
            'delete': { method:'DELETE'}
        });
    }
})();
