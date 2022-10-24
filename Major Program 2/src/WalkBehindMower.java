
public abstract class WalkBehindMower extends Mower{
	private double cutWidth, wheelDiameter;
	
	public WalkBehindMower () {
		this.cutWidth = 0.0;
		this.wheelDiameter = 0.0;
	}
	public WalkBehindMower (double cw, double wd) {
		this.cutWidth = cw;
		this.wheelDiameter = wd;
	}
	
	public void setCutWidth(double cw) {
		this.cutWidth = cw;
	}
	public void setWheelDiameter(double dw) {
		this.wheelDiameter = dw;
	}
	
	public double getCutWidth() {
		return this.cutWidth;
	}
	public double getWheelDiameter() {
		return this.wheelDiameter;
	}
	
	@ Override
	public String printInfo() {
		// Print info in same format as input file
		String str = String.format("%.1f\n%.1f\n", cutWidth, wheelDiameter);
		return str;
	}
	
	@Override
	public String toString() {
		String str = String.format("""
				%s
				Cut Width (inches): %.1f
				Wheel Diameter (inches): %.1f
				""", super.toString(), cutWidth, wheelDiameter);
		return str;
	}
}
