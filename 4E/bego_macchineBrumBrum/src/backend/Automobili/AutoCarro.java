package backend.Automobili;

public class AutoCarro extends Auto {
    private int tara;

    public AutoCarro(String id, String marca, String modello, double prezzo, int anno, int tara) {
        super(id, marca, modello, prezzo, anno);
        this.tara = tara;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    @Override
    public String mostraDettagli() {
        return super.toString() + "Dettaglio: " + tara + "Valore attuale: " + calcolaValoreAttuale();
    }
}
