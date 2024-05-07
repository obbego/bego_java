enum tipoContratto{abitazione, cellulare, aziendale};

public class Contatto
{
    public String nome;
    public String cognome;
    public String telefono;
    public tipoContratto tipo;

    /*@Override // riscrive il metodo to string
    public String toString()
    {
        return String.format("Nome: %s  Cognome: %s  Telefono: %s  Tipo: %s", nome, cognome, telefono, tipo);
    }*/

    public String stampa(){
        return String.format("Nome: %s  Cognome: %s  Telefono: %s  Tipo: %s", nome, cognome, telefono, tipo.toString());
    }
}
