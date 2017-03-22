(function() {
    'use strict';

    angular
        .module('realestateApp', [
           
        ])
        .run(run);

    run.$inject = ['stateHandler'];

    function run(stateHandler) {
        stateHandler.initialize();
    }
})();
