public class TriangleUtil {
	private double a;
    private double b;
    private double c;

    public TriangleUtil(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static boolean canCreateTriangle(TriangleUtil triangle) {
         if (!(triangle.a > 0 || triangle.b > 0 || triangle.c > 0)) {
            return false;
        }
        return triangle.a + triangle.b > triangle.c && triangle.a + triangle.c > triangle.b && triangle.b + triangle.c > triangle.a;
    }
}
