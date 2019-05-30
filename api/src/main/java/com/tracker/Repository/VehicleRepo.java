package com.tracker.Repository;

import java.util.List;



import com.tracker.Entity.*;

public interface VehicleRepo {
	public List<Vehicles> findAll();
	public Vehicles[] insertNupdate(Vehicles[] v);
	public Vehicles findOne(String vin);
}
