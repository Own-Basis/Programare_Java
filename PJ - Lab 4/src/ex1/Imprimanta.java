package ex1;

import java.io.Serializable;

enum Mod {
    color,
    alb_negru
}

public class Imprimanta extends Echipament implements Serializable {

    private int ppm;
    private String rezolutie;
    private int p_car;
    private Mod mod;

    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, int ppm, String rezolutie, int p_car, Mod mod) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod = mod;
    }

    public int getPpm() {
        return ppm;
    }
    public String getRezolutie() {
        return rezolutie;
    }
    public int getP_car() {
        return p_car;
    }
    public Mod getMod_scriere() {
        return mod;
    }
    public void setMod_scriere(Mod mod) {
        this.mod = mod;
    }
    @Override
    public String toString() {
        return super.toString()+"Imprimanta; Pagini pe minut: " + ppm + "; Rezolutie: " + rezolutie + "; Pagini/cartus: " + p_car + "; Mod scriere: "
                + mod;
    }
}

