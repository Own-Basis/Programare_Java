package Test3;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static ArrayList<Object> lista() {
        Membru membru1 = new Membru("Nume1", 18, 10, Membru.tipSport.FOTBAL);
        Membru membru2 = new Membru("Nume2", 19, 9, Membru.tipSport.FOTBAL);
        Membru membru3 = new Membru("Nume3", 20, 8, Membru.tipSport.FOTBAL);
        Membru membru4 = new Membru("Nume4", 21, 7, Membru.tipSport.FOTBAL);
        Membru membru5 = new Membru("Nume5", 22, 6, Membru.tipSport.FOTBAL);
        Membru membru6 = new Membru("Nume6", 23, 5, Membru.tipSport.FOTBAL);
        Membru membru7 = new Membru("Nume7", 24, 4, Membru.tipSport.FOTBAL);
        Membru membru8 = new Membru("Nume8", 25, 3, Membru.tipSport.FOTBAL);
        Membru membru9 = new Membru("Nume9", 26, 2, Membru.tipSport.FOTBAL);
        Membru membru10 = new Membru("Nume10", 27, 1, Membru.tipSport.FOTBAL);

        Competitie competitie1 = new Competitie("Competitie1", 2010, Arrays.asList(membru1, membru2, membru3), Competitie.tipSport.FOTBAL);
        Competitie competitie2 = new Competitie("Competitie2", 2011, Arrays.asList(membru4, membru5, membru6, membru7), Competitie.tipSport.FOTBAL);
        Competitie competitie3 = new Competitie("Competitie3", 2012, Arrays.asList(membru8, membru9, membru10), Competitie.tipSport.FOTBAL);

        return new ArrayList<>(Arrays.asList(membru1, membru2, membru3, membru4, membru5, membru6, membru7, membru8, membru9, membru10, competitie1, competitie2, competitie3));
    }

    public static void serializeLista(ArrayList<Object> lista, String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filename), lista);
            System.out.println("\n Lista serializata: " + filename + "\n");
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Membru> deserializeLista(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Membru> lista = new ArrayList<>();
        try {
            objectMapper.readValue(new File(filename), new TypeReference<List<Object>>() {
            });
            System.out.println("\n Lista serializata: " + filename + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Object> lista = lista();
        String filename = "lista.json";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int opt, nrFotbal = 0, nrBaschet = 0, nrTenis = 0;

        serializeLista(lista, filename);
        for (Object membru : lista) {
            System.out.println(membru);
        }

        deserializeLista(filename);

        while (true) {
            System.out.println("0. Iesire");
            System.out.println("1. Afisare membri 30+ care practica fobtbal");
            System.out.println("2. Afisare numarc competitii din fiecare sport");
            String s = bufferedReader.readLine();
            opt = Integer.parseInt(s);
            switch (opt) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    for (Object membru_enumerare : lista) {
                        if (membru_enumerare instanceof Membru) {
                            Membru membru = (Membru) membru_enumerare;
                            if (membru.getVarsta() > 30) {
                                {
                                    System.out.println(membru);
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    for (Object competitie_enumerare : lista) {
                        if (competitie_enumerare instanceof Competitie) {
                            Competitie competitie = (Competitie) competitie_enumerare;
                            if (competitie.getTip().equals(Competitie.tipSport.FOTBAL)) {
                                nrFotbal++;
                            }
                            else if (competitie.getTip().equals(Competitie.tipSport.BASCHET)) {
                                nrBaschet++;
                            }
                            else if (competitie.getTip().equals(Competitie.tipSport.TENIS)) {
                                nrTenis++;
                            }
                        }
                    }
                    System.out.println("Numar competitii fotbal: " + nrFotbal);
                    System.out.println("Numar competitii baschet: " + nrBaschet);
                    System.out.println("Numar competitii tenis: " + nrTenis);
                    break;
                default:
                    System.out.println("Optiune invalida!");
                    break;
            }
        }
    }
}
