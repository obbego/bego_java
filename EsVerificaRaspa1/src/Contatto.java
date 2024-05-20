
public class Contatto {
    public String nome;
    public String cognome;
    public String numero;
    public boolean visibilita;
    public int nVolte = 0;
    
    public String stampa()
    {
      return String.format("Nome: %s Cognome: %s Telefono: %s, Numero Chiamate: %d", nome, cognome, numero, nVolte);
    }

    public void aumentaChiamate() {
        nVolte++;
    }
}