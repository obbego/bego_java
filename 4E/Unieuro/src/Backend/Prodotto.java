package Backend;

public abstract class Prodotto {
    protected double prezzo;
    protected String codiceProdotto;

    public Prodotto(double prezzo, String codiceProdotto) {
        this.prezzo = prezzo;
        this.codiceProdotto = codiceProdotto;
    }
}
