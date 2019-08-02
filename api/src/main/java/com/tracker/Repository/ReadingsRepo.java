package com.tracker.Repository;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.tracker.Entity.Readings;

public interface ReadingsRepo {
	public Readings createrNupdate(Readings r);
	public List<Readings> findAll();
	public List<Readings> findOnebyVin( String vin);
	public List<Readings> plotSignal(String vin, float time);
 
}
