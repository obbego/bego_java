import java.util.Scanner;

public class Bego_3E_Es19_DataTryCatch {
    public static void main(String[] args) {
        int numero = 0;
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        String scelta;

        boolean dataNonValida = false;
        do {
            System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
            try {
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

        do {
            System.out.println("Vuole aumentare o diminuire la data?\n1. Aumentare\n2. Diminuire\n3. Continuare senza modifiche");
            scelta = scanner.next();
            switch (scelta) {
                case "1":
                    numero = aumentaData(numero, scanner);
                    break;
                case "2":
                    numero = diminuisciData(numero, scanner);
                    break;
                case "3":
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida, si prega di selezionare 1, 2 o 3.");
            }
        } while (continua);

        int[] dataSeparata = separazioneData(numero);
        if (!dataReale(dataSeparata))
        {
            System.out.println("La Data attuale: " + dataToString1(dataSeparata) + " non esiste");
        }
        else
            System.out.println("Data attuale: " + dataToString1(dataSeparata)+ " esiste");
    }

    private static int aumentaData(int numero, Scanner scanner) {
        int aumentoGiorno;
        do {
            System.out.println("Di quanti giorni vuole aumentare la data?");
            aumentoGiorno = scanner.nextInt();
            if (aumentoGiorno < 0){
                System.out.println("Non puoi aumentare con un numero negativo");
            }
        } while (aumentoGiorno < 0);

        int giorno = numero / 1000000;
        int mese = (numero % 1000000) / 10000;
        int anno = numero % 10000;

        giorno += aumentoGiorno;

        while (giorno > qtaGiorni(mese, anno)) {
            giorno -= qtaGiorni(mese, anno);
            mese++;
            if (mese > 12) {
                mese = 1;
                anno++;
            }
        }

        return giorno * 1000000 + mese * 10000 + anno;
    }

    private static boolean dataReale(int[] dataSeparata) {
        int giorno = dataSeparata[0];
        int mese = dataSeparata[1];
        int anno = dataSeparata[2];
        int qtaGiorni = qtaGiorni(mese, anno);

        return (giorno > 0 && giorno <= qtaGiorni);
    }

    private static int diminuisciData(int numero, Scanner scanner) {
        int diminuzioneGiorno;
        do {
            System.out.println("Di quanti giorni vuole diminuire la data?");
            diminuzioneGiorno = scanner.nextInt();
            if (diminuzioneGiorno < 0){
                System.out.println("Non puoi diminuire con un numero negativo");
            }
        } while (diminuzioneGiorno < 0);

        int giorno = numero / 1000000;
        int mese = (numero % 1000000) / 10000;
        int anno = numero % 10000;

        giorno -= diminuzioneGiorno;

        while (giorno <= 0) {
            mese--;
            if (mese <= 0) {
                mese = 12;
                anno--;
            }
            giorno += qtaGiorni(mese, anno);
        }

        return giorno * 1000000 + mese * 10000 + anno;
    }

    private static int qtaGiorni(int mese, int anno) {
        if (mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12) {
            return 31;
        } else if (mese == 4 || mese == 6 || mese == 9 || mese == 11) {
            return 30;
        } else if (mese == 2) {
            if ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return -1;
        }
    }


    private static int[] separazioneData(int data) {
        int[] output = new int[3];
        output[2] = data % 10000;
        data /= 10000;
        output[1] = data % 100;
        data /= 100;
        output[0] = data;
        return output;
    }

    private static String dataToString1(int[] data) {
        return String.format("%02d/%02d/%04d", data[0], data[1], data[2]);
    }

    private static boolean validadata(int numero){
        return (numero > 31129999 || numero < 1010001);
    }
}