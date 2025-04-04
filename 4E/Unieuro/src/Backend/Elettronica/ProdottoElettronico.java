package Backend.Elettronica;

import Backend.Prodotto;

public abstract class ProdottoElettronico extends Prodotto {
    protected String marca;


    public ProdottoElettronico(String codiceProdotto, String marca, double prezzo) {
        super(prezzo, codiceProdotto);
        this.marca = marca;
    }

    public String getCodiceProdotto() {
        return codiceProdotto;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }


    public abstract int costoMemoria();

    @Override
    public String toString(){
        return String.format("codiceProdotto: " + codiceProdotto + " marca" + " prezzo:" + prezzo);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ProdottoElettronico that = (ProdottoElettronico) object;
        return this.codiceProdotto.equals(that.getCodiceProdotto());
    }

}