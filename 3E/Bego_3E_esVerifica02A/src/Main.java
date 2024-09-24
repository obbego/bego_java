/*2- Scrivere un programma DueSequenze che lette da input due sequenze di
stringhe, ciascuna di 5 elementi, stampa il messaggio "OK" se almeno una stringa
della prima sequenza compare anche nella seconda, altrimenti stampa il messaggio
"NO".
Bonus: utilizzare un metodo per inserire i dati all’interno dei vettori di
stringhe e, nel caso in cui le due sequenze abbiano almeno una stringa in
comune, interrompere i confronti.
Es: risolto 7 con metodo e interruzione 8*/

//importazione librerie
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        //creazione strumento scanner
        Scanner tastiera = new Scanner(System.in);

        //dichiarazone e iniziallizzazione variabili
        boolean compaionoStringhe = false;

        //dichiarazione di 2 array di tipo string con 5
        String[] seq1 = new String[5];
        String[] seq2 = new String[5];

        //invocare metodo per popolare il vettore 1
        popolazione(seq1,tastiera);
        //invocare metodo per popolare il vettore 1
        popolazione(seq2,tastiera);
        //invocare il metodo per fare il controllo se compare la stessa stringa
        compaionoStringhe = controllo(seq1, seq2, compaionoStringhe);

        if(compaionoStringhe)
        {
            System.out.println("OK");
        }
        else
        {
            System.out.println("NO");
        }

    }

    //metodo per inserire i valori nell'array casuale
    private static void popolazione(String [] vettore, Scanner tastiera)
    {
        //popolazione vettore
        for (int i = 0; i<vettore.length; i++)
        {
            System.out.println("Inserisci il " + (i + 1) + " Stringa");
            vettore[i] = tastiera.nextLine();
        }
    }

    //metoto per controllare se le stringhe sono uguali
    private static boolean controllo(String [] vet1, String [] vet2, boolean compaionoNumeri) {
        //primo ciclo for per aumentare il contatore di vet1
        for (int i = 0; i <vet1.length; i++)
        {
            //primo ciclo for per aumentare il contatore di vet2
            for(int j=0; j < vet2.length; j++)
            {
                if (vet1[i].equals(vet2[j])) //controllo per vedere se la stringa è uguale
                {
                    compaionoNumeri=true; //rendere vera la variabile per il return:
                    break; //uscire subito dal 1 ciclo appena trovata la 1 coppia di stringhe
                }
            }
            //controllo per uscire dal 2 ciclo appena trovata la 1 coppia di stringhe
            if (compaionoNumeri)
                break;
        }
        return compaionoNumeri; //ritornare il valore bool compaionoNumeri
    }
}