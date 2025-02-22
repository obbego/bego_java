//Francesco Bego

import java.util.Random;

class Dado {

    //numero di facce nel dado
    private int nFacce;
    private Random valLancio = new Random();

    //costruttore
    public Dado(int nFacce) {
        this.nFacce = nFacce;
    }

    //metodo che lancia il dado, ritorna un int casuale tra 1 e il nFacce
    public int lancia() {
        return valLancio.nextInt(0, nFacce) + 1;
    }

    public int getnFacce() {
        return nFacce;
    }
}