//importazione librerie
import static tools.utility.*;
import java.util.Scanner;
import  java.io.*;

public class Main {
    public static void main(String[] args) {
        //dimensione array
        final int maxContatti = 20;
        //creo array con quella dimensione
        Contatto[] rubrica = new Contatto[maxContatti];
        //fino a dove abbiamo riempito l'array
        int nContatti = 0;
        //variabili per visualizzare i numeri nascosti + ripetizione del codice
        boolean visualizzaOscuri = false, fine = true;
        //password per modificare la visibilità
        String password = null;
        Scanner keyboard = new Scanner(System.in);
        //opzioni menu
        String[] operazioni = {
                "RUBRICA TELEFONICA",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Imposta Password",
                "[4] Ricerca",
                "[5] Modifica visibilità contatto",
                "[6] Cancella Contatto",
                "[7] Chiama qualcuno",
                "[8] Visualizza ultime chiamate",
                "[9] Importa rubrica da file",
                "[10] Salva rubrica su file",
                "[11] Fine"};

        //ciclo da ripetere fino a quando l'utente non esce
        do {
            //stampare lo schermo con le varie opzioni
            switch (menu(operazioni, keyboard)) {
                case 1:
                    //controllo se cè ancora spazio nella rubrica
                    if (nContatti >= maxContatti)
                        System.out.println("Rubrica piena. Impossibile aggiungere nuovi contatti.");
                    //se ce spazio
                    else {
                        //vado a leggere il contatto
                        rubrica[nContatti] = leggiContatto(keyboard, rubrica, nContatti);
                        //ordino la rubrica per tenerla ordinata in ordine alfabetico
                        ordinaRubrica(nContatti, rubrica);
                        //aumento il contatore
                        nContatti++;
                    }
                    break;
                case 2:
                    //stampo a schermo i contatti
                    visualizzaContatti(nContatti, rubrica, visualizzaOscuri);
                    break;
                case 3:
                    //se la password non è impostata
                    if (password == null){
                        //vado ad impostarla
                        password = inserisciPassword(keyboard);
                        //modifico la voce nel menù
                        operazioni[3] = "[3] INSERISCI password";
                    }
                    //se è gia impostata
                    else
                        //modifico la visibilità dei contatti
                        visualizzaOscuri = attivaPassword(keyboard, password, visualizzaOscuri);

                    break;
                case 4:
                    //cerco il contatto
                    int posContatto = ricercaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
                    //se è stato trovato, stampo le informazioni di quel contatto
                    if (posContatto != -1)
                        System.out.println(rubrica[posContatto].stampa());
                    break;
                case 5:
                    //inverto la visibilità del contatto
                    modificaVisibilitaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
                    break;
                case 6:
                    //cancello il contatto
                    cancellaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
                    break;
                case 7:
                    //chiamo il contatto
                    chiamaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
                    break;
                case 8:
                    //stampo i contatti che sono stati chiamati
                    visualizzaChiamate(visualizzaOscuri, nContatti, rubrica);
                    break;
                case 9 :
                    try {
                        //vado a leggere i contatti dal file
                        nContatti = leggiFile("rubrica.csv", rubrica);
                        //riordino per tenere in ordine
                        ordinaRubrica(nContatti, rubrica);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                case 10:
                    //gestione delle eccezioni (errori di runtime)
                    try {
                        //vado a salvare la rubrica nel file
                        scriviFile(rubrica, nContatti,"rubrica.csv");
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                case 11:
                    //esco dal ciclo
                    fine = false;
                    break;
                //valore inserito fuori dal range
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        } while (fine);
        //condizione di ripetizione del ciclo
    }


    //riempio rubrica con i dati del file
    private static int leggiFile(String fileName, Contatto[] rubrica) throws Exception {
        FileReader reader = new FileReader(fileName);
        Scanner input = new Scanner(reader);
        int contaElementi = 0;
        String lineIn;
        String[] vettAttributi;

        //salto la prima riga perchè contiene l'indice
        if (input.hasNextLine()) {
            input.nextLine();
        }
        //fino a quando il file ha informazioni o fino a quando cè spazio nella rubrica
        while (input.hasNextLine() && contaElementi < rubrica.length) {
            //leggo il valore
            lineIn = input.nextLine();
            //attribuisco all'array i valori trovati che sono stati separati
            vettAttributi = lineIn.split(";");
            Contatto persona = new Contatto();
            //attribuisco alle variabili le informazioni trovate
            persona.nome = vettAttributi[0];
            persona.cognome = vettAttributi[1];
            persona.numero = vettAttributi[2];
            if (vettAttributi[3].equals("true"))
                persona.visibilita = true;
            else
                persona.visibilita = false;
            persona.nVolte = Integer.parseInt(vettAttributi[4]);
            //salvo le informazioni nella rubrica e aumento il contatore
            rubrica[contaElementi++] = persona;
        }
        //ritorno il numero di contatti importati
        return contaElementi;
    }
    //vado a salvare sul file la rubrica attuale
    private static void scriviFile(Contatto[] rubrica, int nContatti, String fileName) throws IOException {
        FileWriter out = new FileWriter(fileName);
        //indice
        out.write("NOME; COGNOME; NUMERO; VISIBILITà; NUMERO CHIAMATE\r\n");
        //scrivo sul file
        for (int i = 0; i < nContatti;  i++){
            out.write(rubrica[i].toString()+"\r\n");
        }
        out.flush();
        out.close();
    }
    //imposto la password
    private static String inserisciPassword(Scanner keyboard) {
        String password;
        System.out.print("Inserisci una nuova password: ");
        password = keyboard.nextLine();
        System.out.println("Password impostata con successo.");
        //ritorno la stringa appena inserita
        return password;
    }


    private static Contatto leggiContatto(Scanner keyboard, Contatto[] rubrica, int nContatti) {
        Contatto contatto = new Contatto();
        boolean nomeP;
        boolean numeroP, numeroV;
        //faccio inserire da tastiera
        do {
            System.out.print("Inserisci il nome: ");
            contatto.nome = keyboard.nextLine();
            System.out.print("Inserisci il cognome: ");
            contatto.cognome = keyboard.nextLine();
            //controllo il nome non sia un doppione
            nomeP = controllaPresenzaNome(contatto.nome, contatto.cognome, nContatti, rubrica);
            if (nomeP)
                System.out.println("Nome e cognome già presenti nella rubrica.");
        }while (nomeP);

        do {
            System.out.print("Inserisci il numero di telefono: ");
            contatto.numero = keyboard.nextLine();
            //controllo non sia doppione
            numeroP = controllaPresenzaNumero(contatto.numero, nContatti, rubrica);
            //controllo sia composto da sole cifre e <= di 10
            numeroV = controllaIsNumber(contatto.numero);
            if (numeroP)
                System.out.println("Numero di telefono già presente nella rubrica.");
            else if (numeroV)
                System.out.println("Il numero inserito non è un numero");
        }while(numeroP && numeroV);

        System.out.print("Vuoi nascondere il contatto? (SI per nascondere, qualsiasi altra cosa per rendere visibile): ");
        String risposta = keyboard.nextLine().toUpperCase();
        if (risposta.equals("SI"))
            contatto.visibilita = false;
        else
            contatto.visibilita = true;

        return contatto;
    }

    //controllo se sia formato solo da numeri e che il numero delle cifre sia <= di 10
    private static boolean controllaIsNumber(String numero) {
        try {
            Integer.parseInt(numero);
            int lunghezza = numero.length();
            if (lunghezza <= 10)
                return true;
            else
                return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //controllo che nell'array non ci sia un altro contatto con lo stesso nome
    private static boolean controllaPresenzaNome(String nome, String cognome, int nContatti, Contatto[] rubrica) {
        for (int i = 0; i < nContatti; i++) {
            if (rubrica[i].nome.equals(nome) && rubrica[i].cognome.equals(cognome)) {
                return true;
            }
        }
        return false;
    }

    //controllo che nell'array non ci sia un altro contatto con lo stesso numero
    private static boolean controllaPresenzaNumero(String numero, int nContatti, Contatto[] rubrica) {
        for (int i = 0; i < nContatti; i++) {
            if (rubrica[i].numero.equals(numero)) {
                return true;
            }
        }
        return false;
    }

    //metodo per ordinare l'array secondo il nome dei contatti
    private static void ordinaRubrica(int nContatti, Contatto[] rubrica) {
        for (int i = 0; i < nContatti - 1; i++) {
            for (int j = 0; j < nContatti - 1 - i; j++) {
                if (rubrica[j].nome.compareTo(rubrica[j + 1].nome) > 0) {
                    Contatto temp = rubrica[j];
                    rubrica[j] = rubrica[j + 1];
                    rubrica[j + 1] = temp;
                }
            }
        }
    }

    //stampo i contatti
    private static void visualizzaContatti(int nContatti, Contatto[] rubrica, boolean visualizzaOscuri) {
        /*variabile per controllare se almeno uno è stato stampato (nel caso ci siano solo contatti nascosti,
        cosi anche se sono inseriti nella rubrica, verra stampato che non ci sono contatti
        cosi sono nascosti totalmente all'utente fino a quando non mette la password*/
        boolean stampato = false;
        for (int i = 0; i < nContatti; i++) {
            //controllo se la password è stata inserita o se il contatto è visibile
            if (visualizzaOscuri || rubrica[i].visibilita) {
                //è stato stampato almeno un contatto
                stampato = true;
                //stampo il contatto
                System.out.println(rubrica[i].stampa());
            }
        }
        //controllo sia stato stampato qualcosa
        if (!stampato)
            System.out.println("Non è stato inserito nessun contatto");
    }

    //nasconde o mostra i contatti nascosti
    private static boolean attivaPassword(Scanner keyboard, String password, boolean visualizzaOscuri) {
            //controllo la password sia corretta
            System.out.print("Inserisci la password: ");
            String tentativo = keyboard.nextLine();
            //se è giusta
            if (password.equals(tentativo)) {
                //cambio lo stato di visualizza oscuri
                visualizzaOscuri = !visualizzaOscuri;
                //comunico il nuovo stato
                if (visualizzaOscuri)
                    System.out.println("Modalità visualizzazione contatti oscuri: Attivata");
                else
                    System.out.println("Modalità visualizzazione contatti oscuri: Disattivata");
            }//se è sbagliata esco e dico che è sbagliata
            else {
                System.out.println("Password errata.");
            }
            //ritorno la variabile
            return visualizzaOscuri;
    }

    //ricerca di un contatto dato nome o numero, ritornando l'indice nell'array
    private static int ricercaContatto(Scanner keyboard, boolean visualizzaOscuri, int nContatti, Contatto[] rubrica) {
        System.out.print("Inserisci il nome o il numero da cercare: ");
        String ricerca = keyboard.nextLine();
        //controllo per tutta la rubrica se qualche contatto ha lo stesso nome o numero
        for (int i = 0; i < nContatti; i++) {
            if ((rubrica[i].nome.equalsIgnoreCase(ricerca) || rubrica[i].numero.equals(ricerca)) && (rubrica[i].visibilita || visualizzaOscuri)) {
                //ritorno la posizione
                return i;
            }
        }
        //se non è stato trovato ritorno -1
        return -1;
    }

    private static void modificaVisibilitaContatto(Scanner keyboard, Boolean visualizzaOscuri, int nContatti, Contatto[] rubrica) {
        int posRicerca = ricercaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
        if (posRicerca != -1) {
            //inverto lo stato di visibilità
            rubrica[posRicerca].visibilita = !rubrica[posRicerca].visibilita;
            System.out.println("Visibilità del contatto modificata.");
        }
        else
            System.out.println("Contatto non trovato.");
    }

    private static void cancellaContatto(Scanner keyboard, boolean visualizzaOscuri, int nContatti, Contatto[] rubrica) {
        int posRicerca = ricercaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
        if (posRicerca != -1) {
                //una volta trovato il contatto da cancellare sposto a sinistra tutti i contatti alla sua destra
                for (int j = posRicerca; j < nContatti - 1; j++) {
                    rubrica[j] = rubrica[j + 1];
                }
                System.out.println("Contatto cancellato.");
        }
        else
            System.out.println("Contatto non trovato.");
    }

    private static void chiamaContatto(Scanner keyboard, boolean visualizzaOscuri, int nContatti, Contatto[] rubrica) {
        int posRicerca = ricercaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
        if (posRicerca != -1) {
            //aumento il contatore
            rubrica[posRicerca].aumentaChiamate();
            System.out.println("Chiamata effettuata.");
        }
        else
            System.out.println("Contatto non trovato.");
    }

    private static void visualizzaChiamate(boolean visualizzaOscuri, int nContatti, Contatto[] rubrica) {
        boolean stampato = false;
        //stampa tutti i contatti che sono stati chiamati e che sono visibili
        for (int i = 0; i < nContatti; i++) {
            if (rubrica[i].nVolte > 0 && (visualizzaOscuri || rubrica[i].visibilita)) {
                stampato = true;
                System.out.println(rubrica[i].stampa());
            }
        }
        if (!stampato)
            System.out.println("Non è stato inserito nessun contatto");
    }
}
