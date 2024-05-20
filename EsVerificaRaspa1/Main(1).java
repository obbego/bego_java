/******************************************************************************
Realizzare il codice dell'esecizio fatto in verifca.

ES1: 
Progettare un software che permetta ad un utente di poter gestire la propria rubrica telefonica, permettendo, 
tramite l’inserimento di un’apposita password, di visualizzare anche eventuali contatti nascosti. 
Tramite un altro metodo appositamente progettato consenta di tornare alla situazione iniziale.
Attenzione: 
   Un singolo contatto nascosto può essere reso sempre visibile e viceversa.
   Occorrerà gestire la lista delle ultime chiamate, in modo che possa essere coerente con quanto sopra richiesto
   Scrivere il codice (java-like) di una parte saliente del software, motivandone la scelta.
*******************************************************************************/
import static tools.utility.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"RUBRICA TELEFONICA",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Imposta Password",
                "[4] Ricerca",
                "[5] Modifica visibilità contatto",
                "[6] Cancella Contatto",
                "[7] Chiama qualcuno",
                "[8] Visualizza ultime chiamate",
                "[9] Fine"};
        final int nMax = 20;
        int nContatti = 0, modContratto = 0, elimContratto = 0, sceltaRicerca, creditoContratto = 0;
        boolean visualizzaOscuri = false, fine = true; 
        String password;
        Contatto[] rubrica = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);
        do {
            switch (menu(operazioni, keyboard)) {
                case 1:

                    if (nContatti < nMax) {
                        //inserisco contatto
                        rubrica[contrattiVenduti]=leggiPersona(keyboard);
                        if(controllaPresenza(rubrica[contrattiVenduti], rubrica, nContatti)!=-1)
                            System.out.println("Il nome è gia usato nella rubrica, il "+(controllaPersona(gestore[contrattiVenduti], gestore, contrattiVenduti)+1)+" numero di contratto, \nRINSERIRE");
                        else
                            contrattiVenduti++;
                    }
                    else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;
                case 2: {
                    System.out.println("\n");
                    visualizza(gestore, contrattiVenduti);
                    System.out.println("\n");
                    break;
                }

                case 3: {
                    if (contrattiVenduti==0)
                        System.out.println("Nessun contratto è stato ancora firmato per oggi");
                    else {
                        do {
                            System.out.println("Vuole ricercare in base:\n[1]Nome \n[2]numero di contratto");
                            sceltaRicerca = keyboard.nextInt();
                            if (sceltaRicerca != 1 && sceltaRicerca != 2) {
                                System.out.println("L'opzione di scelta non esiste, RINSERIRE");
                            }
                        } while (sceltaRicerca != 1 && sceltaRicerca != 2);
                        svuotaBuffer = keyboard.nextLine();
                        System.out.println(ricercaContratto(sceltaRicerca, gestore, keyboard, contrattiVenduti));
                    }
                    break;
                }

                case 4: {
                    if (contrattiVenduti==0)
                        System.out.println("Nessun contratto è stato ancora firmato per oggi");
                    else{
                        do {
                            System.out.println("Quale contratto vuole modificare?\n Da 1 a " + contrattiVenduti);
                            modContratto = keyboard.nextInt() - 1;
                            if (modContratto < 0 || modContratto> contrattiVenduti-1)
                                System.out.println("Il numero di contratto inserito non esiste, RINSERIRE");
                        } while (modContratto < 0 || modContratto> contrattiVenduti-1);
                        svuotaBuffer = keyboard.nextLine();
                        gestore[modContratto]=leggiPersona(keyboard);}
                    break;
                }
                case 5:{
                    if (contrattiVenduti==0)
                        System.out.println("Nessun contratto è stato ancora firmato per oggi");
                    else {
                        do {
                            System.out.println("Quale contratto vuole Eliminare?\n Da 1 a " + contrattiVenduti);
                            elimContratto = keyboard.nextInt() - 1;
                            if (elimContratto < 0 || elimContratto > contrattiVenduti - 1)
                                System.out.println("Il numero di contratto inserito non esiste, RINSERIRE");
                        } while (elimContratto < 0 || elimContratto > contrattiVenduti - 1);
                        svuotaBuffer = keyboard.nextLine();
                        contrattiVenduti--;
                        gestore[elimContratto] = cancContratto(gestore, elimContratto);
                        spostaContratti(gestore, contrattiVenduti);
                        System.out.println("Contratto eliminato: \n");
                    }
                    break;
                }
                case 6:
                {
                    int opzioneCredito=0;
                    float soldi=0;
                    if (contrattiVenduti==0)
                        System.out.println("Nessun contratto è stato ancora firmato per oggi");
                    else{
                        do {
                            System.out.println("Di quale contratto vuole modificare il credito?\n Da 1 a " + contrattiVenduti + "\n Inserisci per uscire: " + (contrattiVenduti+1) );
                            creditoContratto = keyboard.nextInt() - 1;
                            if (creditoContratto == contrattiVenduti){
                               break;
                            }
                            if ((creditoContratto < 0 || creditoContratto > contrattiVenduti) || (gestore[creditoContratto].telefono == null))
                                System.out.println("Il numero di contratto inserito non è valido, RINSERIRE");
                        }while ((creditoContratto < 0 || creditoContratto > contrattiVenduti) || (gestore[creditoContratto].telefono == null));
                        if (creditoContratto == contrattiVenduti){
                            keyboard.next();
                            break;
                        }
                        else {
                            do {
                                System.out.println("Cosa vuole fare?\n[1] Aggiungere credito\n[2] Telefonare");
                                opzioneCredito = keyboard.nextInt();
                            } while (opzioneCredito != 1 && opzioneCredito != 2);
                            if (opzioneCredito == 1) {
                                do {
                                    System.out.println("Quanti soldi vuole aggiungere?");
                                    soldi = keyboard.nextFloat();
                                    if (soldi < 0)
                                        System.out.println("Non puoi aggiungere un numero negativo");
                                } while (soldi < 0);
                                svuotaBuffer = keyboard.nextLine();
                                gestore[creditoContratto].aumentaCredito(soldi);
                            } else {
                                do {
                                    System.out.println("Quanti soldi vuole togliere?");
                                    soldi = keyboard.nextFloat();
                                    if (soldi < 0)
                                        System.out.println("Non puoi sottrarre un numero negativo");
                                } while (soldi < 0);
                                svuotaBuffer = keyboard.nextLine();
                                gestore[creditoContratto].diminuisciCredito(soldi);
                            }
                        }
                    }
                    break;
                }
                case 7:
                {
                    String[] opzioniOrdinamento = {"ORDINAMENTO", "[1] bouble sort", "[2] selection sort", "[3] quick sort", "[4] uscire senza ordinare"};
                    switch (menu(opzioniOrdinamento, keyboard)){
                        case 1: {
                            System.out.println("BOUBLE:");
                            ordinaBouble(gestore);
                            visualizza(gestore, contrattiVenduti);
                            break;
                        }
                        case 2:{
                            System.out.println("SELECTION:");
                            ordinaSelection(gestore);
                            visualizza(gestore, contrattiVenduti);
                            break;
                        }
                        case 3:{
                            System.out.println("QUICK:");
                            ordinaQuick(gestore);
                            visualizza(gestore, contrattiVenduti);
                        }
                        default:{
                        break;    
                        }
                    }
                    break;
                }
                case 8:{
                    incasina(gestore, random);
                    visualizza(gestore, contrattiVenduti);
                    break;
                }
                case 9:{
                    //gestione delle eccezioni (errori di runtime)
                    try {
                        scriviFile(gestore, contrattiVenduti,"archivio.csv");
                    } catch (IOException e) {
                        System.out.println(e.toString());
                    }
                    break;
                }
                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    private static void scriviFile(Contatto[] gestore, int contrattiVenduti, String fileName) throws IOException {
        FileWriter out = new FileWriter(fileName);
        out.write("NOME; COGNOME; TELEFONO; TIPO; CREDITO\r\n");
        for (int i = 0; i < contrattiVenduti;  i++){
            out.write(gestore[i].toString()+"\r\n");
        }
        out.flush();
        out.close();
    }
    /*private static void incasina(Contatto[] gestore, Random random) {

        for (int i = 0; i < gestore.length; i++){
            Contatto temp;
            int posRandom = random.nextInt(i,4);
            temp = gestore[i];
            gestore[i] = gestore[posRandom];
            gestore[posRandom] = temp;
        }
    }*/

    private static void incasina(Contatto[] array, Random random) {
        for (int i = array.length - 1; i > 0; i--) {
            int posRandom = random.nextInt(i + 1); // Genera un numero casuale tra 0 e i incluso
            Contatto temp = array[i];
            array[i] = array[posRandom];
            array[posRandom] = temp;
        }
    }

    private static void ordinaQuick(Contatto[] gestore) {
    }

    private static void ordinaSelection(Contatto[] gestore) {
        Contatto temp;
        for (int i = 0; i < gestore.length; i++){
            int minimo = i;
            for (int j = i+1; j < gestore.length; j++){
                if (gestore[minimo].cognome.compareTo(gestore[j].cognome)>0){
                    minimo = j;
                }
            }
            temp = gestore[i];
            gestore[i] = gestore[minimo];
            gestore[minimo] = temp;
        }
    }

    private static void ordinaBouble(Contatto[] array) {
        int sentinellaSx = 0;
        int sentinellaDx = array.length-1;
        Contatto temp;
        while(sentinellaSx < sentinellaDx){

            for (int i = sentinellaSx; i < sentinellaDx; i++){
                if (array[i].cognome.compareTo(array[i+1].cognome) > 0){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            sentinellaDx--;

            for (int i = sentinellaDx; i > sentinellaSx; i--){
                if (array[i].cognome.compareTo(array[i+1].cognome) > 0){
                    temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp;
                }
            }
        }
    }


    private static void spostaContratti(Contatto[] gestore, int contrattiVenduti) {
        for (int i = 0; i < contrattiVenduti ;i++){
            if (gestore[i].nome == null && gestore[i].cognome == null && gestore[i].telefono == null && gestore[i].tipo == null) {
                for (int j = i; j < contrattiVenduti; j++){
                    gestore[j] = gestore [j+1];
                }
            }
        }
    }

    private static String ricercaContratto(int sceltaRicerca, Contatto[] gestore, Scanner keyboard, int contrattiVenduti) {
        int posizioneCercare, j=-1;

        if (sceltaRicerca==2){
            do {
                System.out.println("Inserisci la posizione da cercare:\n Da 1 a " + contrattiVenduti);
                posizioneCercare = keyboard.nextInt()-1;
            } while (posizioneCercare < 0 || posizioneCercare > contrattiVenduti-1);
            String svuotaBuffer = keyboard.nextLine();
            return gestore[posizioneCercare].stampa();
        }
        else {
            System.out.println("Inserisci il nome da cercare: ");
            String nomeCercare = keyboard.nextLine();
            System.out.println("Inserisci il cognome da cercare: ");
            String cognomeCercare = keyboard.nextLine();
            for(int i = 0; i < contrattiVenduti; i++){
                if(nomeCercare.equals(gestore[i].nome) && cognomeCercare.equals(gestore[i].cognome)){
                    j = i;
                    break;
                }
            }
            if (j != -1)
                return gestore[j].stampa();
            else
                return ("Non esiste nessun contatto con nome: " +nomeCercare);
        }

    }

    private static Contatto cancContratto(Contatto[] gestore, int elimContratto) {

        gestore[elimContratto].nome = null;
        gestore[elimContratto].cognome = null;
        gestore[elimContratto].telefono = null;
        gestore[elimContratto].tipo = null;
        return gestore [elimContratto];
    }


    private static int controllaPersona(Contatto contatto, Contatto[] gestore, int contrattiVenduti) {
        for(int i = 0; i < contrattiVenduti;i++)
        {
            if(contatto.nome.equals(gestore[i].nome) && contatto.cognome.equals(gestore[i].cognome))
                return i;
        }
        return -1;
    }

    private static void visualizza(Contatto [] gestore, int contrattiVenduti) {
        ClrScr();

        /* controllo se hanno
         * stipulato contratti */
        if (contrattiVenduti > 0) {
            for (int i = 0; i < contrattiVenduti; i++)
                System.out.println(gestore[i].stampa()); //stampo i contatti
        }
        /* altrimenti restituisco un
         * messaggio di errore */
        else
            System.out.println("Nessun contratto è stato ancora firmato per oggi");
    }
    private static Contatto leggiPersona(Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        boolean Sitel = false;
        String sceltaTel;
        String[] tipoC = {"Telefono","1]abitazione", "2]cellulare", "3]aziendale"};
        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();

        System.out.println("\nInserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();
        System.out.println("\nVuole inserire il numero di telefono?\nDIGITARE si O no");
        sceltaTel = keyboard.nextLine().toLowerCase();
        if (sceltaTel.equals("si")){
            Sitel = true;
        }
        if (Sitel) {
            System.out.println("\nInserisci il numero di telefono: ");
            persona.telefono = keyboard.nextLine();  //Vado a leggere il numero di telefono
            System.out.println("\n Inserisci il credito del numero di telefono: ");
            persona.credito = keyboard.nextFloat();
            keyboard.nextLine();
            //I valori assegnati all'attributo sono compresi nel range
            switch (menu(tipoC, keyboard)) {
                case 1 -> persona.tipo = tipoContratto.abitazione;
                case 2 -> persona.tipo = tipoContratto.cellulare;
                default -> persona.tipo = tipoContratto.aziendale;

            }
        }

        return persona;
    }
}