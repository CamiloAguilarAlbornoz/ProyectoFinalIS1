package edu.uptc.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "multa_tabla")
public class PenaltyFee {

	@Id
	@Column(name = "id_multa_tabla")
	private int id;
	@Column(name = "fecha")
	private Date date;
	@Column(name = "descripcion")
	private String description;
	@Column(name = "estado_multa")
	private String state;
	@Column(name = "valor_multa")
	private int value;
	@ManyToOne
	@JoinColumn(name = "conductor_documento")
	private Conductor conductor;
	@ManyToOne
	@JoinColumn(name = "agente_numero_agente")
	private Agent agent;
	
	public PenaltyFee() {}

	public PenaltyFee(int id, Date date, String description, String state, int value, Conductor conductor, Agent agent) {
		this.id = id;
		this.date = date;
		this.description = description;
		this.state = state;
		this.value = value;
		this.conductor = conductor;
		this.agent = agent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
}
