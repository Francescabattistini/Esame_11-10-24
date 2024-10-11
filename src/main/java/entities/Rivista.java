package entities;

import enums.PeriodicitàType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Rivista extends Catalogo {
    @Column(name = "periodicità")
    @Enumerated(EnumType.STRING)
    private PeriodicitàType periodicità;

    public Rivista(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, PeriodicitàType periodicità) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    public Rivista() {}

    public PeriodicitàType getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(PeriodicitàType periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" + super.toString() +
                "periodicità=" + periodicità +
                "} ";
    }
}
