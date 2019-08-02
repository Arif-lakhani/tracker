package com.tracker.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.Entity.*;
import com.tracker.Repository.*;
@Service
public class VehicleServiceImpl implements VehicleService{
	@Autowired
	VehicleRepo vr;
	
	public List<Vehicles> findAll() {
		return vr.findAll();
	}
	
	public Vehicles[] insertNupdate(Vehicles[] v) {
		// TODO Auto-generated method stub
		return vr.insertNupdate(v);
	}

	public Vehicles findOne(String vin) {
		// TODO Auto-generated method stub
		return vr.findOne(vin);
	}

	
}
