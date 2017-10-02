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
		'ngMap',
		'star-rating'
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
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
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
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
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
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
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
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
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
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
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
				url: "/register/:name/:lastname/:email/:username/:password/:repeated_password/:selectedCompany",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
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
			.state('register_company', {
				url: "/register_company/:username/:propertyNo/:email/:webAddress/:phoneNumber/:password/:repeated_password",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						controller: 'CompanyRegistrationController'
					}
				}
			})
			.state('user_profile', {
				url: "/user_profile/:userId",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						templateUrl: 'app/views/content/user_profile.html',
						controller: 'UserController'
					}
				}
			})
			.state('company_profile', {
				url: "/company_profile/:companyId",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						templateUrl: 'app/views/content/company_profile.html',
						controller: 'CompanyController'
					}
				}
			})
			.state('start_add_agent', {
				url: "/start_add_agent/:companyId",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						templateUrl: 'app/views/content/add_new_agent.html',
						controller: 'CompanyController'
					}
				}
			})
			.state('add_agent', {
				url: "/add_agent/{myParams: json}",
				params: {myParams : null},
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {
						templateUrl: 'app/views/sidebar_search.html',
						controller: 'SidebarSearchController'
					},
					'content@': {
						templateUrl: 'app/views/content/company_profile.html',
						controller: 'AddAgentController'
					}
				}
			})
			.state('realEstate', {
				url: "/realEstate/:realEstateId",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {

					},
					'content@': {
						controller: 'RatingsController'
					}
				}
			})
			.state('realEstate2', {
				url: "/realEstate2/:realEstateId",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {

					},
					'content@': {
						templateUrl: 'app/views/content/property.html',
						controller: 'RealEstateController'
					}
				}
			})
			.state('realEstateLatLng', {
				url: "/realEstateLatLng/{latlng: json}",
				params: {latlng : null},
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {

					},
					'content@': {
						templateUrl: 'app/views/content/property.html',
						controller: 'RealEstateLatLngController'
					}
				}
			})
			.state('open_add_realEstate', {
				url: "/open_add_realEstate",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {

					},
					'content@': {
						templateUrl: 'app/views/content/add_new_property.html',
						controller: 'StartAddRealEstateController'
					}
				}
			})
			.state('add_realestate', {
				url: "/add_realestate/{myParams: json}",
				params: {myParams : null},
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {

					},
					'content@': {
						controller: 'AddRealEstateController'
					}
				}
			})
			.state('create_comment', {
				url: "/create_comment/:commentText/:realEstateId",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {

					},
					'content@': {
						templateUrl: 'app/views/content/property.html',
						controller: 'CreateCommentController'
					}
				}
			})
			.state('create_report', {
				url: "/create_report/:realEstateId",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {

					},
					'content@': {
						templateUrl: 'app/views/content/property.html',
						controller: 'CreateReportController'
					}
				}
			})
			.state('rate_realEstate', {
				url: "/rate_realEstate/:rate/:realEstateId",
				views: {
					'navbar@': {
						templateUrl: 'app/views/navbar.html',
						controller: 'NavBarController'
					},
					'sidebar_menu@': {
						templateUrl: 'app/views/sidebar_menu.html'
					},
					'sidebar_search@': {

					},
					'content@': {
						templateUrl: 'app/views/content/property.html',
						controller: 'RateRealEstateController',
						controllerAs: 'rateCtrl'
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
