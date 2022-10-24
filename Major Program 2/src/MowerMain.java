import java.io.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

public class MowerMain {
	
	public static File openFile(String[] args) throws IOException {
		FileInputStream fbs = null;
	    JFileChooser jfc = new JFileChooser();
	    File f = null;

	  // If no filename given, opens JFileChooser
	    if (args.length == 0) {
	    	int fcv = jfc.showOpenDialog(jfc);
	    	if (fcv == JFileChooser.APPROVE_OPTION) {
	    		f = jfc.getSelectedFile();
	    		}
	    	}
	  // Tries to read filename from command line
	    else if(args.length > 0) {
	    	f = new File(args[0]);
	    	}	    
	  // Try to open filename
	    try {
	    	fbs = new FileInputStream(f);
	    	} 
	    catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    	}
	    fbs.close();
	    return f;
	    }
	
	public static void mowerMenu(MowerWareHouse mw) {
		boolean doLoop = true;
		Scanner s = new Scanner(System.in);
		// menu loop  
	    System.out.println("Welcome to " + mw.getStoreName());
	    while(doLoop) {
	    	System.out.printf("Please select which type of mower you are looking for-"
	    			+ "\nPress \"L\" for lawn tractors,"
	    			+ "\nPress \"C\" for commercial mowers,"
	    			+ "\nPress \"G\" for gas powered mowers,"
	    			+ "\nPress \"P\" for push reel mowers,"
	    			+ "\nPress \"S\" to stop." 
	    			+ "\n" + "_".repeat(48));
	    	// match mower class with search criteria
	    	switch (s.nextLine().toUpperCase()) {
	    	case "S":
	    		System.out.println("Thank you for visiting " + mw.getStoreName() + ", goodbye.");
				doLoop = false;
				break;
			case "L": // Find LawnTractors
	    		for (Mower m : mw.getMowers()) {
	    			if (m.getClass() == LawnTractor.class) { 
	    				System.out.println(m.toString() + "\n" + "_".repeat(48));
	    			}
	    		}
	    		break;
	    	case "C": // Find CommercialMowers
	    		for (Mower m : mw.getMowers()) {
	    			if (m.getClass() == CommercialMower.class) {
	    				System.out.println(m.toString() + "\n" + "_".repeat(48));
	    			}
	    		}
	    		break;
	    	case "G": // Find GasPoweredMowers
	    		for (Mower m : mw.getMowers()) {
	    			if (m.getClass() == GasPoweredMower.class) {
	    				System.out.println(m.toString() + "\n" + "_".repeat(48));
	    			}
	    		}
	    		break;
	    	case "P": // Find PushReelMowers
	    		for (Mower m : mw.getMowers()) {
	    			if (m.getClass() == PushReelMower.class) {
	    				System.out.println(m.toString() + "\n" + "_".repeat(48));
	    			}
	    		}
	    		break;
	    	default:
	    		System.out.println("Invalid input,");
	    		}
	    	}
	    s.close();
	    }
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		MowerWareHouse mw = new MowerWareHouse();
	    File f = openFile(args);
	  //read data into warehouse
	    mw.readMowerData(f);
	  
	  // create new Mowers and Engines
	    LawnTractor l = new LawnTractor();
	    CommercialMower c = new CommercialMower();
	    GasPoweredMower g = new GasPoweredMower();
	    PushReelMower p = new PushReelMower();
	    Engine e1 = new Engine();
	    Engine e2 = new Engine();
	    Engine e3 = new Engine();
	    
	    e1.setManufacturer("Briggs & Stratton");
	    e1.setHorsePower(17.5);
	    e1.setCylinders(1);
	    
	    l.setManufacturer("John Deere");
	    l.setYear(2021);
	    l.setSerialNumber("13002");
	    l.setEngine(e1);
	    l.setModel("S100");
	    l.setDeckWidth(42);
	    
	    e2.setManufacturer("Kohler");
	    e2.setHorsePower(38);
	    e2.setCylinders(2);
	    
	    c.setManufacturer("Toro");
	    c.setYear(2021);
	    c.setSerialNumber("3160001-3160449");
	    c.setEngine(e2);
	    c.setModel("7500g");
	    c.setDeckWidth(102.3);
	    c.setOperatingHours(23);
	    c.setZeroTurnRadius(true);
	    
	    e3.setManufacturer("Briggs & Stratton");
	    e3.setHorsePower(3.3);
	    e3.setCylinders(1);
	    
	    g.setManufacturer("Troy Bilt");
	    g.setYear(2021);
	    g.setSerialNumber("1G219H30420");
	    g.setEngine(e3);
	    g.setCutWidth(21);
	    g.setWheelDiameter(11);
	    g.setSelfPropelled(false);
	    
	    p.setManufacturer("Scott's");
	    p.setYear(2021);
	    p.setSerialNumber("415-16S");
	    p.setCutWidth(16);
	    p.setWheelDiameter(10);
	    p.setNumWheels(2);
	    
	    mw.addLawnTractor(l);
	    mw.addCommercialMower(c);
	    mw.addGasPoweredMower(g);
	    mw.addPushReelMower(p);
	    
	  //call search menu
	    mowerMenu(mw);
	    
	  //save updated MowerWareHouse
	    mw.saveMowerData(f);
	}
}
