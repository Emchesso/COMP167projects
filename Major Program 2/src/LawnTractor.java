
public class LawnTractor extends Mower {
	private Engine engine;
	private String model;
	private double deckWidth;
	
	public LawnTractor() {
		this.engine = null;
		this.model = "";
		this.deckWidth = 0.0;
	}
	public LawnTractor(Engine en, String mod, double dw) {
		this.engine = en;
		this.model = mod;
		this.deckWidth = dw;
	}
	
	public void setEngine(Engine en) {
		this.engine = en;
	}
	public void setModel(String mod) {
		this.model = mod;
	}
	public void setDeckWidth(double dw) {
		this.deckWidth = dw;
	}
	
	public Engine getEngine() {
		return this.engine;
	}
	public String getModel() {
		return this.model;
	}
	public double getDeckWidth() {
		return this.deckWidth;
	}
	
	@ Override
	public String printInfo() {
		// Print info to file in format readable by readMowerData()
		String str = String.format(super.printInfo() + "L\n" + engine.printInfo() + "%s\n%.1f\n", model, deckWidth);
		return str;
	}
	
	@Override
	public String toString() {
		String str = String.format("""
				%s
				Engine: 
				%s
				Model: %s
				Deck Width (inches): %.1f
				""", super.toString(), engine, model, deckWidth);
		return str;
	}
}
