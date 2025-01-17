package Test3;

public class Membru {
    public enum tipSport{
        FOTBAL,
        TENIS,
        BASCHET
    };
    private String nume;
    private int varsta, numarCompetitii;
    private tipSport tip;

    public Membru(String nume, int varsta, int numarCompetitii, tipSport tip) {
        this.nume = nume;
        this.varsta = varsta;
        this.numarCompetitii = numarCompetitii;
        this.tip = tip;
    }

    public Membru(){
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public int getNumarCompetitii() {
        return numarCompetitii;
    }

    public void setNumarCompetitii(int numarCompetitii) {
        this.numarCompetitii = numarCompetitii;
    }

    public tipSport getTip() {
        return tip;
    }

    public void setTip(tipSport tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Nume: " + nume +
                " Varsta: " + varsta +
                " Tipul de sport: " + tip +
                " Numarul de competitii: " + numarCompetitii;
    }
}
