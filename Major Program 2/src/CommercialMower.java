
public class CommercialMower extends LawnTractor {
	private double operatingHours;
	private Boolean zeroTurnRadius;
	
	public CommercialMower() {
		operatingHours = 0.0;
		zeroTurnRadius = null;
	}
	public CommercialMower(double hrs, boolean ztr) {
		this.operatingHours = hrs;
		this.zeroTurnRadius = ztr;
	}
	
	public void setOperatingHours(double hrs) {
		this.operatingHours = hrs;
	}
	public void setZeroTurnRadius(Boolean ztr) {
		this.zeroTurnRadius = ztr;
	}
	
	public double getOperatingHours() {
		return this.operatingHours;
	}
	public Boolean getZeroTurnRadius() {
		return this.zeroTurnRadius;
	}
	
	@ Override
	public String printInfo() {
		// Print info to file in format readable by readMowerData()
		String str = String.format("%s\n%d\n%s\nC\n%s%s\n%.1f\n%.1f\n%b\n", // inserts "C" before Engine attributes
				this.getManufacturer(), this.getYear(), this.getSerialNumber(), //Mower attributes
				this.getEngine().printInfo(), //Engine attributes
				this.getModel(), this.getDeckWidth(), // LawnTractor attributes
				operatingHours, zeroTurnRadius); // CommercialMower attributes
		return str;
	}
	
	@Override
	public String toString() {
		String str = String.format("""
				%s
				Operating Hours: %.1f
				Zero Turn Radius: %b
				""", super.toString() ,operatingHours, zeroTurnRadius);
		return str;
	}
}