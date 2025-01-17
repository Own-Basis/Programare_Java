package Ex2;

enum TipChitara {ELECTRICA, ACUSTICA, CLASICA}

public class Chitara extends InstrumentMuzical {
    private TipChitara tipChitara;
    private int nrCorzi;

    public Chitara(String producator, double pret, TipChitara tipChitara, int nrCorzi) {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.nrCorzi = nrCorzi;
    }

    public Chitara() {
        super("", 0); // Default pentru InstrumentMuzical
        this.tipChitara = TipChitara.ELECTRICA; // Valoare implicită
        this.nrCorzi = 6; // Valoare implicită
    }

    public TipChitara getTipChitara() {
        return tipChitara;
    }

    public int getNrCorzi() {
        return nrCorzi;
    }

    @Override
    public String toString() {
        return "Chitara{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                ", tipChitara=" + tipChitara +
                ", nrCorzi=" + nrCorzi +
                '}';
    }
}

