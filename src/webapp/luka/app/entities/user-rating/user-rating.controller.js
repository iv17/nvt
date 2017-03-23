(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('UserRatingController', UserRatingController);

    UserRatingController.$inject = ['$scope', '$state', 'UserRating'];

    function UserRatingController ($scope, $state, UserRating) {
        var vm = this;

        vm.userRatings = [];

        loadAll();

        function loadAll() {
            UserRating.query(function(result) {
                vm.userRatings = result;
                vm.searchQuery = null;
            });
        }
    }
})();
