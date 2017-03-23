(function() {
    'use strict';
    angular
        .module('realestateApp')
        .factory('UserRating', UserRating);

    UserRating.$inject = ['$resource'];

    function UserRating ($resource) {
        var resourceUrl =  'api/user-ratings/:id';

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
