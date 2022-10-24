import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
public class MyCalc {
	public static String displayFormat(Double n1, Double n2, Double result, String operation) {
		// will properly format the output, if a decimal or division was used, the output will
		// involve a double, if only integers were involved, the output is a long (integer)
		String outStr = "";
		if (n1 != Math.floor(n1) || n2 != Math.floor(n2) || operation.equals("÷") ) { // creates double if a decimal or division is involved
			outStr = ""+result;
		}
		else if ((n1 == Math.floor(n1) && n2 == Math.floor(n2)) || result == Math.floor(result)) { // keeps numbers as integers if no decimal nor division involved
			outStr = ""+result.longValue();
		}
		return outStr;
	}
	public static Double operate(String operation, Double n1, Double n2) {
		// if a previous operation was entered, this will execute that operation as though the
		// "=" was pressed, preparing for the next operation to be entered.  When "=" is pressed, 
		// the operator will execute.
		double result = 0;
		// depending on previous operation, a switch case is chosen
		switch(operation) {
		case "+":
			result = n1 + n2;
			break;
		case "-":
			result = n1 - n2;
			break;
		case "×":
			result = n1 * n2;
			break;
		case "÷":
			result = n1 / n2;
			break;
		case "%":
			result = n1 % n2;
			break;					
		}
		return result;
	}
// instantiate variables
	public JPanel panScreen, panBut1, panBut2; // different panels for button layouts
	public JTextArea inDisp, outDisp;
	public JButton zer, one, two, thr, fou, fiv, six, sev, eig, nin;
	public JButton add, sub, mul, div, equ, clr, sqr, cub, mod, sqrt, pnt, perc, neg, overn;
	public JButton sin, cos, tan, asin, acos, atan, sinh, cosh, tanh, log, ln, abs, exit, exp;
	public static JFrame myFrame;
	public GridBagLayout gbl;
	public GridBagConstraints gbc;
	public Insets i = new Insets(1,1,1,1);
	public Double n1, n2, result;
	public String operation = "";
	public String inStr = "";
	public String outStr = "";
	public boolean isNeg = false;
	public boolean isFloat = false;
	public boolean isOperation = false;
	JRadioButton deg=new JRadioButton("Deg");    
	JRadioButton rad=new JRadioButton("Rad");       
	ButtonGroup bg = new ButtonGroup();    

// layout design
	public MyCalc() {
	// create panels for buttons and displays
		inDisp = new JTextArea(1,28); // input number display
		outDisp = new JTextArea(1,28); // result number display
		inDisp.setEditable(false);
		outDisp.setEditable(false);
		inDisp.setText("0");
		outDisp.setText("0");
	// instantiate number buttons
		zer = new JButton("0");
		one = new JButton("1");
		two = new JButton("2");
		thr = new JButton("3");
		fou = new JButton("4");
		fiv = new JButton("5");
		six = new JButton("6");
		sev = new JButton("7");
		eig = new JButton("8");
		nin = new JButton("9");
	// operator buttons
		add = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("×");
		div = new JButton("÷");
		equ = new JButton("=");
	// data buttons
		clr = new JButton("C");
		sqr = new JButton("x²");
		cub = new JButton("x³");
		mod = new JButton("Mod");
		sqrt = new JButton("√");
		pnt = new JButton(".");
		perc = new JButton("%");
		neg = new JButton("±");
		overn = new JButton("1/n");
		log = new JButton("log");
		ln = new JButton("ln");
		abs = new JButton("abs");
		exit = new JButton("EXIT");
		exp = new JButton("10^n");
	// trigonometry buttons
		sin = new JButton("sin");
		cos = new JButton("cos");
		tan = new JButton("tan");
		asin = new JButton("asin");
		acos = new JButton("acos");
		atan = new JButton("atan");
		sinh = new JButton("sinh");
		cosh = new JButton("cosh");
		tanh = new JButton("tanh");  
	// Button layout initial settings
		myFrame = new JFrame("Scientific Calculator");
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		myFrame.setLayout(new BorderLayout());
		panScreen = new JPanel();
		panScreen.setLayout(gbl);
		panScreen.setBackground(Color.LIGHT_GRAY);
		panBut1 = new JPanel();
		panBut1.setLayout(gbl);
		panBut1.setBackground(Color.LIGHT_GRAY);
		panBut2 = new JPanel();
		panBut2.setLayout(gbl);
		panBut2.setBackground(Color.LIGHT_GRAY);
		myFrame.add(panScreen, BorderLayout.NORTH);
		myFrame.add(panBut1, BorderLayout.CENTER);
		myFrame.add(panBut2, BorderLayout.SOUTH);
		myFrame.setSize(500,500);
		myFrame.setResizable(false);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = i;
	//display positions
		gbc.gridx = 0;
		gbc.gridy = 0;
		//gbc.gridwidth = 6;
		panScreen.add(inDisp, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panScreen.add(outDisp, gbc);
	// standard button section
		// clear button
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		panBut1.add(clr, gbc);
	// first row of buttons (7 through sqr)
		// 7
		gbc.gridx = 0;
		gbc.gridy = 1;
		panBut1.add(sev, gbc);
		// 8
		gbc.gridx = 1;
		gbc.gridy = 1;
		panBut1.add(eig, gbc);
		// 9
		gbc.gridx = 2;
		gbc.gridy = 1;
		panBut1.add(nin, gbc);
		// mult
		gbc.gridx = 3;
		gbc.gridy = 1;
		panBut1.add(mul, gbc);
		// div
		gbc.gridx = 4;
		gbc.gridy = 1;
		panBut1.add(div, gbc);
		// square root
		gbc.gridx = 5;
		gbc.gridy = 1;
		panBut1.add(sqr, gbc);
	// second row of buttons (4 through cube)
		// 4
		gbc.gridx = 0;
		gbc.gridy = 2;
		panBut1.add(fou, gbc);
		// 5
		gbc.gridx = 1;
		gbc.gridy = 2;
		panBut1.add(fiv, gbc);
		// 6
		gbc.gridx = 2;
		gbc.gridy = 2;
		panBut1.add(six, gbc);
		// +
		gbc.gridx = 3;
		gbc.gridy = 2;
		panBut1.add(add, gbc);
		// -
		gbc.gridx = 4;
		gbc.gridy = 2;
		panBut1.add(sub, gbc);
		// cube
		gbc.gridx = 5;
		gbc.gridy = 2;
		panBut1.add(cub, gbc);
	// third row of buttons (1 through mod)
		// 1
		gbc.gridx = 0;
		gbc.gridy = 3;
		panBut1.add(one, gbc);
		// 2
		gbc.gridx = 1;
		gbc.gridy = 3;
		panBut1.add(two, gbc);
		// 3
		gbc.gridx = 2;
		gbc.gridy = 3;
		panBut1.add(thr, gbc);
		// =
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		panBut1.add(equ, gbc);
		// mod
		gbc.gridx = 5;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		panBut1.add(mod, gbc);
	// fourth row of buttons (0 through sqrt)
		// 0
		gbc.gridx = 0;
		gbc.gridy = 4;
		panBut1.add(zer, gbc);
		// .
		gbc.gridx = 1;
		gbc.gridy = 4;
		panBut1.add(pnt, gbc);
		// ±
		gbc.gridx = 2;
		gbc.gridy = 4;
		panBut1.add(neg, gbc);
		// 1/n
		gbc.gridx = 3;
		gbc.gridy = 4;
		panBut1.add(overn, gbc);
		// %
		gbc.gridx = 4;
		gbc.gridy = 4;
		panBut1.add(perc, gbc);
		// √
		gbc.gridx = 5;
		gbc.gridy = 4;
		panBut1.add(sqrt, gbc);
// scientific button section
	// first row sci buttons (sin through ln)
		// sin
		gbc.gridx = 0;
		gbc.gridy = 0;
		panBut2.add(sin, gbc);
		// cos
		gbc.gridx = 1;
		gbc.gridy = 0;
		panBut2.add(cos, gbc);
		// tan
		gbc.gridx = 2;
		gbc.gridy = 0;
		panBut2.add(tan, gbc);
		// log
		gbc.gridx = 3;
		gbc.gridy = 0;
		panBut2.add(log, gbc);
		// ln
		gbc.gridx = 4;
		gbc.gridy = 0;
		panBut2.add(ln, gbc);
	// second row sci buttons (asin through abs)
		// asin
		gbc.gridx = 0;
		gbc.gridy = 1;
		panBut2.add(asin, gbc);
		// acos
		gbc.gridx = 1;
		gbc.gridy = 1;
		panBut2.add(acos, gbc);
		// atan
		gbc.gridx = 2;
		gbc.gridy = 1;
		panBut2.add(atan, gbc);
		// 10^n
		gbc.gridx = 3;
		gbc.gridy = 1;
		panBut2.add(exp, gbc);
		// abs
		gbc.gridx = 4;
		gbc.gridy = 1;
		panBut2.add(abs, gbc);
	// thrid row sci buttons (sinh through EXIT)
		//sinh
		gbc.gridx = 0;
		gbc.gridy = 2;
		panBut2.add(sinh, gbc);
		// cosh
		gbc.gridx = 1;
		gbc.gridy = 2;
		panBut2.add(cosh, gbc);
		// tanh
		gbc.gridx = 2;
		gbc.gridy = 2;
		panBut2.add(tanh, gbc);
		// EXIT
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		panBut2.add(exit, gbc);
	// action listeners for numbers
		zer.addActionListener(new numberListener());
		one.addActionListener(new numberListener());
		two.addActionListener(new numberListener());
		thr.addActionListener(new numberListener());
		fou.addActionListener(new numberListener());
		fiv.addActionListener(new numberListener());
		six.addActionListener(new numberListener());
		sev.addActionListener(new numberListener());
		eig.addActionListener(new numberListener());
		nin.addActionListener(new numberListener());
	// action listener for basic operations
		add.addActionListener(new operatorListener());
		sub.addActionListener(new operatorListener());
		mul.addActionListener(new operatorListener());
		div.addActionListener(new operatorListener());
		mod.addActionListener(new operatorListener());
		equ.addActionListener(new operatorListener());
	// utility action listeners (clear, exit)
		clr.addActionListener(new utilListener());
		exit.addActionListener(new utilListener());
	// trig action listeners
		sin.addActionListener(new trigListener());
		cos.addActionListener(new trigListener());
		tan.addActionListener(new trigListener());
		asin.addActionListener(new trigListener());
		acos.addActionListener(new trigListener());
		atan.addActionListener(new trigListener());
		sinh.addActionListener(new trigListener());
		cosh.addActionListener(new trigListener());
		tanh.addActionListener(new trigListener());
	// modifier action listeners
		pnt.addActionListener(new modifyListener());
		perc.addActionListener(new modifyListener());
		neg.addActionListener(new modifyListener());
		abs.addActionListener(new modifyListener());
	// advanced operation listeners
		sqr.addActionListener(new advOpListener());
		cub.addActionListener(new advOpListener());
		sqrt.addActionListener(new advOpListener());
		overn.addActionListener(new advOpListener());
		log.addActionListener(new advOpListener());
		ln.addActionListener(new advOpListener());
		exp.addActionListener(new advOpListener());
	}
	// main method
	public static void main(String[] args) {
		MyCalc mc = new MyCalc();
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.pack();
		myFrame.setVisible(true);
	}
// action listeners
	class numberListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			// enter numbers into input display
			switch (((AbstractButton) e.getSource()).getLabel()) {
			case "0":
				if (inStr == "") {
				}
				else {
					inStr += "0";
					inDisp.setText(inStr);
				}
				break;
			case "1":
				inStr += "1";
				inDisp.setText(inStr);
				break;
			case "2":
				inStr += "2";
				inDisp.setText(inStr);
				break;
			case "3":
				inStr += "3";
				inDisp.setText(inStr);
				break;
			case "4":
				inStr += "4";
				inDisp.setText(inStr);
				break;
			case "5":
				inStr += "5";
				inDisp.setText(inStr);
				break;
			case "6":
				inStr += "6";
				inDisp.setText(inStr);
				break;
			case "7":
				inStr += "7";
				inDisp.setText(inStr);
				break;
			case "8":
				inStr += "8";
				inDisp.setText(inStr);
				break;
			case "9":
				inStr += "9";
				inDisp.setText(inStr);
				break;
			}
		}
	}
	class operatorListener implements ActionListener {
		@SuppressWarnings({ "deprecation", "unlikely-arg-type" })
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((AbstractButton) e.getSource()).getLabel()) { // read operator button used
			case "+":
				if (inDisp.equals("0")) { 				// no numbers input yet
					outStr = outDisp.getText();			
					n1 = Double.parseDouble(outStr);	// n1 set to result (or 0 if blank)
					inStr += outStr + " + ";			// sets input display
					inDisp.setText(inStr);
					outStr = "0";						// reset output display
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) {		// if "=" pushed, n1 is result, continues to calculate
					inStr = outDisp.getText() + " + ";
					inDisp.setText(inStr);
					operation = "+";
					break;
				}
				else if (!inDisp.equals("0") && isOperation) { // 1 number entered and a previous operation entered
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
					n1 = result;	// reset n1 for next operation
					inStr = outStr + " + "; // reset inStr to match new operation
					inDisp.setText(inStr);
				}
				else if (!inDisp.equals("0")) { // no other operation and 1 number entered
					n1 = Double.parseDouble(inDisp.getText()); // n1 = first number entered
					inStr += " + ";
					inDisp.setText(inStr);
				}
				isFloat = isNeg = false; // reset booleans for next input
				operation = "+";
				isOperation = true;
				break;
			case "-":
				if (inDisp.equals("0")) { 
					outStr = outDisp.getText();
					n1 = Double.parseDouble(outStr);
					inStr += outStr + " - ";
					inDisp.setText(inStr);
					outStr = "0";
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) {		// if "=" pushed, n1 is result, continues to calculate
					inStr = outDisp.getText() + " - ";
					inDisp.setText(inStr);
					operation = "-";
					break;
				}
				else if (!inDisp.equals("0") && isOperation) { // 1 number entered and previous operation entered
					//FIXME bug if there is a negative number and use subtraction
//					if (n1 < 0) {
//						String subStr = inStr.substring(2);
//						n2 = Double.parseDouble(subStr.substring(inStr.indexOf(operation)+2)); // slice inDisp to find number after operator
//					}
//					else {
//						
//					}
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // slice inDisp to find number after operator
					result = operate(operation, n1, n2);
					outStr = displayFormat(n1, n2, result, operation);
					outDisp.setText(outStr);
					isFloat = isNeg = false;
					n1 = result;
					inStr = outStr + " - ";
					inDisp.setText(inStr);
				}
				else if (!inDisp.equals("0")) { // no other operation and 1 number entered
					n1 = Double.parseDouble(inDisp.getText());
					inStr += " - ";
					inDisp.setText(inStr);
				}
				isFloat = isNeg = false; // reset booleans for next input
				operation = "-";
				isOperation = true;
				break;
			case "×":
				if (inDisp.equals("0")) { 				// no numbers input yet
					outStr = outDisp.getText();			
					n1 = Double.parseDouble(outStr);	// n1 set to result (or 0 if blank)
					inStr += outStr + " × ";			// sets input display
					inDisp.setText(inStr);
					outStr = "0";						// reset output display
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) {		// if "=" pushed, n1 is result, continues to calculate
					inStr = outDisp.getText() + " × ";
					inDisp.setText(inStr);
					operation = "×";
					break;
				}
				else if (!inDisp.equals("0") && isOperation) { // 1 number entered and a previous operation entered
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
					n1 = result;	// reset n1 for next operation
					inStr = outStr + " × "; // reset inStr to match new operation
					inDisp.setText(inStr);
				}
				else if (!inDisp.equals("0")) { // no other operation and 1 number entered
					n1 = Double.parseDouble(inDisp.getText()); // n1 = first number entered
					inStr += " × ";
					inDisp.setText(inStr);
				}
				isFloat = isNeg = false; // reset booleans for next input
				operation = "×";
				isOperation = true;
				break;
			case "÷":
				if (inDisp.equals("0")) { 				// no numbers input yet
					outStr = outDisp.getText();			
					n1 = Double.parseDouble(outStr);	// n1 set to result (or 0 if blank)
					inStr += outStr + " ÷ ";			// sets input display
					inDisp.setText(inStr);
					outStr = "0";						// reset output display
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) {		// if "=" pushed, n1 is result, continues to calculate
					inStr = outDisp.getText() + " ÷ ";
					inDisp.setText(inStr);
					operation = "÷";
					break;
				}
				else if (!inDisp.equals("0") && isOperation) { // 1 number entered and a previous operation entered
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
					n1 = result;	// reset n1 for next operation
					inStr = outStr + " ÷ "; // reset inStr to match new operation
					inDisp.setText(inStr);
				}
				else if (!inDisp.equals("0")) { // no other operation and 1 number entered
					n1 = Double.parseDouble(inDisp.getText()); // n1 = first number entered
					inStr += " ÷ ";
					inDisp.setText(inStr);
				}
				isFloat = isNeg = false; // reset booleans for next input
				operation = "÷";
				isOperation = true;
				break;
			case "Mod":
				if (inDisp.equals("0")) { 				// no numbers input yet
					outStr = outDisp.getText();			
					n1 = Double.parseDouble(outStr);	// n1 set to result (or 0 if blank)
					inStr += outStr + " % ";			// sets input display
					inDisp.setText(inStr);
					outStr = "0";						// reset output display
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) {		// if "=" pushed, n1 is result, continues to calculate
					inStr = outDisp.getText() + " % ";
					inDisp.setText(inStr);
					operation = "%";
					break;
				}
				else if (!inDisp.equals("0") && isOperation) { // 1 number entered and a previous operation entered
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
					n1 = result;	// reset n1 for next operation
					inStr = outStr + " % "; // reset inStr to match new operation
					inDisp.setText(inStr);
				}
				else if (!inDisp.equals("0")) { // no other operation and 1 number entered
					n1 = Double.parseDouble(inDisp.getText()); // n1 = first number entered
					inStr += " % ";
					inDisp.setText(inStr);
				}
				isFloat = isNeg = false; // reset booleans for next input
				operation = "%";
				isOperation = true;
				break;
			case "=":
				n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
				result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
				outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
				outDisp.setText(outStr);
				inStr = "";
				n1 = result;
				isFloat = isNeg = false;
				operation = "=";
			}
		}
	}
	class utilListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((AbstractButton) e.getSource()).getLabel()) {
			case "C":
				n1 = n2 = result = (double) 0;
				isNeg = isFloat = isOperation = false;
				inStr = outStr = operation = "";
				inDisp.setText("0");
				outDisp.setText("0");
				break;
			case "EXIT":
				System.exit(0);
				break;
			}
		}
	}
	class trigListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((AbstractButton) e.getSource()).getLabel()) {
			case "sin":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.sin(Math.toRadians(n1)); // sin of first value
					inStr = "sin(" + n1 + ")"; // displays sin function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so use n2
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " sin(" + n2 + ")"; // displays sin function
					n2 = Math.sin(Math.toRadians(n2));
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.sin(Math.toRadians(n1)); // sin of first value
					inStr = "sin(" + n1 + ")"; // displays sin function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isFloat = isOperation = true;
				operation = "=";
				n1 = result;
				isNeg = false;
				break;
			case "cos":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.cos(Math.toRadians(n1)); // sin of first value
					inStr = "cos(" + n1 + ")"; // displays sin function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so use n2
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " cos(" + n2 + ")"; // displays cos function
					n2 = Math.cos(Math.toRadians(n2));
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.cos(Math.toRadians(n1)); // cos of first value
					inStr = "cos(" + n1 + ")"; // displays cos function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isFloat = isOperation = true;
				operation = "=";
				n1 = result;
				isNeg = false;
				break;
			case "tan":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.tan(Math.toRadians(n1)); // tan of first value
					inStr = "tan(" + n1 + ")"; // displays sin function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so use n2
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " tan(" + n2 + ")"; // displays tan function
					n2 = Math.tan(Math.toRadians(n2));
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.tan(Math.toRadians(n1)); // tan of first value
					inStr = "tan(" + n1 + ")"; // displays tan function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isFloat = isOperation = true;
				operation = "=";
				n1 = result;
				isNeg = false;
				break;
			case "asin":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.asin(Math.toRadians(n1)); // asin of first value
					inStr = "asin(" + n1 + ")"; // displays asin function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so use n2
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " asin(" + n2 + ")"; // displays asin function
					n2 = Math.asin(Math.toRadians(n2));
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.asin(Math.toRadians(n1)); // asin of first value
					inStr = "asin(" + n1 + ")"; // displays asin function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isFloat = isOperation = true;
				operation = "=";
				n1 = result;
				isNeg = false;
				break;
			case "acos":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.acos(Math.toRadians(n1)); // acos of first value
					inStr = "acos(" + n1 + ")"; // displays acos function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so use n2
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " acos(" + n2 + ")"; // displays acos function
					n2 = Math.acos(Math.toRadians(n2));
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.acos(Math.toRadians(n1)); // acos of first value
					inStr = "acos(" + n1 + ")"; // displays acos function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isFloat = isOperation = true;
				operation = "=";
				n1 = result;
				isNeg = false;
				break;
			case "atan":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.atan(Math.toRadians(n1)); // atan of first value
					inStr = "atan(" + n1 + ")"; // displays atan function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so use n2
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " atan(" + n2 + ")"; // displays atan function
					n2 = Math.atan(Math.toRadians(n2));
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.atan(Math.toRadians(n1)); // atan of first value
					inStr = "atan(" + n1 + ")"; // displays atan function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isFloat = isOperation = true;
				operation = "=";
				n1 = result;
				isNeg = false;
				break;
			case "sinh":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.sinh(Math.toRadians(n1)); // sinh of first value
					inStr = "sinh(" + n1 + ")"; // displays sinh function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so use n2
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " sinh(" + n2 + ")"; // displays sinh function
					n2 = Math.sinh(Math.toRadians(n2));
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.sinh(Math.toRadians(n1)); // sinh of first value
					inStr = "sinh(" + n1 + ")"; // displays sinh function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isFloat = isOperation = true;
				operation = "=";
				n1 = result;
				isNeg = false;
				break;
			case "cosh":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.cosh(Math.toRadians(n1)); // cosh of first value
					inStr = "cosh(" + n1 + ")"; // displays cosh function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so use n2
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " cosh(" + n2 + ")"; // displays cosh function
					n2 = Math.cosh(Math.toRadians(n2));
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.cosh(Math.toRadians(n1)); // cosh of first value
					inStr = "cosh(" + n1 + ")"; // displays cosh function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isFloat = isOperation = true;
				operation = "=";
				n1 = result;
				isNeg = false;
				break;
			case "tanh":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.tanh(Math.toRadians(n1)); // tanh of first value
					inStr = "tanh(" + n1 + ")"; // displays tanh function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so use n2
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " tanh(" + n2 + ")"; // displays tanh function
					n2 = Math.tanh(Math.toRadians(n2));
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.tanh(Math.toRadians(n1)); // tanh of first value
					inStr = "tanh(" + n1 + ")"; // displays tanh function
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isFloat = isOperation = true;
				operation = "=";
				n1 = result;
				isNeg = false;
				break;
		}
	}
	}
	class modifyListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((AbstractButton) e.getSource()).getLabel()) {
			case ".":
				if (inStr == "") {	// if no numbers entered, 0 in the 1s place, followed by decimal
					inStr += "0.";
					inDisp.setText(inStr);
					}
				else if (!isFloat){ // if number is already a double, will not allow a second decimal
					inStr += ".";
					inDisp.setText(inStr);
					}
				isFloat = true; // set boolean to prevent multiple decimals
				break;
			case "±":
				if (!isNeg) {	// if number is > 0, will make the number negative
					inStr = "-" + inStr;
					inDisp.setText(inStr);
					isNeg = true;
				}
				else {	// if number is < 0, will make the number positive
					inStr = inStr.substring(1);
					inDisp.setText(inStr);
					isNeg = false;
				}
				break;
			case "%":
				if (!isOperation) {
					n1 = Double.parseDouble(inStr);
					n1 = n1/100; // converts n1 to percentage value
					inStr = ""+n1; // displays percentage value
					inDisp.setText(inStr);
				}
				else {
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					n2 = n2/100;	// converts n2 to percentage value
					inStr = ""+n1 + " " + operation + " " + n2;  // displays percentage value
					inDisp.setText(inStr);
				}
				break;
			case "abs":
				if (!isOperation) {
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.abs(n1); // performs absolute value calculation
					inStr = "abs(" + n1 + ")"; // displays abs operation
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else {
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					result = Math.abs(operate(operation, n1, n2));	// call operate to solve previous operation and set new result
					inStr = "abs(" + n1 + " " + operation + " " + n2 + ")"; // displays abs operation
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				n1 = result;
				operation = "=";
				isFloat = isNeg = false;
				isOperation = true;
				break;
		}
	}
	}
	class advOpListener implements ActionListener {
		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (((AbstractButton) e.getSource()).getLabel()) {
			case "x²":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.pow(n1,2); // squares first value
					inStr = ""+n1 + "²"; // displays exponent
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so n2 gets squared
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " " + n2 + "²"; // displays exponent
					n2 = Math.pow(n2,2);
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.pow(n1,2); // squares first value
					inStr = ""+n1 + "²"; // displays exponent
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isOperation = true;
				operation = "=";
				n1 = result;
				isFloat = isNeg = false;
				break;
			case "x³":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.pow(n1,3); // cubes first value
					inStr = ""+n1 + "³"; // displays exponent
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so n2 gets squared
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " " + n2 + "³"; // displays exponent
					n2 = Math.pow(n2,3);
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.pow(n1,3); // cubes first value
					inStr = ""+n1 + "³"; // displays exponent
					inDisp.setText(inStr);
					outStr = ""+result;
					outDisp.setText(outStr);
				}
				isOperation = true;
				operation = "=";
				n1 = result;
				isFloat = isNeg = false;
				break;
			case "√":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.sqrt(n1); // square root of first value
					inStr = "√" + n1; // displays sqrt symbol
					inDisp.setText(inStr);
					outStr = "" + result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so n2 gets squared
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " " + "√" + n2; // displays sqrt symbol
					n2 = Math.sqrt(n2);
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.sqrt(n1); // square root first value
					inStr = "√" + n1; // displays exponent
					inDisp.setText(inStr);
					outStr = "" + result;
					outDisp.setText(outStr);
				}
				isOperation = true;
				operation = "=";
				n1 = result;
				isFloat = isNeg = false;
				break;
			case "1/n":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					if (n1 == 0) {
						inDisp.setText("DIVIDE BY 0 ERROR");
					}
					else {
						result = 1/n1; // 1 divided by first value
						inStr = "1/" + n1; // displays 1/n symbol
						inDisp.setText(inStr);
						outStr = "" + result;
						outDisp.setText(outStr);
					}
				}
				else if (!operation.equals("=")){ // previous operation, so n2 gets squared
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					if (n2 == 0) {
						inDisp.setText("DIVIDE BY 0 ERROR");
					}
					else {
						inStr = "" + n1 + " " + operation + " " + "1/" + n2; // displays 1/ symbol
						n2 = 1/n2;
						result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
						inDisp.setText(inStr);
						outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
						outDisp.setText(outStr);
					}
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					if (n1 == 0) {
						inDisp.setText("DIVIDE BY 0 ERROR");
					}
					else {
						result = 1/n1; // squares first value
						inStr = "1/" + n1; // displays exponent
						inDisp.setText(inStr);
						outStr = "" + result;
						outDisp.setText(outStr);
					}
				}
				isOperation = true;
				operation = "=";
				n1 = result;
				isFloat = isNeg = false;
				break;
			case "log":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.log10(n1); // log of first value
					inStr = "log(" + n1; // displays log
					inDisp.setText(inStr);
					outStr = "" + result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so n2 gets squared
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " " + "log(" + n2; // displays log symbol
					n2 = Math.log10(n2);
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.log10(n1); // log of first value
					inStr = "log(" + n1; // displays log
					inDisp.setText(inStr);
					outStr = "" + result;
					outDisp.setText(outStr);
				}
				isOperation = true;
				operation = "=";
				n1 = result;
				isFloat = isNeg = false;
				break;
			case "ln":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.log(n1); // ln of first value
					inStr = "ln(" + n1; // displays ln
					inDisp.setText(inStr);
					outStr = "" + result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so n2 gets squared
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " " + "ln(" + n2; // displays ln
					n2 = Math.log(n2);
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.log(n1); // ln of first value
					inStr = "ln(" + n1; // displays ln
					inDisp.setText(inStr);
					outStr = "" + result;
					outDisp.setText(outStr);
				}
				isOperation = true;
				operation = "=";
				n1 = result;
				isFloat = isNeg = false;
				break;
			case "10^n":
				if (!isOperation) { // no previous operation (one number entered or 0)
					n1 = Double.parseDouble(inDisp.getText());
					result = Math.pow(10, n1); // power of ten of first value
					inStr = "10^(" + n1; // displays power of ten symbol
					inDisp.setText(inStr);
					outStr = "" + result;
					outDisp.setText(outStr);
				}
				else if (!operation.equals("=")){ // previous operation, so n2 gets squared
					n2 = Double.parseDouble(inStr.substring(inStr.indexOf(operation)+2)); // get n2 by slicing inStr after the operator symbol
					inStr = "" + n1 + " " + operation + " " + "10^(" + n2; // displays power of ten symbol
					n2 = Math.pow(10, n2);
					result = operate(operation, n1, n2);	// call operate to solve previous operation and set new result
					inDisp.setText(inStr);
					outStr = displayFormat(n1, n2, result, operation); // format output to either a double or integer
					outDisp.setText(outStr);
				}
				else if (operation.equals("=")) { // previous operation executed, takes result as n1
					result = Math.pow(10, n1); // squares first value
					inStr = "10^(" + n1; // displays power of ten symbol
					inDisp.setText(inStr);
					outStr = "" + result;
					outDisp.setText(outStr);
				}
				isOperation = true;
				operation = "=";
				n1 = result;
				isFloat = isNeg = false;
				break;
		}
	}
}

}

  
	