package fr.efrei.web;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

@Entity
public class Rent {
	
	long id;
	long price;
	Date begingRent;
	Date endRent;
	private Vehicle vehicle;
	private Person person;
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	

	@Temporal(TemporalType.DATE)
	public Date getBegingRent() {
		return begingRent;
	}

	public void setBegingRent(Date begingRent) {
		this.begingRent = begingRent;
	}

	@Temporal(TemporalType.DATE)
	public Date getEndRent() {
		return endRent;
	}
	
	public void setEndRent(Date endRent) {
		this.endRent = endRent;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}	
	
}