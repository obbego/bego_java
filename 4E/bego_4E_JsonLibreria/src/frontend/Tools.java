package frontend;

import backend.Libro;
import backend.manuale.Livello;
import backend.manuale.Manuale;
import backend.romanzo.Romanzo;
import backend.thriller.GenereThriller;
import backend.thriller.Thriller;

import java.util.ArrayList;
import java.util.Scanner;

public class Tools {
    /*public static void main(String[] args) {

    }*/
    private Tools() {
    }

    ; //impedisce di istanziare la classe

    public static void clrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
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
        } while ((scelta < 1) || (scelta > opzioni.length - 1));
        //tastiera.nextLine();
        return scelta;
    }

    public static Libro leggiLibro(Scanner tastiera, boolean soluzioni) {
        String[] sceltaGenere = {"GENERE", "ROMANZO", "MANUALE", "THRILLER", "GENERICO"};


        System.out.print("Inserisci l'autore del libro: ");
        String autore = tastiera.nextLine();
        System.out.print("Inserisci il titolo del libro: ");
        String titolo = tastiera.nextLine();
        System.out.print("Inserisci il numero di pagine del libro: ");
        int nPagine = Integer.parseInt(tastiera.nextLine());

        System.out.println("Inserisci il tipo del libro: ");
        switch (Menu(sceltaGenere, tastiera)) // visto che Menu parte da indice 1
        {
            case 1: {
                System.out.print("Inserisci il genere letterario del romanzo: ");
                String genereLetterario = tastiera.nextLine();
                return new Romanzo(autore, titolo, nPagine, genereLetterario);
            }
            case 2: {
                System.out.print("Inserisci l'argomento del manuale: ");
                String argomento = tastiera.nextLine();
                Livello livello = Manuale.getLivello(Menu(Manuale.getLivelliArrayString(), tastiera) - 1);
                return new Manuale(autore, titolo, nPagine, argomento, livello);
            }
            case 3: {
                GenereThriller genere = Thriller.getGenere(Menu(Thriller.getGeneriArrayString(), tastiera) - 1);
                return new Thriller(autore, titolo, nPagine, genere);
            }
            default:
                return new Libro(autore, titolo, nPagine);
        }
    }

    public static void visualizzaMensola(ArrayList<Libro> volumi) {
        for (Libro l : volumi) {
            clrScr();
            System.out.println(l.toString());
        }
    }
}