(function() {
    'use strict';

    angular
        .module('realestateApp')
        .controller('UserCommentController', UserCommentController);

    UserCommentController.$inject = ['$scope', '$state', 'UserComment'];

    function UserCommentController ($scope, $state, UserComment) {
        var vm = this;

        vm.userComments = [];

        loadAll();

        function loadAll() {
            UserComment.query(function(result) {
                vm.userComments = result;
                vm.searchQuery = null;
            });
        }
    }
})();
