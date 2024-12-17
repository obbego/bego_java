public class Pilota {

    private String nome;
    private String cognome;
    private String nazonalita;

    public Pilota(String nome, String cognome, String nazonalita) {
        this.nome = nome;
        this.cognome = cognome;
        this.nazonalita = nazonalita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNazonalita() {
        return nazonalita;
    }

    public void setNazonalita(String Nazonalita) {
        this.nazonalita = Nazonalita;
    }

    public boolean equals(Pilota p) {
        return this.nome.equals(p.nome) && this.cognome.equals(p.cognome) && this.nazonalita.equals(p.nazonalita);
    }

    public String toString() {
        return String.format("Nome: %s, Cognome: %s, Nazionalità: %s", nome, cognome, nazonalita);
    }
}
