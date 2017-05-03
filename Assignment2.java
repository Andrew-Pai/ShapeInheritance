
/*======================================================================
 * Assignment 2 - Geometric Shapes
 * Andrew Pai
 * November 26, 2015
 * Java 1.7
 * =====================================================================
 * Problem Definition - The purpose of this assignment is to use the object-oriented programming 
 * concepts discussed in class. This program implements a series of classes (hierarchy) that
 * deal with geometric shapes: circle, cone, sphere, cube, rectangular prism, and cylinder.  
 * It also includes methods to determine the perimeter, surface area, volume where appropriate.  
 * It includes data fields that keep track of the number geometric shapes created, as well 
 * as the number of each type of geometric shape created. 
 * 
 * Input - The shape the user wishes to create, and dimensions of the shape if the user chooses
 * to create a custom shape. Also, a unique ID to search for an existing shape.
 * 
 * Output - Number of shapes created, and number of each type of shape created. 
 * The attributes of shapes, list of the objects stored in the database.
 * 
 * Process - Used OOP concepts to build a database with shapes the user creates. 
 * Search for shapes using the ID provided when a shape is created.
 =====================================================================
 */
//Allows access to external libraries, such as BufferedReader.
import java.io.*;
import java.util.*;

public class Assignment2 {// Driver class header
	/**
	 * Main method: This procedural method is automatically called and is used
	 * to organize the calling of other methods defined in the class
	 * 
	 * Local Variables:
	 * 
	 * ass2 - Object used to gain access to non-static methods defined in the class <type Assignment2>
	 * shapes - ArrayList of type Object used to store the shapes created <type ArrayList>
	 * br - Object used to get user input <type BufferedReader>
	 * attribute - String to temporarily store the attribute of the shape the user wishes to create <type String>
	 * input - Stores the users input <type double>
	 * radius - Temporarily stores radius of shape <type double>
	 * height - Temporarily stores height of shape <type double>
	 * length - Temporarily stores length of shape <type double>
	 * width - Temporarily stores width of shape <type width>
	 * newShape - Check to see if the user created a new shape <type boolean>
	 * 
	 * @param args <type String>
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, NumberFormatException, InterruptedException {//Method header
		Assignment2 ass2 = new Assignment2();
		ArrayList<Object> shapes = new ArrayList<Object>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String attribute;
		double input, radius, height, length, width;
		boolean newShape = false;
		System.out.println("Welcome to Andrew's Geometric Shape Database!");
		ass2.lineCreater("~", 45);
		System.out.println("This amazing database allows you to create a variety of shapes:");
		System.out.println("(Circle, Sphere, Cylinder, Cone, Cube, and Rectangular Prism)");
		System.out.println("It can also create shapes with custom or default dimensions,");
		System.out.println("Print the number of shapes, search for shapes by their unqiue ID,");
		System.out.println("And print a list of all the shapes stored within the database.");
//		The purpose of this assignment is to use the object-oriented programming 
//		 * concepts discussed in class. This program implements a series of classes (hierarchy) that
//		 * deal with geometric shapes: circle, cone, sphere, cube, rectangular prism, and cylinder.  
//		 * It also includes methods to determine the perimeter, surface area, volume where appropriate.  
//		 * It includes data fields that keep track of the number geometric shapes created, as well 
//		 * as the number of each type of geometric shape created. 
		ass2.lineCreater("-", 60);		
		System.out.println("What would you like to do?");
		Thread.sleep(20);
		System.err.println("1. Create a Shape");
		System.err.println("2. View the number of objects");
		System.err.println("3. View the objects in the database");
		System.err.println("4. Search for a certain object");
		System.err.println("5. Exit Program");
		Thread.sleep(20);
		input = ass2.userInput(br, 5);
		while (input != 5) {
			if (input == 1) {
				System.out.println("Would you like to create a custom or a default shape?");
				Thread.sleep(20);
				System.err.println("1. Custom Shape (You choose the dimensions of the shape)");
				System.err.println("2. Default Shape (Default dimensions)");
				System.err.println("3. Return to Menu");
				Thread.sleep(20);
				input = ass2.userInput(br, 3);
				if (input == 1) {
					System.out.println("What shape would you like to create:");
					Thread.sleep(20);
					System.err.println("1. Circle");
					System.err.println("2. Sphere");
					System.err.println("3. Cylinder");
					System.err.println("4. Cone");
					System.err.println("5. Cube");
					System.err.println("6. Rectangular Prism");
					Thread.sleep(20);
					switch ((int) (ass2.userInput(br, 6))) {
					case 1:
						System.out.println("What is the radius of the Circle?");
						radius = ass2.userInput(br, 0);
						attribute = "Circle: " + "Radius = " + radius;
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Circle(radius));
							newShape = true;
						}
						break;
					case 2:
						System.out.println("What is the radius of the Sphere?");
						radius = ass2.userInput(br, 0);
						attribute = "Sphere: " + "Radius = " + radius;
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Sphere(radius));
							newShape = true;
						}
						break;
					case 3:
						System.out.println("What is the radius of the Cylidner?");
						radius = ass2.userInput(br, 0);
						System.out.println("What is the height of the Cylinder?");
						height = ass2.userInput(br, 0);
						attribute = "Cylinder: " + "Radius = " + radius + ", Height = " + height;
						if (ass2.userConfirm(attribute, br))
							shapes.add(new Cylinder(radius, height));
						break;
					case 4:
						System.out.println("What is the radius of the Cone?");
						radius = ass2.userInput(br, 0);
						System.out.println("What is the height of the Cone?");
						height = ass2.userInput(br, 0);
						attribute = "Cone: " + "Radius = " + radius + ", Height = " + height;
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Cone(radius, height));
							newShape = true;
						}
						break;
					case 5:
						System.out.println("What is the length of the Cube?");
						length = ass2.userInput(br, 0);
						attribute = "Square: " + "Side Length = " + length;
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Cube(length));
							newShape = true;
						}
						break;
					case 6:
						System.out.println("What is the length of the Rectangular Prism?");
						length = ass2.userInput(br, 0);
						System.out.println("What is the Width of the Rectangular Prism?");
						width = ass2.userInput(br, 0);
						System.out.println("What is the Height of the Rectangular Prism?");
						height = ass2.userInput(br, 0);
						attribute = "Rectangular Prism: " + "Side Length = " + length + ", Width = " + width
								+ ", Height = " + height;
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Prism(length, width, height));
							newShape = true;
						}
						break;
					default:
						break;

					}

				} else if (input == 2) {
					System.out.println("What shape would you like to create:");
					Thread.sleep(20);
					System.err.println("1. Circle");
					System.err.println("2. Sphere");
					System.err.println("3. Cylinder");
					System.err.println("4. Cone");
					System.err.println("5. Cube");
					System.err.println("6. Rectangular Prism");
					System.err.println("7. Exit Back to Menu");
					Thread.sleep(20);
					switch ((int) (ass2.userInput(br, 7))) {

					case 1:

						attribute = "Circle: " + "Radius = 5.0";
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Circle());
							newShape = true;
						}
						break;
					case 2:

						attribute = "Sphere: " + "Radius = 5.0";
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Sphere());
							newShape = true;
						}
						break;
					case 3:

						attribute = "Cylinder: " + "Radius = 5.0, Height = 7.0";
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Cylinder());
							newShape = true;
						}
						break;
					case 4:

						attribute = "Cone: " + "Radius = 5.0, Height = 7.0";
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Cone());
							newShape = true;
						}
						break;
					case 5:

						attribute = "Square: " + "Side Length = 5.0";
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Cube());
							newShape = true;
						}
						break;
					case 6:

						attribute = "Rectangular Prism: " + "Side Length = 5.0, Width = 6.0, Height = 7.0";
						if (ass2.userConfirm(attribute, br)) {
							shapes.add(new Prism());
							newShape = true;
						}
						break;
					default:
						break;
					}
				}
				ass2.lineCreater("-", 60);
			} else if (input == 2) {

				System.out.println("Total number of Geometric Shapes: " + Geometric.getShapes());
				System.out.println("Number of Circles Created: " + Circle.getNum());
				System.out.println("Number of Spheres Created: " + Sphere.getNum());
				System.out.println("Number of Cylinders Created: " + Cylinder.getNum());
				System.out.println("Number of Cones Created: " + Cone.getNum());
				System.out.println("Number of Cubes Created: " + Cube.getNum());
				System.out.println("Number of Rectangular Prisms Created: " + Prism.getNum());
				if (shapes.size() == 0) {
					Thread.sleep(20);
					System.err.println("The database is empty! :(");
					System.err.println("(You should create some shapes)");
					Thread.sleep(20);
				}
				ass2.lineCreater("-", 60);
			} else if (input == 3) {
				if (shapes.size() == 0) {
					Thread.sleep(20);
					System.err.println("The database is empty! :(");
					System.err.println("(You should create some shapes)");
					Thread.sleep(20);
				} else {
					System.out.println("These are the shapes stored in the database:");
					ass2.lineCreater("~", 45);
					ass2.shapePrint(shapes);
				}
				ass2.lineCreater("-", 60);
			} else {
				if (shapes.size() != 0) {
					System.out.println("What shape would you like to search for:");
					Thread.sleep(20);
					System.err.println("1. Circle");
					System.err.println("2. Sphere");
					System.err.println("3. Cylinder");
					System.err.println("4. Cone");
					System.err.println("5. Cube");
					System.err.println("6. Rectangular Prism");
					System.err.println("7. Exit Back to Menu");
					Thread.sleep(20);
					switch ((int) (ass2.userInput(br, 7))) {
					case 1:
						ass2.shapeSearch(shapes, "Circle", br);
						break;
					case 2:
						ass2.shapeSearch(shapes, "Sphere", br);
						break;
					case 3:
						ass2.shapeSearch(shapes, "Cylinder", br);
						break;
					case 4:
						ass2.shapeSearch(shapes, "Cone", br);
						break;
					case 5:
						ass2.shapeSearch(shapes, "Cube", br);
						break;
					case 6:
						ass2.shapeSearch(shapes, "Prism", br);
						break;

					}

				} else {
					Thread.sleep(20);
					System.err.println("The database is empty! :(");
					System.err.println("(You should create some shapes)");
					Thread.sleep(20);
				}
				ass2.lineCreater("-", 60);
			}
			if (newShape == true) {
				System.out.println("The following has been added to the database:");
				System.out.println(shapes.get(shapes.size() - 1));
				ass2.lineCreater("-", 60);
			}
			newShape = false;
			System.out.println("What would you like to do?");
			Thread.sleep(20);
			System.err.println("1. Create a Shape");
			System.err.println("2. View the number of objects");
			System.err.println("3. View the objects in the database");
			System.err.println("4. Search for a certain object");
			System.err.println("5. Exit Program");
			Thread.sleep(20);
			input = ass2.userInput(br, 5);
		} // End while loop
		System.out.println("Thank you for using this program!");
		System.out.println("Hope you have a nice day :D");
	}//End main method

	/**
	 * userInput method:
	 * 
	 * This procedural method  returns the users input
	 * 
	 * Variables:
	 * input - The input of the user <type double>
	 * @param br - BufferedReader object used to get userInput <type BufferedReader>
	 * @param limit - The allowed range for the users input from 1 to limit <type int>
	 * @return input <type double>
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public double userInput(BufferedReader br, int limit) throws IOException, InterruptedException {//Method Header
		double input;
		while (true) {
			try {
				System.out.print("Input(Enter the number):");
				input = Double.parseDouble(br.readLine());

				if (limit == 0 && input > 0) {
					lineCreater("-", 60);
					return input;
				} else if (input % 1 != 0)//Checks if input is not an integer
					throw new NumberFormatException();
				else if (input > 0 && input <= limit) {
					lineCreater("-", 60);
					return input;
				} else if (limit == -1 && input > 0) {
					lineCreater("-", 60);
					return input;
				} else
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				lineCreater("-", 60);
				Thread.sleep(20);
				System.err.println("Sorry, that is an invalid option.");
				Thread.sleep(20);

			}
		}
	}//End method

	/**lineCreater method
	 * 
	 * This functional method prints a line (symbol) length number of times
	 * 
	 * @param symbol - Symbol to be printed <type String>
	 * @param length - # of times ot be printed <type int>
	 */
	public void lineCreater(String symbol, int length) {//Method Header
		for (int x = 0; x < length; x++) {
			System.out.print(symbol);
		}
		System.out.println();
	}//end method

