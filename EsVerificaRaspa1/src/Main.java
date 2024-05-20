import static tools.utility.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int maxContatti = 20;
        Contatto[] rubrica = new Contatto[maxContatti];
        int nContatti = 0;
        boolean visualizzaOscuri = false, fine = true;
        String password = null;
        Scanner keyboard = new Scanner(System.in);
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
                "[9] Fine"
        };

        do {
            switch (menu(operazioni, keyboard)) {
                case 1:
                    if (nContatti >= maxContatti)
                        System.out.println("Rubrica piena. Impossibile aggiungere nuovi contatti.");
                    else {
                        rubrica[nContatti] = leggiContatto(keyboard, rubrica, nContatti);
                        ordinaRubrica(nContatti, rubrica);
                        nContatti++;
                    }
                    break;
                case 2:
                    visualizzaContatti(nContatti, rubrica, visualizzaOscuri);
                    break;
                case 3:
                    if (password == null){
                        password = inserisciPassword(keyboard, password);
                        operazioni[3] = "[3] INSERISCI password";
                    }
                    else
                        visualizzaOscuri = attivaPassword(keyboard, password, visualizzaOscuri);

                    break;
                case 4:
                    int posContatto = ricercaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
                    if (posContatto != -1)
                        System.out.println(rubrica[posContatto].stampa());
                    break;
                case 5:
                    modificaVisibilitaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
                    break;
                case 6:
                    cancellaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
                    break;
                case 7:
                    chiamaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
                    break;
                case 8:
                    visualizzaUltimeChiamate(visualizzaOscuri, nContatti, rubrica);
                    break;
                case 9:
                    fine = false;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        } while (fine);
    }

    private static String inserisciPassword(Scanner keyboard, String password) {
        System.out.print("Inserisci una nuova password: ");
        password = keyboard.nextLine();
        System.out.println("Password impostata con successo.");
        return password;
    }


    private static Contatto leggiContatto(Scanner keyboard, Contatto[] rubrica, int nContatti) {
        Contatto contatto = new Contatto();
        boolean nomeP;
        boolean numeroP;
        do {
            System.out.print("Inserisci il nome: ");
            contatto.nome = keyboard.nextLine();
            System.out.print("Inserisci il cognome: ");
            contatto.cognome = keyboard.nextLine();
            nomeP = controllaPresenzaNome(contatto.nome, contatto.cognome, nContatti, rubrica);
            if (nomeP)
                System.out.println("Nome e cognome già presenti nella rubrica.");
        }while (nomeP);

        do {
            System.out.print("Inserisci il numero di telefono: ");
            contatto.numero = keyboard.nextLine();
            numeroP = controllaPresenzaNumero(contatto.numero, nContatti, rubrica);
            if (numeroP)
                System.out.println("Numero di telefono già presente nella rubrica.");
        }while(numeroP);

        System.out.print("Vuoi nascondere il contatto? (SI per nascondere, qualsiasi altra cosa per rendere visibile): ");
        String risposta = keyboard.nextLine().toUpperCase();
        if (risposta.equals("SI"))
            contatto.visibilita = false;
        else
            contatto.visibilita = true;

        return contatto;
    }

    private static boolean controllaPresenzaNome(String nome, String cognome, int nContatti, Contatto[] rubrica) {
        for (int i = 0; i < nContatti; i++) {
            if (rubrica[i].nome.equals(nome) && rubrica[i].cognome.equals(cognome)) {
                return true;
            }
        }
        return false;
    }

    private static boolean controllaPresenzaNumero(String numero, int nContatti, Contatto[] rubrica) {
        for (int i = 0; i < nContatti; i++) {
            if (rubrica[i].numero.equals(numero)) {
                return true;
            }
        }
        return false;
    }

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

    private static void visualizzaContatti(int nContatti, Contatto[] rubrica, boolean visualizzaOscuri) {
        boolean stampato = false;
        for (int i = 0; i < nContatti; i++) {
            if (visualizzaOscuri || rubrica[i].visibilita) {
                stampato = true;
                System.out.println(rubrica[i].stampa());
            }
        }
        if (!stampato)
            System.out.println("Non è stato inserito nessun contatto");
    }

    private static boolean attivaPassword(Scanner keyboard, String password, boolean visualizzaOscuri) {
            System.out.print("Inserisci la password: ");
            String tentativo = keyboard.nextLine();
            if (password.equals(tentativo)) {
                visualizzaOscuri = !visualizzaOscuri;
                if (visualizzaOscuri)
                    System.out.println("Modalità visualizzazione contatti oscuri: Attivata");
                else
                    System.out.println("Modalità visualizzazione contatti oscuri: Disattivata");
            } else {
                System.out.println("Password errata.");
            }
            return visualizzaOscuri;
    }

    private static int ricercaContatto(Scanner keyboard, boolean visualizzaOscuri, int nContatti, Contatto[] rubrica) {
        System.out.print("Inserisci il nome o il numero da cercare: ");
        String ricerca = keyboard.nextLine();
        for (int i = 0; i < nContatti; i++) {
            if ((rubrica[i].nome.equalsIgnoreCase(ricerca) || rubrica[i].numero.equals(ricerca)) && (rubrica[i].visibilita || visualizzaOscuri)) {
                return i;
            }
        }
        System.out.println("Contatto non trovato.");
        return -1;
    }

    private static void modificaVisibilitaContatto(Scanner keyboard, Boolean visualizzaOscuri, int nContatti, Contatto[] rubrica) {
        int posRicerca = ricercaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
        if (posRicerca != -1) {
            rubrica[posRicerca].visibilita = !rubrica[posRicerca].visibilita;
            System.out.println("Visibilità del contatto modificata.");
        }
    }

    private static void cancellaContatto(Scanner keyboard, boolean visualizzaOscuri, int nContatti, Contatto[] rubrica) {
        int posRicerca = ricercaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
        if (posRicerca != -1) {
                for (int j = posRicerca; j < nContatti - 1; j++) {
                    rubrica[j] = rubrica[j + 1];
                }
                rubrica[--nContatti] = null;
                System.out.println("Contatto cancellato.");
        }
    }

    private static void chiamaContatto(Scanner keyboard, boolean visualizzaOscuri, int nContatti, Contatto[] rubrica) {
        int posRicerca = ricercaContatto(keyboard, visualizzaOscuri, nContatti, rubrica);
        if (posRicerca != -1) {
                rubrica[posRicerca].aumentaChiamate();
                System.out.println("Chiamata effettuata.");
        }
    }

    private static void visualizzaUltimeChiamate(boolean visualizzaOscuri, int nContatti, Contatto[] rubrica) {
        boolean stampato = false;
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
