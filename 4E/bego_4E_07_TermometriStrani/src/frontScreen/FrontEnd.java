package frontScreen;
import java.util.Scanner;
import static utility.Tools.*;
import ospedale.*;
public class FrontEnd {
    public Paziente creaPaziente (Scanner keyboard){

        Paziente output = new Paziente();

        System.out.println("Inserisci nome paziente: ");
        output.nome = keyboard.nextLine();

        System.out.println("Inserisci cognome paziente: ");
        output.cognome = keyboard.nextLine();

        System.out.println("Inserisci età paziente: ");
        output.eta = Integer.parseInt(keyboard.nextLine());

        //Inserimento Ospedale.Reparto
        Reparto[] reparti = Reparto.values();
        String[] menuReparti = new String[reparti.length + 1];
        menuReparti[0] = "Inserire Ospedale.Reparto";
        for (int i = 0; i < reparti.length; i++)
            menuReparti[i + 1] = reparti[i].toString();
        int genereIndex = Menu(menuReparti, keyboard) - 1;
        output.reparto = reparti[genereIndex];

        return output;
    }

}
