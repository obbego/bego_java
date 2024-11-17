package LunaPark;

import java.time.LocalTime;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Locale;

public class Biglietto {
    public String nome;
    public String cognome;
    public ArrayList<Giostre> giostrFatte = new ArrayList<>();
    public ArrayList<LocalTime> oraGiostre = new ArrayList<>();
    public int nGiostreFatte;
    public LocalDate dataIngresso;
    public LocalTime oraIngresso;
    public int idBiglietto;


    public String toString() {
        return String.format("Nome: %s, Cognome: %s, Giostre fatte: %s, numero delle giostre fatte:  %d,Data ingresso: %s, ID biglietto: %d", nome, cognome, giostrFatte, nGiostreFatte, dataIngresso, idBiglietto);
    }

    public boolean equals (String nomeR, String cognomeR) {
        return nomeR.equals(nome) && cognomeR.equals(cognome);
    }
}
