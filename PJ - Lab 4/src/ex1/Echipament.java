package ex1;

enum Stare{
    achizitionat,
    vandut,
    expus
}

public class Echipament {
    private String denumire;
    private int nr_inv;
    private double pret;
    private String zona_mag;
    private Stare stare;

    public Echipament(String denumire, int nr_inv, double pret, String zona_mag, Stare stare) {
        super();
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public double getPret() {
        return pret;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    public Stare getSt() {
        return stare;
    }

    public void setSt(Stare stare) {
        this.stare = stare;
    }

    @Override
    public String toString() {
        return "Denumire: " + denumire + "; Numar inventar: " + nr_inv + "; Pret: " + pret + "; Zona magazin: "
                + zona_mag + "; Stare: " + stare + "; Tip: ";
    }
}
