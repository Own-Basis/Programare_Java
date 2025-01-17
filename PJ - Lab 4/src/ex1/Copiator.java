package ex1;

import java.io.Serializable;

enum Format {
    A3,
    A4
}

public class Copiator extends Echipament implements Serializable {
    private int ppm;
    private int p_ton;
    private Format format;

    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, int p_ton, Format format) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.p_ton = p_ton;
        this.format = format;
    }

    public int getPpm() {
        return ppm;
    }

    public int getP_ton() {
        return p_ton;
    }

    public Format getFormat_copiere() {
        return format;
    }

    public void setFormat_copiere(Format format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + "Copiator; pagini pe min: " + ppm + "; Pagini/toner " + p_ton + " Format copiere: " + format;
    }
}
