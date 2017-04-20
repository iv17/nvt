(function() {
	angular
		.module('nvtApp')
		.factory('AdvertisementResource', ['Restangular', '_', function(Restangular, _) {
			'use strict';

			var advertisements = [];
			var retVal = {};

			retVal.getAdvertisements = function() {
				return Restangular.all("advertisements").getList().then(function(entries) {
					advertisements = entries;
					return advertisements;
				});
			};

			retVal.deleteAdvertisement = function(id) {
				return Restangular.one("advertisements", id).remove().then(function() {
					// uklanjamo advertisement sa zadatim id-om iz kolekcije
					_.remove(advertisements, {
						id: id
					});
				});
			};

			retVal.saveAdvertisement = function(advertisement) {
				if (advertisement.id) {
					return Restangular.all('advertisements').customPUT(advertisement).
					then(function(data) {
						var index = _.indexOf(advertisements,
							_.find(advertisements, {
								id: advertisement.id
							}));
						advertisements.splice(index, 1, data); //replaces advertisement
					});
				} else {
					return Restangular.all('advertisements').post(advertisement).
					then(function(data) {
						advertisements.push(data);
					});
				}
			};
			return retVal;
		}]);

})();
