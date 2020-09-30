package edu.uptc.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import edu.uptc.model.entity.Person;

public class PersonManager {

	private static final String NAME_WEB_APP = "FineVehicle";private static final String WARNING_GET_PERSON = "Can't find Person for document ";
	
	private static EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	
	public PersonManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory(NAME_WEB_APP);
		entityManager = entityManagerFactory.createEntityManager();
	}

	public void addPerson(Person conductor) {
		entityManager.getTransaction().begin();
		entityManager.persist(conductor);
		entityManager.getTransaction().commit();
	}
	
	public void updatePerson(Person person) {
		entityManager.getTransaction().begin();
		entityManager.merge(person);
		entityManager.getTransaction().commit();
	}

	public Person findPerson(int document) {
		Person persona = entityManager.find(Person.class, document);
   		if (persona == null) {
    		throw new EntityNotFoundException(WARNING_GET_PERSON+ document);
   		}
		return persona;
	}
}
