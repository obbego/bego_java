package frontScreen;
import mensola.*;
import java.util.Scanner;
import static utility.Tools.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FrontEnd {
    public static Libro leggiLibro(Scanner keyboard){
        Libro output = new Libro();
        //Inserimento autore
        System.out.println("Inserisci l'autore: ");
        output.autore = keyboard.nextLine();
        //Inserimento titolo
        System.out.println("Inserisci il titolo: ");
        output.titolo = keyboard.nextLine();
        //Inserire numero di pagine
        System.out.println("Inserisci il numero di pagine: ");
        output.numeroPagine = Integer.parseInt(keyboard.nextLine());
        //Inserimento tipologia
        Genere[] generi = Genere.values();
        String[] menuData = new String[generi.length + 1];
        menuData[0] = "Inserire Genere";
        for(int i = 0; i < generi.length; i++)
            menuData[i + 1] = generi[i].toString();
        int genereIndex = Menu(menuData, keyboard) - 1;
        output.tipologia = generi[genereIndex];
        //Inserimento data
        System.out.println("Inserire data: ");
        String dataInput = keyboard.nextLine();


    }
}
