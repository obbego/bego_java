import static frontScreen.FrontEnd.*;
import static utility.Tools.*;

import mensola.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final int MAX_LIBRI = 2;
        final String[] elenco = {
                "Libreria",
                "Inserisci Libro",
                "Visualizza tutti i libri inseriti",
                "Modifica pagine libro",
                "Cancella libro",
                "Visualizza libri di un autore",
                "Posizioni dei libri di un autore",
                "Valore totale dei libri di un autore",
                "Esci"
        };
        Libro[] scaffale = new Libro[MAX_LIBRI];
        int nLibri = 0;
        boolean fine = true;

        do {
            switch (Menu(elenco, keyboard)) {
                case 1:
                    try {
                        controllaSpazio(nLibri, MAX_LIBRI);
                    } catch (Exception e) {
                        System.out.println("Lo scaffale è pieno");
                        break;
                    }
                    scaffale[nLibri] = LeggiLibro(keyboard, nLibri, scaffale);
                    nLibri++;
                    break;

                case 2:
                    try {
                        controllaSeVuoto(nLibri);
                        visualizza(scaffale, nLibri);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        controllaSeVuoto(nLibri);
                        modificaNumPagine(nLibri, keyboard, scaffale);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        controllaSeVuoto(nLibri);
                        cancellaLibro(nLibri, keyboard, scaffale);
                        nLibri--;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        controllaSeVuoto(nLibri);
                        visualizzaPerAutore(scaffale, keyboard, nLibri);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        controllaSeVuoto(nLibri);
                        visualizzaPosizioneLibri(scaffale, keyboard, nLibri);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        controllaSeVuoto(nLibri);
                        visualizzaValoreTotale(scaffale, keyboard, nLibri);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    public static void visualizzaPerAutore(Libro[] scaffale, Scanner keyboard, int nLibri) throws Exception {

        ArrayList<Integer> posAutore = trovaLibriAutore(scaffale, keyboard, nLibri);
        for (Integer pos : posAutore) {
            System.out.println(scaffale[pos].toString());
        }
    }

    public static void cancellaLibro(int nLibri, Scanner keyboard, Libro[] scaffale) throws Exception {

        System.out.println("Inserire il titolo del libro che si vuole cancellare");
        String titoloDaTrovare = keyboard.nextLine();

        int pos = cercaLibro(titoloDaTrovare, scaffale, nLibri);

        scaffale[pos] = null;
        compatta(scaffale, pos, nLibri);
        scaffale[nLibri - 1] = null;
    }

    public static void compatta(Libro[] scaffale, int pos, int nLibri) {
        for (int i = pos; i < nLibri - 1; i++) {
            scaffale[i] = scaffale[i + 1];
        }
    }

    public static void modificaNumPagine(int nLibri, Scanner keyboard, Libro[] scaffale) throws Exception {

        System.out.println("Inserire il titolo del libro che si vuole modificare");
        String titoloDaTrovare = keyboard.nextLine();

        int pos = cercaLibro(titoloDaTrovare, scaffale, nLibri);

        System.out.println("Inserisci il nuovo numero di pagine:\n(vecchio numero: " + scaffale[pos].numeroPagine + ")");
        int nPagine = Integer.parseInt(keyboard.nextLine());

        if (nPagine < 0) {
            throw new Exception("Non puoi inserire un numero negativo di pagine");
        } else {
            scaffale[pos].numeroPagine = nPagine;
        }
    }

    public static void controllaSpazio(int nLibri, int maxLibri) throws Exception {
        if (nLibri >= maxLibri)
            throw new Exception("Scaffale pieno");
    }

    public static int cercaLibro(String titolo, Libro[] scaffale, int nLibri) throws Exception {
        for (int i = 0; i < nLibri; i++) {
            if (scaffale[i].titolo.equals(titolo))
                return i;
        }
        throw new Exception("Libro non trovato");
    }
}
