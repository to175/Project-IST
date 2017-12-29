package fr.efrei.web;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public class Van extends Vehicle {
	long maxWeight;

	public long getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(long maxWeight) {
		this.maxWeight = maxWeight;
	}

	public Van() {
		super();
	}
	
	public Van(long maxWeight) {
		super();
		this.maxWeight = maxWeight;
	}
}
