package ex4;

public class main {

    public static int cmmdc(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return cmmdc(n2, n1 % n2);
    }

    public static void main(String[] args) {
        int min = 1;
        int max = 30;
        int range = max - min + 1;
        int rand1 = (int) (Math.random() * range) + min;
        int rand2 = (int) (Math.random() * range) + min;

        System.out.println("Primul numar: " + rand1);
        System.out.println("Al doilea numar: " + rand2);
        System.out.println("Cmmdc este " + cmmdc(rand1, rand2));
    }


}
