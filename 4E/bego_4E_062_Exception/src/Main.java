import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int n1 = 0, n2 = 0;
        boolean acc;
        double divisione = 0;

        n1 = getNewValue(keyboard);
        n2 = getNewValue(keyboard);

        System.out.println("//////////////////////////////////////////");
        //senzaMetodo
        do{
            acc = false;
            try{
                if (n2 == 0){
                    throw new Exception("Non si puo dividere per 0");
                }
                else {
                    divisione = (double) n1 / (double) n2;
                }
                System.out.println("Senza-Metodo");
                System.out.println(divisione);
            }catch (Exception e){
                System.out.println(e.getMessage() + ": da metodo e.getMessage()");
                System.out.println("Non si può dividere per 0: da stringa");
                acc = true;
                System.out.println("--------------------------------------");
                System.out.println("INSERISCI NUOVI VALORI");
                n1 = getNewValue(keyboard);
                n2 = getNewValue(keyboard);
                System.out.println("--------------------------------------");
            }
        } while (acc);

        System.out.println("//////////////////////////////////////////");
        //conMetodo
           do {
               acc = false;
               try {
                   System.out.println("Con-Metodo");
                   divisione = dividi(n1, n2);
                   System.out.println(divisione);
               } catch (Exception e) {
                   System.out.println(e.getMessage() + ": da metodo e.getMessage()");
                   System.out.println("Non si può dividere per 0: da stringa");
                   acc = true;
                   System.out.println("--------------------------------------");
                   System.out.println("INSERISCI NUOVI VALORI");
                   n1 = getNewValue(keyboard);
                   n2 = getNewValue(keyboard);
                   System.out.println("--------------------------------------");
               }
           }while (acc);
    }

    private static int getNewValue(Scanner keyboard) {
        boolean acc;
        int n1 = 0;
        do {
            acc = false;
            System.out.println("Inserisci il numero: ");
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
        return n1;
    }

    /*private static double dividi(int n1, int n2)  {
        double n3 = 0;
        try {
            n3 = n1/n2;
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Non puoi dividere per 0");
        }
        return n3;
    }*/

    private static double dividi(int n1, int n2) throws Exception{
        if (n2 == 0){
            throw new Exception("Non si puo dividere per 0");
        }
        else {
            return (double)n1/(double)n2;
        }
    }
}