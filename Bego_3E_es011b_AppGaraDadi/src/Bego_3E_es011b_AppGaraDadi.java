/*consegna:
Modificare l'esercizio in modo da
inserire il menù visto in classe.
Eliminare eventuali ridondanze presenti all'interno dell'esercizio.
Apportare una miglioria "piacere" all'esercizio.
*/

//librerie
import java.util.Random;
import java.util.Scanner;

public class Bego_3E_es011b_AppGaraDadi  //creazione classe
{
    public static void main(String[] args)  //creazione main
    {
        Scanner tastiera = new Scanner(System.in);   //metodo costruttore

        //variabili
        int gara;
        int valoreFaccia1 = 0, valoreFaccia2 = 0, vincitore;
        boolean condizione = true;
        String giocatore1 = "";
        String giocatore2 = "computer";

        //array di stringhe che contiene un insieme di valori costanti
        String[] opzioni = {"=== APP Gara Dadi ===", "[1]-Sfida tra due giocatori", "[2]-Sfida contro il computer", "[3]-Fine" };

        do
        {
            gara = (Menu(opzioni, tastiera)); //assegnazione a gara la scelta del menu
            Wait(2000);

            if (gara==3)
            {
                break; // saltare il resto delle istruzioni
            }
            System.out.println("Inserisci il nome del primo giocatore: ");
            // nome g1

            giocatore1 = tastiera.nextLine();

            if (gara == 1)
            {
                System.out.println("Inserisci il nome del secondo giocatore: ");
                //nome g2
                giocatore2 = tastiera.nextLine();
            }

            Random faccia = new Random();

            //lancio dado g1
            System.out.println("Turno di " + giocatore1 + ":\n");
            valoreFaccia1 = Estrazione(faccia);
            Wait(2000);
            //lancio dado g2 o computer


            System.out.println("Turno di " + giocatore2 + ":\n");
            valoreFaccia2 = Estrazione(faccia);
            Wait(1000);

            //stampa a schermo vincitore
            vincitore = DeterminaVincitore(valoreFaccia1, valoreFaccia2);

            if (vincitore == 0)
            {
                System.out.println("Pareggio!");
            }
            else if (vincitore == 1)
            {
                System.out.println(giocatore1 + " vince!");
            }
            else if (vincitore == 2)
            {
                System.out.println(giocatore2 + " vince!");
            }

            //ristabilire nome giocatori
            giocatore1 = "";
            giocatore2 = "computer";
        }

        while (condizione); // condizione ripetere il ciclo
    }

    private static int Estrazione (Random faccia) // metodo unico per estrarre i dadi
    {
        int valoreFaccia = 0;
        for (int i = 1; i <= 7; i++)
        {
            if (i == 7)
            {
                Wait(500);
                ClrScr();
                System.out.println("E' uscito il numero: ");
                valoreFaccia = faccia.nextInt(6) + 1;
            }
            else
            {
                Wait(500);
                ClrScr();
                valoreFaccia = i;
            }

            FacceDado(valoreFaccia);
        }
        return valoreFaccia;
    }
    //metodo per stampare il menù e acquisire la scelta
    private static int Menu(String opzioni[], Scanner tastiera)
    {
        int scelta;

        do
        {
            ClrScr();

            // titolo
            System.out.println("-----------------------");
            System.out.println(opzioni[0]);
            System.out.println("-----------------------");
            // menù
            for (int i = 1; i < opzioni.length; i++)
            {
                System.out.println(opzioni[i]);

            }

            //acquisizione scelta
            scelta = tastiera.nextInt();

            //verifica scelta
            if ((scelta < 1) || (scelta > opzioni.length - 1))
            {
                System.out.println("Opzione sbagliata");
                Wait(1000);
            }

        } while ((scelta < 1) || (scelta > opzioni.length - 1));

        return scelta;
    }

    //metodo per cancellare lo schermo
    private static void ClrScr()
    {
        try
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    //metodo per fermare il programma
    private static void Wait(int attesa)
    {
        try
        {
            Thread.sleep(attesa);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    //metodo per stampare a schermo le facce del dado
    private static void FacceDado(int valoreFaccia)
    {
        switch (valoreFaccia)
        {
            case 1:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 2:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 3:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6:
            {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        }
    }

    //metodo per determinare il vincitore
    private static int DeterminaVincitore (int valoreFaccia1, int valoreFaccia2)
    {
        //caso di pareggio
        if (valoreFaccia1==valoreFaccia2)
        {
            return 0;
        }

        //caso in cui giocatore 1 vince
        else if (valoreFaccia1>valoreFaccia2)
        {
            return 1;
        }

        //caso in cui giocatore 2 vince
        {
            return 2;
        }

    }

} 