import java.io.*;
import java.util.*;

public class MowerWareHouse {
	private String storeName;
	private ArrayList<Mower> mowers;
	
	public MowerWareHouse() {
		storeName = "";
		mowers = new ArrayList<Mower>();
	}
	public MowerWareHouse(String sn, ArrayList<Mower> mowers) {
		this.storeName = sn;
		this.mowers = mowers;
	}
	
	public void setStoreName(String sn) {
		this.storeName = sn;
	}
	public void setMowers(ArrayList<Mower> mowers) {
		this.mowers = mowers;
	}
	
	public String getStoreName() {
		return this.storeName;
	}
	public ArrayList<Mower> getMowers() {
		return this.mowers;
	}

	public void addLawnTractor(LawnTractor l) {
		this.mowers.add(l);
	}
	public void addCommercialMower(CommercialMower c) {
		this.mowers.add(c);
	}
	public void addGasPoweredMower(GasPoweredMower g) {
		this.mowers.add(g);
	}
	public void addPushReelMower(PushReelMower p) {
		this.mowers.add(p);
	}
	
	public void readMowerData(File inputFile) throws FileNotFoundException {
		Scanner inFS = new Scanner(inputFile);
		this.setStoreName(inFS.nextLine());
		
	    while(inFS.hasNext()) {
	    	Engine e = new Engine();
	    	// Get Mower abstract attributes
	    	String man = inFS.nextLine();
	    	int year = Integer.parseInt(inFS.nextLine());
	    	String sn = inFS.nextLine();
	    	// Determine type of mower
	    	switch(inFS.nextLine()) {
	    	case "L":
	    		LawnTractor l = new LawnTractor();
	    		// set Mower abstract attributes
	    		l.setManufacturer(man);
	    		l.setYear(year);
	    		l.setSerialNumber(sn);
	    		// set Engine attributes
	    		e.setManufacturer(inFS.nextLine());
	    		e.setHorsePower(Double.parseDouble(inFS.nextLine()));
	    		e.setCylinders(Integer.parseInt(inFS.nextLine()));
	    		// set LawnTractor attributes
	    		l.setEngine(e);
	    		l.setModel(inFS.nextLine());
	    		l.setDeckWidth(Double.parseDouble(inFS.nextLine()));
	    		this.mowers.add(l);
	    		break;
	    		
	    	case "C":
	    		CommercialMower c = new CommercialMower();
	    		c.setManufacturer(man);
	    		c.setYear(year);
	    		c.setSerialNumber(sn);

	    		e.setManufacturer(inFS.nextLine());
	    		e.setHorsePower(Double.parseDouble(inFS.nextLine()));
	    		e.setCylinders(Integer.parseInt(inFS.nextLine()));

	    		c.setEngine(e);
	    		c.setModel(inFS.nextLine());
	    		c.setDeckWidth(Double.parseDouble(inFS.nextLine()));
	    		// set CommercialMower attributes
	    		c.setOperatingHours(Double.parseDouble(inFS.nextLine()));
	    		c.setZeroTurnRadius(Boolean.parseBoolean(inFS.nextLine()));
	    		this.mowers.add(c);
	    		break;
	    		
	    	case "G":
	    		GasPoweredMower g = new GasPoweredMower();
	    		g.setManufacturer(man);
	    		g.setYear(year);
	    		g.setSerialNumber(sn);
	    		// set WalkBehindMower abstract attributes
	    		g.setCutWidth(Double.parseDouble(inFS.nextLine()));
	    		g.setWheelDiameter(Double.parseDouble(inFS.nextLine()));
	    		
	    		e.setManufacturer(inFS.nextLine());
	    		e.setHorsePower(Double.parseDouble(inFS.nextLine()));
	    		e.setCylinders(Integer.parseInt(inFS.nextLine()));
	    		// set GasPoweredMower attributes
	    		g.setEngine(e);
	    		g.setSelfPropelled(Boolean.parseBoolean(inFS.nextLine()));
	    		this.mowers.add(g);
	    		break;
	    		
	    	case "P":
	    		PushReelMower p = new PushReelMower();
	    		p.setManufacturer(man);
	    		p.setYear(year);
	    		p.setSerialNumber(sn);

	    		p.setCutWidth(Double.parseDouble(inFS.nextLine()));
	    		p.setWheelDiameter(Double.parseDouble(inFS.nextLine()));
	    		// set PushReelMower attributes
	    		p.setNumWheels(Integer.parseInt(inFS.nextLine()));
	    		this.mowers.add(p);
	    		break;
	    	}
	    }
	    inFS.close();
	}
	
	public void saveMowerData(File outputFile) throws FileNotFoundException {
		FileOutputStream fs = new FileOutputStream(outputFile);
		PrintWriter oFS = new PrintWriter(fs);
		oFS.println(this.storeName); // Write MowerWareHouse name into file
		for (Mower m : this.getMowers()) {
			oFS.print(m.printInfo()); // Write each mower's info into file
		}
		oFS.close();
	}
	
	public String toString() {
		String str = String.format("""
				Store Name:	%s				
				Mowers: """ + mowers, storeName);
		return str;
	}
}
