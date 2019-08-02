(function() {
  'use strict';
  angular.module('myModule', ['ngRoute', 'zingchart-angularjs']);

  angular.module('myModule').config(moduleConfig);

  moduleConfig.$inject = ['$routeProvider'];

  function moduleConfig($routeProvider) {
    $routeProvider.
    when('/vehicles', {
        templateUrl: 'vehicleList.tmpl.html',
        controller: 'VehicleController',
        controllerAs: 'VehicleVm'
      })
      .when('/vehicles/:vin', {
        templateUrl: 'vehicleDetails.tmpl.html',
        controller: 'VehicleDetailsController',
        controllerAs: 'detailVm'
      })
      .when('/highAlerts', {
        templateUrl: 'alerts.tmpl.html',
        controller: 'AlertsController',
        controllerAs: 'AlertsVm'

      })
      .when('/plotsignals', {
        templateUrl: 'signalplot.tmpl.html',
        controller: 'SignalPlotController',
        controllerAs: 'PlotVm'

      })
      .when('/geolocation', {
        templateUrl: 'geoloc.tmpl.html',
        controller: 'GeoController',
        controllerAs: 'GeoVm'
      })
      .when('/histroy', {
        templateUrl: 'history.tmpl.html',
        controller: 'VehicleHistoryController',
        controllerAs: 'HistoryVm'

      })
      .otherwise({
        redirectTo: '/vehicles'
      })
  }


})();