package backend.Automobili;

import jdk.jfr.Percentage;

public abstract class Auto {
    private String id;
    private String marca;
    private String modello;
    private double prezzo;
    private int anno;


    public Auto(String id, String marca, String modello, double prezzo, int anno) {
        this.id = id;
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.anno = anno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                ", prezzo=" + prezzo +
                ", anno=" + anno;
    }

    public abstract String mostraDettagli();

    public Double calcolaValoreAttuale() {
        int percentuale = 5;
        double prezzoAttuale = prezzo;
        for (int i = 0; i < 2025 - anno; i++) {
            prezzoAttuale = prezzoAttuale - (prezzoAttuale * percentuale / 100);
        }
        return prezzoAttuale;
    }
}
