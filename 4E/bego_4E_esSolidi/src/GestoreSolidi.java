import solidi.*;

import static utility.tools.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GestoreSolidi {
    private static ArrayList<Solido> collezioneSolidi = new ArrayList<Solido>();

    public static void addCollezioneSolidi(Solido solido) {
        collezioneSolidi.add(solido);
    }

    public static ArrayList<Solido> getCollezioneSolidi() {
        return collezioneSolidi;
    }

    public static void isEmpty() throws Exception {
        if (collezioneSolidi.isEmpty()) {
            throw new Exception("Non hai inserito nessun solido");
        }
    }
}
