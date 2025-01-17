package Test3;

import java.util.List;

public class Competitie {
    public enum tipSport{
        FOTBAL,
        TENIS,
        BASCHET
    };
    private String denumire;
    private int anOrganizare;
    private List<Membru> lista;
    private tipSport tip;

    public Competitie(String denumire, int anOrganizare, List<Membru> lista, tipSport tip) {
        this.denumire = denumire;
        this.anOrganizare = anOrganizare;
        this.lista = lista;
        this.tip = tip;
    }

    public Competitie(){

    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getAnOrganizare() {
        return anOrganizare;
    }

    public void setAnOrganizare(int anOrganizare) {
        this.anOrganizare = anOrganizare;
    }

    public List<Membru> getLista() {
        return lista;
    }

    public void setLista(List<Membru> lista) {
        this.lista = lista;
    }

    public tipSport getTip() {
        return tip;
    }

    public void setTip(tipSport tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Denumire : " + denumire +
                " An organizare: " + anOrganizare +
                " Tipul de sport: " + tip +
                " Lista participantilor: " + lista;
    }
}
