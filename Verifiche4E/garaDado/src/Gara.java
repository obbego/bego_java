//Francesco Bego
class Gara {

    private int nRound;
    private int vittoreG1 = 0;
    private int vittoreG2 = 0;
    private boolean fineGara = false; //proprietà utilizzata per determinare il fine della gara

    public Gara(int nRound) {
        this.nRound = nRound;
    }

    //inizia la gara e ritorna una stringa formattata con il nome del costruttore
    public String iniziaGara(Dado dado, String[] giocatori) {
        for (int i = 0; i < nRound; i++) {
            System.out.println(winner(i, giocatori[round(dado)]));
        }
        this.fineGara = true;
        return String.format("Il vincitore finale della gara è: %s\n %s", giocatori[finalWinner()], punteggi(giocatori));
    }

    private String punteggi(String[] giocatori) {
        return String.format("Con punteggi:\n %d %s\n %d %s", vittoreG1, giocatori[1], vittoreG2, giocatori[2]);
    }

    public String winner(int i, String vincitore) // ritorna il nome del vincitore del round
    {
        if (vincitore.equals("pareggio")) {
            return String.format("Il %d round finisce in %s", i + 1, vincitore);
        } else {
            return String.format("Vince il %d round il giocatore %s", i + 1, vincitore);
        }
    }

    //esegue un round della partita
    public int round(Dado dado)
    {
        int valG1, valG2;
        valG1 = dado.lancia();
        valG2 = dado.lancia();

        //ritorna 1 = vince g1, 2 = vince g2, 0 = pareggio
        if (valG1 > valG2) {
            vittoreG1++;
            return 1;
        } else if (valG1 == valG2) {
            vittoreG1++;
            vittoreG2++;
            return 0;
        } else {
            vittoreG2++;
            return 2;
        }
    }

    public int finalWinner()// resetta la partita
    {
        if (vittoreG1 > vittoreG2)
            return 1;
        else if (vittoreG1 == vittoreG2)
            return 0;
        else
            return 2;
    }

    public int getNRound() {
        return nRound;
    }

    public int getVittoreG1() {
        return vittoreG1;
    }

    public int getVittoreG2() {
        return vittoreG2;
    }

    public boolean isFineGara() {
        return fineGara;
    }

    //resetta la partita
    public void resetGame()// resetta la partita
    {
        vittoreG1 = 0;
        vittoreG2 = 0;
        nRound = 0;
        fineGara = false;
    }
}