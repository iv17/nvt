(function() {
    'use strict';

    angular
        .module('nvtApp', [
            'ngResource',
            'ui.bootstrap',
            'ui.router'
        ])
        .run(run);

    <!-- vidi sta je ovo-->
    run.$inject = ['stateHandler'];

    function run(stateHandler) {
        stateHandler.initialize();
    }
})();
