(function() {
  'use strict';
  angular.module('myModule').controller('VehicleHistoryController', VehicleHistoryController);

  VehicleHistoryController.$inject = ['vehicleService', '$scope'];

  function VehicleHistoryController(vehicleService, $scope) {
    var HistoryVm = this;

    $scope.OnClick = function() {
      //console.log(HistoryVm.abc);
      console.log(HistoryVm.vin);
      vehicleService.getAllalerts(HistoryVm.vin).then(function(response) {
        HistoryVm.alerts = response;
        console.log('historyVm.alerts'+HistoryVm.alerts);

      }, function(error) {
        console.log(error);
      });
    }
  }
})();