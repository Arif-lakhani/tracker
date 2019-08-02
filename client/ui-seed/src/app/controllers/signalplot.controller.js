(function() {
  'use strict';
  angular.module('myModule').controller('SignalPlotController', SignalPlotController);

  SignalPlotController.$inject = ['vehicleService', '$scope'];

  function SignalPlotController(vehicleService, $scope) {
    var PlotVm = this;

    console.log('now adding to scope');

    $scope.OnClickSignal = function() {
      console.log('Radio '+ PlotVm.options)
      vehicleService.getPlotreadings(PlotVm.vin, PlotVm.range).then(function(response) {
        PlotVm.readings = response;
        console.log('readings are' + PlotVm.readings);

        var abc;
        var fuelReadings = [];
        for (var i = 0; i < PlotVm.readings.length; i++) {
          if(PlotVm.options=='fuel'){
            
          
          fuelReadings.push(PlotVm.readings[i].fuelVolume);
             abc='Fuel Volume';
          }
          else
          fuelReadings.push(PlotVm.readings[i].engineRpm);
          abc='Engine Rpm';

        }
        console.log(PlotVm.vin + " " + PlotVm.range);
        $scope.myJson = {
          gui: {
            contextMenu: {
              button: {
                visible: 0
              }
            }
          },
          backgroundColor: "#434343",
          globals: {
            shadow: false,
            fontFamily: "Helvetica"
          },
          type: "area",

          legend: {
            layout: "x4",
            backgroundColor: "transparent",
            borderColor: "transparent",
            marker: {
              borderRadius: "50px",
              borderColor: "transparent"
            },
            item: {
              fontColor: "white"
            }

          },
          scaleX: {
            maxItems: 8,
            transform: {
              type: 'date'
            },
            zooming: true,

            lineColor: "white",
            lineWidth: "1px",
            tick: {
              lineColor: "white",
              lineWidth: "1px"
            },
            item: {
              fontColor: "white"
            },
            guide: {
              visible: false
            }
          },
          scaleY: {
            lineColor: "white",
            lineWidth: "1px",
            tick: {
              lineColor: "white",
              lineWidth: "1px"
            },
            guide: {
              lineStyle: "solid",
              lineColor: "#626262"
            },
            item: {
              fontColor: "white"
            },
          },
          tooltip: {
            visible: false
          },
          crosshairX: {
            scaleLabel: {
              backgroundColor: "#fff",
              fontColor: "black"
            },
            plotLabel: {
              backgroundColor: "#434343",
              fontColor: "#FFF",
              _text: "Number of hits : %v"
            }
          },
          plot: {
            lineWidth: "2px",
            aspect: "spline",
            marker: {
              visible: false
            }
          },
          series: [{
            text: abc,
            values: fuelReadings,
            backgroundColor1: "#77d9f8",
            backgroundColor2: "#272822",
            lineColor: "#40beeb"
          }]
        };



      }, function(error) {
        console.log(error);
      });

    }
  }
})();