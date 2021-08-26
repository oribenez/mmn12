/**
 * Triangle.java represents a triangle in the Euclidean space.
 * 
 * @author Ori Ben-Ezra
 * @version 22-02-2021
 */
public class Triangle {
	// Declarations
	private Point _point1;
	private Point _point2;
	private Point _point3;
	public static final double EPSILON = 0.001;

	/**
	 * Construct a new Triangle (default constructor) from 3 default
	 * Points:(1,0),(-1,0),(0,1)
	 */
	public Triangle() {
		// default values of the Triangle class
		_point1 = new Point(1, 0);
		_point2 = new Point(-1, 0);
		_point3 = new Point(0, 1);
	}

	/**
	 * constructor which gets 3 vertices and set them to the triangle
	 * 
	 * @param p1 The first vertex of the desired triangle
	 * @param p2 The second vertex of the desired triangle
	 * @param p3 The third vertex of the desired triangle
	 */
	public Triangle(Point p1, Point p2, Point p3) {

		if (isValid(p1, p2, p3)) { // Triangle has valid vertices
			// sets triangle vertices to a clone of the argument values
			_point1 = new Point(p1);
			_point2 = new Point(p2);
			_point3 = new Point(p3);
		} else { // Triangle has invalid vertices
			// sets triangle vertices to it's default values
			_point1 = new Point(1, 0);
			_point2 = new Point(-1, 0);
			_point3 = new Point(0, 1);
		}
	}

	/**
	 * Constructor that create Triangle object using six numbers that each pair of
	 * arguments represents the Triangle vertex. If the values of the Triangle
	 * vertices are invalid the method sets the Triangle vertices to it's default
	 * values.
	 * 
	 * @param x1 The x coordiante of the first vertex
	 * @param y1 The y coordiante of the first vertex
	 * @param x2 The x coordiante of the second vertex
	 * @param y2 The y coordiante of the second vertex
	 * @param x3 The x coordiante of the third vertex
	 * @param y3 The y coordiante of the third vertex
	 */
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		Point p3 = new Point(x3, y3);

