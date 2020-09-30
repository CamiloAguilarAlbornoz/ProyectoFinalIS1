package edu.uptc.model.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import org.jboss.resteasy.spi.ReaderException;

import edu.uptc.model.entity.Conductor;
import edu.uptc.model.entity.Vehicle;

public class ConductorManager {

	private static final String SELECT_ALL_CONDUCTORS = "SELECT e FROM Conductor e";
	private static final String NAME_WEB_APP = "FineVehicle";
	private static final int MIN_YEAR = 1960;
	private static final String EXCEPTION_REPEAT_VEHICLE = "Ya se ha realizado un registro con datos similares";
	private static final String EXCEPTION_DATE = "Mal ingreso de fechas";
	private static final String EXEPTION_READ_VEHICLE = "Can't find Vehicle for licensePlate ";
	
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
				Conductor conductor  = new Conductor(STATE_CONDUCTOR.ACTIVE.toString(), document, name, lastName, direction, 
						dateExpedition, dateExpiration);
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
			throw new EntityNotFoundException(EXEPTION_READ_VEHICLE+ licensePlate);
		}
		return vehicle;
	}
	
	private static boolean isValidate(Date dateExpedition, Date dateExpiration) {
		LocalDate expedition = dateExpedition.toLocalDate();
		LocalDate expiration = dateExpiration.toLocalDate();
		Period period = Period.between(expedition, expiration);
		return period.getYears() > 0;
	}
	
	@SuppressWarnings("unchecked")
	public List<Conductor> findAllConductors() {
		return entityManager.createQuery(SELECT_ALL_CONDUCTORS).getResultList();
	}
}
