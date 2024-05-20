import java.util.Random;

public class ContaOperazioni {

    public static void main(String[] args) {
        //array conteneti le dimensioni dei vari array che andremo ad ordinare
        int[] dim = {10, 100, 1000, 10000, 100000, 1000000};
        //creazione random per popolare array
        Random random = new Random();

        //ciclo per ripetere le operazioni con tutte le dimensioni
        for (int length : dim) {
            //creo un array avente come dimensione una di quelle contenute in dim[]
            int[] array = new int[length];
            //popolo l'array usando random
            for (int i = 0; i < length; i++) {
                //do {
                    array[i] = random.nextInt(1000000);
                //} while (controllaPresenza(array, i));
                //evitando i doppioni ci metteva troppo ad eseguire il codice
            }

            //creo le copie dell'array
            int[] arrayBouble = copiaArray(array);
            int[] arraySelection = copiaArray(array);

            //do in output la dimensione con cui sto lavorando
            System.out.println("Array Dim: " + length);

            //ordino con il selction sort
            long selectionSortOperazioni = selectionSort(arraySelection);
            //do in output il numero di operazioni
            System.out.println("Selection Sort n di Operazioni: " + selectionSortOperazioni);

            //ordino con il bouble sort
            long bubbleSortOperazioni = bubbleSort(arrayBouble);
            System.out.println("Bubble Sort n di Operazioni: " + bubbleSortOperazioni);
            //spazio per distanziare i vari output
            System.out.println();
        }
    }

    //metodo per evitare la presenza di doppioni durante la popolazione dell'array
    /*private static boolean controllaPresenza(int[] array, int i) {
        for (int j = 0; j < i; j++){
            if (array[j] == array[i])
                return false;
        }
        return true;
    }*/

    //copio l'array in un altro array e lo ritorno
    public static int[] copiaArray(int[] array) {
        int[] copia = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copia[i] = array[i];
        }
        return copia;
    }

    //selection sort
    public static long selectionSort(int[] array) {
        long operazioni = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int indice = i;
            //trovo il numero minore dell'array
            for (int j = i + 1; j < array.length; j++) {
                operazioni++;
                if (array[j] < array[indice]) {
                    indice = j;
                }
            }

            //porto il numero minore a sinistra dell'array (
            int temp = array[indice];
            array[indice] = array[i];
            array[i] = temp;
            operazioni += 3; // +3 perchè sono avvenuti 3 scambi
        }
        //ritorno il numero di operazioni
        return operazioni;
    }

    //bouble sort
    public static long bubbleSort(int[] array) {
        long operazioni = 0;
        boolean scambio;
        for (int i = 0; i < array.length - 1; i++) {
            scambio = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                operazioni++;
                //controllo se il numero successivo è più piccolo, nel caso gli scambio
                if (array[j] > array[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    scambio = true;
                    operazioni += 3; // +3 perchè sono avvenuti 3 scambi
                }
            }
            //se non è avvenuto neanche uno scabio vuol dire che era gia ordinato
            if (!scambio) break;
        }
        //ritorno il numero di operazioni
        return operazioni;
    }
}
