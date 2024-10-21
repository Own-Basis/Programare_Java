package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/ex1/judete_in.txt");
        String[] judete  = Files.readAllLines(path).toArray(new String[0]);
        System.out.println("Lista nesortata cu toate judetele:");
        for (int i = 0; i < judete.length; i++) {
            System.out.println(judete[i]);
        }

        System.out.println("\nLista sortata cu toate judetele:");
        Arrays.sort(judete);
        for (int i = 0; i < judete.length; i++) {
            System.out.println(judete[i]);
        }

        System.out.println("\nIntroduceti judetul cautat:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String judet_cautat = String.format(bufferedReader.readLine());
        System.out.println("\nJudetul cautat se afla la pozitia:\n " + Arrays.binarySearch(judete, judet_cautat));

    }
}