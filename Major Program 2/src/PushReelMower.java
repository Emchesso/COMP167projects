
public class PushReelMower extends WalkBehindMower{
	private int numWheels;
	
	public PushReelMower() {
		numWheels = 0;
	}
	public PushReelMower(int nw) {
		this.numWheels = nw;
	}
	
	public void setNumWheels(int nw) {
		this.numWheels = nw;
	}
	
	public int getNumWheels() {
		return this.numWheels;
	}
	
	@ Override
	public String printInfo() {
		// Print info to file in format readable by readMowerData()
		String str = String.format("%s\n%d\n%s\nP\n%s%d\n", // inserts "P" before WalkBehind attributes
				this.getManufacturer(), this.getYear(), this.getSerialNumber(), //Mower attributes
				super.printInfo(), // WalkBehind attributes
				numWheels); // PushReelMower attributes
		return str;
	}
	
	@Override
	public String toString() {
		String str = String.format("""
				%s
				Number of Wheels: %d
				""", super.toString(),numWheels);
		return str;
	}
}
