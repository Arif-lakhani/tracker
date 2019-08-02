package com.tracker.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tracker.Entity.*;
public interface VehicleService {
	
	public List<Vehicles> findAll();
	public Vehicles[] insertNupdate(Vehicles[] v);
	public Vehicles findOne(String vin);

}
