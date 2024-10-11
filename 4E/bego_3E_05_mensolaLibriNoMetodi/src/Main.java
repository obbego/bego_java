import static frontScreen.FrontEnd.*;
import static utility.Tools.*;
import mensola.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        final  int MAX_LIBRI = 20;
        final String[] elenco = {
                "Libreria",
                "Inserisci Libro",
                "Visualizza libri inseriti",
                "Esci"
        };
        Libro[] scaffale = new Libro[MAX_LIBRI];
        int nLibri = 0;
        boolean fine = true;

        do{
            switch (Menu(elenco, keyboard))
            {
                case 1:
                    if (nLibri < MAX_LIBRI)
                    {
                    scaffale[nLibri] = LeggiLibro(keyboard, nLibri, scaffale);
                    nLibri++;
                    }
                    else {
                        System.out.println("Lo scaffale è pieno");
                    }
                    break;
                case 2:
                    visualizza(scaffale, nLibri);
                    break;
                case 3:
                    fine = false;
                    break;
            }
        }while(fine);
    }
}