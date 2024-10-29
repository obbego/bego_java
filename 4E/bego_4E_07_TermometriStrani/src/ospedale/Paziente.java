package ospedale;

import java.util.ArrayList;
import java.time.LocalDate;
public class Paziente {
    public String nome;
    public String cognome;
    public int eta;
    public Reparto reparto;
    public ArrayList<LocalDate> dateMisurazioni;
    public ArrayList<Termometro> misurazioni;
}