		if (isValid(p1, p2, p3)) { // Triangle has valid vertices
			// sets triangle vertices to argument values
			_point1 = p1;
			_point2 = p2;
			_point3 = p3;
		} else { // Triangle has invalid vertices
			// sets triangle vertices to it's default values
			_point1 = new Point(1, 0);
			_point2 = new Point(-1, 0);
			_point3 = new Point(0, 1);
		}
	}

	/**
	 * Constructor which clones a triangle using given triangle.
	 * 
	 * @param other A valid Triangle to clone
	 */
	public Triangle(Triangle other) {
		_point1 = new Point(other.getPoint1());
		_point2 = new Point(other.getPoint2());
		_point3 = new Point(other.getPoint3());
	}

	/**
	 * This method returns the triangle's first point
	 * 
	 * @return method which return the first point of this triangle
	 */
	public Point getPoint1() {
		return _point1;
	}

	/**
	 * This method returns the triangle's second point
	 * 
	 * @return method which return the second point of this triangle
	 */
	public Point getPoint2() {
		return _point2;
	}

	/**
	 * This method returns the triangle's third point
	 * 
	 * @return method which return the third point of this triangle
	 */
	public Point getPoint3() {
		return _point3;
	}

	/**
	 * Method which sets the first point of this triangle only if it is valid after
	 * change.
	 * 
	 * @param p the desired point to change to.
	 */
	public void setPoint1(Point p) {
		if (isValid(p, _point2, _point3)) {
			_point1 = new Point(p); // sets the point to a new one
		}
	}

	/**
	 * Method which sets the second point of this triangle only if it is valid after
	 * change.
	 * 
	 * @param p the desired point to change to.
	 */
	public void setPoint2(Point p) {
		if (isValid(_point1, p, _point3)) {
			_point2 = new Point(p); // sets the point to a new one
		}
	}

	/**
	 * Method which sets the third point of this triangle only if it is valid after
	 * change.
	 * 
	 * @param p the desired point to change to.
	 */
	public void setPoint3(Point p) {
		if (isValid(_point1, _point2, p)) {
			_point3 = new Point(p); // sets the point to a new one
		}
	}

	/**
	 * Method which checks if the point arguments can behave like valid triangle
	 * vertices.
	 * 
	 * @param p1 The first vertex of the triangle
	 * @param p2 The second vertex of the triangle
	 * @param p3 The third vertex of the triangle
	 * @return true if all three points can behave like a triangle vertices,
	 *         otherwise false.
	 */
	public boolean isValid(Point p1, Point p2, Point p3) {
		// Measure three sides of the triangle
		// a,b,c represents triangle sides
		double a = p1.distance(p2);
		double b = p1.distance(p3);
		double c = p2.distance(p3);

		// check if sum of two sides of the triangle are equals to the third side.
		// if the difference is under EPSILON
		if (epsilonEqual(a + b, c) || epsilonEqual(a + c, b) || epsilonEqual(b + c, a)) {
			return false; // Points arguments can't behave as a triangle vertices.
		}
		return true; // Points arguments can behave as a triangle vertices.
	}

	/**
	 * Function which compares two length values according to epsilon equality
	 * 
	 * @param len1 the first length
	 * @param len2 the second length
	 * @return True if both lengths are equal according to epsilon.
	 */
	private boolean epsilonEqual(double len1, double len2) {
		if (Math.abs(len1 - len2) < EPSILON) {
			return true; // they are equal
		}
		return false; // Lengths are not equal
	}

	/**
	 * A method which overrides the base class toString method
	 * 
	 * @return String of Triangle points
	 */
	public String toString() {
		String strTriangle = "";
		strTriangle += "{";
		strTriangle += "(" + _point1.getX() + "," + _point1.getY() + "),"; // first point
		strTriangle += "(" + _point2.getX() + "," + _point2.getY() + "),"; // second point
		strTriangle += "(" + _point3.getX() + "," + _point3.getY() + ")"; // third point
		strTriangle += "}";

		return strTriangle;
	}

	/**
	 * Method which calculates the perimeter of this triangle
	 * 
	 * @return double number which represents the perimeter
	 */
	public double getPerimeter() {
		// Measure three sides of the triangle
		double a = _point1.distance(_point2);
		double b = _point1.distance(_point3);
		double c = _point2.distance(_point3);

		return a + b + c;
	}

	/**
	 * Method which calculates the area of this triangle using Haron's method
	 * 
	 * @return double value which represents the area
	 */
	public double getArea() {
		// a,b,c represents triangle sides
		double a = _point1.distance(_point2);
		double b = _point1.distance(_point3);
		double c = _point2.distance(_point3);

		// Variable in Haron's formula
		double s = getPerimeter() / 2;

		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	/**
	 * Method which checks if this triangle is Isoceles
	 * 
	 * @return True if this triangle is isosceles, otherwise false.
	 */
	public boolean isIsosceles() {
		// a,b,c represents triangle sides
		double a = _point1.distance(_point2);
		double b = _point1.distance(_point3);
		double c = _point2.distance(_point3);

		return (epsilonEqual(a, b) || epsilonEqual(a, c) || epsilonEqual(b, c));
	}

	/**
	 * Method which checks if this triangle has right angle
	 * 
	 * @return True if the triangle has right angle, otherwise false.
	 */
	public boolean isPythagorean() {
		// a,b,c represents triangle sides
		double a = _point1.distance(_point2);
		double b = _point1.distance(_point3);
		double c = _point2.distance(_point3);

		// Check if the triangle is a pythagorean
		return epsilonEqual(a * a + b * b, c * c) || epsilonEqual(a * a + c * c, b * b)
				|| epsilonEqual(b * b + c * c, a * a);
	}

	/**
	 * Method which checks if this triangle is inside a given circle
	 * 
	 * @param x coordinate of the given circle
	 * @param y coordinate of the given circle
	 * @param r radius of the given circle
	 * @return true if this triangle is inside a given circle
	 */
	public boolean isContainedInCircle(double x, double y, double r) {
		Point circleCenter = new Point(x, y);

		// measures the length between the center of the circle to each triangle vertex
		double len1 = circleCenter.distance(_point1);
		double len2 = circleCenter.distance(_point2);
		double len3 = circleCenter.distance(_point3);

		return len1 <= r && len2 <= r && len3 <= r;
	}

	/**
	 * Method checks which vertex of this triangle has the lowest y coordinate.
	 * 
	 * @return Point object of the lowest vertex of this triangle.
	 */
	public Point lowestPoint() {
		double y1 = _point1.getY();
		double y2 = _point2.getY();
		double y3 = _point3.getY();

		if (y1 < y2 && y1 < y3) // the first point has the lowest Y coordinate
			return _point1;
		else if (y2 < y1 && y2 < y3) // the second point has the lowest Y coordinate
			return _point2;
		else if (y3 < y2 && y3 < y1) // the third point has the lowest Y coordinate
			return _point3;

		// both of the points arent the same y level
		// returning the left point
		double x1 = _point1.getX();
		double x2 = _point2.getX();
		double x3 = _point3.getX();

		if (x1 < x2 && x1 < x3) // the first point has the lowest X coordinate
			return _point1;
		else if (x2 < x1 && x2 < x3) // the second point has the lowest X coordinate
			return _point2;

		return _point3;// the third point has the lowest X coordinate
	}

	/**
	 * Method checks which vertex of this triangle has the highest y coordinate.
	 * 
	 * @return Point object of the highest vertex of this triangle.
	 */
	public Point highestPoint() {
		double y1 = _point1.getY();
		double y2 = _point2.getY();
		double y3 = _point3.getY();

		if (y1 > y2 && y1 > y3) // the first point has the highest Y coordinate
			return _point1;
		else if (y2 > y1 && y2 > y3) // the second point has the highest Y coordinate
			return _point2;
		else if (y3 > y2 && y3 > y1) // the third point has the highest Y coordinate
			return _point3;

		// both of the points areat the same y level
		// returning the left point
		double x1 = _point1.getX();
		double x2 = _point2.getX();
		double x3 = _point3.getX();

		if (x1 < x2 && x1 < x3) // the first point has the highest X coordinate
			return _point1;
		else if (x2 < x1 && x2 < x3) // the second point has the highest X coordinate
			return _point2;

		return _point3;// the third point has the highest X coordinate
	}

	/**
	 * Method which checks if the whole triangle is located in one quadrant.
	 * 
	 * @return True if the whole triangle is located in one quadrant, otherwise
	 *         false.
	 */
	public boolean isLocated() {
		return _point1.quadrant() == _point2.quadrant() && _point2.quadrant() == _point3.quadrant();
	}

	/**
	 * Method checks if this triangle is above the given argument triangle
	 * 
	 * @param other Triangle object
	 * @return True if this triangle is above the given argument triangle, otherwise
	 *         false.
	 */
	public boolean isAbove(Triangle other) {
		return this.lowestPoint().isAbove(other.highestPoint());
	}

	/**
	 * Method checks if this triangle is under the given argument triangle
	 * 
	 * @param other Triangle object
	 * @return True if this triangle is under the given argument triangle, otherwise
	 *         false.
	 */
	public boolean isUnder(Triangle other) {
		return other.isAbove(this);
	}

	/**
	 * Method checks if this triangle points are equals to the given argument
	 * triangle corresponding to each point.
	 * 
	 * @param other the triangle to compare to.
	 * @return True if both triangles points equals to the given triangle points in
	 *         the correct order.
	 */
	public boolean equals(Triangle other) {
		return _point1.equals(other._point1) && _point2.equals(other._point2) && _point3.equals(other._point3);
	}

	/**
	 * Method checks if both triangles are congruent
	 * 
	 * @param other Triangle to compare to
	 * @return True if both triangles are congruent, otherwise false.
	 */
	public boolean isCongruent(Triangle other) {
		// a,b,c represents this triangle sides
		double a1 = _point1.distance(_point2);
		double b1 = _point1.distance(_point3);
		double c1 = _point2.distance(_point3);

		// a,b,c represents other triangle sides
		double a2 = other._point1.distance(other._point2);
		double b2 = other._point1.distance(other._point3);
		double c2 = other._point2.distance(other._point3);

		if (epsilonEqual(a1, a2) || epsilonEqual(a1, b2) || epsilonEqual(a1, c2)) {
			if (epsilonEqual(b1, a2) || epsilonEqual(b1, b2) || epsilonEqual(b1, c2)) {
				if (epsilonEqual(c1, a2) || epsilonEqual(c1, b2) || epsilonEqual(c1, c2)) {
					return true;
				}
			}
		}
		return false;
	}
}
