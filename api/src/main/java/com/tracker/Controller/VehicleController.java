package com.tracker.Controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.Entity.Vehicles;
import com.tracker.Service.VehicleService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleController
{
	@Autowired
	private VehicleService service;


	@RequestMapping(method=RequestMethod.GET, value="/vehicles/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)

	public Vehicles findOne(@PathVariable("id")   String vin) {
		return service.findOne(vin);
	}

	@RequestMapping(method=RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, value="/vehicles",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vehicles[] insertNupdate(@RequestBody Vehicles[] v) 
	{
		return service.insertNupdate(v);
	}

	@RequestMapping(method=RequestMethod.GET,value="/vehicles",
			produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicles> findAll()
	{

		return service.findAll();

	}



}
