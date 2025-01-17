package Test2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    private static List<Carte> catalog() {
        Autor autor1 = new Autor("Ion Creanga", "Romana", 55);
        Autor autor2 = new Autor("Mihai Eminescu", "Romana", 50);
        Autor autor3 = new Autor("Jules Verne", "Franceza", 70);
        Autor autor4 = new Autor("Arthur C. Clarke", "Engleza", 60);
        Autor autor5 = new Autor("Isaac Asimov", "Rusa", 72);

        Carte carte1 = new Carte("Titlu1", Carte.Gen.FICTIUNE, 1999, Arrays.asList(autor1, autor2, autor3));
        Carte carte2 = new Carte("Titlu2", Carte.Gen.NON_FICTIUNE, 2000, Arrays.asList(autor1, autor2, autor3));
        Carte carte3 = new Carte("Titlu3", Carte.Gen.STIINTA, 2001, Arrays.asList(autor1, autor4, autor5));

        return new ArrayList<>(Arrays.asList(carte1, carte2, carte3));
    }

    private static void serializeCatalog(List<Carte> catalog, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File(filename), catalog);
            System.out.println("\nCatalog serialized to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Carte> deserializeCatalog(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(new File(filename), new TypeReference<List<Carte>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        List<Carte> catalog = catalog();
        catalog.forEach(System.out::println);
        String filename = "catalog.json";

        serializeCatalog(catalog, filename);
        List<Carte> catalog2 = deserializeCatalog(filename);

        catalog2.forEach(System.out::println);
    }
}
