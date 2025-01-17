package Ex2;

enum TipTobe {ELECTRONICE, ACUSTICE}

public class SetTobe extends InstrumentMuzical {
    private TipTobe tipTobe;
    private int nrTobe;
    private int nrCinele;

    public SetTobe(String producator, double pret, TipTobe tipTobe, int nrTobe, int nrCinele) {
        super(producator, pret);
        this.tipTobe = tipTobe;
        this.nrTobe = nrTobe;
        this.nrCinele = nrCinele;
    }

    public SetTobe() {
        super("", 0); // Default pentru InstrumentMuzical
        this.tipTobe = TipTobe.ELECTRONICE; // Valoare implicită
        this.nrTobe = 0; // Valoare implicită
        this.nrCinele = 0; // Valoare implicită
    }

    public TipTobe getTipTobe() {
        return tipTobe;
    }

    public int getNrTobe() {
        return nrTobe;
    }

    public int getNrCinele() {
        return nrCinele;
    }

    @Override
    public String toString() {
        return "SetTobe{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                ", tipTobe=" + tipTobe +
                ", nrTobe=" + nrTobe +
                ", nrCinele=" + nrCinele +
                '}';
    }
}

