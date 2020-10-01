package edu.uptc.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "agente_tabla")
@PrimaryKeyJoinColumn(referencedColumnName = "documento")
public class Agent extends Person {

	@OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
//	@JoinColumn(name = "a_person_documento", referencedColumnName = "documento")
	private List<PenaltyFee> penaltyFeesList;

	public Agent() {
		penaltyFeesList = new ArrayList<PenaltyFee>();
	}

	public Agent(int document, String name, String lastName, String direction, String state) {
		super(state, document, name, lastName, direction);
		penaltyFeesList = new ArrayList<PenaltyFee>();
	}

	public List<PenaltyFee> getPenaltyFeesList() {
		return penaltyFeesList;
	}

	public void setPenaltyFeesList(List<PenaltyFee> penaltyFeesList) {
		this.penaltyFeesList = penaltyFeesList;
	}
	
	public void addFine(PenaltyFee penaltyFee) {
		penaltyFeesList.add(penaltyFee);
	}
}
