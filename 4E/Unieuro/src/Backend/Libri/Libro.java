package Backend.Libri;

import Backend.Prodotto;

public abstract class Libro extends Prodotto {
    protected String autore;
    protected String titolo;
    protected int quantita;

    public Libro(double prezzo, String codiceProdotto, String autore, String titolo, int quantita) {
        super(prezzo, codiceProdotto);
        this.autore = autore;
        this.titolo = titolo;
        this.quantita = quantita;
    }
}
