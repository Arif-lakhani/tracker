package com.tracker.Service;

import java.util.List;

import com.tracker.Entity.Readings;

public interface ReadingsService {
	public List<Readings> findOnebyVin(String id);
public Readings createrNupdate(Readings r);
public List<Readings> plotSignalReadings(String vinId, float range);
}
