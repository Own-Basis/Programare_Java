package Ex2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@class"
)
public abstract class InstrumentMuzical {
    String producator;
    double pret;

    public InstrumentMuzical(String producator, double pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public double getPret() {
        return pret;
    }

    public String getProducator() {
        return producator;
    }

    @Override
    public String toString() {
        return "InstrumentMuzical{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }
}

