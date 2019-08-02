package com.tracker.Entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries
({@NamedQuery(name = "Vehicles.findAll", query = "select v from Vehicles v "),
@NamedQuery(name="Vehicles.findOne", query="select v from Vehicles v where v.vin=:vin")})
public class Vehicles {
	@Id	
	private String vin; 
	private String make;
	private String model;
	private int year;
	private double redlineRpm;
	private double maxFuelVolume;
	private Timestamp lastServiceDate;
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getRedlineRpm() {
		return redlineRpm;
	}

	public void setRedlineRpm(double redlineRpm) {
		this.redlineRpm = redlineRpm;
	}

	public double getMaxFuelVolume() {
		return maxFuelVolume;
	}

	public void setMaxFuelVolume(double maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}

	public Timestamp getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(Timestamp lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	@Override
	public String toString() {
		return "Vehicles [vin=" + vin + ", make=" + make + ", model=" + model + ", year=" + year + ", redlinerpm="
				+ redlineRpm + ", maxfuel=" + maxFuelVolume + ", lastservDate=" + lastServiceDate + "]";
	}

}
