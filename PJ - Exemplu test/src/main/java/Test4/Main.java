package Test4;

public class Main {
    static void afiseaza(var vector){
        for(Integer x: vector){
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        int a[] = {1, 2, 3};
        afiseaza(a);
    }
}
