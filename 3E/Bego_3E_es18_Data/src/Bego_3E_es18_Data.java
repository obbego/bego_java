//libreria
import java.util.Scanner;

public class Bego_3E_es18_Data
{
    public static void main(String[] args) //creazione metodo principale
    {
        //creazione scanner
        Scanner tastiera=new Scanner(System.in);

        //dichiarazione variabili
        int dataSingola;
        int[] dataCompleta; //array contenente in ogni slot di memoria un pezzo della data
        char scelta;

        do {
            //acquisizione del valore della data
            System.out.println("Inserire la data nel formato ggmmaaaa: \n(Senza spazi tra le lettere)\n");
            dataSingola = tastiera.nextInt();

            //verifica dati inseriti invocando il metodo per controllare i valori
            if(!verificaValiditaData(dataSingola))
            {
                System.out.println("Data non valida.\nFormato errato");
            }
            else
            {
                //invoca metodo per dividere la data in giorno, mese, anno
                dataCompleta=divisioneData(dataSingola);

                //invoca metodo per verificare la validità della data
                if(!validitaData(dataCompleta))
                {
                    System.out.println("Data non esistente");
                }
                else
                {
                    //stampa della data
                    stampa(dataCompleta);
                }
            }

            //richiesta di ripetizione del programma
            System.out.println("\nDesideri ripetere il programma?\nDigita S per confermare: ");
            scelta=tastiera.next().charAt(0);

        } while (scelta=='S' || scelta=='s'); //condizione di ripetizione 

    }//chiude main

    //creazione metodo che verifica la validità del valore intero che rappresenta la data
    private static boolean verificaValiditaData (int data)
    {
        //dichiarazione variabili locali
        boolean verifica;
        int cont=0;

        //dichiarazione costanti lunghezza 
        final int maxlength = 8;
        final int minlength = 7; //lunghezza minima 7 perchè se il giorno inizia con 0 non lo conta

        //verifica quante cifre sono presenti
        while(data!=0)
        {
            cont++;//incrementa variabile contatore
            data/=10;
        }

        //verifica validità del numero di cifre
        if(cont>=minlength && cont<=maxlength)
        {
            verifica=true;
        }
        else
        {
            verifica=false;
        }

        return verifica; //ritorno valore bool per indicare la validita
    }//chiude metodo verificaValiditaData

    //creazione metodo per dividere il numero intero in un array di 3 slot
    private static int [] divisioneData(int data)
    {
        //dichiarazione vettore per i valori di giorno, mese e anno
        int[] dataArray = new int[3];
        //dichiarazione boolean per associare l'anno
        boolean inserimentoAnno = true;

        //calcolo numero dell'anno
        dataArray[2] = (data % 10000);
        data /= 10000;

        //calcolo numero del mese
        dataArray[1] = (data % 100);
        data/= 100;

        //calcolo numero del giorno
        dataArray[0] = (data % 100);

        return dataArray; //ritorno vettore
    }//chiude metodo divisione

    //metodo per determinare il mese corrispondete in formato stringa
    private static String mese (int[] data)
    {
        //dichiarazione variabile per il mese corrispondente
        String meseString;

        //switch case che confronta le opzioni dei mesi e assegna a mese la stringa corrispondente
        int meseInt = data[1]; // Supponendo che data[1] sia l'indice del mese

        switch (meseInt) {
            case 1:
                meseString = "Gennaio";
                break;
            case 2:
                meseString = "Febbraio";
                break;
            case 3:
                meseString = "Marzo";
                break;
            case 4:
                meseString = "Aprile";
                break;
            case 5:
                meseString = "Maggio";
                break;
            case 6:
                meseString = "Giugno";
                break;
            case 7:
                meseString = "Luglio";
                break;
            case 8:
                meseString = "Agosto";
                break;
            case 9:
                meseString = "Settembre";
                break;
            case 10:
                meseString = "Ottobre";
                break;
            case 11:
                meseString = "Novembre";
                break;
            case 12:
                meseString = "Dicembre";
                break;
            default:
                meseString = "MESE NON VALIDO";
        }

        return meseString;
    }

    //metodo per stampare la data divisa
    private static void stampa(int[] dataArray)
    {
        System.out.println("\nData divisa:");
        System.out.println("Giorno: "+dataArray[0]);
        System.out.println("Mese (parola): "+mese(dataArray)+"\nMese (numero): "+ dataArray[1]);
        System.out.println("Anno: "+dataArray[2]);
    }

    // metodo per verificare se l'anno è bisestile
    private static boolean verificaBisestile(int[] dataDivisa)
    {
        //dichiarazione variabile di verifica
        boolean bisestile;

        /*condizione anno bisestile: deve essere divisibile per 4,
        se multiplo di 100, deve essere divisibile anche per 400 */
        if((dataDivisa[2] % 4 == 0 && dataDivisa[2] % 100 != 0) || dataDivisa[2] % 400 == 0)
        {
            bisestile=true;
        }
        else
        {
            bisestile=false;
        }

        return bisestile;
    }//chiude verificaBisestile

    //verifica della validità della data in base al giorno e al mese inserito
    private static boolean validitaData(int[] dataDivisa) {
        int giorni;
        boolean valida;

        // verifica le varie possibilità del numereo massimo di giorni in base al mese
        int mese = dataDivisa[1];
        if (mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12) {
            giorni = 31;
        } else if (mese == 4 || mese == 6 || mese == 9 || mese == 11) {
            giorni = 30;
        } else if (mese == 2) {
            if (verificaBisestile(dataDivisa)) // invoca metodo che controlla se l'anno è bisestile
                giorni = 29;
            else
                giorni = 28;
        } else {
            giorni = -1;
        }

        // verifica validità del numero dei giorni
        if (dataDivisa[0] > 0 && dataDivisa[0] <= giorni) {
            valida = true;
        } else {
            valida = false;
        }
        return valida;


        //private static String errori()
        // 1: out of range
        // 2: domain incorect
        // -1: corretto

        //private static String tipoErrori()
    }


}//chiude classe