	/**
	 * userConfirm method
	 *  
	 * This functional method has the user confirm the attribute of the shape being created
	 * 
	 * @param message - The attributes of the shape to be confirmed <type String>
	 * @param br - object to get user input <type BufferedReader>
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean userConfirm(String message, BufferedReader br) throws IOException, InterruptedException {//Method header
		System.out.println("Are these attributes correct?");
		System.out.println(message);
		Thread.sleep(20);
		System.err.println("1. Yes");
		System.err.println("2. No");
		Thread.sleep(20);
		if (userInput(br, 2) == 1)
			return true;
		else
			return false;
	}//end method

	/**
	 * shapeSearch  method
	 * 
	 * This procedural method searches for a specific shape using the ID of the shapes
	 * 
	 * Variables:
	 * ID - The ID of the shape to search for
	 * 
	 * @param shapes - ArrayList of all the shapes <type ArrayList>
	 * @param type - String of which type of shape to search for <type String>
	 * @param br - BufferedReader object to get user input <type BufferedReader>
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void shapeSearch(ArrayList<Object> shapes, String type, BufferedReader br)
			throws IOException, InterruptedException {//Method header
		short ID;
		while (true) {
			try {
				System.out.println("Enter the ID of the shape you wish to search for:");
				System.out.println("(ID's available: 1-" + shapes.size() + ")");
				ID = (short) (userInput(br, -1));
				if (ID > shapes.size())
					throw new IndexOutOfBoundsException();
				if (type.equalsIgnoreCase("Circle")) {
					Circle c = new Circle(ID);
					shapeCompare(shapes, c);
				} else if (type.equalsIgnoreCase("Sphere")) {
					Sphere s = new Sphere(ID);
					shapeCompare(shapes, s);
				} else if (type.equalsIgnoreCase("Cylinder")) {
					Cylinder c = new Cylinder(ID);
					shapeCompare(shapes, c);
				} else if (type.equalsIgnoreCase("Cone")) {
					Cone c = new Cone(ID);
					shapeCompare(shapes, c);
				} else if (type.equalsIgnoreCase("Cube")) {
					Cube c = new Cube(ID);
					shapeCompare(shapes, c);
				} else if (type.equalsIgnoreCase("Prism")) {
					Prism p = new Prism(ID);
					shapeCompare(shapes, p);
				}
				break;
			} catch (IndexOutOfBoundsException i) {
				Thread.sleep(20);
				System.err.println("Sorry, that ID does not exist.");
				Thread.sleep(20);
				lineCreater("-", 60);
			}
		}

	}//End method

	/**shapeCompare method
	 * 
	 * This procedural method compares the shapes in the database to the search parameters
	 * Prints the attributes of the shape if found, or an error message if none is found.
	 * 
	 * @param shapes - ArrayList of the shapes in the database <type ArrayList>
	 * @param o - The shape to search for <type Object>
	 */
	public void shapeCompare(ArrayList<Object> shapes, Object o) {//Method header
		for (int x = 0; x < shapes.size(); x++) {
			if (shapes.get(x).equals(o)) {
				System.out.println("Shape Retrieved:");
				lineCreater("~", 14);
				System.out.println(shapes.get(x));
				return;
			}
		}
		System.out.println("Sorry, a shape with that ID could not be found.");
	}//End method

