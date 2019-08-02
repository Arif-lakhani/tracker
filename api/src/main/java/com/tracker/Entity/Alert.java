package com.tracker.Entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Alert.findAll",query="select a from Alert a "),
	@NamedQuery(name="Alert.findAllHigh",query="select a from Alert a where a.priority=:priority"),
	@NamedQuery(name="Alert.findbyVin",query="select a from Alert a where a.vin= :vin")
})
public class Alert {
	@Id
	private String id;
	private String priority;
	private Timestamp timestamp;
	private String vin;
	public Alert() {
		this.id=UUID.randomUUID().toString();
	}
	@Override
	public String toString() {
		return "Alert [id=" + id + ", priority=" + priority + ", timestamp=" + timestamp + ", vin=" + vin + ", msg="
				+ msg + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private  String msg;
	

}
