/*1-Scrivere un programma TuttiPositiviPari che chiede all’utente di inserire una
sequenza di interi (chiedendo prima quanti numeri voglia inserire) e poi, al
termine dell’inserimento dell’intera sequenza all’interno di un array, stampa
"Tutti positivi e pari" se i numeri inseriti sono tutti positivi e pari,
altrimenti stampa "NO".
Bonus: utilizzare un metodo per determinare se il vettore contiene tutti
Positivi e Pari.
Es: risolto 6 con metodo 7*/

//importazione librerie
import java.util.Scanner;
public class Bego_3E_EsVerifica01_TuttiPositiviPari {
    public static void main(String[] args)
    {
        //creazione oggetto scanner
        Scanner tastiera = new Scanner(System.in);
        //dichiarazione variabili
        int vetLenght=0;
        do {
            //chiedere in input la dimensione dell'array
            System.out.println("Quanti numeri vuoi inserire: ");
            vetLenght = tastiera.nextInt();
            if(vetLenght<=0)
            {
                System.out.println("Numero <=0, impossibile procedere\nRinserire valore\n\n");
            }
        }
        while (vetLenght<=0)

        //popolazione vettore
        int [] vetNumeri = popolazione(vetLenght, tastiera);

        //controllo tuttiPositiviPari
        boolean controllo = tuttiPositiviPari(vetNumeri);

        //stampa dei risultati
        if(controllo)
            System.out.println("Tutti i numeri inseriti sono pari e positivi");
        else
            System.out.println("NO");
    }

    //metodo per controllare i numeri siano positivi o pari
    private static boolean tuttiPositiviPari(int [] vetNumeri)
    {
        boolean controllo = true;
        //ciclo per controllare tutti i numeri dell'array
        for (int i = 0; i < vetNumeri.length; i++)
        {
           //condizione di uscita dal ciclo
            if ((vetNumeri[i] < 0) || (((vetNumeri[i]) % 2) == 1))
                //CORREZIONE VERIFICA: usare operatori logici
            {
                controllo = false;
                break;
            }
        }
        return controllo;
    }
    //metodo per popolare il vettore
    private static int[] popolazione(int vetLenght, Scanner tastiera) {
    //CORREZZIONE VERIFICA: passare la lunghezza dell'array e creare l'array nel metodo
        int [] numeri  = new int[vetLenght] ;
        //popolazione vettore
        for (int i = 0; i<vetLenght; i++) {
            System.out.println("Inserisci il " + (i + 1) + " numero");
            numeri[i] = tastiera.nextInt();
        }
        //ritornare il vettore
        return numeri;
    }
}