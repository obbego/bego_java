public class Auto {
    private String scuderia;
    private Pilota pilota;
    private int cilindrata;

    public Auto(String scuderia, Pilota pilota, int cilindrata) throws IllegalArgumentException {
        if (scuderia == null || pilota == null || cilindrata <= 0) {
            throw new IllegalArgumentException("I parametri non sono validi.");
        }
        this.scuderia = scuderia;
        this.pilota = pilota;
        this.cilindrata = cilindrata;
    }

    @Override
    public String toString() {
        return scuderia + " - Pilota: " + pilota.toString() + " - Cilindrata: " + cilindrata + "cc";
    }

    public Pilota getPilota() {
        return pilota;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public String getScuderia() {
        return scuderia;
    }

    public void setScuderia(String scuderia) {
        this.scuderia = scuderia;
    }
}
