
public class Main {
    public static void main(String[] args)
    {
        Boolean vero = true; //posso utilizzare una serie di metodi, perchè è una reference
        boolean Vero = true; // non ho metodi integrati perchè è primitivo

        //le reference ci sono per tutte le variabili primitive
        double doppio;
        Double Doppio;

        Integer Numero;
        int numero;

        char carattere;
        Character Carattere;

        float fluttuante;
        Float Fluttuante;

        String laccio; //non è primitiva, solo reference

        System.out.println("\n");
        if(vero=Vero) {
            System.out.println("Confronto tra reference e primitivo");
            System.out.println("Reference = " + vero.toString());
        }

        char car = 'a';
        if (car >= 'a' && car<='z')
        {
            System.out.println("è un carattere");
        }
        else
            System.out.println("non è un carattere");


        car = Character.toUpperCase(car); //funzione reference su primitivo

        if(Character.isLetter(car))
        {
            System.out.println("è un carattere");
        }
        else
            System.out.println("non è un carattere");


        if(Character.isDigit(car))
        {
            System.out.println("è un NUMERO");
        }
        else
            System.out.println("non è un NUMERO");


        int valore1;
        Integer Valore1;
        String ggmmaaaa = "24022008";

        valore1 = Integer.parseInt(ggmmaaaa); //da stringa a int
        System.out.println("Valore GGMMAAAA: "+valore1);


        int valore2;
        valore2 = Integer.parseInt("1111", 2); //convertire una stringa binaria in numero
        System.out.println(valore2);

        //data to string

        String output;
        int data = 12122024;

        output = String.valueOf(data);
        System.out.println(data);

        output = Integer.toString(data);
        System.out.println(data);


        //String to int
        String carletto = "12345678";
        Integer Valore12 = Integer.parseInt(carletto);
        int valore22 = Integer.parseInt(carletto);
        System.out.println(Valore12);
        System.out.println(valore22);

        //binario/esadecimale to int
        valore22 = Integer.parseInt("1000101", 2);
        System.out.println(valore22);
        valore22 = Integer.parseInt("45", 16);
        System.out.println(valore22);

        //gestire gli errori = sollevare le eccezioni
        try //eseguire quello che si vuole controllare
        {
            valore22 = Integer.parseInt("a", 2);
            //se genera un eccezione si va su catch
        }
        catch (Exception x)
        {
            System.out.println("ERRORE FATALE");
        }

        /*
        //usare try-catch per far inserire un numero
        System.out.println("INSERISCI un valore intero: ");
        try //eseguire quello che si vuole controllare
        {

            //se genera un eccezione si va su catch
        }
        catch (Exception x)
        {
            System.out.println("ERRORE FATALE");
        }
        */
    }
}