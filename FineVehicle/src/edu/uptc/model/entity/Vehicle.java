package edu.uptc.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehiculo_tabla")
public class Vehicle {

	@Id
	@Column(name="placa")
	private String licensePlate;
	@Column(name="marca")
	private String trademark;
	@Column(name="anio")
	private Date year;
	@Column(name="documento")
	private int document;
	@OneToOne
	private Conductor conductor;
	
	public Vehicle(int document, String licensePlate, String trademark, Date year) {
		this.document = document;
		this.licensePlate = licensePlate;
		this.trademark = trademark;
		this.year = year;
	}

	public Vehicle() {}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getTrademark() {
		return trademark;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
}
