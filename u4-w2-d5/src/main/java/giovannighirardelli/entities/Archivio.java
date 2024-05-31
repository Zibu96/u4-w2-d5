package giovannighirardelli.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Archivio {
    private List<Catalogo> archivioLibri;
    private List<Catalogo> archivioRiv;

    public Archivio() {
        this.archivioLibri = archivioLibri = new ArrayList<>();
        this.archivioRiv = archivioRiv = new ArrayList<>();

    }

    public void aggElemento(String str, Catalogo item) {
        if (str.equals("Libro")) {
            archivioLibri.add(item);
            System.out.println(item.getTitolo() + " Aggiunto in libri");
        } else if (str.equals("Rivista")) {
            archivioRiv.add(item);
            System.out.println(item.getTitolo() + " Aggiunto in riviste");
        } else System.out.println("C'è qualche errore...");
    }

    public void elElemento(String str, long isbn) {
        if (str.equals("Libro")) {
            archivioLibri.removeIf(e -> e.getCodiceISBN() == isbn);
            System.out.println("Libro rimosso");
        } else if (str.equals("Rivista")) {
            archivioRiv.removeIf(e -> e.getCodiceISBN() == isbn);
            System.out.println("Rivista rimossa");
        } else System.out.println("Non hai rimosso nulla...");
    }

    public void cercaPerISBN(String str, long isbn) {
        if (str.equals("Libro")) {
            List<Catalogo> cercaLibro = archivioLibri.stream().filter(libro -> libro.getCodiceISBN() == isbn).toList();
            System.out.println("Questo è il libro che stavi cercando " + cercaLibro);
        } else if (str.equals("Rivista")) {
            List<Catalogo> cercaRivista = archivioRiv.stream().filter(rivista -> rivista.getCodiceISBN() == isbn).toList();
            System.out.println("Questa è la rivista che stavi cercando " + cercaRivista);

        } else System.out.println("Non hai trovato nulla...");
    }

    public void cercaPerAnno(String str, int anno) {
        if (str.equals("Libro")) {
            List<Catalogo> cercaLibro = archivioLibri.stream().filter(libro -> libro.getAnnoPubbl() == anno).toList();
            System.out.println("Questo è il libro che stavi cercando " + cercaLibro);
        } else if (str.equals("Rivista")) {
            List<Catalogo> cercaRivista = archivioRiv.stream().filter(rivista -> rivista.getAnnoPubbl() == anno).toList();
            System.out.println("Questa è la rivista che stavi cercando " + cercaRivista);

        } else System.out.println("Non hai trovato nulla...");
    }

    public void cercaPerAutore(String str, String autore) {
        if (str.equals("Libro")) {
            List<Catalogo> cercaLibro = archivioLibri.stream().filter(libro -> libro instanceof Libri && Objects.equals(((Libri) libro).getAutore(), autore)).toList();
            System.out.println("Questo è il libro che stavi cercando " + cercaLibro);


        } else System.out.println("Non hai trovato nulla...");
    }


    @Override
    public String toString() {
        return "Archivio{" +
                "archivioLibri=" + archivioLibri +
                ", archivioRiv=" + archivioRiv +
                '}';
    }
}

