package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static boolean isPrime(int numar) {
        double dmax = Math.sqrt(numar);
        int count = 0;

        if (numar < 2) {
            return false;
        }

        for (int i = 2; i <= (int) dmax; i++) {
            if (numar % i == 0) {
                count++;
            }
        }

        return count == 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduceti un numar:");
        double numar = Integer.parseInt(bufferedReader.readLine());
        double dmax = Math.sqrt(numar);

        if (numar != 0) {
            System.out.println("Divizorii numarului sunt:");
            for (int i = (int) dmax; i >= 1; i--) {
                if (numar % i == 0) {
                    if (numar / i == i) {
                        System.out.println((i));
                    } else {
                        System.out.println(("" + i));
                        System.out.println(("" + (int) numar / i));
                    }
                }
            }

        } else {
            System.out.println("Eroare!");
            System.exit(0);
        }

        if (isPrime((int) numar))
            System.out.println("Numarul este prim");
        else System.out.println("Numarul nu este prim");
    }
}