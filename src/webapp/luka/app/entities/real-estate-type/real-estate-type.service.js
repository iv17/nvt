(function() {
    'use strict';
    angular
        .module('realestateApp')
        .factory('RealEstateType', RealEstateType);

    RealEstateType.$inject = ['$resource'];

    function RealEstateType ($resource) {
        var resourceUrl =  'api/real-estate-types/:id';

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
