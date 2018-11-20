public class TriangleUtil {
	private double a;
    private double b;
    private double c;

    public TriangleUtil(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    boolean canCreateTriangle() {
            return a + b > c && a + c > b && b + c > a;
        }
}
