package ex1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/ex1/in.txt");
        File file = new File(String.valueOf(path));
        List<Parabola> lista = new ArrayList<>();
        BufferedReader reader;
        String line;

        if (file.exists()) {
            while ((line = reader.readLine()) != null) {

            }
        } else {
            throw new FileNotFoundException("File does not exist");
        }


        while (path.toFile().exists()) {
        }
        List<Parabola> lista = new Parabola();
    }
}