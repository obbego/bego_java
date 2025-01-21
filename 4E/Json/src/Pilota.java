import java.util.Objects;

public class Pilota {
    private String nome;
    private String cognome;
    private String nazionalita;
    private int eta;

    public Pilota(String nome, String cognome, String nazionalita, int eta) throws IllegalArgumentException {
        if (nome == null || cognome == null || nazionalita == null || eta <= 0) {
            throw new IllegalArgumentException("I parametri non sono validi.");
        }
        this.nome = nome;
        this.cognome = cognome;
        this.nazionalita = nazionalita;
        this.eta = eta;
    }

    @Override
    public String toString() {
        return nome + " " + cognome + " (" + eta + " anni, " + nazionalita + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pilota pilota = (Pilota) obj;
        return eta == pilota.eta &&
                Objects.equals(nome, pilota.nome) &&
                Objects.equals(cognome, pilota.cognome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, eta);
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public int getEta() {
        return eta;
    }
}
