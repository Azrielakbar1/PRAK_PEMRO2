package soal1;

abstract class Shape {
	protected String shapeName;
	
	public Shape(String ShapeName) {
		this.shapeName = ShapeName;
	}
	
	protected abstract double area();
	public String toString() {
		return this.shapeName;
	}
	
}
