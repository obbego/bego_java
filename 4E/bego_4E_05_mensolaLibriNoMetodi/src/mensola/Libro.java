package mensola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {
    public String autore;
    public String titolo;
    public int numeroPagine;
    public double costoPerPagina = 0.05;
    public Genere tipologia;
    public LocalDate dataPubblicazione;
    private final DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String toString() {
        return String.format("Autore: %s; Titolo: %s; Numero di pagine %s; Prezzo: %.2f; Genere: %s; Data: %s\n",
                autore, titolo, numeroPagine, numeroPagine * costoPerPagina, tipologia.toString(), dataPubblicazione.format(formattazioneData));
    }

    public boolean equalsT(String titoloR){
        return titolo.equals(titoloR);
    }

    public boolean equalsA(String autoreR){
        return autore.equals(autoreR);
    }

    public boolean equals (String titoloR, String autoreR){
        return equalsA(autoreR) && equalsT(titoloR);
    }

    @Override
    public boolean equals(Object book){
        Libro x = (Libro) book;
        return equalsA(x.autore) && equalsT(x.titolo);
    }
}
