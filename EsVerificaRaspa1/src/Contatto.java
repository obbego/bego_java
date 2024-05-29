
public class Contatto {
    public String nome;
    public String cognome;
    public String numero;
    public boolean visibilita;
    public int nVolte = 0;

    @Override
    public String toString(){
        return String.format("%s;%s;%s;%s;%d", nome, cognome, numero, visibilita, nVolte);
    }
    public String stampa()
    {
      return String.format("Nome: %s Cognome: %s Telefono: %s, Numero di Chiamate: %d", nome, cognome, numero, nVolte);
    }

    public void aumentaChiamate() {
        nVolte++;
    }
}