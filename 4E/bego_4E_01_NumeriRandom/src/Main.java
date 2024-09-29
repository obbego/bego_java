import static utility.Tools.*;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean fine=true;
        final int NMAX = 50;
        final int RANGERANDOM = 100;
        int [] numeri = new int[NMAX];
        //int numeri[] = null;
        //boolean[] numeriUsati = new boolean[RANGERANDOM];
        //RendiFalse(numeriUsati);
        int[] numeriUsati = new int[NMAX];
        String[] opzioni ={
                "Numeri Random",
                "Inserimento",
                "Visualizzazione",
                "Fine"
        };

        do {

            switch (Menu(opzioni, keyboard)){
                case 1:
                    /*
                    for (int i=0; i<NMAX; i++){
                        numeri[i] = casuale.nextInt(0,RANGERANDOM)+1;
                    }*/

                    //generaNumeri(numeri, RANGERANDOM,NMAX, numeriUsati);
                    numeri = generaNumeri2(RANGERANDOM,NMAX, numeriUsati);
                    break;
                case 2:
                    for(int i=0; i<NMAX; i++){
                        System.out.println(numeri[i]);
                    }
                    Wait(2000);
                    break;
                case 3:
                    fine = false;
                    break;
            }
        }while(fine);


        /*
        int numero;
        double numero2;
        boolean trovato;
        float numero3;
        String numero4;
        numero = keyboard.nextInt();
        numero2= keyboard.nextDouble();
        numero4= keyboard.nextLine();
        Integer numerow1;
        numerow1=Integer.parseInt(keyboard.nextLine());
        */

    }

    //iniziallizzare arr a falso
    /*private static void RendiFalse (boolean[] arr){
        for (int i = 0; i < arr.length; i++)
            arr[i] = false;
    }*/

    //metodo generanumeri
    //nel main devo istanziare il vettore
    //int []numeri = new int[10];
    /*private static void generaNumeri(int[] numeri, int RANGERANDOM, int NMAX, int[] numeriUsati){
        Random casuale = new Random();
        for (int i=0; i < NMAX; i++){
            do
                numeri[i] = casuale.nextInt(0,RANGERANDOM)+1;
            while(verificaPresenza(numeri[i], numeriUsati, i) != -1);
            //while(verificaPresenza(numeri[i], numeriUsati));
        }
    }*/


    //genera numeri 2
    private static int[] generaNumeri2(int RANGERANDOM, int NMAX, int[] numeriUsati){
        int [] numeri = new int[NMAX];
        Random casuale = new Random();
        for (int i=0; i < NMAX; i++){
            do
                numeri[i] = casuale.nextInt(0,RANGERANDOM)+1;
            while(verificaPresenza(numeri[i], numeriUsati, i) != -1);
            //while(verificaPresenza(numeri[i], numeriUsati));
            numeriUsati[i] = numeri[i];
        }
        return numeri;
    }

    private static int verificaPresenza(int num, int[] numeriUsati, int posNum)
    {
        for (int i = 0; i < posNum; i++){
            if (num == numeriUsati[i])
                return i;
        }
        return -1;
    }

    //controlla presenza del numero
    /*private static boolean verificaPresenza(int num, boolean[]numeriUsati) {
        if (numeriUsati[num-1] == true)
            return true;
        else{
            numeriUsati[num-1] = true;
            return false;
        }
    }*/

}