/*
 * PARTITa AVANZATA:
 * MIN 3 round
 * Ogni 3 round vinti di fila dallo stesso giocatore: BONUS vincita
 * Parita -> si resetta bonus vincita
 * Comunicare il bonus vincita
 * Eseguire confronti tra dado e giocatore con comparable
 * Possibilità di utilizzare sia partita base che avanzata
 * Utilizzando il polimorfismo comunicare il tipo di partita che stiamo utilizzando (istance of)
 * */
public class GaraAvanzata extends Gara {
    private int punteggioBonus = 0;
    private int lastWinner;

    public GaraAvanzata(String nomeGiocatore1, String nomeGiocatore2, int numeroRound) {
        super(nomeGiocatore1, nomeGiocatore2, numeroRound);

    }

    @Override
    public String giocaRound() {
        String esito = super.giocaRound();

        this.giocatori[0].getDado().getValoreLancio();
        this.giocatori[1].getDado().getValoreLancio();

        giocatori[0].getDado().compareTo(giocatori[1].getDado());
        return esito;
    }

}
