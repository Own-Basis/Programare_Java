package ex4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceți numărul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Persoana[] persoane = new Persoana[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Persoana " + (i + 1) + ":");

            System.out.print("Introduceți numele: ");
            String nume = scanner.nextLine();

            String cnp;
            while (true) {
                System.out.print("Introduceți CNP-ul: ");
                cnp = scanner.nextLine();

                if (Persoana.validareCNP(cnp)) {
                    break;
                } else {
                    System.out.println("CNP invalid.");
                }
            }

            persoane[i] = new Persoana(nume, cnp);
        }

        // Afișăm informațiile pentru fiecare persoană
        System.out.println("\nInformații persoane:");
        for (Persoana p : persoane) {
            System.out.println(p);
        }
    }
}
