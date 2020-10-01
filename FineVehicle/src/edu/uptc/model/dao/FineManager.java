package edu.uptc.model.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.uptc.model.entity.Agent;
import edu.uptc.model.entity.Conductor;
import edu.uptc.model.entity.PenaltyFee;

public class FineManager {

	private static final String NAME_WEB_APP = "FineVehicle";
	private static final int MIN_VALUE = 10000;
	private static final String EXCEPTION_VALUE = "Muy barato";
	private static final String SELECT_ALL_FINES = "SELECT e FROM PenaltyFee e";
	
	private static EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	
	public FineManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory(NAME_WEB_APP);
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static PenaltyFee createPenaltyFree(int id, Date date, String description, String state, int value,
			Conductor conductor, Agent agent) {
		if (value >= MIN_VALUE) {
			return new PenaltyFee(id, date, description, state, value, conductor, agent);
		}
		throw new IndexOutOfBoundsException(EXCEPTION_VALUE);
	}
	
	public void addFine(PenaltyFee penaltyFee) {
		entityManager.getTransaction().begin();
		entityManager.persist(penaltyFee);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<PenaltyFee> findAllFines() {
		return entityManager.createQuery(SELECT_ALL_FINES).getResultList();
	}
}
