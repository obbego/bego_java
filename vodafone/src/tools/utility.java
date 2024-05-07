package tools;

import java.util.Scanner;

public class utility {
    public static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void Wait(int x)
    {
        try{
            Thread.sleep(1000*x);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public static int menu(String[] opzioni, Scanner keyboard)
    {
        int scelta;

        do {
            ClrScr();
            System.out.println("=== "+opzioni[0]+" ===");
            for(int i=1;i<opzioni.length;i++)
            {
                System.out.println(opzioni[i]);
            }
            scelta = Integer.parseInt(keyboard.nextLine());
            if(scelta<1 || scelta>opzioni.length-1)
            {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        }while(scelta<1 || scelta>opzioni.length-1);

        return scelta;
    }
    /*private static Contatto leggiPersona(boolean Sitel, Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        String[] tipoC = {"Telefono","1]abitazione", "2]cellulare", "3]aziendale"};
        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();
        System.out.println("\nInserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();

        if (Sitel) {
            System.out.println("\nInserisci il numero di telefono: ");
            persona.telefono = keyboard.nextLine();  //Vado a leggere il numero di telefono
            //I valori assegnati all'attributo sono compresi nel range
            switch (menu(tipoC, keyboard)) {
                case 1 -> persona.tipo = tipoContratto.abitazione;
                case 2 -> persona.tipo = tipoContratto.cellulare;
                default -> persona.tipo = tipoContratto.aziendale;

            }
        }

        return persona;
    }*/
}
