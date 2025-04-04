package Backend.Elettronica;

public class Smartphone extends ProdottoElettronico {
    private String modello;
    private int memoria;
    private static int costoRam = 10;

    public Smartphone(String prodotto, String marca, double prezzo, String modello, int memoria) {
        super(prodotto, marca, prezzo);
        this.modello = modello;
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

    public int costoMemoria(){
        int prezzoRam = 0;
        return  prezzoRam = memoria * costoRam;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("modello: " + modello + "memoria" + memoria + "prezzoRam: " + costoMemoria());
    }
}