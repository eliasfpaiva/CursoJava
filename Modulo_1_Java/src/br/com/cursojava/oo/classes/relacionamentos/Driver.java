package br.com.cursojava.oo.classes.relacionamentos;

public class Driver {
	private String driverName;
	private Vehicle vehicle;

	public Driver(String driverName) {
		this(driverName, null);
	}

	public Driver(String driverName, Vehicle vehicle) {
		this.driverName = driverName;
		this.vehicle = vehicle;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void dirigeOque() {
		if (naoTemCarro())
			System.out.println(String.format("%s doesn't drive any vehicle", getDriverName()));
		else
			System.out.println(String.format("%s drives a %s", getDriverName(), vehicle));
	}

	private boolean naoTemCarro() { return !temCarro(); }
	private boolean temCarro() { return getVehicle() != null; }
}