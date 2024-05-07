enum tipoContratto{abitazione, cellulare, aziendale};

public class Contatto {
    public String nome;
    public String cognome;
    public String telefono;
    public tipoContratto tipo;
    public float credito;

    public String stampa()
    {
        if (telefono == null){
            return String.format("Nome: %s Cognome: %s Telefono: non inserito Credito: %f", nome, cognome, credito);
        }
        else
        return String.format("Nome: %s Cognome: %s Telefono: %s, tipo: %s Credito: %f", nome, cognome, telefono, tipo.toString(), credito);
    }
    public void aumentaCredito(float soldi)
    {
        credito += soldi;
    }
    public void diminuisciCredito(float soldi)
    {
        credito -= soldi;
    }
}
