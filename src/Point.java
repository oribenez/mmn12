/**
 * Point.java represents a 2-Dimensional point in the Euclidean space.
 * 
 * @author Ori Ben-Ezra
 * @version 22-02-2021
 */
public class Point {
	// Declaration
	private static final int AXIS_DEFAULT_VAL = 0;
	private double _x; // X axis
	private double _y; // Y axis

	/**
	 * Constructor which initialize Point obj variables using two new known values
	 * 
	 * @param x Represents the X value on the Cartesian system
	 * @param y Represents the Y value on the Cartesian system
	 */
	public Point(double x, double y) {
		_x = x;
		_y = y;
	}

	/**
	 * Copy constructor Creates a new Point identical to the given point
	 * 
	 * @param other the Point to be copied
	 */
	public Point(Point other) {
		_x = other._x;
		_y = other._y;
	}

	/**
	 * Returns the x coordinate.
	 * 
	 * @return a double
	 */
	public double getX() {
		return _x;
	}

	/**
	 * Returns the y coordinate.
	 * 
	 * @return a double
	 */
	public double getY() {
		return _y;
	}

	/**
	 * This method sets the x coordinate of the point.
	 * 
	 * @param num The new x coordinate
	 */
	public void setX(double num) {
		_x = num;
	}

	/**
	 * This method sets the y coordinate of the point.
	 * 
	 * @param num The new y coordinate
	 */
	public void setY(double num) {
		_y = num;
	}

	/**
	 * Return true if the given point is equal to this point.
	 * 
	 * @param other The point we are checking equality with
	 * @return true if the point other equals this point
	 */
	public boolean equals(Point other) {
		if (other._x == _x && other._y == _y)
			return true;
		return false;
	}

	/**
	 * Check if this point is above a received point.
	 * 
	 * @param other The point to check if this point is above
	 * @return True if this point is above the other point
	 */
	public boolean isAbove(Point other) {
		if (_y > other._y)
			return true;
		return false;
	}

	/**
	 * Check if this point is below a received point.
	 * 
	 * @param other The point to check if this point is below
	 * @return True if this point is below the other point
	 */
	public boolean isUnder(Point other) {
		return other.isAbove(this);
	}

	/**
	 * Check if this point is left of a received point.
	 * 
	 * @param other The point to check if this point is left of
	 * @return True if this point is left of the other point
	 */
	public boolean isLeft(Point other) {
		if (_x < other._x)
			return true;
		return false;
	}

	/**
	 * Check if this point is right of a received point.
	 * 
	 * @param other The point to check if this point is right of
	 * @return True if this point is right of the other point
	 */
	public boolean isRight(Point other) {
		return other.isLeft(this);
	}

	/**
	 * Check the distance between this point and a received point.
	 * 
	 * @param p The point to check the distance from
	 * @return The distance between this point and a received point
	 */
	public double distance(Point p) {
		return Math.sqrt(Math.pow(p._y - _y, 2) + Math.pow(p._x - _x, 2));
	}

	/**
	 * Return number of quadrant or 0 if the point is on an axis
	 * 
	 * @return an int representing the quadrant number
	 */
	public int quadrant() {
		if (_x > AXIS_DEFAULT_VAL && _y > AXIS_DEFAULT_VAL) { // quarter I
			return 1;
		} else if (_x < AXIS_DEFAULT_VAL && _y > AXIS_DEFAULT_VAL) { // quarter II
			return 2;
		} else if (_x < AXIS_DEFAULT_VAL && _y < AXIS_DEFAULT_VAL) { // quarter III
			return 3;
		} else if (_x > AXIS_DEFAULT_VAL && _y < AXIS_DEFAULT_VAL) { // quarter IV
			return 4;
		}
		return 0;
	}

	/**
	 * Returns a string representation of this Point. The format of the string
	 * should be: (x,y)
	 * 
	 * @return A string representation of a Point object
	 */
	public String toString() {
		return "(" + _x + "," + _y + ")";
	}
}
