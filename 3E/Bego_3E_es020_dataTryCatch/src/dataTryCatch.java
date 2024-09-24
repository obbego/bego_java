import java.util.Scanner;

public class dataTryCatch {
    public static void main(String[] args) {
        //declaration and initialization of variables/arrays

        int numero = 0;
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        String scelta;

        boolean dataNonValida = false;
        do{
            //output for enter the date
            System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
            //Check for non valid user input
            try {
                //insertion of the date
                numero = scanner.nextInt();
            } catch(Exception x) {
                System.out.println("Errore : il valore inserito non e' valido");
                dataNonValida = true;
                scanner.nextLine();
            }

            dataNonValida = validadata(numero);
            if(dataNonValida)
                System.out.println("DATA ERRATA");
        } while(dataNonValida);

        System.out.println("Vuole aumetare la data?\n Digiti SI per aumentare o qualsiasi altra cosa per andare avanti");
        scelta = scanner.nextLine().toUpperCase();
        scelta = scanner.nextLine().toUpperCase();

        if(scelta.equals("SI")){
            numero = uppperData(numero, scanner);
        }

        //Separare la data in giorno, mese, anno
        int[] dataSeparata = separazioneData(numero);

        System.out.println("Conversione stringa 1 : " + dataToString1(dataSeparata));
        System.out.println("Conversione stringa 2 : " + dataToString2(dataSeparata));
        System.out.println("Conversione stringa 3 : " + dataToString3(dataSeparata));
    }

    private static int uppperData(int numero, Scanner scanner)
    {
        int aumentoGiorno = 0;
        int aumentoAnno = 0;
        int aumentoMese = 0;

        do {
            System.out.println("Di quanti giorni vuole aumentare la data?");
            aumentoGiorno = scanner.nextInt();

            if (aumentoGiorno < 0){
                System.out.println("Non puoi aumentare con un numero negativo");
            }
        }
        while (aumentoGiorno < 0);
        while (aumentoGiorno >= 365)
        {
            aumentoAnno++;
            aumentoGiorno = aumentoGiorno - 365;
        }
        while (aumentoGiorno >= qtaGiorni(numero))
        {
            aumentoMese++;
            aumentoGiorno = aumentoGiorno -  qtaGiorni(numero);
        }

        numero = numero + (aumentoGiorno*1000000);
        numero = numero + (aumentoMese*10000);
        numero =numero + aumentoAnno;

        /*System.out.println("AUMENTI:");
        System.out.println(aumentoGiorno);
        System.out.println(aumentoMese);
        System.out.println(aumentoAnno);


        System.out.println("DATE:");
        System.out.println(numero);
        numero = numero + (aumentoGiorno*1000000);
        System.out.println(numero);
        numero = numero + (aumentoMese*10000);
        System.out.println(numero);
        numero =numero + aumentoAnno;
        System.out.println(numero);*/

        return numero;
    }
    private static int qtaGiorni(int numero) {
        // verifica le varie possibilità del numereo massimo di giorni in base al mese
        int mese = numero % 100;
        int giorni;

        if (mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12) {
            giorni = 31;
        } else if (mese == 4 || mese == 6 || mese == 9 || mese == 11) {
            giorni = 30;
        } else if (mese == 2) {
                giorni = 28;
        } else {
            giorni = -1;
        }
        return giorni;
    }
    /* Separazione della data inserita in giorno, mese ed anno*/
    //12042024
    //12
    //04
    //2024:
    //Si ottiene dal resto della divisione della data per 10000
    //12042024 / 10000 = 1204 Resto 2024
    //12042024 / 10000 = 1204 Salviamo il risultato dentro data
    //1204 / 100 = 12 Resto 04
    //1204 / 100 = 12 Salviamo il risultato dentro data
    private static int[] separazioneData (int data) {
        //Contiene il valore d'uscita
        int[] output = new int[3];

        //Anno
        output[2] = data % 10000;
        //Rimuovere l'anno dalla data
        data /= 10000;
        //Mese
        output[1] = data % 100;
        //Rimuovere il mese dalla data
        data /= 100;
        //Giorno
        output[0] = data;

        //Ritornare i valori separati
        return output;
    }

    private static String dataToString1(int[] data) {
        String output;

        output = String.valueOf(data[0]) + "/" + String.valueOf(data[1]) + "/" + String.valueOf(data[2]);

        return output;
    }

    private static String dataToString2(int[] data) {
        String output;

        output = Integer.toString(data[0]) + "/" + Integer.toString(data[1]) + "/" + Integer.toString(data[2]);

        return output;
    }

    private static String dataToString3(int[] data) {
        Integer boxing = data[0];
        String output = boxing.toString() + "/";

        boxing = data[1];
        output += boxing.toString() + "/";

        boxing = data[2];
        output += boxing.toString();

        return output;
    }



    //anno: 31129999
    //01010001
    private static boolean validadata(int numero){
        return (numero>31129999 || numero<1010001);
    }

    //private static int validata()
    //-1 : No error
    //1 : Out of range
    //2 : Domain incorrect
    /*private static int validaDataString(String numero){
        return 0;
    }

    private static String errore(int tipoErrore){

        return null;
    }*/
}