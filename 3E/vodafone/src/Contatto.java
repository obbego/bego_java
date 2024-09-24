enum tipoContratto{abitazione, cellulare, aziendale};

public class Contatto {
    public String nome;
    public String cognome;
    public String telefono;
    public tipoContratto tipo;
    public float credito;
    /*public double ricarica;
    public Contatto(String nome, String cognome) {
        this.nome=nome;
        this.ricarica=10;
    }
    public String getNome(){
        return this.nome.toUpperCase();
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public String getTelefono(){
        return this.telefono;
    }*/

    public String stampa()
    {
        if (telefono == null){
            return String.format("Nome: %s Cognome: %s Telefono non inserito", nome, cognome);
        }
        return String.format("Nome: %s Cognome: %s Telefono: %s, tipo: %s, Credito: %.2f", nome, cognome, telefono, tipo.toString(), credito);
    }

    public void aumentaCredito(float soldi) {
        credito += soldi;
    }

    public void diminuisciCredito(float soldi) {
        credito -= soldi;
    }
}
