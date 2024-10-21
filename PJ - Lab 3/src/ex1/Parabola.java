package ex1;

public class Parabola {
    private int a,b,c;

    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "f(x) = " + a + " x^2 +" + b + " x +" + c;
    }

    public int msd(int a, int b, int c) {


        return 0;
    }
}