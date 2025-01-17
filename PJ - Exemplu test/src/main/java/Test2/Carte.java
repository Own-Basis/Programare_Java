package Test2;

import Test2.Autor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carte implements Serializable {
    public enum Gen {
        FICTIUNE, NON_FICTIUNE, STIINTA
    }

    private String titlu;
    private Gen gen;
    private int anulPublicarii;
    private List<Autor> listaAutori;

    // Constructor
    public Carte(String titlu, Gen gen, int anulPublicarii, List<Autor> listaAutori) {
        this.titlu = titlu;
        this.gen = gen;
        this.anulPublicarii = anulPublicarii;
        this.listaAutori = listaAutori;
    }

    public Carte() {
        this.titlu = "Unknown";
        this.gen = Gen.FICTIUNE;
        this.anulPublicarii = 0;
        this.listaAutori = new ArrayList<>();
    }

    // Getters and Setters
    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    public int getAnulPublicarii() {
        return anulPublicarii;
    }

    public void setAnulPublicarii(int anulPublicarii) {
        this.anulPublicarii = anulPublicarii;
    }

    public List<Autor> getListaAutori() {
        return listaAutori;
    }

    public void setListaAutori(List<Autor> listaAutori) {
        this.listaAutori = listaAutori;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "titlu='" + titlu + '\'' +
                ", gen=" + gen +
                ", anulPublicarii=" + anulPublicarii +
                ", listaAutori=" + listaAutori +
                '}';
    }
}
