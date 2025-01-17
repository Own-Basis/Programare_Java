package Ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        List<Angajat> angajati = mapper.readValue(new File("src/main/resources/angajati.json"),
                new TypeReference<List<Angajat>>() {
                });
        Scanner scanner = new Scanner(System.in);
        int optiune;

        while (true) {
            System.out.println("1. Afisare lista angajati");
            System.out.println("2. Afisare angajati cu salariul mai mare de 2500 ron");
            System.out.println("3. Afisare angajati cu functie de conducere din aprilie anul trecut");
            System.out.println("4. Afisare angajati fara functie de conducere, crescator dupa salariu");
            System.out.println("5. Afisare nume angajati cu majuscule");
            System.out.println("6. Afisare salarii mai mici de 3000 ron");
            System.out.println("7. Afisare data prim angajat");
            System.out.println("8. Afisare existenta angajat cu numele Ion");
            System.out.println("9. Afisare angajati din vara anului trecut");
            System.out.println("10. Salvare lista modificata in JSON");
            System.out.println("0. Iesire");

            System.out.println("Alegeti o optiune:");
            optiune = scanner.nextInt();

            switch (optiune) {
                case 0:
                    scanner.close();
                    return;
                case 1:
                    angajati.forEach(System.out::println);
                    break;
                case 2:
                    angajati.stream()
                            .filter(angajat -> angajat.getSalariu() > 2500)
                            .forEach(System.out::println);
                    break;
                case 3:
                    int an_trecut = LocalDate.now().minusYears(1).getYear();
                    angajati.stream()
                            .filter(angajat -> angajat.getDataAngajarii().getYear() == an_trecut &&
                                    angajat.getDataAngajarii().getMonth() == Month.APRIL &&
                                    (angajat.getPost().contains("sef") || angajat.getPost().contains("direcotr"))
                            )
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    break;
                case 4:
                    angajati.stream()
                            .filter(angajat -> !(angajat.getPost().contains("sef") || angajat.getPost().contains("director")))
                            .sorted((a1, a2) -> Float.compare(a2.getSalariu(), a1.getSalariu()))
                            .forEach(System.out::println);
                    break;
                case 5:
                    angajati.stream()
                            .map(angajat -> angajat.getNume().toUpperCase())
                            .collect(Collectors.toList())
                            .forEach(System.out::println);
                    break;
                case 6:
                    angajati.stream()
                            .map(Angajat::getSalariu)
                            .filter(salariu -> salariu < 3000)
                            .forEach(System.out::println);
                    break;
                case 7:
                    Optional<Angajat> primAngajat = angajati.stream()
                            .min((a1, a2) -> a1.getDataAngajarii().compareTo(a2.getDataAngajarii()));

                    primAngajat.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Nu există angajat în listă.")
                    );
                    break;
                case 8:
                    angajati.stream()
                            .filter(angajat -> angajat.getNume().contains("Ion"))
                            .findAny()
                            .ifPresentOrElse(
                                    angajat -> System.out.println("Firma are cel puțin un Ion angajat"),
                                    () -> System.out.println("Firma nu are nici un Ion angajat")
                            );
                    break;
                case 9:
                    long numarAngajatiVara = angajati.stream()
                            .filter(angajat -> angajat.getDataAngajarii().getYear() == LocalDate.now().minusYears(1).getYear() &&
                                    (angajat.getDataAngajarii().getMonth() == Month.JUNE ||
                                            angajat.getDataAngajarii().getMonth() == Month.JULY ||
                                            angajat.getDataAngajarii().getMonth() == Month.AUGUST))
                            .count();
                    System.out.println("Numărul de angajați care s-au angajat vara anului trecut: " + numarAngajatiVara);
                    break;
                case 10:
                    try {
                        mapper.writeValue(new File("src/main/resources/angajati_modificat.json"), angajati);
                        System.out.println("Lista de angajați a fost salvată cu succes în fișierul JSON.");
                    } catch (IOException e) {
                        System.out.println("Eroare la salvarea fișierului JSON: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }
}
