package fr.efrei.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarService {
	
	public CarService() {
		super();
	}
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
	EntityManager entityManager = emf.createEntityManager();
	EntityTransaction tx = entityManager.getTransaction();
	
	public List<Vehicle>getAll() {//getAll cars in the table vehicle
		return entityManager.createQuery("SELECT v FROM Vehicle v", Vehicle.class).getResultList();
	}

	public void creerCar(Car Car){
		tx.begin();
		Vehicle v = new Vehicle();
		v.setPlatenumber("1234");
		System.out.println("creerCar: " + Car);
		tx.commit();
	}
	
	public void supprimerCar( String immat){
		entityManager.createQuery("DELETE v FROM Vehicle v WHERE Platenumber="+immat, Vehicle.class).getResultList();
	}
	
	public Vehicle obtenirUneCar( String immat){
		return entityManager.createQuery("SELECT v FROM Vehicle v WHERE Platenumber="+immat, Vehicle.class).getSingleResult();
	}

	public List<Car> obtenirUneListeDeCars(){
		List<Car> listes  = new  ArrayList<Car>();
		// ?
		return listes;
	}
	
}
