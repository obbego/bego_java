import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //dichiarazione variabili
        int[] arr = {1,2,3,4,5,6,7,7,8,8,8,8,8,10};
        Scanner keyboard = new Scanner(System.in);

        //stampa a schermo l'arr originale
        System.out.println("\nARR originale");
        visualizza(arr);

        //versione con inserimento dati da input
        /*
        //prendere in input il numero da cancellare
        System.out.println("Numero da cancellare: ");
        int num = Integer.parseInt(keyboard.nextLine());
        */
        //versione con inserimento definito
        int num = 8;

        //creare l'array
        int[]arr2 = EliminaNumeri(arr, num);
        //stampare a schermo la nuova versione
        System.out.println("ARR con numero: "+num+" eliminato");
        visualizza(arr2);

        //creare l'arr
        int[] arr3 = findAll(arr, num);
        //stampare arr3
        System.out.println("ARR contenente le riccorenze del numero: "+num);
        visualizza(arr3);

        /*arr3[0] = 1;
        codice per generare l'errore*/

        if(verificaPos(arr, arr3, num)){
            System.out.println("L'arr è stato verificato");
        }
        else{
            System.out.println("Ci sono stati degli errori");
            if (arr3 == null)
                System.out.println("Perche il vettore contenenti le posizioni è vuoto, \ndato che il numero cercato non è presente");
        }
    }

    //controllo se le posizioni trovate sono corrette
    private static boolean verificaPos(int[] arr, int[] arr3, int num) {
        //se l'arr3 è vuoto ritorno falso, dato che non lo posso confrontare
        if (arr3 == null)
            return false;

        for(int i = 0; i < arr3.length; i++){
            //se trovo anche solo un indirizzo sbagliato esco
            if (arr[arr3[i]] != num)
                return false;
        }
        //se tutto è andato bene ritorno vero
        return true;
    }

    //creo un arr con le ricorrenze di un numero nell'arr originale
    private static int[] findAll(int[] arr, int num) {
        //creo un arr con la dimensione delle volte che quel numero compare
        int nNumero = TrovaNumeri(arr, num), j = 0;
        int[] arr2 = new int[TrovaNumeri(arr, num)];

        //se non è stato trovato il numero ritorno null
        if (nNumero == 0){
            return null;
        }

        for (int i = 0; i < arr.length; i++){
            //se il numero in pos[i] è uguale a num mi salvo la posizionein arr2
            if(arr[i] == num) {
                arr2[j] = i;
                j++;
            }
        }
        //ritorno arr2
        return arr2;
    }

    //stampa tutti i numeri del vettore
    private static void visualizza(int[] arr) {
        if (arr == null)
            System.out.println("Il vettore è vuoto\n");
        else {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("\n");
        }
    }

    //restituisce l'arr senza i numeri
    private static int[] EliminaNumeri(int[] arr, int num)
    {
        //trovo quante volte compare il numero richiesto
        int nNumero = TrovaNumeri(arr, num), j = 0;
        int[] arr2 = new int[arr.length-nNumero];

        //se non è stato trovato il numero ritorno null
        if (nNumero == 0)
            return null;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != num){
                arr2[j] = arr[i];
                j++;
            }
        }
       return arr2;
    }

    //conto all'interno del ciclo quante volte compare il numero
    private static int TrovaNumeri(int[] arr, int num)
    {
        int nNumero = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]==num)
                nNumero++;
        }
        return nNumero;
    }


}