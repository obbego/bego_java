enum tipoContratto{abitazione, cellulare, aziendale};

public class Contatto {
    public String nome;
    public String cognome;
    public String telefono;
    public tipoContratto tipo;

    public String stampa()
    {
        if (telefono == null){
            return String.format("Nome: %s Cognome: %s", nome, cognome);
        }
        else
        return String.format("Nome: %s Cognome: %s Telefono: %s, tipo: %s", nome, cognome, telefono, tipo.toString());
    }
}
