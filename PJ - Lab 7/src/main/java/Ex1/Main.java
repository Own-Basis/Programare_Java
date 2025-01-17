package Ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Map<Integer, Carte> carti = mapper.readValue(
                new File("src/main/resources/carti.json"),
                new TypeReference<Map<Integer, Carte>>() {}
        );

        Scanner scanner = new Scanner(System.in);
        int optiune;

        while (true) {
            System.out.println("1. Afisare colectie");
            System.out.println("2. Stergere carte");
            System.out.println("3. Adaugare carte");
            System.out.println("4. Salvare modificari in fisier");
            System.out.println("5. Extrage cartile autorului Yual Noah Harari");
            System.out.println("6. Afisare ordonata dupa titlul cartilor");
            System.out.println("7. Afisare cea mai veche carte");
            System.out.println("0. Iesire");

            System.out.println("Alegeti o optiune:");
            optiune = scanner.nextInt();

            switch (optiune) {
                case 0:
                    scanner.close();
                    return;
                case 1:
                    carti.forEach((id, carte) -> System.out.println(id + ": " + carte));
                    break;
                case 2:
                    System.out.println("Introduceti id-ul cartii de sters:");
                    int idDeSters = scanner.nextInt();
                    carti.remove(idDeSters);
                    System.out.println("Cartea a fost stearsa.");
                    break;
                case 3:
                    System.out.println("Introduceti id-ul cartii:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduceti titlul cartii:");
                    String titlu = scanner.nextLine();
                    System.out.println("Introduceti autorul cartii:");
                    String autor = scanner.nextLine();
                    System.out.println("Introduceti anul aparitiei:");
                    int an = scanner.nextInt();
                    carti.putIfAbsent(id, new Carte(titlu, autor, an));
                    System.out.println("Cartea a fost adaugata.");
                    break;
                case 4:
                    mapper.writeValue(new File("src/main/resources/carti.json"), carti);
                    System.out.println("Modificarile au fost salvate in fisier.");
                    break;
                case 5:
                    Set<Carte> cartiAutor = carti.values().stream()
                            .filter(carte -> "Yuval Noah Harari".equals(carte.autor()))
                            .collect(Collectors.toSet());
                    cartiAutor.forEach(System.out::println);
                    break;
                case 6:
                    carti.values().stream()
                            .sorted(Comparator.comparing(Carte::titlu))
                            .forEach(System.out::println);
                    break;
                case 7:
                    carti.values().stream()
                            .min(Comparator.comparing(Carte::an))
                            .ifPresentOrElse(
                                    System.out::println,
                                    () -> System.out.println("Nu exista carti in colectie.")
                            );
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }
}

record Carte(String titlu, String autor, int an) {}
