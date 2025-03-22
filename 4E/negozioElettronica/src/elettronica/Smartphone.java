package elettronica;

public class Smartphone extends ProdottoElettronico {
    String modello;
    int memoria;

    public Smartphone(String codiceProdotto, String marca, double prezzo, String modello, int memoria) throws Exception {
        super(codiceProdotto, marca, prezzo);
        this.modello = modello;
        if (memoria <= 0) {
            throw new IllegalArgumentException("La memoria deve essere > 0");
        }
        this.memoria = memoria;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    @Override
    public String toString() {
        return "Smartphone: " + super.toString() + ", memoria=" + memoria +
                ", modello='" + modello + "'";
    }
}
