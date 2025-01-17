package Ex2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String JSON_FILE_PATH = "src/main/resources/instrumente.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        Set<InstrumentMuzical> instrumente = new HashSet<>();
        initializeInstrumente(instrumente);

        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("\nMeniu:");
            System.out.println("1. Afișează toate instrumentele");
            System.out.println("2. Adaugă un instrument");
            System.out.println("3. Salvează instrumentele în JSON");
            System.out.println("4. Încarcă instrumentele din JSON");
            System.out.println("5. Elimină instrumentele mai scumpe de 3000 RON");
            System.out.println("6. Verifică duplicate");
            System.out.println("7. Afișează chitări");
            System.out.println("8. Afișează seturi de tobe");
            System.out.println("9. Chitara cu cele mai multe corzi");
            System.out.println("10. Tobele acustice ordonate după număr de tobe");
            System.out.println("11. Ieșire");
            System.out.print("Alege o opțiune: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consumăm linia rămasă

            switch (option) {
                case 1 -> instrumente.forEach(System.out::println);
                case 2 -> addInstrument(scanner, instrumente);
                case 3 -> saveToJson(instrumente);
                case 4 -> instrumente = loadFromJson();
                case 5 -> {
                    instrumente.removeIf(instr -> instr.getPret() > 3000);
                    System.out.println("Instrumentele mai scumpe de 3000 RON au fost eliminate.");
                }
                case 6 -> checkDuplicate(scanner, instrumente);
                case 7 -> instrumente.stream()
                        .filter(instr -> instr instanceof Chitara)
                        .forEach(System.out::println);
                case 8 -> instrumente.stream()
                        .filter(instr -> instr.getClass().equals(SetTobe.class))
                        .forEach(System.out::println);
                case 9 -> instrumente.stream()
                        .filter(instr -> instr instanceof Chitara)
                        .map(instr -> (Chitara) instr)
                        .max(Comparator.comparingInt(Chitara::getNrCorzi))
                        .ifPresent(System.out::println);
                case 10 -> instrumente.stream()
                        .filter(instr -> instr instanceof SetTobe)
                        .map(instr -> (SetTobe) instr)
                        .filter(tobe -> tobe.getTipTobe() == TipTobe.ACUSTICE)
                        .sorted(Comparator.comparingInt(SetTobe::getNrTobe))
                        .forEach(System.out::println);
                case 11 -> {
                    running = false;
                    System.out.println("Ieșire din program.");
                }
                default -> System.out.println("Opțiune invalidă. Încearcă din nou.");
            }
        }

        scanner.close();
    }

    private static void initializeInstrumente(Set<InstrumentMuzical> instrumente) {
        instrumente.add(new Chitara("Yamaha", 2000, TipChitara.ELECTRICA, 6));
        instrumente.add(new Chitara("Gibson", 3500, TipChitara.ACUSTICA, 12));
        instrumente.add(new Chitara("Fender", 3000, TipChitara.CLASICA, 8));
        instrumente.add(new SetTobe("Roland", 4000, TipTobe.ELECTRONICE, 5, 3));
        instrumente.add(new SetTobe("Pearl", 2500, TipTobe.ACUSTICE, 7, 2));
        instrumente.add(new SetTobe("Tama", 1500, TipTobe.ACUSTICE, 4, 1));
    }

    private static void addInstrument(Scanner scanner, Set<InstrumentMuzical> instrumente) {
        System.out.print("Tipul instrumentului (chitara/tobe): ");
        String type = scanner.nextLine().toLowerCase();

        System.out.print("Producător: ");
        String producator = scanner.nextLine();

        System.out.print("Preț: ");
        double pret = scanner.nextDouble();
        scanner.nextLine(); // consumăm linia rămasă

        if (type.equals("chitara")) {
            System.out.print("Tip chitară (ELECTRICA/ACUSTICA/CLASICA): ");
            TipChitara tipChitara = TipChitara.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Număr de corzi: ");
            int nrCorzi = scanner.nextInt();
            scanner.nextLine(); // consumăm linia rămasă

            instrumente.add(new Chitara(producator, pret, tipChitara, nrCorzi));
            System.out.println("Chitara a fost adăugată.");
        } else if (type.equals("tobe")) {
            System.out.print("Tip tobe (ELECTRONICE/ACUSTICE): ");
            TipTobe tipTobe = TipTobe.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Număr de tobe: ");
            int nrTobe = scanner.nextInt();

            System.out.print("Număr de cinele: ");
            int nrCinele = scanner.nextInt();
            scanner.nextLine(); // consumăm linia rămasă

            instrumente.add(new SetTobe(producator, pret, tipTobe, nrTobe, nrCinele));
            System.out.println("Setul de tobe a fost adăugat.");
        } else {
            System.out.println("Tip invalid.");
        }
    }

    private static void saveToJson(Set<InstrumentMuzical> instrumente) {
        try {
            mapper.writeValue(new File(JSON_FILE_PATH), instrumente);
            System.out.println("Instrumentele au fost salvate în JSON.");
        } catch (IOException e) {
            System.out.println("Eroare la salvarea în JSON: " + e.getMessage());
        }
    }

    private static Set<InstrumentMuzical> loadFromJson() {
        try {
            Set<InstrumentMuzical> instrumenteSet = mapper.readValue(
                    new File(JSON_FILE_PATH),
                    mapper.getTypeFactory().constructCollectionType(HashSet.class, InstrumentMuzical.class)
            );
            System.out.println("Instrumentele au fost încărcate din JSON.");
            return instrumenteSet;
        } catch (IOException e) {
            System.out.println("Eroare la încărcarea din JSON: " + e.getMessage());
            return new HashSet<>();
        }
    }


    private static void checkDuplicate(Scanner scanner, Set<InstrumentMuzical> instrumente) {
        System.out.print("Introdu producătorul instrumentului duplicat: ");
        String producator = scanner.nextLine();
        System.out.print("Introdu prețul instrumentului duplicat: ");
        double pret = scanner.nextDouble();
        scanner.nextLine(); // consumăm linia rămasă

        InstrumentMuzical duplicate = new Chitara(producator, pret, TipChitara.ELECTRICA, 6); // presupunem chitara electrică
        if (!instrumente.add(duplicate)) {
            System.out.println("Instrument duplicat. Nu a fost adăugat.");
        } else {
            System.out.println("Instrumentul a fost adăugat.");
        }
    }
}
