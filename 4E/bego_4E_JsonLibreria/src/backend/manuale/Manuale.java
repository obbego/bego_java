package backend.manuale;

import backend.Libro;

public class Manuale extends Libro {
    String argomento;
    Livello livello;

    public Manuale(String autore, String titolo, int nPagine, String argomento, Livello livello) {
        super(autore, titolo, nPagine);
        this.argomento = argomento;
        this.livello = livello;
    }

    public static String[] getLivelliArrayString() {
        String[] output = new String[Livello.values().length + 1];
        Livello[] valori = Livello.values();

        output[0] = "LIVELLI MANUALE";
        for (int i = 0; i < valori.length; i++)
            output[i + 1] = valori[i].toString();

        return output;
    }

    public static Livello getLivello(int pos) {
        return Livello.values()[pos];
    }
}
