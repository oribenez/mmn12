
public class Tester {
	public static void main(String[] args) {
		Point p1 = new Point(2, 18);
		Point p2 = new Point(0, 15);
		Point p3 = new Point(0, 12);

		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle(p1, p2, p3);

		System.out.println(t2.isAbove(t1));
		System.out.println(t2);

	}
}
