import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Nome giocatore 1: ");
        String nome1 = keyboard.nextLine();
        System.out.println("Nome giocatore 2: ");
        String nome2 = keyboard.nextLine();
        System.out.println("Quanti round si desidera effettuare: ");
        int nRound = Integer.parseInt(keyboard.nextLine());

        boolean avanzata = false;
        if (nRound >= 3) {
            System.out.println("Vuole effettuare una partita avanzata?\n S/N");
            if (keyboard.nextLine().equalsIgnoreCase("S")) {
                avanzata = true;
            }
        }

        Gara gara;
        if (avanzata) {
            gara = new GaraAvanzata(nome1, nome2, nRound);
        } else {
            gara = new Gara(nome1, nome2, nRound);
        }

        do {
            System.out.println(gara.StatoPartita());
            System.out.println(gara.giocaRound());
        } while (gara.StatoPartita().equals("In corso"));
        System.out.println(gara.Winner());
    }
}