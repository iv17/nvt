(function() {
	'use strict';

	angular
	.module('nvtApp', [
		'toastr',
		'ui.router',
		'ngRoute',
		'ngResource',
		'restangular',
		'ui.bootstrap',
		'lodash',
		'ngStorage',
		'angularjs-dropdown-multiselect',
		'ngMap'
		])
		.config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
			function($stateProvider, $urlRouterProvider, $locationProvider) {
			$locationProvider.hashPrefix('');
			$urlRouterProvider.otherwise('/');
			$stateProvider
			.state('home', {
				url: "/",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						templateUrl: 'app/views/content/propertiesList.html',
						controller: 'RealEstatesController'
					}
				}
			})
			.state('realestates_map', {
				url: "/realestates_map",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						templateUrl: 'app/views/content/map_search.html',
						controller: 'MapController'
					}
				}
			})
			.state('search', {
				url: "/search/{search: json}",
				params: {search : null},
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						templateUrl: 'app/views/content/propertiesList.html',
						controller: 'SearchController'
					}
				}
			})
			.state('login', {
				url: "/login/:username/:password",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						controller: 'LoginController'
					}
				}
			})
			.state('logout', {
				url: "/logout",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						controller: 'LogoutController'
					}
				}
			})
			.state('register', {
				url: "/register/:name/:lastname/:email/:username/:password/:repeated_password",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						controller: 'RegistrationController'
					}
				}
			})
			.state('realEstate', {
				url: "/realEstate/:realEstateId",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						templateUrl: 'app/views/content/property.html',
						controller: 'RealEstateController'
					}
				}
			})
			.state('realEstateLatLng', {
				//url: "/realEstateLatLng/:latlng",
				url: "/realEstateLatLng/{latlng: json}",
				params: {latlng : null},
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						templateUrl: 'app/views/content/property.html',
						controller: 'RealEstateLatLngController'
					}
				}
			});
		}])
		// run se izvrsava pre svega ostalog
		.run(['Restangular', '$log', '$localStorage',
			function(Restangular, $log, $localStorage) {
			Restangular.setBaseUrl("api");

			Restangular.addFullRequestInterceptor(
					function (element, operation, route, url, headers, params, httpConfig) {

						headers = {'X-Auth-Token':  $localStorage.token };

						return {
							element: element,
							params: params,
							headers: headers,
							httpConfig: httpConfig
						};

					});
			$log.info("started");
			Restangular.setErrorInterceptor(function(response) {
				if (response.status === 500) {
					$log.info("internal server error");
					return true;
				}
				return true;
			});
		}]);
})();
