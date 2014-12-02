public class SquareCalc {
	
	private double side;
	
	public static void main(String[] args) 	{
		SquareCalc square = new SquareCalc(4);
		System.out.println("Side:      " + square.getSide());
		System.out.println("Area:      " + square.calcArea());
		System.out.println("Perimeter: " + square.calcPerim());
		System.out.println("Diagonal:  " + square.calcDiagonal());
	}
	
	public SquareCalc(double side) {
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	
	public double calcArea() {
		return side * side;
	}
	
	public double calcPerim() {
		return side * 4;
	}
	
	public double calcDiagonal() {
		return side * Math.sqrt(2);
	}
}
