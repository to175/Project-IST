/*Lancement hsqldb : 
Aller dans le dossier lib de hsqldb et executer
>>> java -cp hsqldb.jar org.hsqldb.Server
>>> java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing
Aller dans le dossier activemq et executer
>>> start
Aller sur http://localhost.com:8161/admin



*/
package fr.efrei;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.efrei.web.Person;
import fr.efrei.web.Rent;
import fr.efrei.web.Vehicle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		
    	try{
			tx.begin();
			
			Person p = new Person();
			p.setName("Tintin");

			Vehicle v = new Vehicle();
			v.setPlatenumber("1234");
			
			Rent r = new Rent();
			r.setPerson(p);
			r.setVehicle(v);
			
			p.getRents().add(r);
			v.getRents().add(r);
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date beginDate = dateFormat.parse("23/09/2015");
			
			entityManager.persist(p);
			entityManager.persist(r);
			entityManager.persist(v);
				
			tx.commit();			
		
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
	}
}
