package com.tracker.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.Entity.Alert;
import com.tracker.Entity.HighAlerts;
import com.tracker.Service.AlertService;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping(value="/alert")

public class AlertController{
	@Autowired
	private AlertService service;
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)

	public List<HighAlerts> findAll() {
		return service.findAll();
	}
	@RequestMapping(method=RequestMethod.GET,value="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> findOnebyVin(@PathVariable("id") String vin){
		return service.findOnebyVin(vin);
	}
}
