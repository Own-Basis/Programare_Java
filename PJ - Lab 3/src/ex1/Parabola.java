package ex1;

public class Parabola {
    private double a, b, c, x, y;

    public Parabola(double a, double b, double c, double x, double y) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x = x;
        this.y = y;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static Parabola fromString(String line) {
        String[] parts = line.split(" ");
        double a = Double.parseDouble(parts[0]);
        double b = Double.parseDouble(parts[1]);
        double c = Double.parseDouble(parts[2]);
        double x = -1 * (b/2*a);
        double y = (-1 * b * b + 4 * a * c) / 4 *a;
        return new Parabola(a, b, c, x, y);
    }

    @Override
    public String toString() {
        return "f(x) = " + a + " x^2 + " + b + " x + " + c + " | Vx = " + x + " Vy = " + y;
    }

    public static void Optiune1(String line) {

    }

}