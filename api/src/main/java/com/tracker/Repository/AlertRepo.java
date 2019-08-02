package com.tracker.Repository;

import java.util.List;


import com.tracker.Entity.Alert;
import com.tracker.Entity.HighAlerts;

public interface AlertRepo {
public List<HighAlerts> findAll();
public List<Alert> findOnebyVin(String vin);
public Alert addAlert(Alert a);

}

