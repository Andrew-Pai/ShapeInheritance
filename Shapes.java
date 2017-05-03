public class Shapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Square s = new Square();
Rectangle r = new Rectangle();
Rhombus rh = new Rhombus();
Trapezoid t = new Trapezoid();
Parallelogram p = new Parallelogram();
Kite k = new Kite();
System.out.println(s);
System.out.println(r);
System.out.println(rh);
System.out.println(t);
System.out.println(p);
System.out.println(k);

	}

}

abstract class Quadrilateral {

	public abstract double findArea();

	public abstract double findPerimeter();

}

class Square extends Quadrilateral {
	private double side1;

	public Square() {
		side1 = 5;
	}

	public Square(double side1) {
		this.side1 = side1;
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double findArea() {
		return side1 * side1;
	}

	public double findPerimeter() {
		return 4 * side1;
	}

	public boolean equals(Object o) {
		if (o instanceof Square) {
			Square s = (Square) o;
			if (side1 == s.getSide1())
				return true;
		}
		return false;
	}

	public String toString() {
		return "[Square] Side length = " + getSide1() + ", Area = "
				+ findArea() + ", Perimeter = " + findPerimeter();
	}
}

class Rhombus extends Square {
	private long angle;

	public Rhombus() {
		angle = 30;
	}

	public Rhombus(double side1, long angle) {
		super(side1);
		this.angle = angle;
	}

	public Rhombus(double side1) {
		super(side1);
		angle = 30;
	}

	public Rhombus(long angle) {
		this.angle = angle;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(long angle) {
		this.angle = angle;
	}

	public double findArea() {
		return super.findArea() * Math.sin(Math.toRadians(angle));
	}

	public double findPerimeter() {
		return super.findArea();
	}

	public boolean equals(Object o) {
		if (o instanceof Rhombus) {
			Rhombus r = (Rhombus) o;
			if (this.angle == r.getAngle())
				if (getSide1() == r.getSide1())
					return true;
		}
		return false;
	}

	public String toString() {
		return "[Rhombus] Side length = " + getSide1() + ", Area = "
				+ Math.round(findArea()*100)/100.0 + ", Perimeter = " + findPerimeter();
	}
}

class Rectangle extends Square {
	private double side2;

	public Rectangle() {
		super();
		side2 = 3;
	}

	public Rectangle(double side1, double side2) {
		super(side1);
		this.side2 = side2;
	}

	public Rectangle(double side2) {
		this.side2 = side2;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double findArea() {
		return getSide1() * side2;
	}

	public double findPerimeter() {
		return 2 * (getSide1() + side2);
	}

	public boolean equals(Object o) {
		if (o instanceof Rectangle) {
			Rectangle s = (Rectangle) o;
			if (this.side2 == s.getSide2())
				if (getSide1() == s.getSide1())
					return true;
		}
		return false;
	}

	public String toString() {
		return "[Rectangle] length = " + getSide1() + ", width = " + getSide2()
				+ ", Area = " + findArea() + ", Perimeter = " + findPerimeter();
	}

}

class Trapezoid extends Rectangle {
	private double side3, side4, height;

	public Trapezoid() {
		side3 = 6;
		side4 = 8;
		height = 2;
	}

	public Trapezoid(double side1, double side2, double side3, double side4,
			double height) {
		super(side1, side2);
		this.side3 = side3;
		this.side4 = side4;
		this.height = height;
	}

	public Trapezoid(double side1, double side2, double side3, double side4) {
		super(side1, side2);
		this.side3 = side3;
		this.side4 = side4;
		height = 2;

	}

	public Trapezoid(double side3, double side4, double height) {
		this.side3 = side3;
		this.side4 = side4;
		this.height = height;
	}

	public Trapezoid(double side4, double height) {
		this.side4 = side4;
		this.height = height;
		side3 = 6;
	}

	public Trapezoid(double height) {
		side3 = 6;
		side4 = 8;
		this.height = height;
	}

	public double getSide3() {
		return side3;
	}

	public double getSide4() {
		return side4;
	}

	public double getHeight() {
		return height;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	public void setSide4(double side4) {
		this.side4 = side4;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double findArea() {
		return 0.5 * (getSide1() + getSide2()) * height;
	}

	public double findPerimeter() {
		return getSide1() + getSide2() + side3 + side4;
	}

	public boolean equals(Object o) {
		if (o instanceof Trapezoid) {
			Trapezoid t = (Trapezoid) o;
			if (getSide1() == t.getSide1() && getSide2() == t.getSide2()
					&& side3 == t.getSide3() && side4 == t.getSide4()
					&& height == t.getHeight())
				return true;
		}
		return false;
	}

	public String toString() {
		return "[Trapezoid] Side 1 = " + getSide1() + ", Side 2 = "
				+ getSide2() + ", Side 3 = " + side3 + ", Side 4 = " + side4
				+ ", Height == " + height + ", Area = " + findArea()
				+ ", Perimeter = " + findPerimeter();
	}
}

class Parallelogram extends Rectangle {
	private long angle;

	public Parallelogram() {
		angle = 30;
	}

	public Parallelogram(double side1, double side2, long angle) {
		super(side1, side2);
		this.angle = angle;
	}

	public double getAngle() {
		return angle;
	}

	public void setSide2(long angle) {
		this.angle = angle;
	}

	public double findArea() {
		return Math.sin(Math.toRadians(angle)) * getSide2() * getSide1();
	}

	public double findPerimeter() {
		return super.findPerimeter();
	}

	public boolean equals(Object o) {
		if (o instanceof Parallelogram) {
			Parallelogram p = (Parallelogram) o;
			if (getSide1() == p.getSide1() && getSide2() == p.getSide2()
					&& angle == p.getAngle())
				return true;
		}
		return false;
	}

	public String toString() {
		return "[Parallelogram] Side 1 = " + getSide1() + ", Side 2 = "
				+ getSide2() + ", Angle == " + angle + ", Area = " + Math.round(findArea()*100)/100.0
				+ ", Perimeter = " + findPerimeter();
	}

}

class Kite extends Parallelogram {
	public Kite(){
		
	}
	public Kite(double side1, double side2, long angle) {
		super(side1, side2, angle);
	}

	public boolean equals(Object o) {
		if (o instanceof Kite) {
			Kite k = (Kite) o;
			if (getSide1() == k.getSide1() && getSide2() == k.getSide2()
					&& getAngle() == k.getAngle())
				return true;
		}
		return false;
	}

	public String toString() {
		return "[Kite] Side 1 = " + getSide1() + ", Side 2 = " + getSide2()
				+ ", Angle == " + getAngle() + ", Area = " + Math.round(findArea()*100)/100.0
				+ ", Perimeter = " + findPerimeter();
	}
}