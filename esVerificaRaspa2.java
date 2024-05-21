import java.util.Scanner;

public class esVerificaRaspa2 {
    public static void main(String[] args) {
        final int min = 10, max = 11;
        Scanner scanner = new Scanner(System.in);
        int dim = 0;
        boolean doppioni;

        do {
            System.out.println("Quanti numeri vuole inserire, max " + max + " min " + min);
            dim = scanner.nextInt();
            if (!(dim == min || dim == max))
                System.out.println("Dimensione errata, reinserire");
        } while (!(dim == min || dim == max));

        int[] arrOrig = new int[dim];
        for (int i = 0; i < dim; i++) {
            do {
                System.out.println("Inserisci la " + (i + 1) + " cifra");
                arrOrig[i] = scanner.nextInt();
                doppioni = controllaDoppioni(arrOrig, i);
                if (arrOrig[i] < 0 || arrOrig[i] > 30 || doppioni)
                    System.out.println("Il numero non rispetta i requisiti o è un duplicato");
            } while (arrOrig[i] < 0 || arrOrig[i] > 30 || doppioni);
        }

        // stampo l'array prima delle modifiche
        System.out.println("ARRAY ORIGINALE: ");
        stampa(arrOrig);
        // Creo un secondo array avente come dimensione il numero di pari, escludendo l'ultima cifra
        int[] arrPari = new int[trovaPari(arrOrig, arrOrig.length - 1)];
        // Popolo array con i pari, escludendo l'ultima cifra
        inserisciPari(arrOrig, arrPari, arrOrig.length - 1);
        // Ordino i pari
        ordina(arrPari);
        // Li inserisco nell'array originale, escludendo l'ultima cifra
        merge(arrOrig, arrPari);
        // Stampo il risultato
         System.out.println("ARRAY MODIFICATO: ");
        stampa(arrOrig);
    }

    // Metodo per contare i numeri pari, escludendo l'ultima cifra
    public static int trovaPari(int[] arr, int length) {
        int contaPari = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] % 2 == 0) {
                contaPari++;
            }
        }
        return contaPari;
    }

    // Metodo per inserire i numeri pari in un altro array, escludendo l'ultima cifra
    public static void inserisciPari(int[] arr, int[] arrPari, int length) {
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] % 2 == 0) {
                arrPari[j] = arr[i];
                j++;
            }
        }
    }

    // Metodo per ordinare un array usando il selection sort
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

    // Metodo per fondere i due array, escludendo l'ultima cifra
    public static void merge(int[] arr, int[] arrPari) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) { // escludo l'ultima cifra
            if (arr[i] % 2 == 0) {
                arr[i] = arrPari[j];
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
