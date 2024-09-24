
/*Il gioco dei 21 fiammiferi è una gara tra due
giocatori che, a turno, possono prelevare,
dall’insieme iniziale dei 21 fiammiferi, da 1 a 3 fiammiferi.
Il gioco e vinto dal giocatore che preleva l’ultimo fiammifero.*/

//IMPORTAZIONE LIBRERIA SCANNER e RANDOM
import java.util.Scanner;
import java.util.Random;
//inizio classe
public class Bego_3E_es22_FiammiferiLudopatici {
    //inizio main
    public static void main(String[] args) {
        //creazione oggetto scanner e random
        Scanner tastiera = new Scanner(System.in);
        Random random = new Random();

        //dichiarazione altre variabili
        int scelta = 0, fiammiferiRimanenti = 21;

        //creare vettore conteneti opzioni menu
        String[] opzioni = {
                "Cosa vuoi fare",
                "[1] - Giocatore VS Giocatore",
                "[2] - Giocatore VS PC",
                "[3] - Giocatore VS PC arrabbiatissimosupermegafortissimopazzoimbattibilepefforza",
                "[4] - Quit"
        };
        //stampare a schermo il menu e salvarsi l'opzione scelta dall'utente
        scelta = printMenu(opzioni, tastiera);

        //switch che si basa sulla scelta dell'utente
        switch (scelta)
        {
            case 1: //giocatore contro giocatore
                /*passiamo fiammiferi rimanenti per sottrarre ad essi quelli presi,
                tastiera per prendere in input quelli inseriti da utente,
                random per la generazione casuale del pc scarso
                scelta per diversificare i casi e di conseguenza gli output e i metodi di riferimento*/
                sfidaGvsG(fiammiferiRimanenti, tastiera, random, scelta);
                break;
            case 2: //giocatore contro pc scarso
                sfidaGvsPc(fiammiferiRimanenti, tastiera, random, scelta);
                break;
            case 3: //giocatore contro pc fortissimo
                sfidaGvsPc(fiammiferiRimanenti, tastiera, random, scelta);
                break;
            default:
                System.out.println("ARRIVEDERCI");
                break;
        }
    }


    //metodo per far sfidare 2 giocatori
    private static void sfidaGvsG (int fiammiferiRimanenti, Scanner tastiera, Random random, int scelta) {

        //dichiarazione variabile contatore per dichiarare chi ha vinto, dato che i non si vede fuori dal ciclo
        int j=0;
        //ciclo for che funziona "come while" con un contatore che aumenta in automatico
        for (int i = 0; fiammiferiRimanenti > 3;i++)
        {
            //metodo che rimuove a fiammiferi rimanenti i fiammiferi presi
            fiammiferiRimanenti = prendiFiammiferi(fiammiferiRimanenti, i, tastiera, random, scelta);
            //stampare a schermo quanti fiammiferi rimangono
            System.out.println("\nRimangono "+ fiammiferiRimanenti+" Fiammiferi\n\n");
            //attribuire a j il valore finale di i (ultimo ciclo)
            j=i;
        }
        //controllo chi ha vinto in base al numero del turno
        if (j%2==0) {
            System.out.println("Ha vinto il giocatore 2");
        }
        else {
            System.out.println("Ha vinto il giocatore 1");
        }
    }

    private static void sfidaGvsPc(int fiammiferiRimanenti, Scanner tastiera, Random random, int scelta)
    {
        //dichiarazione variabile contatore per dichiarare chi ha vinto, dato che i non si vede fuori dal ciclo
        int j=0;
        //ciclo for che funziona "come while" con un contatore che aumenta in automatico
        for (int i = 0; fiammiferiRimanenti > 3 ;i++)
        {
            //metodo che rimuove a fiammiferi rimanenti i fiammiferi presi
            fiammiferiRimanenti = prendiFiammiferi(fiammiferiRimanenti, i, tastiera, random, scelta);
            //stampare a schermo quanti fiammiferi rimangono
            System.out.println("Rimangono "+ fiammiferiRimanenti+" Fiammiferi\n\n");
            //attribuire a j il valore finale di i (ultimo ciclo)
            j=i;
        }
        //controllo chi ha vinto in base al numero del turno
        if (j%2==0) {
            System.out.println("Ha vinto il PC");
        }
        else {
            System.out.println("Ha vinto il giocatore 1");
        }
    }