	/**shapePrint method
	 * 
	 * This procedural method prints all the shapes within the database
	 * 
	 * @param shapes - ArrayList of the shapes in the database <type ArrayList>
	 * @throws InterruptedException
	 */
	public void shapePrint(ArrayList<Object> shapes) throws InterruptedException {//Method header
		for (int x = 0; x < shapes.size(); x++) {
			System.out.println(shapes.get(x));
			if (x != shapes.size() - 1)
				lineCreater("=", 40);
		}

	}//end method
}//End of driver class

abstract class Geometric {//class header
	private static int numOfShapes = 0;

	/**
	 * Default constructor for class Geometric to increment the 
	 * number of total shapes created	
	 */
	Geometric() {//method header
		numOfShapes++;
	}//end method
	
	Geometric (short ID){
		
	}

	/**
	 * getShapes method
	 * 
	 * Accessor method that returns the total number of shapes created
	 */
	public static int getShapes() {//method header
		return numOfShapes;
	}//end method

	//Abstract functional method to calculate and return area
	public abstract double calcArea();

	//Abstract functional method to calculate and return perimeter
	public abstract double calcPerimeter();

	//Abstract functional method to calculate and return volume
	public abstract double calcVolume();
}//End Geometric class

class Circle extends Geometric {//Class header
	private double radius;
	private static int numOfObjects = 0;
	private short ID;

