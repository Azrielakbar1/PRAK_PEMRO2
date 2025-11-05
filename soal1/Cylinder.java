package soal1;

public class Cylinder extends Shape {
	private double radius;
	private double height;
	
	public Cylinder(double r, double h) {
		super("Cylinder");
		this.height =  h;
		this.radius = r;
	}
	@Override 
	public double area() {
		return 2 * Math.PI * radius * (height+ radius);
	}
	
	@Override 
	public String toString() {
		return super.toString() + " of radius " + radius + " and height " + height;
	}
}
