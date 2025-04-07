package backend.Automobili;

public class AutoNuova extends Auto {
    private String alimentazione;
    private int cavalli;

    public AutoNuova(String id, String marca, String modello, double prezzo, int anno, String alimentazione, int cavalli) {
        super(id, marca, modello, prezzo, anno);
        this.alimentazione = alimentazione;
        this.cavalli = cavalli;
    }

    public int getCavalli() {
        return cavalli;
    }

    public void setCavalli(int cavalli) {
        this.cavalli = cavalli;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    @Override
    public String mostraDettagli() {
        return super.toString() + "Dettaglio: " + alimentazione + ", " + cavalli + "Valore attuale: " + calcolaValoreAttuale();
    }
}
