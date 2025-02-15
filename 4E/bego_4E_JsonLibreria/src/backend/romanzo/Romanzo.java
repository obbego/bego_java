package backend.romanzo;

import backend.Libro;
import backend.manuale.Livello;

public class Romanzo extends Libro {
    String genLetterario;

    public Romanzo(String autore, String titolo, int nPagine, String genLetterario) {
        super(autore, titolo, nPagine);
        this.genLetterario =  genLetterario;
    }
}
