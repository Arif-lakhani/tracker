(function() {
  'use strict';
  angular.module('myModule').controller('GeoController', GeoController);

  GeoController.$inject = ['vehicleService', '$scope'];

  function GeoController(vehicleService, $scope) {
    var GeoVm = this;

    $scope.OnGeoClick = function(vin) {
      vehicleService.getGeo(vin).then(function(readings) {
        GeoVm.readings = readings;
        var Locations = GeoVm.readings;
        console.log(Locations[0].latitude+' '+Locations[0].longitude);
          var uluru = {lat: -25.344, lng: 131.036};

        var map = new google.maps.Map(document.getElementById('map'),{
          zoom : 1,
          center :
          new google.maps.LatLng(Locations[0].latitude, Locations[0].longitude),
          
                        mapTypeId: google.maps.MapTypeId.ROADMAP
        }
        );
        var marker, i; var infowindow = new google.maps.InfoWindow();
        for(i=0;i<Locations.length;i++){
          marker =new google.maps.Marker({position: new google.maps.LatLng(Locations[i].latitude, Locations[i].longitude), map: map});
        }
        google.maps.event.addListener(marker,'click',(function (marker,i){
          return function (){
                      console.log('click event');

            infowindow.setContent(Locations[i].latitude,Locations[i].longitude);
            infowindow.open(map,marker);
          }
        })(marker,i));

      }, function(error) {
        console.log(error);
      })
    }
  }
})();