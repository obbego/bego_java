import solidi.Cubo;
import solidi.Sfera;
import solidi.Solido;

import java.util.Scanner;

import static utility.tools.Menu;

public class FrontEnd {
    public static void leggiSolidi(Scanner keyboard) {
        String[] opzioniMenu = {
                "FORME DISPONIBILI",
                "Cubo",
                "Sfera"
        };

        switch (Menu(opzioniMenu, keyboard)) {
            case 1: {
                System.out.println("Inserisci il lato del cubo: ");
                double lato = Integer.parseInt(keyboard.nextLine());
                Cubo cubo = new Cubo(lato);
                GestoreSolidi.addCollezioneSolidi(cubo);
                break;
            }
            case 2: {
                System.out.println("Inserisci il raggio della sfera: ");
                double raggio = Integer.parseInt(keyboard.nextLine());
                Sfera sfera = new Sfera(raggio);
                GestoreSolidi.addCollezioneSolidi(sfera);
                break;
            }
        }
    }

    public static void visualizzaSolidi() throws Exception {
        for (Solido x : GestoreSolidi.getCollezioneSolidi()) {
            System.out.println(x.toString());
        }
    }

    public static String whatSolido(Solido solido) {
        if (solido instanceof Sfera) {
            return "Sfera";
        } else if (solido instanceof Cubo) {
            return "Cubo";
        } else
            return "Solido";
    }
}
