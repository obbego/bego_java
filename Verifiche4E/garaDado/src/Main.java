//Francesco Bego

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        boolean reset;

        System.out.printf("Inserisci il nome del PRIMO giocatore: \n");
        String nG1 = keyboard.nextLine();
        Giocatore G1 = new Giocatore(nG1);

        System.out.printf("Inserisci il nome del SECONDO giocatore: \n");
        String nG2 = keyboard.nextLine();
        Giocatore G2 = new Giocatore(nG2);

        String[] giocatori = {
                "pareggio",
                G1.getNome(),
                G2.getNome()
        };

        do {
            reset = false;

            System.out.printf("Quanti round si desidera effettuare: \n");
            int nRound = Integer.valueOf(keyboard.nextLine());
            Gara gara = new Gara(nRound);

            int nFacce;
            do {
                System.out.printf("Quante facce ha il dado, min 3 max 20: \n");
                nFacce = Integer.valueOf(keyboard.nextLine());
            } while (nFacce < 3 || nFacce > 20);
            Dado dado = new Dado(nFacce);

            System.out.println("INIZIO ESTRAZIONE GARA CON: " + gara.getNRound() + " Lanci");
            System.out.println(gara.iniziaGara(dado, giocatori));

            System.out.println("----------------------");
            G1.setVittorieTotali(gara.getVittoreG1());
            System.out.println(G1.getVittorieFormat());
            G2.setVittorieTotali(gara.getVittoreG2());
            System.out.println(G2.getVittorieFormat());
            System.out.println("----------------------");


            System.out.println("Iniziare una nuova gara?\nDigitare <SI> per effettuare una altra gara, qualsiasi altra cosa per uscire");
            if (keyboard.nextLine().equals("SI")) {
                reset = true;
                gara.resetGame();
                System.out.println("----------------------");
            }
        } while (reset);
    }
}