	/**
	 * Default constructor to initialize the radius, 
	 * and increment number of Circle objects created
	 */
	Circle() {
		radius = 5.0;
		ID = (short)getShapes();
		if (this.getClass() == Circle.class)
			numOfObjects++;
	}

	/**
	 * Overloaded constructor to initialize radius with a specified value
	 * Increments number of Circle objects created
	 * 
	 * @param radius - New specified value of radius <type double> 
	 */
	Circle(double radius) {//Method header
		this.radius = radius;
		ID = (short)getShapes();
		if (this.getClass() == Circle.class)
			numOfObjects++;
	}//End method

	/**
	 * Overloaded constructor to change ID to use for searching
	 * @param ID - ID that is being searched for
	 */
	Circle(short ID) {//Method header
		super(ID);
		this.ID = ID;
	}//End method

	/**
	 * getRadius method
	 * 
	 * Accessor method to return the radius of the Circle
	 * @return radius <type double>
	 */
	public double getRadius() {//method header
		return radius;
	}//end method

	/**
	 * setRadius method
	 * 
	 * Mutator method to change the radius
	 * @param radius <type double>
	 */
	public void setRadius(double radius) {//method header
		this.radius = radius;
	}//end method

	/**
	 * getNum method
	 * 
	 * Accessor method to return number of circle objects
	 * @return numOfObjects <type int>
	 */
	public static int getNum() {//method header
		return numOfObjects;
	}//end method

