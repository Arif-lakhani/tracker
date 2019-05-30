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

import com.tracker.Entity.Readings;
import com.tracker.Service.ReadingsService;

@RestController
@CrossOrigin(origins="*",maxAge=3600)
@RequestMapping("/readings")
public class ReadingController {
	@Autowired
	private ReadingsService service;
	@RequestMapping(method=RequestMethod.POST,
			
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Readings createNupdate(@RequestBody Readings r) {
	System.out.println(r);
		service.createrNupdate(r);
		return r;
	}
	@RequestMapping(method=RequestMethod.GET,
			value= "/{id}/{range}",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Readings> plotSignalReadings(@PathVariable("id") String vinId, @PathVariable("range") float range)
	{
		return service.plotSignalReadings(vinId,range);
		
	}
	@RequestMapping(method=RequestMethod.GET,
			value= "/{id}",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Readings> findOnebyVin(@PathVariable("id") String vin) {
		return service.findOnebyVin(vin);
	}

}
