(function() {
  'use strict';
  angular.module('myModule').service('vehicleService', vehicleService);

  vehicleService.$inject = ['$http', '$q'];

  function vehicleService($http, $q) {
    var self = this;
    self.get = getAll;
    self.getById = getOne;
    self.getHAlerts = getHighAlerts;
    self.getAllalerts = getAllAlerts;
    self.getPlotreadings =getPlotSignals
    self.getGeo = getGeoloc;
    
    function getAll() {
      return $http.get('http://localhost:8080/finaltracker/api/vehicles').then(successfn, errorfn);
    }

    function getOne(id) {
      return $http.get('http://localhost:8080/finaltracker/api/vehicles/' + id).then(successfn, errorfn);
    }
    function getHighAlerts(){
      return $http.get('http://localhost:8080/finaltracker/api/alert/').then(successfn,errorfn);
    }
    
    function getAllAlerts(id){
      return $http.get('http://localhost:8080/finaltracker/api/alert/' + id).then(successfn,errorfn);
    }
    
    function getPlotSignals(id,range){
      return $http.get('http://localhost:8080/finaltracker/api/readings/'+id+'/'+range).then(successfn,errorfn);
    }
    
    function getGeoloc(id){
            return $http.get('http://localhost:8080/finaltracker/api/readings/'+id).then(successfn,errorfn);

    }

    function successfn(response) {
      
      return response.data;
    }

    function errorfn(error) {
      return $q.reject(error);
    }

  }


})();