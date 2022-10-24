
public abstract class Mower {
	private String manufacturer, serialNumber;
	private int year;
	
	public Mower() {
		this.manufacturer = "";
		this.year = 0;
		this.serialNumber = "";
	}
	
	public Mower(String man, int year, String sn) {
		this.manufacturer = man;
		this.year = year;
		this.serialNumber = sn;
	}
	
	public void setManufacturer(String man) {
		this.manufacturer = man;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setSerialNumber(String sn) {
		this.serialNumber = sn;
	}
	
	public String getManufacturer() {
		return this.manufacturer;
	}
	public int getYear() {
		return this.year;
	}
	public String getSerialNumber() {
		return this.serialNumber;
	}
	
	public String printInfo() {
		// Print info to file in format readable by readMowerData()
		String str = String.format("%s\n%d\n%s\n", manufacturer, year, serialNumber);
		return str;
	}
	
	public String toString() {
		String str = String.format("""
				Manufacturer: %s
				Year: %d
				Serial Number: %s
				""", manufacturer, year, serialNumber);
		return str;
	}
}
