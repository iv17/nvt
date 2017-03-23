(function() {
    'use strict';
    angular
        .module('realestateApp')
        .factory('UserComment', UserComment);

    UserComment.$inject = ['$resource'];

    function UserComment ($resource) {
        var resourceUrl =  'api/user-comments/:id';

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
            'update': { method:'PUT' }
        });
    }
})();
