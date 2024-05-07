import java.util.Scanner;
import java.util.Random;    //libreria per funzione random

public class Bego_3E_Es011_AppLotto {
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        int[] nEstratti = null;
        int [] nEstratti2= null;
        int scelta;
        boolean fine=true;

        do
        {
            Menu();
            scelta = keyboard.nextInt();
            ClrScr ();

            switch (scelta)
            {
                case 1:
                {
                   nEstratti2= nEstratti;
                    System.out.println("\nEstrazioni Venezia:");
                    aspetta(2000);
                    nEstratti = estraiNumeri();
                    break;
                }

                case 2:
                {
                    System.out.println("\nVisualizzazione Ruota Venezia:");
                    VisualizzaNumeri(nEstratti);
                    aspetta(2000);
                    break;
                }

                case 3:
                {
                    System.out.println("\nExit:");
                    fine=false;
                    aspetta(2000);
                    break;
                }
                default:
                {
                    System.out.println("\nValore non compreso");
                    aspetta(2000);
                    break;
                }
            }
        }
        while(fine);
    }

    private static void Menu() //creazione funzione aspettare
    {
        System.out.println("\n=== APP LOTTO ===");
        System.out.println("\n[1] Estrazioni Ruota Venezia:");
        System.out.println("\n[2] Visualizzazione Ruota Venezia:");
        System.out.println("\n[3] Exit:");
    }

    private static int [] estraiNumeri() //creazione funzione aspettare
    {
        Random casuale = new Random();
        int [] nEstratti  = new int[5];


        for(int i=0; i<nEstratti.length;i++)
        {
            nEstratti[i] = casuale.nextInt(1,90)+1;

            for (int j=0; j<i;j++)
            {
                while (nEstratti[i] == nEstratti[j])
                {
                    nEstratti[i] = casuale.nextInt(1,90)+1;
                    j=0;
                }
            }
        }
        return nEstratti;
    }

    private static void VisualizzaNumeri(nEstratti) //creazione funzione aspettare
    {
        for(int numero : nEstratti)
        {
            System.out.println(numero+"\n");
        }
    }
    private static void ClrScr () // creazione funzione ClrScr per cancellare lo schermo
    {
        try				//gestisce eccezioni  (Non fa interrompere i programmi)
        {
            new ProcessBuilder ("cmd", "/c", "cls").inheritIO ().start ().waitFor ();	//comandi dos da eseguire
        }
        catch (Exception e)		//gestisce eccezioni (Non fa interrompere i programmi)
        {
            e.printStackTrace ();
        }
    }
    private static void aspetta(int attesa) //creazione funzione aspettare
    {
        try
        {
            Thread.sleep( attesa); //"Blocca" l'esecuzione per il tempo indicato (millisecondi)
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}