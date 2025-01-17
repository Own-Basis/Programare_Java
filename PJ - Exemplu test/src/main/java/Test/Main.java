package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDate.now;

public class Main {

    public static List<Publicatie> citire(String fileName) {
        List<Publicatie> publicatii = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            String linie;
            br.readLine();

            while ((linie = br.readLine()) != null) {
                String[] valori = linie.split(",");

                String tip = valori[0];
                String titlu = valori[1];
                String autor = valori[2];
                int anPublicare = Integer.parseInt(valori[3]);

                if ("Carte".equals(tip)) {
                    int numarPagini = Integer.parseInt(valori[4]);
                    publicatii.add(new Carte(titlu, autor, anPublicare, numarPagini));
                } else if ("Revista".equals(tip)) {
                    int numarExemplare = Integer.parseInt(valori[5]);
                    publicatii.add(new Revista(titlu, autor, anPublicare, numarExemplare));
                }
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Eroare la parsarea numerelor: " + e.getMessage());
        }

        return publicatii;
    }

    public static void main(String[] args) throws IOException {
        List<Publicatie> publicatii = citire("publicatii.csv");
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int opt, anPublicatieIn = 0, numarExemplareIn = 0, numarPaginiIn;
        String tipIn, titluIn, autorIn;
        LocalDateTime now = LocalDateTime.now();
        boolean valid = false;

        while (true) {
            System.out.println("1.  Afisare publicatii");
            System.out.println("2.  Afisare publicatii dintr-un anumit an");
            System.out.println("3.  Afisare carti");
            System.out.println("4.  Afisare reviste");
            System.out.println("5.  introducere publicatie");
            System.out.println("6.  Afisare revista cu cele mai multe exemplare");
            System.out.println("0.  Iesire");
            System.out.println("Optiunea dvs. este:");
            String s = read.readLine();
            opt = Integer.parseInt(s);
            switch (opt) {
                case 1:
                    System.out.println("Afisare publicatii: ");
                    publicatii.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Afisare publicatii dintr-un anumit an: ");
                    System.out.println("Introduceti anul dorit: ");
                    s = read.readLine();
                    int an = Integer.parseInt(s);
                    List<Publicatie> filtrate = publicatii.stream()
                            .filter(p -> p.getAnPublicare() == an)
                            .toList();

                    if (filtrate.isEmpty()) {
                        System.out.println("Nu există publicații pentru anul " + an + ".");
                    } else {
                        System.out.println("\nPublicații din anul " + an + ":");
                        filtrate.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.println("Afisarea carti: ");
                    List<Carte> carti = publicatii.stream()
                            .filter(Carte.class::isInstance)
                            .map(Carte.class::cast)
                            .toList();

                    if (carti.isEmpty()) {
                        System.out.println("Nu există cărți în colecție.");
                    } else {
                        System.out.println("\nCărți disponibile:");
                        carti.forEach(System.out::println);
                    }
                    break;
                case 4:
                    System.out.println("Afisare reviste: ");
                    List<Revista> reviste = publicatii.stream()
                            .filter(Revista.class::isInstance)
                            .map(Revista.class::cast)
                            .toList();
                    if (reviste.isEmpty()) {
                        System.out.println("Nu există reviste în colecție.");
                    } else {
                        System.out.println("\nReviste disponibile:");
                        reviste.forEach(System.out::println);
                    }
                    break;
                case 5:
                    System.out.println("Introducere titlu publicatie: ");
                    titluIn = read.readLine();
                    System.out.println("Introducere autor publicatie: ");
                    autorIn = read.readLine();
                    while (!valid) {
                        System.out.println("Introducere an publicatie: ");
                        try {
                            int inputYear = Integer.parseInt(read.readLine());
                            if (inputYear <= now.getYear()) {
                                anPublicatieIn = inputYear;
                                valid = true;
                            } else {
                                System.out.println("Introduceti un an valid!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Introduceti un an valid!");
                        } catch (IOException e) {
                            System.out.println("Eroare la citire input");
                        }
                    }
                    System.out.println("Introducere tip publicatie: ");
                    tipIn = read.readLine();
                        if (tipIn.equals("Carte")) {
                            System.out.println("Introducere numar pagini carte:");
                            numarPaginiIn = Integer.parseInt(read.readLine());
                            Carte carteIn = new Carte(titluIn, autorIn, anPublicatieIn, numarPaginiIn);
                            publicatii.add(carteIn);
                        }
                        else if (tipIn.equals("Revista")) {
                            System.out.println("Introducere numar exemplare revista:");
                            numarExemplareIn = Integer.parseInt(read.readLine());
                            Revista revistaIn = new Revista(titluIn, autorIn, anPublicatieIn, numarExemplareIn);
                            publicatii.add(revistaIn);
                        }
                    break;
                case 6:
                    Optional<Revista> maxRevista = publicatii.stream().
                            filter(p -> p instanceof Revista).
                            map(p -> (Revista) p).
                            max(Comparator.comparing(Revista::getNumarExemplare));
                    maxRevista.stream().forEach(System.out::println);
                    break;
                case 0:
                    System.exit(0);
                    read.close();
                    break;
                default:
                    System.out.println("Optiunea dvs. este gresita!");
                    break;
            }
        }
    }


}
