package edu.uptc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.uptc.model.entity.Agent;

public class AgentManager {
	
	private static final String SELECT_ALL_AGENTS = "SELECT e FROM Agent e";
	private static final String NAME_WEB_APP = "FineVehicle";
	
	private static EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	
	public AgentManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory(NAME_WEB_APP);
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public static Agent createAgent(String state, int document, String name, String lastName, String direction) 
					throws IndexOutOfBoundsException {
		return new Agent(document, name, lastName, direction, state);
	}
	
	@SuppressWarnings("unchecked")
	public List<Agent> findAllAgents() {
		return entityManager.createQuery(SELECT_ALL_AGENTS).getResultList();
	}
}
