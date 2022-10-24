
public class GasPoweredMower extends WalkBehindMower{
	private Engine engine;
	private Boolean selfPropelled;
	
	public GasPoweredMower() {
		this.engine = null;
		this.selfPropelled = null;
	}
	public GasPoweredMower(Engine en, Boolean sp) {
		this.engine = en;
		this.selfPropelled = sp;
	}
	
	public void setEngine(Engine en) {
		this.engine = en;
	}
	public void setSelfPropelled(Boolean sp) {
		this.selfPropelled = sp;
	}
	
	public Engine getEngine() {
		return this.engine;
	}
	public Boolean getSelfPropelled() {
		return this.selfPropelled;
	}
	
	@ Override
	public String printInfo() {
		// Print info to file in format readable by readMowerData()
		String str = String.format("%s\n%d\n%s\nG\n%s%s%b\n", // inserts "G" before Engine attributes
				this.getManufacturer(), this.getYear(), this.getSerialNumber(), //Mower attributes
				super.printInfo(), // WalkBehind attributes
				this.getEngine().printInfo(), //Engine attributes
				selfPropelled); // GasPoweredMower attributes
		return str;
	}
	
	@Override
	public String toString() {
		String str = String.format("""
				%s
				Engine: 
				%s
				Self Propelled: %b
				""", super.toString(), engine, selfPropelled);
		return str;
	}
}
