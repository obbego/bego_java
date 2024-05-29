import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //costanti per dimensione arr + valore numeri
        final int nMax = 11, nMin = 10, vMax = 30, vMin = 1;
        //creazione oggetto scanner
        Scanner scanner = new Scanner(System.in);
        //per indicare la dimensione dell'array
        int dim = 0;
        //per indicare la presenza di doppioni
        boolean doppioni;

        //chiedere la dimensione fino a quando non viene inserito un valore accettabile
        do {
            System.out.println("Quanti numeri vuole inserire, max " + nMax + " min " + nMin);
            dim = scanner.nextInt();
            if (!(dim == nMin || dim == nMax))
                System.out.println("Dimensione errata, reinserire");
        } while (!(dim == nMin || dim == nMax));

        //creare l'array con dimensione appena inserita
        int[] arrOrig = new int[dim];
        //popolare l'array
        System.out.printf("Inserisci %d numeri. \nDevono essere compresi tra %d e %d senza ripetizioni (no doppioni)\n", dim, vMin, vMax);
        for (int i = 0; i < dim; i++) {
            do {
                System.out.println("Inserisci la " + (i + 1) + " cifra");
                arrOrig[i] = scanner.nextInt();
                //controllo la presenza di doppioni
                doppioni = controllaDoppioni(arrOrig, i);
                //controllo se il numero inserito rispetta l'intervallo e comunico l'errore
                if (arrOrig[i] < vMin || arrOrig[i] > vMax)
                    System.out.println("Il numero non rispetta i requisiti, max: "+ vMax+ " min: "+vMin);
                //se il numero inserito è un doppione e comunico l'errore
                else if (doppioni)
                    System.out.println("Il numero inserito è un doppione, è già stato inserito");
            } //ripeto l'inserimneto fino a quando il valore inserito non è accettabile
            while (arrOrig[i] < vMin || arrOrig[i] >= vMax || doppioni);
        }

        //stampo l'array prima delle modifiche
        System.out.println("ARRAY ORIGINALE: ");
        stampa(arrOrig);
        //creo un secondo array avente come dimensione il numero di pari, escludendo l'ultima cifra
        int[] arrPari = new int[trovaPari(arrOrig, arrOrig.length - 1)];
        //popolo array con i pari, escludendo l'ultima cifra
        inserisciPari(arrOrig, arrPari, arrOrig.length - 1);
        //ordino i pari
        ordina(arrPari);
        //li inserisco nell'array originale, escludendo l'ultima cifra
        merge(arrOrig, arrPari);
        //stampo il risultato
        System.out.println("ARRAY MODIFICATO: ");
        stampa(arrOrig);
    }

    //metodo per contare i numeri pari, escludendo l'ultima cifra
    public static int trovaPari(int[] arr, int length) {
        int contaPari = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] % 2 == 0)
                contaPari++;
        }
        return contaPari;
    }

    //metodo per inserire i numeri pari in un altro array, escludendo l'ultima cifra
    public static void inserisciPari(int[] arr, int[] arrPari, int length) {
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] % 2 == 0) {
                arrPari[j] = arr[i];
                j++;
            }
        }
    }

    //metodo per ordinare un array usando il selection sort
    public static void ordina(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            int minimo = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minimo]) {
                    minimo = j;
                }
            }
            temp = arr[minimo];
            arr[minimo] = arr[i];
            arr[i] = temp;
        }
    }

    //metodo per fondere i due array, escludendo l'ultima cifra
    public static void merge(int[] arr, int[] arrPari) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) { // escludo l'ultima cifra
            /*controllo se il numero che sto osserdavndo è pari, e nel caso lo
            sostituisco con il numero minore del'array ordinato pari*/
            if (arr[i] % 2 == 0) {
                arr[i] = arrPari[j];
                //aumento il contatore j per passare al numero sucessivo dell'array pari
                j++;
            }
        }
    }

    // Metodo per controllare i duplicati, escludendo l'ultima cifra
    public static boolean controllaDoppioni(int[] arr, int i) {
        for (int j = 0; j < i; j++) {
            if (arr[i] == arr[j]) {
                return true; // Trovato un duplicato
            }
        }
        return false; // Nessun duplicato trovato
    }

    // Metodo per stampare un array
    public static void stampa(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}