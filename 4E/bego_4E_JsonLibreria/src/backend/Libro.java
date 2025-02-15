package backend;

public class Libro {
    private String autore;
    private String titolo;
    private int nPagine;
    private final double COSTOPAGINE = 0.5;
    public Libro(String autore, String titolo, int nPagine) {
        this.autore = autore;
        this.titolo = titolo;
        this.nPagine = nPagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getNPagine() {
        return nPagine;
    }

    public void setNPagine(int nPagine) {
        this.nPagine = nPagine;
    }

    public double getCostoPagine() {
        return COSTOPAGINE;
    }

    public boolean equals(Object libroObject) {
        Libro l = (Libro) libroObject;
        return (this.titolo.equals(l.getTitolo()) && this.autore.equals(l.getAutore()));
    }

    public String toString() {
        return String.format("Autore: %s, Titolo: %s, Pagine: %d, ", autore, titolo, nPagine);
    }

    @Override
    public Libro clone() {
        return new Libro(this.titolo, this.autore, this.nPagine);
    }
}
