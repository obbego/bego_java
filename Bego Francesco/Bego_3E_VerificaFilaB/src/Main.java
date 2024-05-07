import static tools.utility.*;
import java.util.Scanner;
//Francesco Bego 3E 24/04
public class Main {
    public static void main(String[] args) {
        // creazione scanner
        Scanner keyboard = new Scanner(System.in);
        // creazione collezione di stringhe per il menu
        String[] opzioni = {"SUPERMERCATO",
                "[1] inserisci articolo",
                "[2] stampa",
                "[3] ricerca per genere",
                "[4] vendita prodotto",
                "[5] stampa elenco da riordinare",
                "[6] prezzo totale scaffale",
                "[7] fine"};
        String[] tipoC = {"GENERE","1]pavimenti", "2]bagno", "3]mobili"};
        // creazione variabile per uscire dal codice
        boolean fine = true;
        // dichiarare il numero max di posti nello scaffale
        final int nMax = 4;
        // creare lo scaffale, come insieme di prodotti
        Prodotto[] scaffale = new Prodotto[nMax];
        // indice per capire fino a dove ho ripempito lo scaffale
        int indexScaf = 0;
        // inserisco già dentro scaffale 3 prodotti
        scaffale[indexScaf] = leggiProdotto("10000100", "Mocio piatto", 1, 20, 5);
        indexScaf++;
        scaffale[indexScaf] = leggiProdotto("20000101", "Confezione spugne", 2, 5, 10);
        indexScaf++;
        scaffale[indexScaf] = leggiProdotto("30000102", "Guanti in gomma", 3, 10, 10);
        indexScaf++;
        //ciclo per ripetere le operazioni
        do {
            //stampo il menu
            switch (menu(opzioni, keyboard)) {
                case 1: {
                    //controllo che ci sia spazio nello scaffale
                    if (indexScaf < nMax) {
                        //creo variabile codice
                        String codice;
                        do {
                            System.out.println("\nInserisci il codice del prodotto: ");
                             codice = keyboard.nextLine();
                        } // controllo il codice sia accettabile con il metodo controllaCodice
                        while (controllaCodice(scaffale, indexScaf, codice));
                        System.out.println("\nInserisci la descrizione: ");
                        String descrizione = keyboard.nextLine();
                        //I valori assegnati all'attributo sono compresi nel range
                        int genere = menu(tipoC, keyboard);
                        System.out.println("\nInserisci il prezzo: ");
                        int prezzo = keyboard.nextInt();
                        System.out.println("\nInserisci la qta: ");
                        int qta = keyboard.nextInt();
                        //usando il metodo leggiProdotto creo il prodotto e lo metto sullo scaffale
                        scaffale[indexScaf] = leggiProdotto(codice, descrizione, genere, prezzo, qta);
                        //aumento l'indice di riempimento
                        indexScaf++;
                        //svuoto il buffer
                        keyboard.nextLine();
                    } else {
                        //comunico non ci sia più spazio
                        System.out.println("Non c'è più spazio nello scaffale");
                    }
                    break;
                }
                case 2: {
                    //controllo ci sia almeno un prodotto
                    if (indexScaf == 0) {
                        System.out.println("Non ce nessun prodotto");
                    } else {
                        //usando il metodo della classe stampa(), stampo tutti i valori all'interno dello scaffale
                        for (int i = 0; i < indexScaf; i++) {
                            System.out.println(scaffale[i].stampa());
                        }
                    }
                    break;
                }
                case 3: {
                    //controllo ci sia almeno un prodotto
                    if (indexScaf == 0) {
                        System.out.println("Non ce nessun prodotto");
                    }
                    else {
                        //chiedo all'utente che genere vuole cercare
                        System.out.println("Che genere vuoi cercare?");
                        //creo variabile cercare
                        String cercare;
                            //I valori assegnati all'attributo sono compresi nel range
                            switch (menu(tipoC, keyboard)) {
                                case 1 -> cercare = String.valueOf(genere.pavimenti);
                                case 2 -> cercare = String.valueOf(genere.bagno);
                                default -> cercare = String.valueOf(genere.mobili);
                            }
                            //stampo tutti i prodotti che hanno quel genere
                            for (int i = 0; i < indexScaf; i++) {
                                if (cercare.equals(String.valueOf(scaffale[i].utilizzo)))
                                    //+ la posizione
                                    System.out.println(scaffale[i].stampa() + " - posizione: " + i);
                            }
                        }
                    break;
                }
                case 4:{
                    int indexRic = 0;
                    if (indexScaf == 0) {
                        System.out.println("Non ce nessun prodotto");
                    }
                    else {
                        do {
                            //chiedo all'utente l'indice del prodotto e controllo sia valido
                            System.out.println("Che prodotto vuole comprare: \n da 1 a " + indexScaf);
                            indexRic = Integer.parseInt(keyboard.nextLine()) - 1;
                        } while (indexRic < 0 || indexRic > indexScaf);
                        //controllo il prodotto non sia esaurito
                        if (scaffale[indexRic].qta > 0)
                            //diminuisco la qta
                            scaffale[indexRic].qta--;
                        else {
                            //comunico l'errore
                            System.out.println("Il prodotto è esaurito");
                        }
                    }
                    break;
                }
                case 5:{
                    if (indexScaf == 0) {
                        System.out.println("Non ce nessun prodotto");
                    }
                    else {
                        // per tutto lo scaffale controllo quali prodotti sono esauriti e li stampo
                        for (int i = 0; i < indexScaf; i++) {
                            if (scaffale[i].qta == 0)
                                System.out.println(scaffale[i].stampa() + " - posizione: " + i);
                        }
                    }
                    break;
                }
                case 6:{
                    if (indexScaf == 0) {
                        System.out.println("Non ce nessun prodotto");
                    }
                    else {
                        int prezzoTot = 0;
                        //per tutto lo scaffale sommo a prezzoTot il valore di ogni prodotto moltiplicato per la qta
                        for (int i = 0; i < indexScaf; i++){
                            prezzoTot += scaffale[i].prezzo * scaffale[i].qta;
                        }
                        System.out.println("il prezzo totale corrisponde a: €"+prezzoTot);
                    }
                    break;
                }
                default:{
                    //per uscire dal ciclo rendo fine = false
                    fine = false;
                    break;
                }

            }
        }while (fine);
    }

    private static boolean controllaCodice(Prodotto[] scaffale, int indexScaf, String codice) {
        for (int i = 0; i < indexScaf; i++){
            //per tutto lo scaffale controllo se i 2 codici sono uguali
            if (scaffale[i].codice.equals(codice)){
                System.out.println("Il codice è gia stato usato");
                // se è gia stato usato ritorno true per rimanere nel ciclo del main
                return true;}
        }
        //se non è stato trovato ritorno false per uscire dal ciclo
        return false;
    }

    private static Prodotto leggiProdotto(String codice, String descrizione, int utilizzo, int prezzo, int qta) {
        //Istanziato un oggetto di tipo Prodotto:
        Prodotto oggetto = new Prodotto();
        //parametrizzo l'inserimento, passando le variavbili al metodo invece di inserire da tastiera nel metodo
        oggetto.codice = codice;
        oggetto.descrizione = descrizione;
        //I valori assegnati all'attributo sono compresi nel range
        switch (utilizzo) {
            case 1 -> oggetto.utilizzo = genere.pavimenti;
            case 2 -> oggetto.utilizzo = genere.bagno;
            default -> oggetto.utilizzo = genere.mobili;
        }
        oggetto.prezzo = prezzo;
        oggetto.qta = qta;

        return oggetto;
    }
}