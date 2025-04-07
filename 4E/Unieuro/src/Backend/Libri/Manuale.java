package Backend.Libri;

public class Manuale extends Libro {
    protected String argomento;

    public Manuale(double prezzo, String codiceProdotto, String autore, String titolo, int quantita, String argomento) {
        super(prezzo, codiceProdotto, autore, titolo, quantita);
        this.argomento = argomento;
    }
}
