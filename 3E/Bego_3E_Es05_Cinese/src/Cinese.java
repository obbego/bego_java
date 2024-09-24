/*consegna:
Realizzare il programma della morra cinese.
In cui:
2 giocatori possono scegliere tra: sasso, carta e forbici.
Regole:
la carta vince sul sasso
il sasso vince sulle forbici
le forbici vincono sulla carta

Il gioco deve essere realizzato in modo che i
due giocatori si possano sfidare
utilizzando la tastiera.
Si suppone che per il primo giocatore sia
abilitato ad utilizzare i tasti
A = carta,S = sasso,D = forbici,
mentre per il secondo
J = carta,K = sasso,L = forbici.
La digitazione dei tasti non deve essere
visibile.

Specifiche di progetto:
- la gara C( valida solamente se i valori letti in input
appartengono all'insieme di validità  ;
- Il programma si deve ripetere finchè( uno dei due
giocatori non inserisce <X>;.

*/


import java.util.Scanner;

public class Cinese
{
    public static void main (String[]args)
    {
        Scanner scanner = new Scanner (System.in);

        //dichiarazione e inizializzazione delle variabili

        boolean gioca = true;
        char sceltaG1 = 0, sceltaG2 = 0;
        int winner;
        //stampa a video dei comandi
        System.out.println ("Benvenuto alla Morra Cinese!");
        System.out.println ("Giocatore 1: A = carta, S = sasso, D = forbici");
        System.out.println ("Giocatore 2: J = carta, K = sasso, L = forbici");
        System.out.println ("Premi 'X' per uscire.");

        while (gioca)
        {
            // Lettura dell'input del giocatore 1
            System.out.print ("\nGiocatore 1, inserisci la tua scelta (A/S/D): ");
            sceltaG1 = scanner.next ().toUpperCase ().charAt (0);
            ClrScr ();


            // Verifica se il giocatore 1 vuole giocare
            if (sceltaG1 == 'X')
            {
                System.out.print ("\nSei uscito dal gioco");
                gioca = false;
            }

            else
            {
                // Verifica se l'input del giocatore 1 valido
                while (sceltaG1 != 'A' && sceltaG1 != 'S' && sceltaG1 != 'D')
                {
                    System.out.println ("Input non valido. Riprova.");
                    sceltaG1 = scanner.next ().toUpperCase ().charAt (0);
                    ClrScr ();
                }
            }
            // Lettura dell'input del giocatore 2
            if (gioca)
            {
                System.out.
                        print ("\nGiocatore 2, inserisci la tua scelta (J/K/L): ");
                sceltaG2 = scanner.next ().toUpperCase ().charAt (0);
                ClrScr ();

                // Verifica se il giocatore 2 vuole giocare
                if (sceltaG2 == 'X')
                {
                    System.out.print ("\nSei uscito dal gioco");
                    gioca = false;
                }

                else
                {
                    // Verifica se l'input del giocatore 2 C( valido
                    while (sceltaG2 != 'J' && sceltaG2 != 'K' && sceltaG2 != 'L')
                    {
                        System.out.println ("Input non valido. Riprova.");
                        sceltaG2 = scanner.next ().toUpperCase ().charAt (0);
                        ClrScr ();
                    }
                }
            }
            if (gioca)
            {			// Determina il vincitore
                winner = determinaVincitore (sceltaG1, sceltaG2);

                // Mostra il risultato della partita
                if (winner == 0)
                {
                    System.out.println ("Pareggio!");
                }
                else if (winner == 1)
                {
                    System.out.println ("Giocatore 1 vince!");
                }
                else
                {
                    System.out.println ("Giocatore 2 vince!");
                }
            }

        }
    }

    private static int determinaVincitore (char sceltaG1, char sceltaG2)
    {
        if ((sceltaG1 == 'A' && sceltaG2 == 'J') ||
                (sceltaG1 == 'S' && sceltaG2 == 'L') ||
                (sceltaG1 == 'D' && sceltaG2 == 'L'))
        {
            return 0;		// Pareggio
        }
        else if ((sceltaG1 == 'A' && sceltaG2 == 'K') ||
                (sceltaG1 == 'S' && sceltaG2 == 'A') ||
                (sceltaG1 == 'D' && sceltaG2 == 'J'))
        {
            return 1;		// Giocatore 1 vince
        }
        else
        {
            return 2;		// Giocatore 2 vince
        }
    }

    private static void ClrScr ()
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
}