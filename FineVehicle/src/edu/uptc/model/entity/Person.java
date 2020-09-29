package edu.uptc.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity (name="persona_tabla")
@Inheritance (strategy = InheritanceType.JOINED)
public class Person {

	@Id
	@Column(name="documento")
	protected int document;
	@Column(name="nombre")
	protected String name;
	@Column(name="apellido")
	protected String lastName;
	@Column(name="direccion")
	protected String direction;

	public Person(int document, String name, String lastName, String direction) {
		this.document = document;
		this.name = name;
		this.lastName = lastName;
		this.direction = direction;
	}

	public Person() {}

	public int getDocument() {
		return document;
	}

	public void setDocument(int document) {
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}
