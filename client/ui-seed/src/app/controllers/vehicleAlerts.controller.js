(function() {
  'use strict';
  angular.module('myModule').controller('AlertsController', AlertsController);

  AlertsController.$inject = ['vehicleService'];

  function AlertsController(vehicleService) {
    var AlertsVm = this;
    AlertsVm.sorter = {
      sortOrder: true,
      sortBy: 'count'
    };
    vehicleService.getHAlerts().then(function(response) {
      AlertsVm.alertswithkey=[];
      AlertsVm.alerts = response;
      var i = 0;
      AlertsVm.alerts.forEach(function(element) {
       AlertsVm.alertswithkey[i]=element
        AlertsVm.alertswithkey[i].vin = element[0];
        AlertsVm.alertswithkey[i].priority = element[1];
        AlertsVm.alertswithkey[i].count = element[2];
        i++;

      });
    //  console.log(AlertsVm.alerts);

      console.log(AlertsVm.alertswithkey);
    }, function(error) {
      console.log(error);
    });
  }

})();