/******************************************************************************
 -Inserire in vettore una sequenza di stringhe,
 stampare a video solamente quelle che iniziano con la lettera maiuscola.
 *******************************************************************************/
//importazione librerie
import java.util.Scanner;
import java.lang.String;

public class Bego_3E_Es014_LettereMaiuscole
{
    public static void main (String[]args)
    {

        //dichiarazione variabili + creazione scanner
        Scanner tastiera = new Scanner (System.in);
        int scelta;
        int dimensione = 0;
        boolean ordine = true;
        // creazione opzioni del menu
        String[] opzioni = { "=== LETTERE MAIUSCOLE === ",
                "[1] Inserisci la frase",
                "[2] Trova le parole maiuscole"
        };
        // Mostra il menu e ottieni la scelta dell'utente
        Menu (opzioni, tastiera);
        Wait (2000);

        // Prendere in input la quantitC  di string
        do
        {
            System.out.println ("\nQuante frasi vuoi inserire");
            dimensione = tastiera.nextInt ();
            if (dimensione <= 0)
                System.out.println ("\nValore non accettabile");
        }
        while (dimensione <= 0);	//controllo accettabilitC
        String[]frase = new String[dimensione];

        // inserimento frase
        for (int i = 0; i < frase.length; i++)
        {
            System.out.println ("Inserisci la parola" + (i + 1));
            frase[i] = tastiera.next ();
        }
        ordine = false;
        Wait (2000);

        //condizione per rispettare l'ordine del programma
        if (ordine)
            System.out.println ("\nnon hai inserito nessuna frase");
        else
        {
            //stampare a schermo i risultati
            System.out.println ("Iniziano con la maiuscola:");
            for (int i = 0; i < dimensione; i++)
            {
                if (frase[i].charAt (0) >= 65 && frase[i].charAt (0) <= 90)	//restituisce in output se la lettera iniziale C( compresa tra A e Z
                    System.out.println (frase[i]);
            }

            System.out.println ("Non iniziano con la maiuscola:");
            for (int i = 0; i < dimensione; i++)
            {
                if (frase[i].charAt (0) >= 97 && frase[i].charAt (0) <= 122)	//restituisce in output se la lettera iniziale C( compresa tra A e Z
                    System.out.println (frase[i]);
            }
        }
    }
    // Funzione per gestire il menu e ottenere la scelta dell'utente


    private static void Menu (String[]opzioni, Scanner tastiera)
    {
        int scelta;

        ClrScr ();
        System.out.println ("------------------");
        System.out.println (opzioni[0]);
        System.out.println ("------------------");
        for (int i = 1; i < opzioni.length; i++)
        {
            System.out.println (opzioni[i]);
        }
    }

    // Funzione per pulire la console
    private static void ClrScr ()
    {
        try
        {
            new ProcessBuilder ("cmd", "/c",
                    "cls").inheritIO ().start ().waitFor ();
        } catch (Exception e)
        {
            e.printStackTrace ();
        }
    }

    // Funzione per la pausa
    private static void Wait (int attesa)
    {
        try
        {
            Thread.sleep (attesa);
        } catch (InterruptedException e)
        {
            e.printStackTrace ();
        }
    }
}