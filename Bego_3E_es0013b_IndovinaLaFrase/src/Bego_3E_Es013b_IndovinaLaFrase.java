/*Realizzare un programma che,
utilizzando la strategia del vettore dei booleani,
permetta, data una stringa di valori alfabetici,
di stampare caratteri presenti e non presenti nella stringa.*/

//importazione librerie
import java.util.Scanner;
import java.lang.String;

public class Bego_3E_Es013b_IndovinaLaFrase
{
    public static void main (String[]args)
    {

        //dichiarazione variabili + creazione scanner
        Scanner tastiera = new Scanner (System.in);
        int scelta;
        String frase = "";
        boolean[] vettoreCaratteri = new boolean[26];
        boolean ordine = false;
        int carattere = 0;

        // creazione opzioni del menu
        String[] opzioni = { "=== CHE LETTERE COMPAIONO? === ",
                "[1] Inserisci la frase",
                "[2] Trova le lettere che compaiono",
                "[3] Scopri che lettere compaiono",
                "[4] Uscita"
        };

        //ciclo per impostare tutto il vettore bool a falso
        for (int i = 0; i < vettoreCaratteri.length; i++)
        {
            vettoreCaratteri[i] = false;
        }

        do
        {
            // Mostra il menu e ottieni la scelta dell'utente
            scelta = Menu(opzioni, tastiera);
            Wait (2000);

            switch (scelta)
            {
                case 1:
                    // Prendere in input la frase
                    frase = tastiera.nextLine().toLowerCase();
                    System.out.println ("\nInserisci la frase");
                    frase = tastiera.nextLine().toLowerCase();
                    Wait (2000);
                    break;

                case 2:


                    //Salvare nel vettore bool le lettere inserite

                    //condizione per rispettare l'ordine del programma
                   if (frase.equals(""))
                        System.out.println ("\nnon hai inserito nessuna frase");

                    else {
                       VetPresenti(frase, carattere, vettoreCaratteri);
                       ordine = true;    //condizione per rispettare l'ordine del programma
                   }
                    Wait (2000);
                    break;

                case 3:
                    // Stampare a schermo i risultati

                    //condizione per rispettare l'ordine del programma
                    if (frase.equals(""))
                        System.out.println ("\nnon hai inserito nessuna frase");
                    else if (!ordine)
                        System.
                                out.println ("\nnon hai controllato che lettere compaiono");
                    else
                    {
                        //stampare a schermo i risultati
                        System.out.println ("Compaiono:");
                        for (int i = 0; i < vettoreCaratteri.length; i++)
                        {
                            if (vettoreCaratteri[i])	// verificare nel vettore bool se e' true o false
                            {
                                char lettereCheCompaiono = (char) (i + 97);	//trasformare il valore da int a char tramite ASCII
                                System.out.println (lettereCheCompaiono);
                            }
                        }

                        System.out.println ("Non Compaiono:");
                        for (int i = 0; i < vettoreCaratteri.length; i++)
                        {
                            if (!vettoreCaratteri[i])	// verificare nel vettore bool se e' true o false
                            {
                                char lettereCheCompaiono = (char) (i + 97); //trasformare il valore da int a char tramite ASCII
                                System.out.println (lettereCheCompaiono);
                            }

                        }
                    }
                    Wait(2000);
                    break;

                case 4:
                    // Uscita dal gioco
                    break;



            }
        }
        while (scelta != 4); //condizione per il ciclo

        Wait(2000);
    }

    // Funzione per gestire il menu e ottenere la scelta dell'utente

    private static void VetPresenti(String frase, int carattere, boolean vettoreCaratteri[])
    {
        for (int i = 0; i < frase.length(); i++)
        {
            // Ottieni il carattere corrente
            carattere = frase.charAt(i);

            if (carattere<97 || carattere >122)
            {
                //controllo per non fare uscire di index il vettore
            }
            else
            {
                vettoreCaratteri[carattere - 97] = true;
            }
        }
    }
    private static int Menu(String[]opzioni, Scanner tastiera)
    {
        int scelta;

        do
        {
            ClrScr();
            System.out.println ("------------------");
            System.out.println (opzioni[0]);
            System.out.println ("------------------");
            for (int i = 1; i < opzioni.length; i++)
            {
                System.out.println (opzioni[i]);
            }
            scelta = tastiera.nextInt();

            // Controllo se la scelta C( valida
            if (scelta < 1 || scelta > opzioni.length - 1)
            {
                System.out.println ("Opzione Sbagliata");
                Wait (1000);
            }
        }
        while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }

    // Funzione per pulire la console
    private static void ClrScr()
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
            e.printStackTrace();
        }
    }
}