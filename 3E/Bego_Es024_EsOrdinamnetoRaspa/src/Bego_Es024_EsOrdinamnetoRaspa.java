/* Consegnare il link GIT dei file dell'esercizio:

- Inserire i valori interi in un array
- Dare in output l'array ordinato secondo l'ordine: numeri dispari crescenti, numeri pari crescenti
- Dare in output l'array ordinato secondo l'ordine: numeri dispari crescenti, numeri pari crescenti, avendo cura di eliminare gli eventuali numeri ripetuti


Esempio:
array di partenza: {1,2,2,4,3,5,8,7,6,9}
array ordinato: {1,3,5,7,9,2,2,4,6,8}
array senza doppioni: {1,3,5,7,9,2,4,6,8}*/


public class Bego_Es024_EsOrdinamnetoRaspa {

    public static void main (String args[]) {
        //creo l'array con valori prestabiliti
        int numeri [] = {1,2,2,4,3,5,8,7,6,9,9};
        //creo un altro array (potevo usare sempre lo stesso ma per questione di comodità uso 3 diversi) su cui ordino l'array originale
        int []numeriOrdinati = ordina(numeri);
        //lo stampo a schermo
        stampa(numeriOrdinati);
        //creo un altro array dove copio quello ordinato senza doppioni
        int [] numeriDoppioni = togliDoppioni(numeriOrdinati);
        //lo stampo a schermo
        stampa(numeriDoppioni);
    }

    private static void stampa(int[] array) {
        //con un ciclo for stampo tutti i numeri
        System.out.println("\n");
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]+" ");
        }
    }

    private static int[] togliDoppioni(int[] array) {
        int contaN = 1; // inizializzo a 1 per includere il primo elemento
        //conto quanti numeri diversi ci sono nell'arr per vedere la dim
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] != array[i]) {
                contaN++;
            }
        }
        //creo un arr di quella dim
        int[] arrayDoppioni = new int[contaN];
        arrayDoppioni[0] = array[0]; // copio il primo elemento senza confronto

        int j = 1; // inizio da 1 poiché ho già copiato il primo elemento
        for (int i = 1; i < array.length; i++) {
            //se il numero sucessivo è diverso (dato che sono ordinati) lo copio nell'altro array
            if (array[i] != array[i - 1]) {
                arrayDoppioni[j] = array[i];
                j++;
            }
        }

        //mi faccio ritornare l'array appena ottenuto
        return arrayDoppioni;
    }

    public static int[] ordina ( int[] array) {
        //creo un array con la stessa dimensione di quello originale
        int[] arrayOrdinato = new int [array.length];
        //dichiarazione variabili
        int j = 0, contaDispari = 0, minimo = 0, temp = 0;

        //conto quanti dispari ci sono nell'array (sentinella) e li copio nelle prime posizioni dell'arr
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 1){
                arrayOrdinato[j] = array[i];
                j++;
                contaDispari++;
            }
        }

        //copio nelle restanti posizioni quelli pari
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                arrayOrdinato[j] = array[i];
                j++;
            }
        }

        //uso l'inserction sort per ordinarli
        for (int i = 0; i < contaDispari; i++){
            minimo = i;

            //trovo il minimo dei restanti numeri
            for (int k = i+1; k < contaDispari; k++){
                if (arrayOrdinato[k] < arrayOrdinato[minimo]){
                    minimo = k;
                }
            }
            //scambio il valore "più a sinistra" con il minimo trovato
            temp = arrayOrdinato[i];
            arrayOrdinato[i] = arrayOrdinato[minimo];
            arrayOrdinato[minimo] = temp;
        }

        //faccio lo stesso con i pari, partendo da dove ero arrivato con la sentinella
        for (int i = contaDispari; i < arrayOrdinato.length; i++){
            minimo = i;

            for (int k = i+1; k < arrayOrdinato.length; k++){
                if (arrayOrdinato[k] < arrayOrdinato[minimo]){
                    minimo = k;
                }
            }
            temp = arrayOrdinato[i];
            arrayOrdinato[i] = arrayOrdinato[minimo];
            arrayOrdinato[minimo] = temp;
        }

        //ritorno l'array che ho appena trovato
        return arrayOrdinato;
    }
}