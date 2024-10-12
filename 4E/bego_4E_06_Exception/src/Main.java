import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        /*int[] arr = {1,2,3,4};
        for (int i = 0; i <= arr.length; i++){
            try{
                System.out.println(arr[i]);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Errore di compilazione");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Valori stampati");*/


        //inizializzazione variabili
        Scanner keyboard = new Scanner(System.in);
        /*int n1 = 0, n2 = 0;
        boolean acc;
        System.out.println("SOMMAA PAZZAA");
        //primo inserimento
        do {
            acc = false;
            System.out.println("Inserisci il primo numero: ");
            //controllo se il valore inserito va bene per un int
            try {
                n1 = Integer.parseInt(keyboard.nextLine());
            }
            catch (Exception e)
            {
                acc = true;
                System.out.println("Non hai inserito un valore accettabile");
                System.out.println(e.getMessage());
            }
        } while (acc);

        do {
            acc = false;
            System.out.println("Inserisci il secondo numero: ");
            try {
                n2 = Integer.parseInt(keyboard.nextLine());
            }
            catch (Exception e)
            {
                acc = true;
                System.out.println("Non hai inserito un valore accettabile");
                System.out.println(e.getMessage());
            }
        } while (acc);

        int somma = Somma(n1, n2);
        System.out.println("Somma: " + somma);*/

        boolean acc;
        do{
            acc = false;
            try
            {
                int num = gestInterger(keyboard);
            }catch (Exception e){
                acc = true;
                System.out.println(e.getMessage());
            }
        }while (acc);
    }

    private static int Somma(int n1, int n2) {
        return n1 + n2;
    }

    private static int gestInterger (Scanner keyboard) throws Exception{
        int n1 = 0;
        System.out.println("Inserire un valore: ");
        n1 = Integer.parseInt(keyboard.nextLine());
        if (n1 >= 0)
        {
            return n1;
        }
        else
        {
            throw new Exception("Valore non valido");
        }
    }
}