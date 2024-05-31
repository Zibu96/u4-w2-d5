package giovannighirardelli.entities;

import giovannighirardelli.enums.Periodicità;

public class Riviste extends Catalogo {
    private Periodicità periodicità;


    public Riviste(String titolo, Integer annoPubbl, Integer numPage, Periodicità periodicità) {
        super(titolo, annoPubbl, numPage);
        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicità=" + periodicità +
                ", codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubbl=" + annoPubbl +
                ", numPage=" + numPage +
                '}';
    }
}
