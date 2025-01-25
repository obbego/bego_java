/*- - autore : String
- titolo : String
- nPagine : int
- COSTOPAGINE: final double
- tipo : Genere
+ Libro (String autore, String titolo, int numeroPagine, Genere tipo)
+ Libro (Libro l)
+ getAutore() : String
+ getTitolo() : String
+ getnPagine() : int
+ getCostoPagine() : double
+ equals(Object o) : int
+ toString() : String	*/
package backend;

public class Libro {
    private String autore;
    private String titolo;
    private int nPagine;
    private final double COSTOPAGINE = 0.5;
    private Genere tipo;

    public Libro(String autore, String titolo, int nPagine, Genere tipo) {
        this.autore = autore;
        this.titolo = titolo;
        this.nPagine = nPagine;
        this.tipo = tipo;
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
    public Genere getTipo() {
        return tipo;
    }
    public void setTipo(Genere tipo) {
        this.tipo = tipo;
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



}
