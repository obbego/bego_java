/*Cancellazione di un elemento:
1-cercare un valore numerico e cancellarlo sostituendolo con uno zero.
2-cercare un valore numerico e cancellarlo sostituendolo con l'elemento che segue (ricompattare gli elementi).
Ordinare gli elementi con il metodo di selezione.*/
import static utility.tools.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random casuale = new Random();
        boolean fine = true;
        final int NMAX = 10;
        final int RANGERANDOM = 20;
        int[] numeri = null;
        int numeroRicercato=0, posNum;
        String[] opzioni = {
                "Numeri Random",
                "Inserimento",
                "Visualizzazione",
                "Ricerca di un numero",
                "Radoppia vettore",
                "Inserimento numero",
                "Cancellazione numero (0)",
                "Cancellazione e compattazione",
                "Ordinamento",
                "Fine"
        };

        do {
            switch (Menu(opzioni, keyboard)) {
                case 1:
                    //Genera numeri random senza ripetizione.
                    numeri = generaNumeriUnici(RANGERANDOM, NMAX);
                    break;
                case 2:
                    try{
                        visualizza(numeri);
                    }
                    catch (Exception e) {
                        System.out.println("Non hai ancora popolato il vettore");
                    }
                    break;
                case 3:
                    if (numeri != null)
                    {
                        System.out.println("Inserisci il numero che desideri ricercare all'interno del vettore");
                        numeroRicercato = keyboard.nextInt();
                        posNum = ricercaNumero(numeri, NMAX, numeroRicercato);
                        if (posNum == -1) {
                            System.out.println("Il numero che hai digitato non è presente all'interno dell'array");
                        } else {
                            System.out.println("Il numero che hai è presente all'interno dell'array e si trova in posizione:" + posNum + 1);
                        }
                    }
                    else
                    {
                        System.out.println("Non hai ancora popolato il vettore");
                    }
                    break;
                case 4:
                    try{
                        numeri= radoppiaVettore(numeri);
                    }
                    catch (Exception e) {
                        System.out.println("Non hai ancora popolato il vettore");
                    }

                    break;
                case 5:
                    /*System.out.println("Inserisci il numero che desideri ricercare all'interno del vettore");
                    numeroRicercato=Integer.parseInt(keyboard.nextLine()); */
                    try {
                        while (findZero(numeri) >= 0) {
                            numeroRicercato = casuale.nextInt(0, 200) + 1;
                            if (aggiungiElemento(numeri, numeroRicercato) >= 0) {
                                System.out.println("Inserimento riuscito");
                            } else {
                                System.out.println("Inserimento fallito");
                            }
                        }
                    }catch (Exception e){
                        System.out.println("Non hai ancora popolato il vettore");
                    }
                    break;
                case 6:
                    if (numeri != null) {
                        /*cancella numero e sostituiscilo con uno 0*/
                        System.out.println("Inserisci il numero che desideri ricercare all'interno del vettore");
                        numeroRicercato=Integer.parseInt(keyboard.nextLine());
                        try {
                            numeri[ricercaNumero(numeri, NMAX, numeroRicercato)] = 0;
                            System.out.println("Il numero è stato cancellato");
                        }
                        catch (Exception e){
                            System.out.println("Il numero inserito non è presente");
                        }
                    }
                    else
                        System.out.println("Non hai ancora popolato il vettore");
                    break;

                case 7:
                    /*cancella numero e compatta*/
                    if (numeri != null) {
                        System.out.println("Inserisci il numero che desideri ricercare all'interno del vettore");
                        numeroRicercato = Integer.parseInt(keyboard.nextLine());
                        posNum = ricercaNumero(numeri, NMAX, numeroRicercato);
                        if (posNum != -1) {
                            for (int i = posNum; i < numeri.length - 1; i++) {
                                numeri[i] = numeri[i + 1];
                            }
                            numeri[numeri.length - 1] = 0;
                            System.out.println("Il numero è stato cancellato");
                        } else
                            System.out.println("Il numero cercato non è stato trovato");
                    }
                    else
                        System.out.println("Non hai ancora popolato il vettore");
                    break;

                case 8:
                    try{
                        ordinamento(numeri);
                    }
                    catch (Exception e){
                        System.out.println("Non hai ancora popolato il vettore");
                    }
                    break;

                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    private static void ordinamento(int[] numeri) {
        // scorri ogni numero
        for (int i = 0; i < numeri.length - 1; i++) {
            if (numeri[i] != 0) {
                // trova l'indice del numero minore nella parte non ordinata
                int key = i;
                for (int j = i + 1; j < numeri.length; j++) {
                    if (numeri[j] < numeri[key] && numeri[j] != 0) {
                        key = j;  // aggiorna l'indice del numero minore
                    }
                }
                // scambia il numero trovato con il primo numero non ordinato
                if (key != i) {
                    int temp = numeri[i];
                    numeri[i] = numeri[key];
                    numeri[key] = temp;
                }
            }
        }
    }

    private static void generaNumeri(int[] numeri, int RANGERANDOM, int NMAX) {
        Random casuale = new Random();
        for (int i = 0; i < NMAX; i++) {
            numeri[i] = casuale.nextInt(0, RANGERANDOM) + 1;
        }
    }

    private static int[] generaNumeri2(int RANGERANDOM, int NMAX) {
        int[] numeri = new int[NMAX];
        Random casuale = new Random();
        for (int i = 0; i < NMAX; i++) {
            numeri[i] = casuale.nextInt(0, RANGERANDOM) + 1;
        }
        return numeri;
    }
    private static int [] radoppiaVettore(int [] numeri)
    {
        int newDim=2*numeri.length;
        int [] nuovoVettore=new int [newDim];
        for(int i=0; i<numeri.length;i++)
        {
            nuovoVettore[i]=numeri[i];
        }
        return nuovoVettore;
    }

    //metodo che inserisce il dato nella posizione mancante
    private static int aggiungiElemento(int [] numeri,int elementoInserito)
    {
        int inserito=-1;

        //gli passo la dimensione del nuovo vettore

        if(findZero(numeri)!=-1&&ricercaNumero(numeri,numeri.length,elementoInserito)==-1)
        {

            numeri[findZero(numeri)] = elementoInserito;
            inserito=0;
        }

        return inserito;
    }

    private static int findZero(int [] numeri){

        return ricercaNumero(numeri,numeri.length,0);


    }
    private static int[] generaNumeriUnici(int RangeRandom, int NMAX) {
        int[] numeri = new int[NMAX];
        Random casuale = new Random();

        for (int i = 0; i < NMAX; i++) {
            int nuovoNumero;
            boolean trovato;

            do {
                trovato = false;
                nuovoNumero = casuale.nextInt(RangeRandom) + 1;
                // da 0 a i-1 sono i numeri gia stati inseriti.
                for (int j = 0; j < i; j++) {
                    if (nuovoNumero == numeri[j]) {
                        trovato = true;
                        break;//esce dal ciclo for.
                    }
                }
            } while (trovato);//continua se trovato è true (perchè indica che ha trovato una ripetizione).

            numeri[i] = nuovoNumero;
        }

        return numeri;
    }
    //metodo ricerca: l'uente inserisce un numero, verifica se è presente e visualizzo la posizione in cui si trova(se è presente)
    private static int ricercaNumero(int[] numeri, int NMAX, int numeroRicercato) {
        // Ciclo per scorrere tutti gli elementi dell'array
        for (int i = 0; i < NMAX; i++) {
            if (numeri[i] == numeroRicercato) {
                // Se il numero è trovato, restituisci la sua posizione (indice)
                return i;

            }
        }
        // Se il numero non è trovato, restituisci -1
        return -1;
    }

    private static int[] generaNumeri3(int[] numeri, int RANGERANDOM, int NMAX) {
        numeri = new int[NMAX];
        Random casuale = new Random();
        for (int i = 0; i < NMAX; i++) {
            numeri[i] = casuale.nextInt(0, RANGERANDOM) + 1;
        }
        return numeri;
    }
    //Metodo
    private static void visualizza(int[] numeri) {
        int numRiga = 5;
        int contatore = 0;

        for (int numero : numeri) {
            System.out.print(numero + "\t"); // Stampa il numero e una tabulazione
            contatore++;

            // Se abbiamo stampato numRiga numeri, vai a capo
            if (contatore == numRiga) {
                contatore=0; //Azzerra il contatore, in maniera tale da creare un altra riga da 5 elementi
                System.out.println(); // Vai a capo
            }
        }
    }
}