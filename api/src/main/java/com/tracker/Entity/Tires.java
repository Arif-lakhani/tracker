package com.tracker.Entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
	public class Tires {
		@Id
		String id;
		public Tires() {
			this.id=UUID.randomUUID().toString();
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public double getFrontLeft() {
			return frontLeft;
		}
		public void setFrontLeft(double frontLeft) {
			this.frontLeft = frontLeft;
		}
		public double getFrontRight() {
			return frontRight;
		}
		public void setFrontRight(double frontRight) {
			this.frontRight = frontRight;
		}
		public double getRearLeft() {
			return rearLeft;
		}
		public void setRearLeft(double rearLeft) {
			this.rearLeft = rearLeft;
		}
		public double getRearRight() {
			return rearRight;
		}
		public void setRearRight(double rearRight) {
			this.rearRight = rearRight;
		}
		double frontLeft;
		double frontRight;
		double rearLeft;
		double rearRight;
	}
	