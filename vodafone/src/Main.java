import static tools.utility.*;
import  java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Modifica contratto esistente",
                "[5] Elimina contratto",
                "[6] Chiama e Gestione credito",
                "[7] Ordinamento",
                "[8] Incasina tutto",
                "[9] Scrivi file",
                "[10] Seleziona File.csv",
                "[11] Fine"};
        //boolean Sitel=true;
        final int nMax = 3;
        int contrattiVenduti = 0, modContratto = 0, elimContratto = 0, sceltaRicerca, creditoContratto = 0;
        String svuotaBuffer;
        Contatto[] gestore = new Contatto[nMax];
        Chiamata[] registroChiamate = new Chiamata[];

        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        boolean fine = true;
        do {
            switch (menu(operazioni, keyboard)) {
                case 1:

                    if (contrattiVenduti < nMax) {
                        //firma contratto
                        gestore[contrattiVenduti]=leggiPersona(keyboard);
                        if(controllaPersona(gestore[contrattiVenduti], gestore, contrattiVenduti)!=-1)
                            System.out.println("La persona ha gia un contratto, il "+(controllaPersona(gestore[contrattiVenduti], gestore, contrattiVenduti)+1)+" numero di contratto, \nRINSERIRE");
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
                        int posRicerca = ricercaContratto(sceltaRicerca, gestore, keyboard, contrattiVenduti);
                        if (posRicerca != -1)
                            System.out.println(gestore[posRicerca].stampa());
                        else
                            System.out.println("Non esiste nessun contatto con quel nome");
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
                        System.out.println("SELEZIONARE CONTATTO DA CHIAMARE/MODIFICARE IL CREDITO");
                        do {
                            System.out.println("Vuole ricercare in base:\n[1]Nome \n[2]numero di contratto");
                            sceltaRicerca = keyboard.nextInt();
                            if (sceltaRicerca != 1 && sceltaRicerca != 2) {
                                System.out.println("L'opzione di scelta non esiste, RINSERIRE");
                            }
                        } while (sceltaRicerca != 1 && sceltaRicerca != 2);
                            svuotaBuffer = keyboard.nextLine();
                            creditoContratto = ricercaContratto(sceltaRicerca, gestore, keyboard, contrattiVenduti);
                        if (creditoContratto == contrattiVenduti){
                            keyboard.next();
                            break;
                        }
                        else {
                            do {
                                System.out.println("Cosa vuole fare?\n[1] Modificare credito\n[2] Telefonare");
                                opzioneCredito = keyboard.nextInt();
                            } while (opzioneCredito != 1 && opzioneCredito != 2);
                            if (opzioneCredito == 1) {
                                do {
                                    System.out.println("Cosa vuole fare?\n[1] Aggiungere credito\n[2] Togliere credito");
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
                                }
                                else {
                                    do {
                                        System.out.println("Quanti soldi vuole togliere?");
                                        soldi = keyboard.nextFloat();
                                        if (soldi < 0)
                                            System.out.println("Non puoi sottrarre un numero negativo");
                                    } while (soldi < 0);
                                    svuotaBuffer = keyboard.nextLine();
                                    gestore[creditoContratto].diminuisciCredito(soldi);
                                }
                            } else {
                               registroChiamate[]
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
                        String nomeFile;
                        boolean validitaNomeFile;
                        //do {
                            System.out.println("Inserire il nome del file: \nNON DEVE CONTENERE punti, l'estenzione .csv verrà aggiunta automaticamente");
                            nomeFile = keyboard.nextLine() + ".csv";
                            //validitaNomeFile = controllaNomeFIle(nomeFile);
                        //} while (validitaNomeFile);
                        scriviFile(gestore, contrattiVenduti, nomeFile);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                    }
                    break;
                }
                case 10:{
                    try {
                        contrattiVenduti = leggiFile("archivio.csv", gestore);
                    } catch (Exception e) {
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

   /*private static boolean controllaNomeFIle(String nomeFile) {
    }*/

    private static int leggiFile(String fileName, Contatto[] gestore) throws Exception {
        FileReader reader = new FileReader(fileName);
        Scanner input = new Scanner(reader);
        int contaElementi = 0;
        String lineIn;
        String[] vettAttributi;
        while (input.hasNextLine() && contaElementi < gestore.length) {
            lineIn = input.nextLine();
            vettAttributi = lineIn.split(";");
            Contatto persona = new Contatto();
            persona.nome = vettAttributi[0];
            persona.cognome = vettAttributi[1];
            if (vettAttributi.length > 2 && vettAttributi[2] != null) {
                persona.telefono = vettAttributi[2];
                persona.tipo = tipoContratto.valueOf(vettAttributi[3]);
                persona.credito = Float.parseFloat(vettAttributi[4]);
            }
            gestore[contaElementi++] = persona;
        }
        return contaElementi;
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
        quickSort(gestore, 0, gestore.length - 1);
    }

    private static void quickSort(Contatto[] array, int basso, int alto) {
        if (basso < alto) {
            int indicePartizione = partizione(array, basso, alto);
            quickSort(array, basso, indicePartizione - 1);
            quickSort(array, indicePartizione + 1, alto);
        }
    }

    private static int partizione(Contatto[] array, int basso, int alto) {
        Contatto pivot = array[alto];
        int i = (basso - 1); // indice dell'elemento più piccolo
        for (int j = basso; j < alto; j++) {
            if (array[j].cognome.compareTo(pivot.cognome) < 0) {
                i++;
                // scambia array[i] e array[j]
                Contatto temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // scambia array[i + 1] e array[alto] (o pivot)
        Contatto temp = array[i + 1];
        array[i + 1] = array[alto];
        array[alto] = temp;

        return i + 1;
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

    private static int ricercaContratto(int sceltaRicerca, Contatto[] gestore, Scanner keyboard, int contrattiVenduti) {
        int posizioneCercare, j=-1;

        if (sceltaRicerca==2){
            do {
                System.out.println("Inserisci la posizione da cercare:\n Da 1 a " + contrattiVenduti);
                posizioneCercare = keyboard.nextInt()-1;
            } while (posizioneCercare < 0 || posizioneCercare > contrattiVenduti-1);
            String svuotaBuffer = keyboard.nextLine();
            return posizioneCercare;
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
           return j;
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