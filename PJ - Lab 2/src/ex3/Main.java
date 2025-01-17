package ex3;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter versuri_out = new FileWriter("src/ex3/cantec_out.txt");
        Path path = Paths.get("src/ex3/string.txt");
        String stringOriginal = new String (Files.readAllBytes(path));
        System.out.println("Stringul din fisier: " + stringOriginal + "\n");
        Random random = new Random();

        int stringLength = stringOriginal.length();
        int deleteLength = 3;
        int indexInsert = random.nextInt(stringLength);
        int indexDelete = random.nextInt(stringLength - deleteLength + 1) + deleteLength;
        System.out.println("Pozitie inserare: " + indexInsert + "\n");
        System.out.println("Pozitie stergere: " + indexDelete);

        System.out.println("\nIntroduceti un string:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String stringUser = bufferedReader.readLine();

        String stringInserted = stringOriginal.substring(0, indexInsert) + stringUser + stringOriginal.substring(indexInsert);
        System.out.println("\n" + stringInserted);

        String stringDeleted = stringInserted.substring(0, indexDelete) + stringInserted.substring(indexDelete + deleteLength);
        System.out.println(stringDeleted);
    }
}
