import static frontScreen.FrontEnd.*;
import static utility.Tools.*;
import mensola.*;

import java.util.EmptyStackException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        final  int MAX_LIBRI = 2;
        final String[] elenco = {
                "Libreria",
                "Inserisci Libro",
                "Visualizza libri inseriti",
                "Esci"
        };
        Libro[] scaffale = new Libro[MAX_LIBRI];
        int nLibri = 0;
        boolean fine = true, spazio;

        do{
            switch (Menu(elenco, keyboard))
            {
                case 1:

                    try{
                        spazio = controllaSpazio(nLibri, MAX_LIBRI);
                    }catch (Exception e){
                        System.out.println("Lo scaffale è pieno");
                        break;
                    }
                    scaffale[nLibri] = LeggiLibro(keyboard, nLibri, scaffale);
                    nLibri++;
                    break;
                case 2:
                    try {
                        visualizza(scaffale, nLibri);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    fine = false;
                    break;
            }
        }while(fine);
    }

    private static boolean controllaSpazio(int nLibri, int maxLibri) throws Exception{
        if (nLibri < maxLibri)
            return true;
        else
            throw new Exception("Scaffale pieno");
    }
}