	/**
	 * calcArea method
	 * 
	 * Overrides calcArea method to return area of Circle
	 * @return area of circle <type double>
	 */
	@Override
	public double calcArea() {//method header
		return Math.PI * Math.pow((radius), 2);
	}//end method

	/**
	 * calcPerimeter method
	 * 
	 * Overrides calcPerimeter method to return circumference of circle
	 * @return circumference of circle <type double>
	 */
	@Override
	public double calcPerimeter() {
		return 2 * Math.PI * radius;
	}

	/**
	 * calcVolume method
	 * 
	 * Overrides calcVolume method to return volume of circle
	 * @return 0 - circle has no volume <type double>
	 */
	@Override
	public double calcVolume() {
		return 0;
	}

	/**
	 * overrides equals method that compare two circle objects by their ID
	 * @param o - object to be compared <type Object>
	 * @return boolean
	 */
	public boolean equals(Object o) {//method header
		Circle c;
		if(o.getClass() == Circle.class){
			c = (Circle) o;
			return ID == c.ID;
		}
		return false;
	}//end method

	/**
	 * overrides toString method that prints the attributes of the current Circle
	 * @return Attribute of circle <type String>
	 */
	public String toString() {//method header
		return "[Circle] \nID = " + ID + "\nRadius = " + radius + "\nArea = " + Math.round(calcArea() * 100.0) / 100.0
				+ "\nCircumference = " + Math.round(calcPerimeter() * 100.0) / 100.0;
	}//end method

}//end of class

class Sphere extends Circle {//class header
	private static int numOfObjects = 0;
	private short ID;

	/** Default Constructor  which sets the ID for the current instance,
	 * and increments the number of spheres created
	 */
	Sphere() {
		ID = (short) getShapes();
		if (this.getClass() == Sphere.class)
			numOfObjects++;
	}

	/**
	 * Overloaded constructor to initialize radius with a specified value
	 * Increments number of SPhere objects created
	 * 
	 * @param radius - New specified value of radius <type double> 
	 */
	Sphere(double radius) {
		super(radius);
		ID = (short) getShapes();
		if (this.getClass() == Sphere.class)
			numOfObjects++;
	}

	/**
	 * Overloaded constructor to change ID to use for searching
	 * @param ID - ID that is being searched for
	 */
	Sphere(short ID) {
		super(ID);
		this.ID = ID;
	}

	/**
	 * getNum method
	 * 
	 * Accessor to return number of Sphere objects created
	 * @return numOfObjects <type int>
	 */
	public static int getNum() {
		return numOfObjects;
	}

    /** 
     * calcArea method
     * Overrides calcArea method to return surface area of sphere
     * @return surface area of sphere <type double>
     */
	@Override
	public double calcArea() {
		return super.calcArea() * 4;
	}

