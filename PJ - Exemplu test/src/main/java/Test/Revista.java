package Test;

public class Revista extends Publicatie {
    private int numarExemplare;

    public Revista(String titlu, String autor, int anPublicare, int numarExemplare) {
        super(titlu, autor, anPublicare);
        this.numarExemplare = numarExemplare;
    }

    public int getNumarExemplare() {
        return numarExemplare;
    }

    public void setNumarExemplare(int numarExemplare) {
        this.numarExemplare = numarExemplare;
    }

    @Override
    public String toString() {
        return super.toString() + " Revista: numar exemplare " + numarExemplare;
    }
}
