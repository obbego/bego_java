//Francesco Bego 3E 24/04
enum genere {pavimenti, bagno, mobili}
public class Prodotto {
    public String codice;
    public String descrizione;
    public genere utilizzo;
    public int prezzo;
    public int qta;

    public String stampa(){
        return String.format("CODICE: %s - DESCRIZIONE: %s - GENERE: %s - PREZZO: €%d - QUANTITà: %d", codice, descrizione, utilizzo, prezzo, qta);
    }
}
