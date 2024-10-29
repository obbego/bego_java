package utility;

import java.util.Scanner;

public class Tools {
    /*public static void main(String[] args) {

    }*/
    private Tools() {
    } //impedisce di istanziare la classe

    public static void clrScr() {
        try {
            // Controllo su quale sistema operativo sono
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;

            // Se sono su Windows uso il comando cls
            if (os.contains("win")) {
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            }
            // Se sono su un sistema UNIX-like (Linux o macOS) e ho un console disponibile
            else if (System.console() != null) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                return; // Esco dalla funzione dopo aver pulito lo schermo
            }
            // Altrimenti uso clear
            else {
                processBuilder = new ProcessBuilder("clear");
            }

            // Eseguo il comando e aspetto che termini
            if (processBuilder != null) {
                processBuilder.inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace(); // Stampo l'errore
        }
    }

    public static void Wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int Menu(String opzioni[], Scanner tastiera) {// parametri formali
        int scelta;

        do {
            clrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println("[" + i + "]" + " " + opzioni[i]);
            }
            scelta = (Integer.parseInt(tastiera.nextLine()));
            //tastiera.nextLine();
            if ((scelta < 1) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        }
        while ((scelta < 1) || (scelta > opzioni.length - 1));
        //tastiera.nextLine();
        return scelta;
    }

}