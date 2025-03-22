package elettronica;

import static frontEnd.FrontEnd.verificaCodiceProdotto;

public abstract class ProdottoElettronico {
    String codiceProdotto;
    String marca;
    double prezzo;

    public ProdottoElettronico(String codiceProdotto, String marca, double prezzo) throws Exception {
        if (verificaCodiceProdotto(codiceProdotto)) {
            throw new Exception("Il codice prodotto è già stato inserito");
        }
        this.codiceProdotto = codiceProdotto;
        this.marca = marca;
        if (prezzo <= 0) {
            throw new IllegalArgumentException("Prezzo non valido.");
        }
        this.prezzo = prezzo;
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }

    public void setCodiceProdotto(String codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "codiceProdotto='" + codiceProdotto + '\'' +
                ", marca='" + marca + '\'' +
                ", prezzo=" + prezzo;
    }
}
