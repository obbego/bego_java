import static frontScreen.FrontEnd.*;
import static utility.Tools.*;

import mensola.*;

import java.util.EmptyStackException;
import java.util.Scanner;

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
                "Esci"
        };
        Libro[] scaffale = new Libro[MAX_LIBRI];
        int nLibri = 0;
        boolean fine = true, spazio;

        do {
            switch (Menu(elenco, keyboard)) {
                case 1:

                    try {
                        spazio = controllaSpazio(nLibri, MAX_LIBRI);
                    } catch (Exception e) {
                        System.out.println("Lo scaffale è pieno");
                        break;
                    }
                    scaffale[nLibri] = LeggiLibro(keyboard, nLibri, scaffale);
                    nLibri++;
                    break;

                case 2:
                    try {
                        visualizza(scaffale, nLibri);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        modificaNumPagine(nLibri, keyboard, scaffale);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        cancellaLibro(nLibri, keyboard, scaffale);
                        nLibri--;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        visualizzaPerAutore(scaffale, keyboard, nLibri);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    private static void visualizzaPerAutore(Libro[] scaffale, Scanner keyboard, int nLibri) throws Exception {
        controllaSeVuoto(nLibri);

        System.out.println("Inserisci il nome dell'autore: ");
        String autore = keyboard.nextLine();
        boolean trovato = false;

        for (int i = 0; i < nLibri; i++) {
            if (scaffale[i].autore.equals(autore)) {
                System.out.println(scaffale[i].toString());
                trovato = true;
            }
        }

        if (!trovato) {
            throw new Exception("Non è stato trovato nessun'autore con quel nome");
        }
    }

    private static void cancellaLibro(int nLibri, Scanner keyboard, Libro[] scaffale) throws Exception {
        controllaSeVuoto(nLibri);

        System.out.println("Inserire il titolo del libro che si vuole cancellare");
        String titoloDaTrovare = keyboard.nextLine();

        int pos = cercaLibro(titoloDaTrovare, scaffale, nLibri);

        scaffale[pos] = null;
        compatta(scaffale, pos, nLibri);
        scaffale[nLibri - 1] = null;
    }

    private static void compatta(Libro[] scaffale, int pos, int nLibri) {
        for (int i = pos; i < nLibri - 1; i++) {
            scaffale[i] = scaffale[i + 1];
        }
    }

    private static void modificaNumPagine(int nLibri, Scanner keyboard, Libro[] scaffale) throws Exception {
        controllaSeVuoto(nLibri);

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

    private static boolean controllaSpazio(int nLibri, int maxLibri) throws Exception {
        if (nLibri < maxLibri)
            return true;
        else
            throw new Exception("Scaffale pieno");
    }

    private static int cercaLibro(String titolo, Libro[] scaffale, int nLibri) throws Exception {
        controllaSeVuoto(nLibri);
        for (int i = 0; i < nLibri; i++) {
            if (scaffale[i].titolo.equals(titolo))
                return i;
        }
        throw new Exception("Libro non trovato");
    }
}
