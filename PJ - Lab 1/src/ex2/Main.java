package ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("src/ex2/out.txt");
        Path path = Paths.get("src/ex2/in.txt");
        List<String> nr = Files.readAllLines(path);

        System.out.println("Numerele sunt:");
        for (int i = 0; i < nr.size(); i++) {
            System.out.println(" " + nr.get(i));
            writer.write(nr.get(i) + "\n");
        }

        System.out.println("Minimul este: " + Collections.min(nr));
        writer.write("Minimul este: " + Collections.min(nr) + "\n");
        System.out.println("Maximul este: " + Collections.max(nr));
        writer.write("Maximul este: " + Collections.max(nr) + "\n");

        float suma = 0;
        for (int i = 0; i < nr.size(); i++) {
            suma = suma + Float.parseFloat(nr.get(i));
        }

        System.out.println("Suma este: " + suma);
        writer.write("Suma este: " + suma + "\n");
        System.out.println("Media este: " + suma/nr.size());
        writer.write("Media este: " + suma/nr.size());

        writer.close();
    }
}