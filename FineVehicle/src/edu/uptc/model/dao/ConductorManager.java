package edu.uptc.model.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import org.jboss.resteasy.spi.ReaderException;

import edu.uptc.model.entity.Conductor;
import edu.uptc.model.entity.Vehicle;

public class ConductorManager {

	private static final String NAME_WEB_APP = "FineVehicle";
	private static final int MIN_YEAR = 1960;
	private static final String EXCEPTION_REPEAT_VEHICLE = "Ya se ha realizado un registro con datos similares";
	private static final String EXCEPTION_DATE = "Mal ingreso de fechas";
	
	private static EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	
	public ConductorManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory(NAME_WEB_APP);
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static Conductor createConductor(int document, String name, String lastName, String direction, 
			Date dateExpedition, Date dateExpiration, String licensePlate, String trademark, int year) 
					throws IndexOutOfBoundsException {
		if (!existVehicle(licensePlate)) {
			if ((year > MIN_YEAR && year <= LocalDate.now().getYear()) &&
					(isValidate(dateExpedition, dateExpiration))) {
				Vehicle vehicle = new Vehicle(document, licensePlate, trademark, year);
				Conductor conductor  = new Conductor(document, name, lastName, direction, dateExpedition, dateExpiration, 
						STATE_CONDUCTOR.ACTIVE.name());
				vehicle.setConductor(conductor);
				conductor.setVehicle(vehicle);
				return conductor;
			} else {
				throw new IndexOutOfBoundsException(EXCEPTION_DATE);
			}
		} else {
			throw new ReaderException(EXCEPTION_REPEAT_VEHICLE);
		}
	}

	public void addConductor(Conductor conductor) {
		entityManager.getTransaction().begin();
		entityManager.persist(conductor);
		entityManager.getTransaction().commit();
	}
	
	public void removeConductor(Conductor conductor) {
		entityManager.getTransaction().begin();
		entityManager.remove(conductor);
		entityManager.getTransaction().commit();
	}
	
	private static boolean existVehicle(String licensePlate) {
		boolean exist = true;
		try {
			readVehicle(licensePlate);
		} catch (EntityNotFoundException e) {
			exist = false;
		}
		return exist;
	}
	
	private static Vehicle readVehicle(String licensePlate) {
		Vehicle vehicle = entityManager.find(Vehicle.class, licensePlate);
		if (vehicle == null) {
			throw new EntityNotFoundException("Can't find Vehicle for licensePlate "+ licensePlate);
		}
		return vehicle;
	}

	public Conductor readConductor(int document) {
		Conductor conductor = entityManager.find(Conductor.class, document);
   		if (conductor == null) {
    		throw new EntityNotFoundException("Can't find Conductor for document "+ document);
   		}
		return conductor;
	}
	
	private static boolean isValidate(Date dateExpedition, Date dateExpiration) {
		LocalDate expedition = dateExpedition.toLocalDate();
		LocalDate expiration = dateExpiration.toLocalDate();
		Period period = Period.between(expedition, expiration);
		return period.getYears() > 0;
	}
}
