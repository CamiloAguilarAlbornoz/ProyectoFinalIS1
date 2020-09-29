package edu.uptc.model.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="conductor_tabla")
@PrimaryKeyJoinColumn(referencedColumnName = "documento")
public class Conductor extends Person {

	@Column(name = "fecha_expedicion_licencia")
	private Date dateExpedition;
	@Column(name = "fecha_expiracion_licencia")
	private Date dateExpiration;
	@Column(name = "estado")
	private String state;
	@OneToOne(mappedBy = "conductor",  cascade = CascadeType.ALL)
	@JoinColumn(name = "c_documento", referencedColumnName = "documento")
	private Vehicle vehicle;
	@OneToMany(mappedBy = "conductor", cascade = {CascadeType.ALL})
//	@JoinColumn(name = "c_person_documento", referencedColumnName = "documento")
	private List<PenaltyFee> penaltyFeesList;
	
	public Conductor() {
		penaltyFeesList = new ArrayList<PenaltyFee>();
	}

	public Conductor(int document, String name, String lastName, String direction, Date dateExpedition,
			Date dateExpiration, String state) {
		super(document, name, lastName, direction);
		this.dateExpedition = dateExpedition;
		this.dateExpiration = dateExpiration;
		this.state = state;
		penaltyFeesList = new ArrayList<PenaltyFee>();
	}

	public Date getDateExpedition() {
		return dateExpedition;
	}

	public void setDateExpedition(Date dateExpedition) {
		this.dateExpedition = dateExpedition;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<PenaltyFee> getPenaltyFeesList() {
		return penaltyFeesList;
	}

	public void setPenaltyFeesList(List<PenaltyFee> penaltyFeesList) {
		this.penaltyFeesList = penaltyFeesList;
	}
}
