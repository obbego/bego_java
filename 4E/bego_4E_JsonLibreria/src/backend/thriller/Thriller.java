package backend.thriller;

import backend.Libro;

public class Thriller extends Libro {
    GenereThriller genere;

    public Thriller(String autore, String titolo, int nPagine, GenereThriller genere) {
        super(autore, titolo, nPagine);
        this.genere = genere;
    }

    public static String[] getGeneriArrayString() {
        String[] output = new String[GenereThriller.values().length + 1];
        GenereThriller[] valori = GenereThriller.values();

        output[0] = "GENERI THRILLER";
        for (int i = 0; i < valori.length; i++)
            output[i + 1] = valori[i].toString();

        return output;
    }

    public static GenereThriller getGenere(int pos) {
        return GenereThriller.values()[pos];
    }
}
