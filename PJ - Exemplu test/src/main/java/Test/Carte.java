package Test;

public class Carte extends Publicatie {
    private int numarPagini;

    public Carte(String titlu, String autor, int anPublicare, int numarPagini) {
        super(titlu, autor, anPublicare);
        this.numarPagini = numarPagini;
    }

    public int getNumarPagini() {
        return numarPagini;
    }

    public void setNumarPagini(int numarPagini) {
        this.numarPagini = numarPagini;
    }

    @Override
    public String toString() {
        return super.toString() + " Carte: numar pagini " + numarPagini;
    }
}
