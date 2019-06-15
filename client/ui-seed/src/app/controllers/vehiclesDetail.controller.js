 (function() {
   'use strict';
   angular.module('myModule').controller('VehicleDetailsController', VehicleDetailsController);

   VehicleDetailsController.$inject = ['vehicleService', '$routeParams'];

   function VehicleDetailsController(vehicleService, $routeParams) {
     var detailVm = this;

  

       vehicleService.getById($routeParams.vin).then(function(response) {
       //  console.log($routeParams.vin);
      detailVm.car= response;
      detailVm.date= new Date(detailVm.car.lastServiceDate);
      console.log(detailVm.date);
     // console.log(detialVm.car.lastServiceDate);
       }, function(error) {
         console.log(error);
       });
     }
 })();