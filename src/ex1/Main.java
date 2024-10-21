package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduceti lungimea dreptunghiului:");
        int lungime = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Introduceti latimea dreptunghiului:");
        int latime = Integer.parseInt(bufferedReader.readLine());

        int arie = lungime * latime;
        System.out.println("Aria dreptunghiului este: " + arie);

        int perimetru = 2 * (lungime + latime);
        System.out.println("Aria perimetrului este: " + perimetru);

    }
}