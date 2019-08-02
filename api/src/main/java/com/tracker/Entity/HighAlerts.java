package com.tracker.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HighAlerts {
	@Id
	String id;
	String priority;
	long count;
	public HighAlerts(String id, String priority, long count) {
		this.id = id;
		this.priority = priority;
		this.count = count;
	}

}