    /** 
     * calcPerimeter method
     * Overrides calcPerimeter method to return perimeter of sphere
     * @return 0 - as sphere's don't have a perimeter <type double>
     */
	@Override
	public double calcPerimeter() {
		return 0;
	}

	/**
	 * calcVolume method
	 * Overrides calcVolume method to return volume of sphere
     * @return Volume of sphere <type double>
	 */
	@Override
	public double calcVolume() {
		return (4 / 3) * Math.PI * super.calcArea() * getRadius();
	}

	 /** 
	  * Overrides equals method that compares two object by their ID
	  * @param Object o: object to be compared <type Object>
	  * @return boolean
	  */  
	public boolean equals(Object o) {
		Sphere s;
		if(o.getClass() == Sphere.class){
			s = (Sphere) o;
			return ID == s.ID;
		}
		return false;
	}

	/**
	 * Overrides toString method to print attributes of Sphere
	 * @return Attributes of current Sphere <type String>
	 */
	public String toString() {
		return "[Sphere] \nID = " + ID + "\nRadius = " + getRadius() + "\nSurface Area = "
				+ Math.round(calcArea() * 100.0) / 100.0 + "\nVolume = " + Math.round(calcVolume() * 100.0) / 100.0;
	}

}//End of class

class Cylinder extends Circle {//Class header
	private static int numOfObjects = 0;
	private double height;
	private short ID;

	/**
	 * Default constructor to initialize the height, ID, 
	 * and increment number of cylinder objects created
	 */
	Cylinder() {
		ID = (short) getShapes();
		height = 7;
		if (this.getClass() == Cylinder.class)
			numOfObjects++;
	}

	/**
	 * Overloaded constructor to initialize radius and height
	 * with a specified value. Increments number of Cylinder objects created
	 * 
	 * @param radius - New specified value of radius <type double> 
	 * @param height - New specified value of height <type double>
	 */
	Cylinder(double radius, double height) {
		super(radius);
		ID = (short) getShapes();
		this.height = height;
		if (this.getClass() == Cylinder.class)
			numOfObjects++;
	}

	/**
	 * Overloaded constructor to change ID to use for searching
	 * @param ID - ID that is being searched for
	 */
	Cylinder(short ID) {
		super(ID);
		this.ID = ID;
	}

	/**
	 * getHeight method
	 * 
	 * Accessor method to return the height of the Cylinder
	 * @return height <type double>
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * setHeight method
	 * 
	 * Mutator method to change the height
	 * @param height <type double>
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * getNum method
	 * 
	 * Accessor method to return number of Cylinder objects
	 * @return numOfObjects <type int>
	 */
	public static int getNum() {
		return numOfObjects;
	}
	
	/**
	 * calcArea method
	 * 
	 * Overrides calcArea method to return area of Cylinder
	 * @return Surface Area of Cylinder <type double>
	 */
	@Override
	public double calcArea() {
		return (2 * super.calcArea()) + (super.calcPerimeter() * height);
	}

	/**
	 * calcVolume method
	 * 
	 * Overrides calcVolume method to return volume of Cylinder
	 * @return Volume of Cylinder <type double>
	 */
	@Override
	public double calcVolume() {
		return super.calcArea() * height;
	}

	/**
	 * overrides equals method that compare two cylinder objects by their ID
	 * @param o - object to be compared <type Object>
	 * @return boolean
	 */
	public boolean equals(Object o) {
		Cylinder c;
		if(o.getClass() == Cylinder.class){
			c = (Cylinder) o;
			return ID == c.ID;
		}
		return false;
	}

	/**
	 * overrides toString method that prints the attributes of the current Cylinder
	 * @return Attribute of cylinder <type String>
	 */
	public String toString() {
		return "[Cylinder] \nID = " + ID + "\nRadius = " + getRadius() + "\nHeight = " + height + "\nSurface Area = "
				+ Math.round(calcArea() * 100.0) / 100.0 + "\nVolume = " + Math.round(calcVolume() * 100.0) / 100.0;
	}
}//End class

class Cone extends Cylinder {//Class header
	private static int numOfObjects = 0;
	private short ID;

