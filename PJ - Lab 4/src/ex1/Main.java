package ex1;

import java.io.*;
import java.util.Arrays;

public class Main {

    static boolean exista_fisier(String s) {
        if (s == null) {
            System.out.println("Fisiserul nu a putut fi deschis!");
            System.exit(0);
            return false;
        } else return true;
    }

    static void scrie(Object o) {
        try {
            FileOutputStream f = new FileOutputStream("echip.bin");
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Object citeste() {
        try {
            FileInputStream f = new FileInputStream("echip.bin");
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o = ois.readObject();
            ois.close();
            f.close();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("echipamente.txt"));
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int opt;
        String nume;
        boolean ok;

        if (exista_fisier(s)) {
            Echipament[] echip=new Echipament[20];
            int n=0;
            while (s != null) {

                String[] info = s.split(";");
                System.out.println(Arrays.toString(info));

                if (info[5].equals("imprimanta")) {
                    if (info[9].equals("alb negru")) {
                        echip[n++] = new Imprimanta(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), info[3], Stare.valueOf(info[4]), Integer.parseInt(info[6]), info[7], Integer.parseInt(info[8]), Mod.alb_negru);
                    } else {
                        if (info[9].equals("color")) {
                            echip[n++] = new Imprimanta(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), info[3], Stare.valueOf(info[4]), Integer.parseInt(info[6]), info[7], Integer.parseInt(info[8]), Mod.color);
                        }
                    }
                }

                if (info[5].equals("copiator")) {
                    echip[n++] = new Copiator(info[0], Integer.parseInt(info[1]), Double.parseDouble(info[2]), info[3], Stare.valueOf(info[4]), Integer.parseInt(info[6]), Format.valueOf(info[7]));
                }

                if (info[5].equals("sistem de calcul")) {
                    echip[n++] = new Sistem_de_calcul(info[0], Integer.parseInt(info[1]), Double.parseDouble(info[2]), info[3], Stare.valueOf(info[4]), info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8]), Sistem.valueOf(info[9]));
                }
                s = reader.readLine();
            }

            while (true) {
                System.out.println("1. Afisarea imprimantelor");
                System.out.println("2. Afisarea copiatoarelor");
                System.out.println("3. Afisarea sistemelor de calcul");
                System.out.println("4. Modificarea starii in care se afla un echipament");
                System.out.println("5. Setarea unui anumit mod de scriere pentru o imprimanta");
                System.out.println("6. Setarea unui format de copiere pentru copiatoare");
                System.out.println("7. Instalarea unui anumit sistem de operare pe un sistem de calcul");
                System.out.println("8. Afisarea echipamentelor vandute");
                System.out.println("9. Serializare");
                System.out.println("10. Deserializare");
                System.out.println("0. Iesire");
                System.out.println("Optiunea dvs. este:");
                s = 1read.readLine();
                opt = Integer.parseInt(s);
                switch (opt) {
                    case 1:
                        System.out.println("Afisarea imprimantelor: ");
                        for (int i = 0; i < n; i++)
                            if (echip[i] instanceof Imprimanta)
                                System.out.println(echip[i]);
                        break;
                    case 2:
                        System.out.println("Afisarea copiatoarelor: ");
                        for (int i = 0; i < n; i++)
                            if (echip[i] instanceof Copiator)
                                System.out.println(echip[i]);
                        break;
                    case 3:
                        System.out.println("Afisarea sistemelor de calcul: ");
                        for (int i = 0; i < n; i++)
                            if (echip[i] instanceof Sistem_de_calcul)
                                System.out.println(echip[i]);
                        break;
                    case 4:
                        Stare st_noua;
                        System.out.print("Introduceti numele echipamentului pentru care sa se modifice starea: ");
                        nume = read.readLine();
                        System.out.print("Introduceti starea(achizitionat/vandut/expus): ");
                        s = read.readLine();
                        st_noua = Stare.valueOf(s);

                        ok = false;
                        for (int i = 0; i < n; i++) {
                            if (nume.compareTo(echip[i].getDenumire()) == 0) {
                                echip[i].setSt(st_noua);
                                System.out.println(echip[i]);
                                ok = true;
                            }
                        }
                        if (!ok)
                            System.out.println("Nu exista nicio inregistrare cu numele '" + nume + "'.");
                        break;
                    case 5:
                        System.out.print("Introduceti numele imprimantei pentru setarea modului de scriere: ");
                        nume = read.readLine();
                        System.out.print("Introduceti modul de scriere (color/alb_negru): ");
                        s = read.readLine();
                        Mod mod_nou = Mod.valueOf(s);

                        ok = false;
                        for (int i = 0; i < n; i++) {
                            if (nume.compareTo(echip[i].getDenumire()) == 0 && (echip[i] instanceof Imprimanta imp)) {
                               imp.setMod_scriere(mod_nou);
                                System.out.println(echip[i]);
                                ok = true;
                            }
                        }
                        if (!ok)
                            System.out.println("Nu exista nicio imprimanta cu numele '" + nume + "'.");
                        break;
                    case 6:
                        System.out.print("Introduceti numele copiatorului pentru modificarea formatului: ");
                        nume = read.readLine();
                        System.out.print("Introduceti formatul(A3/A4): ");
                        s = read.readLine();
                        Format form_nou = Format.valueOf(s);

                        ok = false;
                        for (int i = 0; i < n; i++) {
                            if (nume.compareTo(echip[i].getDenumire()) == 0 && (echip[i] instanceof Copiator)) {
                                ((Copiator) echip[i]).setFormat_copiere(form_nou);
                                ok = true;
                                System.out.println(echip[i]);
                            }
                        }
                        if (!ok)
                            System.out.println("Nu exista niciun copiator cu numele '" + nume + "'.");
                        break;
                    case 7:
                        System.out.print("Introduceti numele sistemului de calcul:");
                        nume = read.readLine();
                        System.out.print("Introduceti sistemul de operare(windows/linux): ");
                        s = read.readLine();
                        Sistem sist = Sistem.valueOf(s);

                        ok = false;
                        for (int i = 0; i < n; i++) {
                            if (nume.compareTo(echip[i].getDenumire()) == 0 && (echip[i] instanceof Sistem_de_calcul)) {
                                ((Sistem_de_calcul) echip[i]).setSist_operare(sist);
                                System.out.println(echip[i]);
                                ok = true;
                            }
                        }
                        if (!ok)
                            System.out.println("Nu exista niciun sistem de calcul cu numele '" + nume + "'.");
                        break;
                    case 8:
                        System.out.println("Vandute:");
                        for (int i = 0; i < n; i++)
                            if (echip[i].getSt().compareTo(Stare.valueOf("vandut")) == 0)
                                System.out.println(echip[i]);
                        break;
                    case 9:
                        scrie(echip);
                        break;
                    case 10:
                        Echipament[] q;
                        q = (Echipament[]) citeste();
                        for (Echipament e : q)
                            if (e != null)
                                System.out.println(e);
                        break;
                    case 0:
                        System.exit(0);
                        reader.close();
                        break;
                    default:
                        System.out.println("Optiunea dvs. este gresita!");
                        break;
                }
            }

        }

    }
}

