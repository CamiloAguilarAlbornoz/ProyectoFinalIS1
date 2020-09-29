package edu.uptc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "agente_tabla")
@PrimaryKeyJoinColumn(referencedColumnName = "numero_agente")
public class Agent extends Person {

	@Column(name="estado")
	private String state;
	@OneToMany(mappedBy = "agent", cascade = {CascadeType.ALL})
	@JoinColumn(name = "a_person_documento", referencedColumnName = "documento")
	private List<PenaltyFee> penaltyFeesList;

	public Agent() {
		penaltyFeesList = new ArrayList<PenaltyFee>();
	}

	public Agent(int document, String name, String lastName, String direction, String state) {
		super(document, name, lastName, direction);
		this.state = state;
		penaltyFeesList = new ArrayList<PenaltyFee>();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<PenaltyFee> getPenaltyFeesList() {
		return penaltyFeesList;
	}

	public void setPenaltyFeesList(List<PenaltyFee> penaltyFeesList) {
		this.penaltyFeesList = penaltyFeesList;
	}
}
