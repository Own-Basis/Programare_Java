package ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter versuri_out = new FileWriter("src/ex2/cantec_out.txt");
        Path path = Paths.get("src/ex2/cantec_in.txt");
        ArrayList<String> versuri = (ArrayList<String>) Files.readAllLines(path);
        Vector<Float> versuri_numere = new Vector<>(versuri.size());
        Random random = new Random();

        for (int i = 0; i < versuri.size(); i++){
            versuri_numere.add(random.nextFloat());
        }

        System.out.println("The Vector is: " + versuri_numere);

        for (int j = 0; j < versuri.size(); j++) {
            versuri.set(j, Vers.steluta(versuri.get(j)));
            versuri.set(j, Vers.nr_Vocale(versuri.get(j)));
            versuri.set(j, Vers.nr_Cuvinte(versuri.get(j)));
            versuri.set(j, Vers.majuscule(versuri.get(j), versuri_numere.get(j)));
            versuri_out.write(versuri.get(j) + "\n");
        }
        versuri_out.close();
    }
}
