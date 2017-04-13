(function() {
    'use strict';

    angular
        .module('nvtApp', [
            'ngResource',
            'ngRoute',
            'ui.bootstrap',
            'ui.router'
        ])
        .run(['Restangular', '$log', function(Restangular, $log) {
    // postavimo base url za Restangular da ne bismo morali da ga
    // navodimo svaki put kada se obracamo back endu
    // poziv vrsimo na http://localhost:8080/api/
    Restangular.setBaseUrl("api");
    Restangular.setErrorInterceptor(function(response) {
      if (response.status === 500) {
        $log.info("internal server error");
        return true; // greska je obradjena
      }
      return true; // greska nije obradjena
    });
  }]);
})();
