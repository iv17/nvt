(function() {
    'use strict';

    angular
        .module('nvtApp')
        .controller('SignInController', SignInController);


    SignInController.$inject = [ '$timeout', 'Auth'];

    function SignInController ($timeout, Auth) {
        var signIn = this;


    }
})();
