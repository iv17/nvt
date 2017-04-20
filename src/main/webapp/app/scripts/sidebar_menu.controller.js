(function() {
    'use strict';

    angular
        .module('nvtApp')
        .controller('SidebarMenuController', SidebarMenuController);

    SidebarMenuController.$inject = ['$scope', '$state'];

    function SidebarMenuController ($scope, $state) {
        var sidebarMenu = this;
    }
})();
