import java.util.Scanner;

import static utility.tools.*;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String[] opzioni = {
                "GESTIONE SOLIDI",
                "Inserisci una figura",
                "Visualizza i solidi inseriti",
                "Cerca che solido è",
                "esci"
        };
        boolean exit = true;

        do {
            switch (Menu(opzioni, keyboard)) {
                case 1: {
                    FrontEnd.leggiSolidi(keyboard);
                    break;
                }
                case 2: {
                    try {
                        GestoreSolidi.isEmpty();
                        FrontEnd.visualizzaSolidi();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    try {
                        GestoreSolidi.isEmpty();
                        System.out.println("Inserisci il numero del solido che vuoi esaminare\n Min 1: Max: " + GestoreSolidi.getCollezioneSolidi().size());
                        int pos = Integer.parseInt(keyboard.nextLine()) - 1;
                        String tipoSolido = FrontEnd.whatSolido(GestoreSolidi.getCollezioneSolidi().get(pos));
                        System.out.println("Il solido è una: " + tipoSolido);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                default: {
                    System.out.println("Esco dal ciclo");
                    exit = false;
                }
            }
        } while (exit);
    }
}
