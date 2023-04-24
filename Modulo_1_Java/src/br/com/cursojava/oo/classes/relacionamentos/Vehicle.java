package br.com.cursojava.oo.classes.relacionamentos;

public class Vehicle {
	private int id;
	private String model;
	
	public Vehicle(int id, String model) {
		this.id = id;
		this.model = model;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }

	public String getModel() { return model; }
	public void setModel(String model) { this.model = model; }

	@Override
	public String toString() {
		return String.format("%s (id: %d)", getModel(), getId());
	}
}