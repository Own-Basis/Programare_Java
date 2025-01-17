package ex1;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Parabola> list = new ArrayList<>();
        List<String> lines = Files.readAllLines(new File("src/ex1/in.txt").toPath(), Charset.defaultCharset());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int opt, opt_parabola1, opt_parabola2;
        Parabola p1, p2;
        double Xm, Ym, L;

        for (String line : lines) {
            Parabola parabola = Parabola.fromString(line);
            list.add(parabola);
        }

        while (true) {
            System.out.println("1. Calcul coordonate mijloc + lungime segment dreapta 2 parabole introduse");
            System.out.println("2. Calcul coordonate mijloc + lungime segment dreapta 1 parabola introdusa si 1 parabola din lista");
            System.out.println("3. Calcul coordonate mijloc + lungime segment dreapta 2 parabole din lista");
            System.out.println("0. Iesire");
            s = reader.readLine();
            opt = Integer.parseInt(s);

            switch (opt) {
                case 0:
                    reader.close();
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Introduceti parametrii pentru prima parabola");
                    p1 = Parabola.fromString(reader.readLine());
                    System.out.println("Introduceti parametrii pentru a doua parabola");
                    p2 = Parabola.fromString(reader.readLine());
                    Xm = (p1.getX() + p2.getX()) / 2;
                    Ym = (p1.getY() + p2.getY()) / 2;
                    L = Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
                    System.out.println("Coordonate mijloc: Xm = " + Xm + ", Ym = " + Ym);
                    System.out.println("Lungime segment: L = " + L);
                    break;
                case 2:
                    System.out.println("Introduceti parametrii pentru prima parabola");
                    p1 = Parabola.fromString(reader.readLine());
                    System.out.println("Alegeti indexul pentru a doua parabola");
                    for (Parabola parabola : list) {
                        System.out.println(parabola + "");
                    }
                    opt_parabola2 = Integer.parseInt(reader.readLine());
                    if (opt_parabola2 >= 1 && opt_parabola2 <= list.size()) {
                        p2 = list.get(opt_parabola2 - 1);
                        Xm = (p1.getX() + p2.getX()) / 2;
                        Ym = (p1.getY() + p2.getY()) / 2;
                        L = Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
                        System.out.println("Coordonate mijloc: Xm = " + Xm + ", Ym = " + Ym);
                        System.out.println("Lungime segment: L = " + L);
                    } else System.out.println("Nu exista parabola cu acel index!");
                    break;
                case 3:
                    for (Parabola parabola : list) {
                        System.out.println(parabola + "");
                    }
                    System.out.println("Introduceti indexul pentru prima parabola");
                    opt_parabola1 = Integer.parseInt(reader.readLine());
                    if (opt_parabola1 >= 1 && opt_parabola1 <= list.size()) {
                        p1 = list.get(opt_parabola1 - 1);
                    } else
                    {
                        System.out.println("Nu exista parabola cu acel index!");
                        break;
                    }
                    System.out.println("Alegeti indexul pentru a doua parabola");
                    opt_parabola2 = Integer.parseInt(reader.readLine());
                    if (opt_parabola2 >= 1 && opt_parabola2 <= list.size()) {
                        p2 = list.get(opt_parabola2 - 1);
                        Xm = (p1.getX() + p2.getX()) / 2;
                        Ym = (p1.getY() + p2.getY()) / 2;
                        L = Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
                        System.out.println("Coordonate mijloc: Xm = " + Xm + ", Ym = " + Ym);
                        System.out.println("Lungime segment: L = " + L);
                    } else
                    {
                        System.out.println("Nu exista parabola cu acel index!");
                        break;
                    }
                    break;
                default:
                    System.out.println("Optiune invalida!");
                    break;
            }
        }
    }
}