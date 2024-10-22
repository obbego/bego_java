package frontScreen;

import mensola.*;
import java.util.ArrayList;
import java.util.Scanner;

import static utility.Tools.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FrontEnd {
    public static Libro LeggiLibro(Scanner keyboard, int nLibri, Libro[] scaffale) {
        Libro output = new Libro();
        boolean trovato, dataAcc;
        //Inserimento autore
        do {
            System.out.println("Inserisci l'autore: ");
            output.autore = keyboard.nextLine();
            //Inserimento titolo
            System.out.println("Inserisci il titolo: ");
            output.titolo = keyboard.nextLine();
            try {
                trovato = verificaDuplicato(output.autore, output.titolo, nLibri, scaffale);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                trovato = true;
            }

        } while (trovato);
        //Inserire numero di pagine
        do {
            System.out.println("Inserisci il numero di pagine: ");
            try {
                output.numeroPagine = Integer.parseInt(keyboard.nextLine());
            } catch (Exception e) {
                System.out.println("Inserisci un numero.");
                output.numeroPagine = -1;
            }
        } while (output.numeroPagine <= 0);

        //Inserimento tipologia
        Genere[] generi = Genere.values();
        String[] menuData = new String[generi.length + 1];
        menuData[0] = "Inserire Genere";
        for (int i = 0; i < generi.length; i++)
            menuData[i + 1] = generi[i].toString();
        int genereIndex = Menu(menuData, keyboard) - 1;
        output.tipologia = generi[genereIndex];
        //Inserimento data
        do {
            dataAcc = true;
            System.out.println("Inserire data nel formato dd/MM/yyyy: ");
            String dataInput = keyboard.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                output.dataPubblicazione = LocalDate.parse(dataInput, formatter);
            } catch (Exception e) {
                System.out.println("La data non rispetta la formattazione corretta");
                dataAcc = false;
            }
        } while (!dataAcc);

        return output;
    }

    // Metodo che verifica se esiste già un libro con lo stesso autore e titolo
    private static boolean verificaDuplicato(String autore, String titolo, int nLibri, Libro[] scaffale) throws Exception {
        for (int i = 0; i < nLibri; i++) {
            if (scaffale[i].autore.equals(autore) && scaffale[i].titolo.equals(titolo)) {
                throw new Exception("Trovato Doppione\n");  // Trovato duplicato (autore e titolo già presenti)
            }
        }
        return false;  // Nessun duplicato trovato
    }


    public static void visualizza(Libro[] scaffale, int nLibri){
        for (int i = 0; i < nLibri; i++) {
            System.out.println(scaffale[i].toString());
        }
    }

    public static void controllaSeVuoto(int nLibri) throws Exception {
        if (nLibri == 0) {
            throw new Exception("Scaffale vuoto");
        }
    }

    public static void visualizzaValoreTotale(Libro[] scaffale, Scanner keyboard, int nLibri) throws Exception {
        ArrayList<Integer> posAutore = trovaLibriAutore(scaffale, keyboard, nLibri);
        double somma = 0;
        for (Integer pos : posAutore) {
            System.out.printf("%.2f (somma attuale) += %.2f (valore libro: %s)\n", somma, scaffale[pos].numeroPagine * scaffale[pos].costoPerPagina, scaffale[pos].titolo);
            somma += scaffale[pos].numeroPagine * scaffale[pos].costoPerPagina;
        }
        System.out.printf("SOMMA TOTALE DEI LIBRI DI %s = %.2f\n", scaffale[posAutore.getFirst()].autore, somma);
    }

    public static void visualizzaPosizioneLibri(Libro[] scaffale, Scanner keyboard, int nLibri) throws Exception {
        ArrayList<Integer> posAutore = trovaLibriAutore(scaffale, keyboard, nLibri);
        for (Integer pos : posAutore) {
            System.out.println(pos);
        }
    }
    //andrebbe nella classe scaffale quando verrà creata, ma non posso metterlo nel main dato che sono in pacchetti diversi e non me lo fa importare
    public static ArrayList<Integer> trovaLibriAutore(Libro[] scaffale, Scanner keyboard, int nLibri) throws Exception {

        ArrayList<Integer> posAutore = new ArrayList<>();
        System.out.println("Inserisci il nome dell'autore: ");
        String autore = keyboard.nextLine();

        for (int i = 0; i < nLibri; i++) {
            if (scaffale[i].autore.equals(autore)) {
                posAutore.add(i);
            }
        }

        if (posAutore.isEmpty()) {
            throw new Exception("Non è stato trovato nessun libro con quel autore");
        }
        return posAutore;
    }

    public static void visualizzaPerAutore(Libro[] scaffale, Scanner keyboard, int nLibri) throws Exception {

        ArrayList<Integer> posAutore = trovaLibriAutore(scaffale, keyboard, nLibri);
        for (Integer pos : posAutore) {
            System.out.println(scaffale[pos].toString());
        }
    }
}
