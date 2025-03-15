public class Giocatore implements Comparable<Giocatore>{
    private String Nome;
    private Dado dado;
    private int numeroVittorie = 0;

    public Giocatore(String nome, int numeroFacce) {
        Nome = nome;
        dado = new Dado(numeroFacce);
    }

    public void incrementaNumeroVittorie() {
        this.numeroVittorie++;
    }

    public Dado getDado() {
        return dado;
    }

    public int getNumeroVittorie() {
        return numeroVittorie;
    }

    public String getNome() {
        return Nome;
    }

    public String toPlayerString() {
        return String.format("nome:%s   valore Lancio;%s", getNome(), getDado());
    }

    @Override
    public int compareTo(Giocatore g) {
        if(this.numeroVittorie == g.numeroVittorie){
            return 0;
        }
        else if(this.numeroVittorie > g.numeroVittorie){
            return 1;
        }
        else{
            return -1;
        }
    }
}
