import static tools.utility.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Modifica contratto esistente",
                "[5] Elimina contratto",
                "[6] Gestione credito",
                "[7] Fine"};
        //boolean Sitel=true;
        final int nMax = 3;
        int contrattiVenduti = 0, modContratto = 0, elimContratto = 0, sceltaRicerca, creditoContratto = 0;
        String svuotaBuffer;
        Contatto[] gestore = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);

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
                    visualizza(gestore, contrattiVenduti);
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
                            System.out.println("Di quale contratto vuole modificare il credito?\n Da 1 a " + contrattiVenduti);
                            creditoContratto = keyboard.nextInt() - 1;
                            if (creditoContratto < 0 || creditoContratto > contrattiVenduti - 1)
                                System.out.println("Il numero di contratto inserito non esiste, RINSERIRE");
                        }while (creditoContratto < 0 || creditoContratto > contrattiVenduti - 1);
                        do{
                            System.out.println("Cosa vuole fare?\n[1] Aggiungere credito\n[2] Telefonare");
                            opzioneCredito = keyboard.nextInt();
                        } while (opzioneCredito != 1 && opzioneCredito != 2);
                        if (opzioneCredito ==1){
                            do{
                                System.out.println("Quanti soldi vuole aggiungere?");
                                soldi = keyboard.nextFloat();
                                if (soldi < 0)
                                    System.out.println("Non puoi aggiungere un numero negativo");
                            } while (soldi < 0);
                            svuotaBuffer = keyboard.nextLine();
                            gestore[creditoContratto].aumentaCredito(soldi);
                        }
                        else
                        {
                            do{
                                System.out.println("Quanti soldi vuole togliere?");
                                soldi = keyboard.nextFloat();
                                if (soldi < 0)
                                    System.out.println("Non puoi sottrarre un numero negativo");
                            } while (soldi < 0);
                            svuotaBuffer = keyboard.nextLine();
                            gestore[creditoContratto].diminuisciCredito(soldi);
                        }
                    }
                    break;
                }
                default:
                    fine = false;
                    break;
            }
        } while (fine);
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
        System.out.println("Vuole inserire il numero di telefono?\nDIGITARE si O no");
        sceltaTel = keyboard.nextLine().toLowerCase();
        if (sceltaTel.equals("si")){
            Sitel = true;
        }
        if (Sitel) {
            System.out.println("\nInserisci il numero di telefono: ");
            persona.telefono = keyboard.nextLine();  //Vado a leggere il numero di telefono
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