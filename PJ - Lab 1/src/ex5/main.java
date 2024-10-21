package ex5;

public class main {

    public static boolean sc(int val){
        int s = (int) Math.sqrt(val);
        return (s*s == val);
    }

    public static boolean fibonacci(int n) {
        return sc(5 * n * n + 4) || sc(5 * n * n - 4);
    }

    public static void main(String[] args) {
        int range = 20;
        int rand = (int) (Math.random() * range);
        System.out.println(fibonacci(rand) ? rand + " apartine sirului Fibonacci" :
                rand + " nu apartine sirului Fibonacci");
    }
}