    //metodo per prendere i fiammiferi dai fiammiferi rimasti
    private static int prendiFiammiferi(int fiammiferiRimanenti, int i, Scanner tastiera, Random random, int scelta)
    {
        //inizializzazione variabile per indicare i fiammiferi presi
        int presi = 0;
        //ciclo per assicurarsi che vengano presi da 1 a 3 fiammiferi
        do {
            //guardare di chi è il turno per personalizzare l'output
            if (i % 2 == 0){
                System.out.println("G1 digita quanti fiammiferi vuoi prendere\n MIN 1 MAX 3");
                presi = tastiera.nextInt();
            }
            //guardare il tipo di scelta per personalizzare l'output
            else if (scelta == 1){
                System.out.println("G2 digita quanti fiammiferi vuoi prendere\n MIN 1 MAX 3");
                presi = tastiera.nextInt();
            }
            //guardare il tipo di scelta per personalizzare l'output
            else if (scelta == 2){
                //chiamare la funzione apposta per il pc scarso
                presi = fiammiferiPc(random);
                System.out.println("Il pc prende:"+ presi);
            }
            else{
                //chiamare la funzione apposta per il pc forte
                presi = fiammiferiPcArrabbiato(fiammiferiRimanenti);
                System.out.println("Il pc fortissimo prende:" + presi);
            }
            //comunicare l'errore (numero di fiammiferi presi non valido)
            if (presi>3 || presi<=0)
                System.out.println("Numero di fiammiferi presi non valido\nRINSERIRE");
        }while (presi>3 || presi<=0);//condizione di ripetizione ciclo
        //se il numero è accettabile ritornare i fiammiferi rimasti togliendo quelli appena presi
        return fiammiferiRimanenti-presi;
    }

    //metodo del pc arrabbiato per vincere sempre
    private static int fiammiferiPcArrabbiato(int fiammiferiRimanenti) {
        //controlla se il numero di fiammiferi rimasti -1 o -5 o -9 è divisibile per 4, per vincere sempre non lasciando all'altro l'opportunita di prendere gli ultimi 3
        if ((fiammiferiRimanenti - 1) % 4 == 0 || (fiammiferiRimanenti - 5) % 4 == 0 || (fiammiferiRimanenti - 9) % 4 == 0) {
            return 1;
        }
        //controlla se il numero di fiammiferi rimasti -2 o -6 o -10 è divisibile per 4, per vincere sempre non lasciando all'altro l'opportunita di prendere gli ultimi 3
        else if ((fiammiferiRimanenti - 2) % 4 == 0 || (fiammiferiRimanenti - 6) % 4 == 0 || (fiammiferiRimanenti - 10) % 4 == 0) {
            return 2;
        }
        else if (fiammiferiRimanenti % 4 == 0 && fiammiferiRimanenti>8){
            return 1;
        }
        //in qualsiasi altro caso prenderne 3
        else {
            return 3;
        }
    }

    //metodo del pc scarso
    private static int fiammiferiPc(Random random)
    {
        //prendi un numero casuale da 1 a 3
        return random.nextInt(1, 4);
    }

    //metodo per stampare il menu standard
    public static int printMenu (String[] opzioni, Scanner tastiera)
    {
        int scelta;

        do {
            ClrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i=1; i < opzioni.length; i++)
            {
                System.out.println(opzioni[i]);
            }

            scelta = Integer.parseInt(tastiera.nextLine());

            if ((scelta < 1 ) || (scelta > opzioni.length -1 ))
            {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        }
        while ((scelta < 1 ) || (scelta > opzioni.length -1 ));

        return scelta;
    }
    //metodo per cancellare lo schermo standard
    public static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //metodo per aspettare standard
    public static void Wait(int attesa) {
        try{
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
