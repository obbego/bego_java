import ospedale.Paziente;
import java.util.ArrayList;
import java.util.Scanner;
import static utility.Tools.*;
import static frontScreen.FrontEnd.*;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Paziente> pazienti= new ArrayList<>();
        String[] opzioni = {
                "OSPEDALE DELLE MISURAZIONI",
                "Inserisci Ospedale.Paziente",
                "Misura temperatura Ospedale.Paziente"
        };
        switch (Menu(opzioni, keyboard)){
            case 1:
                pazienti.add(creaPaziente(keyboard));
        }
    }
}