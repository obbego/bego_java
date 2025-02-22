//Francesco Bego
class Giocatore
{
    private String nome;
    private int vittorie = 0;
    public Giocatore(String nome)
    {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getVittorie() {
        return vittorie;
    }

    public void setVittorie(int vittorie) {
        this.vittorie = vittorie;
    }

    public void setVittorieTotali(int vittorieTotali) {
        this.vittorie += vittorieTotali;
    }


    public String getVittorieFormat () {
        return String.format("Vittorie totali %s = %d", this.getNome(), this.getVittorie());
    }
}