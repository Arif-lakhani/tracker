(function() {
  'use strict';
  angular.module('myModule').controller('VehicleController', VehicleController);

  VehicleController.$inject = ['vehicleService'];

  function VehicleController(vehicleService) {
     var VehicleVm = this;
     VehicleVm.title="List";
    vehicleService.get().then(function(response) {

      VehicleVm.cars = response;
  //  console.log(VehicleVm.cars);
    }, function(error) {
      console.log(error);
    });

   
    
    VehicleVm.sorter={
      sortBy:'year',
      sortOrder:'true'
    };




  }

})();