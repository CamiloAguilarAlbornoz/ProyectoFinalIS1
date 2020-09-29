package edu.uptc.model.dao;

public enum STATE_CONDUCTOR {

	ACTIVE("Activo"), INNACTIVE("Inactivo");
	
	private String state;

	private STATE_CONDUCTOR(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