	/** Default Constructor  which sets the ID for the current instance,
	 * and increments the number of cones created
	 */
	Cone() {
		ID = (short) getShapes();
		if (this.getClass() == Cone.class)
			numOfObjects++;
	}

	/**
	 * Overloaded constructor to initialize radius and height with a specified value
	 * Increments number of cone objects created
	 * 
	 * @param radius - New specified value of radius <type double> 
	 * @param height - New specified value of height <type height>
	 */
	Cone(double radius, double height) {
		super(radius, height);
		ID = (short) getShapes();
		if (this.getClass() == Cone.class)
			numOfObjects++;
	}

	/**
	 * Overloaded constructor to change ID to use for searching
	 * @param ID - ID that is being searched for
	 */
	Cone(short ID) {
		super(ID);
		this.ID = ID;
	}

	/**
	 * getNum method
	 * 
	 * Accessor to return number of Cone objects created
	 * @return numOfObjects <type int>
	 */
	public static int getNum() {
		return numOfObjects;
	}

    /** 
     * calcArea method
     * Overrides calcArea method to return surface area of the cone
     * @return surface area of cone <type double>
     */
	@Override
	public double calcArea() {
		return Math.PI * getRadius() * (getRadius() + Math.sqrt(getHeight() * getHeight() + getRadius() * getRadius()));
		// Pi*r[r+sqrt(h^2+r^2)]
	}

	/**
	 * calcVolume method
	 * Overrides calcVolume method to return volume of cone
     * @return Volume of cone <type double>
	 */
	@Override
	public double calcVolume() {
		return Math.PI * Math.pow(getRadius(), 2) * (getHeight() / 3);
	}

	 /** 
	  * Overrides equals method that compares two object by their ID
	  * @param Object o: object to be compared <type Object>
	  * @return boolean
	  */  
	public boolean equals(Object o) {
		Cone c;
		if(o.getClass() == Cone.class){
			c = (Cone) o;
			return ID == c.ID;
		}
		return false;
	}

	/**
	 * Overrides toString method to print attributes of cone
	 * @return Attributes of current Cone <type String>
	 */
	public String toString() {
		return "[Cone] \nID = " + ID + "\nRadius = " + getRadius() + "\nHeight = " + getHeight() + "\nSurface Area = "
				+ Math.round(calcArea() * 100.0) / 100.0 + "\nVolume = " + Math.round(calcVolume() * 100.0) / 100.0;
	}
}//End class

class Cube extends Geometric {//class header
	private double length;
	private static int numOfObjects = 0;
	private short ID;

	/**
	 * Default constructor to initialize the length, 
	 * and increment number of Cube objects created
	 */
	Cube() {
		ID = (short) getShapes();
		length = 5;
		if (this.getClass() == Cube.class)
			numOfObjects++;
	}

	/**
	 * Overloaded constructor to initialize length with a specified value
	 * Increments number of cube objects created
	 * 
	 * @param length - New specified value of length <type double> 
	 */
	Cube(double length) {
		ID = (short) getShapes();
		this.length = length;
		if (this.getClass() == Cube.class)
			numOfObjects++;
	}

	/**
	 * Overloaded constructor to change ID to use for searching
	 * @param ID - ID that is being searched for
	 */
	Cube(short ID) {
		super(ID);
		this.ID = ID;
	}

	/**
	 * getLength method
	 * 
	 * Accessor to return the length of Cube
	 * @return length <type double>
	 */
	public double getLength() {
		return length;
	}

	/**
	 * setLength method
	 * 
	 * Mutator to change length
	 * @param new length <type double>
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * getNum method
	 * 
	 * Accessor method to return number of cube objects
	 * @return numOfObjects <type int>
	 */
	public static int getNum() {
		return numOfObjects;
	}

	/**
	 * calcArea method
	 * 
	 * Overrides calcArea method to return surface area of cube
	 * @return surface area of cube <type double>
	 */
	@Override
	public double calcArea() {
		return 6 * Math.pow(length, 2);
	}

	/**
	 * calcPerimeter method
	 * 
	 * Overrides calcPerimeter method to return perimeter of cube
	 * @return perimeter of cube <type double>
	 */
	@Override
	public double calcPerimeter() {
		return 12 * length;
	}

	/**
	 * calcVolume method
	 * 
	 * Overrides calcVolume method to return volume of cube
	 * @return volume of cube <type double>
	 */
	@Override
	public double calcVolume() {
		return Math.pow(length, 3);
	}

