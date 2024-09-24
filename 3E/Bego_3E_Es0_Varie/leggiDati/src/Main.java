import java.util.Scanner; //libreria sanner (per leggere dati)
public class Main
{
    public static void main(String[] args)
    {
        int datoInt; //dichiarazione variabile intera ( 4 Byte)
        byte datoByte; // (1 byte)
        double datoDouble;  // (8 byte)
        float datoFloat; // (4 byte)
        boolean datoBool = true; // ( 1 byte)
        char datoChar; //(2 byte)
        String datoString; // (oggetto di tipo classe) (per ogni carattere occupa 2 byte)

        Scanner keyboard = new Scanner(System.in); //creazione scanner

        System.out.println("Lettura dati  int in Java");
        datoInt = keyboard.nextInt(); //acquisizione variabile intera
        System.out.println("Dato intero 1: " +datoInt); //stampa a schermo dato


        System.out.println("\nLettura dati Byte in Java");
        datoByte = keyboard.nextByte(); //acquisizione variabile byte
        System.out.println("Dato Byte: " +datoByte); //stampa a schermo dato

        System.out.println("\nLettura dati double in Java");
        datoDouble = keyboard.nextDouble(); //acquisizione variabile double
        System.out.println("Dato double: " +datoDouble); //stampa a schermo dato

        System.out.println("\nLettura dati float in Java");
        datoFloat = keyboard.nextFloat(); //acquisizione variabile Float
        System.out.println("Dato Float: " +datoFloat); //stampa a schermo dato

        System.out.println("\nDato Boolean: " +datoBool); //stampa a schermo dato

        System.out.println("\nLettura dati Char in Java");
        datoChar = keyboard.next().charAt(0); //acquisizione variabile Char
        System.out.println("Dato Char: " +datoChar); //stampa a schermo dato

        System.out.println("\nLettura dati String in Java");
        datoString = keyboard.nextLine(); //acquisizione CLASSE String
        System.out.println("Dato String: " +datoString); //stampa a schermo dato
    }

}