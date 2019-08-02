package com.tracker.Service;

import java.util.List;


import com.tracker.Entity.Alert;
import com.tracker.Entity.HighAlerts;

public interface AlertService {
	public List<HighAlerts> findAll();
	public List<Alert> findOnebyVin(String vin);

}