	/**
	 * overrides equals method that compare two cube objects by their ID
	 * @param o - object to be compared <type Object>
	 * @return boolean
	 */
	public boolean equals(Object o) {
		Cube c;
		if(o.getClass() == Cube.class){
			c = (Cube) o;
			return ID == c.ID;
		}
		return false;
	}

	/**
	 * overrides toString method that prints the attributes of the current cube
	 * @return Attribute of cube <type String>
	 */
	public String toString() {
		return "[Cube] \nID = " + ID + "\nSide Length = " + length + "\nSurface Area = "
				+ Math.round(calcArea() * 100.0) / 100.0 + "\nVolume = " + Math.round(calcVolume() * 100.0) / 100.0
				+ "\nPerimeter = " + Math.round(calcPerimeter() * 100.0) / 100.0;
	}

}//end class

class Prism extends Cube {//class header
	private double width, height;
	private static int numOfObjects = 0;
	private short ID = (short) getShapes();

	/**
	 * Default constructor to initialize the width and height, 
	 * and increment number of Prism objects created
	 */
	Prism() {
		width = 6;
		height = 7;
		if (this.getClass() == Prism.class)
			numOfObjects++;
	}

	/**
	 * Overloaded constructor to initialize length, width, and height
	 * with a specified value. Increments number of Prism objects created
	 * 
	 * @param length - New specified value of length <type double> 
	 * @param width - New specified value of width <type double
	 * @param height - New specified value of height <type double>
	 */
	Prism(double length, double width, double height) {
		super(length);
		this.width = width;
		this.height = height;
		if (this.getClass() == Prism.class)
			numOfObjects++;
	}

	
	/**
	 * Overloaded constructor to change ID to use for searching
	 * @param ID - ID that is being searched for
	 */
	Prism(short ID) {
		super(ID);
		this.ID = ID;
	}

	/**
	 * getWidth method
	 * 
	 * Accessor method to return the width of the Prism
	 * @return width <type double>
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * getHeight method
	 * 
	 * Accessor method to return the height of the Prism
	 * @return height <type double>
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * setWidth method
	 * 
	 * Mutator method to change the width
	 * @param width <type double>
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * setHeight method
	 * 
	 * Mutator method to change the height
	 * @param height <type double>
	 */
	public void setheight(double height) {
		this.height = height;
	}

	/**
	 * getNum method
	 * 
	 * Accessor method to return number of Prism objects
	 * @return numOfObjects <type int>
	 */
	public static int getNum() {
		return numOfObjects;
	}

	/**
	 * calcArea method
	 * 
	 * Overrides calcArea method to return Surface area of Prism
	 * @return Surface Area of Prism <type double>
	 */
	@Override
	public double calcArea() {
		return 2 * ((width * getLength()) + (height * getLength()) + (height * width));
	}

	/**
	 * calcPerimeter method
	 * 
	 * Overrides calcPerimeter method to return perimeter of Prism
	 * @return Perimeter of Prism <type double>
	 */
	@Override
	public double calcPerimeter() {
		return 4 * (getLength() + height + width);
	}

	/**
	 * calcVolume method
	 * 
	 * Overrides calcVolume method to return volume of prism
	 * @return volume of Prism <type double>
	 */
	@Override
	public double calcVolume() {
		return getLength() * width * height;
	}

	/**
	 * overrides equals method that compare two Prism objects by their ID
	 * @param o - object to be compared <type Object>
	 * @return boolean
	 */
	public boolean equals(Object o) {
		Prism p;
		if(o.getClass() == Prism.class){
			p = (Prism) o;
			return ID == p.ID;
		}
		return false;
	}

	/**
	 * overrides toString method that prints the attributes of the current Prism
	 * @return Attribute of prism <type String>
	 */
	public String toString() {
		return "[Rectangular Prism] \nID = " + ID + "\nLength = " + getLength() + "\nWidth = " + width + "\nHeight = "
				+ height + "\nSurface Area = " + Math.round(calcArea() * 100.0) / 100.0 + "\nVolume = "
				+ Math.round(calcVolume() * 100.0) / 100.0 + "\nPerimeter = "
				+ Math.round(calcPerimeter() * 100.0) / 100.0;
	}

}//end class
