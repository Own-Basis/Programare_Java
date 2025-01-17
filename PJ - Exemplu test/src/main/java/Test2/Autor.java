package Test2;

import java.io.Serializable;

public class Autor implements Serializable {
    private String nume, nationalitate;
    private int varsta;

    public Autor() {
    }

    public Autor(String nume, String nationalitate, int varsta) {
        this.nume = nume;
        this.nationalitate = nationalitate;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nume='" + nume + '\'' +
                ", nationalitate='" + nationalitate + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
