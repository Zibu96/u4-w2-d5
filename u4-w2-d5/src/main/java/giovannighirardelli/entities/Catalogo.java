package giovannighirardelli.entities;

import java.util.Random;

abstract public class Catalogo {
    protected Long codiceISBN;
    protected String titolo;
    protected Integer annoPubbl;
    protected Integer numPage;

    public Catalogo(String titolo, Integer annoPubbl, Integer numPage) {
        Random random = new Random();
        this.codiceISBN = random.nextLong(100000000, 999999999);
        this.titolo = titolo;
        this.annoPubbl = annoPubbl;
        this.numPage = numPage;
    }

    public Long getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(Long codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubbl() {
        return annoPubbl;
    }

    public void setAnnoPubbl(Integer annoPubbl) {
        this.annoPubbl = annoPubbl;
    }

    public Integer getNumPage() {
        return numPage;
    }

    public void setNumPage(Integer numPage) {
        this.numPage = numPage;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubbl=" + annoPubbl +
                ", numPage=" + numPage +
                '}';
    }


}
