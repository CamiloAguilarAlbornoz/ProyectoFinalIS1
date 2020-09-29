package edu.uptc.model.dao;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.uptc.model.entity.Conductor;
import edu.uptc.model.entity.Vehicle;

public class ConductorManager {

	private static final String NAME_WEB_APP = "FineVehicle";
	
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	
	public ConductorManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory(NAME_WEB_APP);
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static Conductor createConductor(int document, String name, String lastName, String direction, 
			Date dateExpedition, Date dateExpiration, String licensePlate, String trademark, Date year) {
		Conductor conductor  = new Conductor(document, name, lastName, direction, dateExpedition, dateExpiration, 
				STATE_CONDUCTOR.ACTIVE.name());
		Vehicle vehicle = new Vehicle(document, licensePlate, trademark, year);
		vehicle.setConductor(conductor);
		conductor.setVehicle(vehicle);
		return conductor;
	}
	
	public boolean addConductor(Conductor conductor) {
		entityManager.getTransaction().begin();
		entityManager.persist(conductor);
		entityManager.getTransaction().commit();
		return true;
	}
}
