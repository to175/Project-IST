package fr.efrei.web;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public class Car extends Vehicle {
	int numberOfSeats;

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Car() {
		super();
	}
	
	public Car(int numberOfSeats) {
		super();
		this.numberOfSeats = numberOfSeats;
	}
}
