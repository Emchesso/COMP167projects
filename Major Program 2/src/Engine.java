
public class Engine {
	private String manufacturer;
	private double horsePower;
	private int cylinders;
	
	public Engine() {
		manufacturer = "";
		horsePower = 0.0;
		cylinders = 0;
	}
	public Engine(String man, double hp, int cyl) {
		this.manufacturer = man;
		this.horsePower = hp;
		this.cylinders = cyl;
	}
	
	public void setManufacturer(String man) {
		this.manufacturer = man;
	}
	public void setHorsePower(double hp) {
		this.horsePower = hp;
	}
	public void setCylinders(int cyl) {
		this.cylinders = cyl;
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}
	public double getHorsePower() {
		return this.horsePower;
	}
	public int getCylinders() {
		return this.cylinders;
	}
	
	public String printInfo() {
		// Print info to file in format readable by readMowerData()
		String str = String.format("%s\n%.1f\n%d\n", manufacturer, horsePower, cylinders);
		return str;
	}
	
	public String toString() {
		String str = String.format("""
				Manufacturer: %s
				Horse Power: %.1f
				No. of Cylinders: %d
				""", manufacturer, horsePower, cylinders);
		return str;
	}
 }
