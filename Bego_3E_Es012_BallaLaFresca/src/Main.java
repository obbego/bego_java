import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        Random caso = new Random();
        int scelta=0;
        int [] nEstratti  = new int[5];
        int [] nG1  = new int[5];

        String [] opzioni = {"=== Gioco Dadi === ",
                "[1] Estrazioni ruota di Venezia",
                "[2] Giocata utente",
                "[3] Verifica vincita",
                "[4] Visualizza giocate"};

        /* Giocata utente: l'utente punta 5 numeri sulla ruota di Venezia
         * lista spesa: array di 5 elementi
         * controllo se valori inseriti sono compresi tra 1 e 90
         * controllo che un numero venga inserito una sola volta
         * controllo che vengano inseriti 5 valori, non di più non di meno
         * Visualizza giocate: lista della spesa
         * menu di scelta, opzioni2 (Venezia, Giocatore)*/

        scelta = Menu(opzioni, tastiera);
        Wait(5000);
        switch (scelta)
        {
            case 1:
            {
                for (int i = 0; i < nEstratti.length - 1; i++)
                {
                    nEstratti[i] = Estrazione(caso);
                }
            }

            case 2:
            {
                for (int i = 0; i < nG1.length - 1; i++)
                {
                    System.out.println("Inserisci il " +i + " numero");
                    nG1[i] = tastiera.nextInt();
                }
            }


            case 3:
            {
                VerificaVincita();
            }

        }
    }

    private static int Menu (String opzioni[], Scanner tastiera)
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
            scelta = tastiera.nextInt();

            if ((scelta < 1 ) || (scelta > opzioni.length -1 ))
            {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        }
        while ((scelta < 1 ) || (scelta > opzioni.length -1 ));

        return scelta;
    }
    private static int Estrazione (Random caso)
    {
            int estratto;
            estratto = caso.nextInt(0,90) + 1;
            return estratto;
    }
    private static int VerificaVincita (int i ; int nEstratti; int nG1)
    {
        if(nEstratti[i]==nG1[i])
    }

    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Wait(int attesa) {
        try{
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}