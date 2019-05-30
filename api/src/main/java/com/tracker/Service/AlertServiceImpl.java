package com.tracker.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.Entity.Alert;
import com.tracker.Entity.HighAlerts;
import com.tracker.Repository.AlertRepo;
@Service
public class AlertServiceImpl implements AlertService{
	@Autowired
	private AlertRepo repo;

	public List<HighAlerts> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
		}

	public List<Alert> findOnebyVin(String vin) {
		// TODO Auto-generated method stub
		return repo.findOnebyVin(vin);
	}
}

