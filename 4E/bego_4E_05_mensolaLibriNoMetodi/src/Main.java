import static frontScreen.FrontEnd.*;
import static utility.Tools.*;
import java.util.ArrayList;
import mensola.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

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
                "Visita mensola",
                "Crea mensola con valori costanti",
                "Esci"
        };
        ArrayList <Libro> scaffale = new ArrayList<>();
        int nLibri = 0;
        boolean fine = true;

        do {
            switch (Menu(elenco, keyboard)) {
                case 1:
                    try {
                        controllaSpazio(nLibri, MAX_LIBRI);
                        scaffale.add(LeggiLibro(keyboard, scaffale));
                        nLibri++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;

                case 2:
                    try {
                        controllaSeVuoto(nLibri);
                        visualizza(scaffale);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        controllaSeVuoto(nLibri);
                        modificaNumPagine(keyboard, scaffale);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        controllaSeVuoto(nLibri);
                        cancellaLibro(keyboard, scaffale);
                        nLibri--;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        controllaSeVuoto(nLibri);
                        visualizzaPerAutore(scaffale, keyboard);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        controllaSeVuoto(nLibri);
                        visualizzaPosizioneLibri(scaffale, keyboard);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        controllaSeVuoto(nLibri);
                        visualizzaValoreTotale(scaffale, keyboard);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        visitaMensola(keyboard, scaffale);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    nLibri = 5;
                    assegnaLibriAutomaticamente(scaffale);
                    break;
                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    public static void assegnaLibriAutomaticamente(ArrayList<Libro> mensola){

        String[] listaNomi = {"Dante", "Catullo", "Leopardi", "Boccaccio", "Petrarca"};
        String[] listaTitoli = {"Divina Commedia", "Ciao", "Canti", "Decameron", "Canzoniere"};

        for(int i=0; i<5; i++) {
            Libro libroInserito = new Libro();
            libroInserito.numeroPagine = 5;
            libroInserito.dataPubblicazione = LocalDate.of(2024,12,11);
            libroInserito.tipologia = Genere.MANUALE;
            libroInserito.titolo = listaTitoli[i];
            libroInserito.autore = listaNomi[i];
            mensola.add(libroInserito);
        }
    }

    private static void visitaMensola(Scanner keyboard, ArrayList <Libro> scaffale) throws Exception {
        String[] opzioni = {
                "OPZIONI VISITA MENSOLA",
                "Numero attuale",
                "Libro precedente",
                "Libro sucessivo",
                "esci"
        };
        int posizioneAttuale = -1;
        boolean fine = true;
        do{
            switch (Menu(opzioni, keyboard)){
                case 1 -> {
                    System.out.println("Inserisci la posizione attuale: ");
                    posizioneAttuale = Integer.parseInt(keyboard.nextLine());
                    if(posizioneAttuale >= scaffale.size() || posizioneAttuale < 0){
                        throw new Exception("Il numero inserito non è valido per i valori dello scaffale");
                    }
                    System.out.println(scaffale.get(posizioneAttuale).toString());
                }
                case 2 -> {
                    if (posizioneAttuale -1 < 0)
                        throw new Exception("Sei arrivato al primo libro, non ci sono precedenti");
                    else{
                        posizioneAttuale--;
                        System.out.println(scaffale.get(posizioneAttuale).toString());
                    }
                }
                case 3 -> {
                    if (posizioneAttuale + 1 == scaffale.size())
                    throw new Exception("Sei arrivato all'ultimo libro, non ci sono sucessivi");
                    else{
                        posizioneAttuale++;
                        System.out.println(scaffale.get(posizioneAttuale).toString());
                    }
                }
                case 4 -> {
                    fine = false;
                }
            }
        }while (fine);
    }


    public static void cancellaLibro(Scanner keyboard, ArrayList<Libro> scaffale) throws Exception {

        System.out.println("Inserire il titolo del libro che si vuole cancellare");
        String titoloDaTrovare = keyboard.nextLine();

        int pos = cercaLibro(titoloDaTrovare, scaffale);
        scaffale.remove(pos);
    }

    public static void modificaNumPagine(Scanner keyboard, ArrayList<Libro> scaffale) throws Exception {

        System.out.println("Inserire il titolo del libro che si vuole modificare");
        String titoloDaTrovare = keyboard.nextLine();

        int pos = cercaLibro(titoloDaTrovare, scaffale);

        System.out.println("Inserisci il nuovo numero di pagine:\n(vecchio numero: " + scaffale.get(pos).numeroPagine + ")");
        int nPagine = Integer.parseInt(keyboard.nextLine());

        if (nPagine < 0) {
            throw new Exception("Non puoi inserire un numero negativo di pagine");
        } else {
            scaffale.get(pos).numeroPagine = nPagine;
        }
    }

    public static void controllaSpazio(int nLibri, int maxLibri) throws Exception {
        if (nLibri >= maxLibri)
            throw new Exception("Scaffale pieno");
    }

    public static int cercaLibro(String titoloR, ArrayList<Libro> scaffale) throws Exception {
        for(Libro x : scaffale) {
            if(x.equalsT(titoloR))
                return scaffale.indexOf(x);
        }
        throw new Exception("Libro non trovato");
    }
}
