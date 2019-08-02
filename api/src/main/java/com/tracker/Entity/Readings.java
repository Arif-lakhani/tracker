package com.tracker.Entity;


import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
@NamedQuery(name="Readings.findAll",query="select r from Readings r"),
@NamedQuery(name="Readings.findOnebyVin", query= "select r from Readings r where r.vin=:vin")
})
public class Readings {
	
	@Id
	private String rid;
	private String vin;
	private double latitude;
	private double longitude;
	private Timestamp timestamp;
	private double fuelVolume;
	private double speed;
	private double engineHp;
	private boolean checkEngineLightOn;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private double engineRpm;
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public double getFuelVolume() {
		return fuelVolume;
	}
	public void setFuelVolume(double fuelVolume) {
		this.fuelVolume = fuelVolume;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getEngineHp() {
		return engineHp;
	}
	public void setEngineHp(double engineHp) {
		this.engineHp = engineHp;
	}
	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}
	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}
	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}
	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}
	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}
	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}
	public double getEngineRpm() {
		return engineRpm;
	}
	public void setEngineRpm(double engineRpm) {
		this.engineRpm = engineRpm;
	}
	public Tires getTires() {
		return tires;
	}
	public void setTires(Tires tires) {
		this.tires = tires;
	}
	@Override
	public String toString() {
		return "Readings [rid=" + rid + ", vin=" + vin + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", timestamp=" + timestamp + ", fuelVolume=" + fuelVolume + ", speed=" + speed + ", engineHp="
				+ engineHp + ", checkEngineLightOn=" + checkEngineLightOn + ", engineCoolantLow=" + engineCoolantLow
				+ ", cruiseControlOn=" + cruiseControlOn + ", engineRpm=" + engineRpm + ", tires="  + tires+"]";
	}
	@OneToOne(cascade = {CascadeType.ALL})
	Tires tires;
	public Readings() {
		rid=UUID.randomUUID().toString();
	}
	
}
