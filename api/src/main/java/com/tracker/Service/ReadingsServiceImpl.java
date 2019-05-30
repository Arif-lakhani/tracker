package com.tracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.Entity.Alert;
import com.tracker.Entity.Readings;
import com.tracker.Entity.Vehicles;
import com.tracker.Repository.AlertRepo;
import com.tracker.Repository.ReadingsRepo;
import com.tracker.Repository.VehicleRepo;
@Service
public class ReadingsServiceImpl implements ReadingsService{
	@Autowired
	ReadingsRepo rp;
	@Autowired
	VehicleRepo v;
	@Autowired
	AlertRepo ar;
	public Readings createrNupdate(Readings r) {
		// TODO Auto-generated method stub
		Vehicles thisVehicle =v.findOne(r.getVin());
		if(r.getEngineRpm()>thisVehicle.getRedlineRpm()) {
			Alert rpmalert= new Alert();
			rpmalert.setMsg("Rpm has exceeded Redline rpm");
			rpmalert.setPriority("high");
			rpmalert.setVin(thisVehicle.getVin());
			rpmalert.setTimestamp(r.getTimestamp());
			ar.addAlert(rpmalert);
			}
		if(r.getFuelVolume()< 10*thisVehicle.getMaxFuelVolume()/100) {
			Alert fuelalert = new Alert();
			fuelalert.setMsg("fuel volume too low");
			fuelalert.setPriority("medium");
			fuelalert.setTimestamp(r.getTimestamp());
			fuelalert.setVin(thisVehicle.getVin());
			ar.addAlert(fuelalert);
		}
		if(r.getTires().getFrontLeft()< 32 || r.getTires().getFrontLeft() >36 ||
				r.getTires().getFrontRight()< 32 || r.getTires().getFrontRight()>36 ||
				r.getTires().getRearLeft()< 32 || r.getTires().getRearLeft() >36 ||
				r.getTires().getRearRight()< 32 || r.getTires().getRearRight()>36 ) {
			Alert tirealert = new Alert();
			tirealert.setMsg("Tire pressure chec needed ");
			tirealert.setPriority("low");
			tirealert.setTimestamp(r.getTimestamp());
			tirealert.setVin(r.getVin());
			ar.addAlert(tirealert);
		}
		if(r.isCheckEngineLightOn()||r.isEngineCoolantLow()) {
			Alert engineAlert = new Alert();
			engineAlert.setTimestamp(r.getTimestamp());
			engineAlert.setMsg("engine check required");
			engineAlert.setPriority("low");
			engineAlert.setVin(r.getVin());
			ar.addAlert(engineAlert);
			
		}
		rp.createrNupdate(r);
		return r;
	}
	
	public List<Readings> findOnebyVin(String id) {
		// TODO Auto-generated method stub
		return rp.findOnebyVin(id);
	}
	public List<Readings> plotSignalReadings(String vinId, float range) {
		// TODO Auto-generated method stub
		return rp.plotSignal(vinId, range);
	}

}
