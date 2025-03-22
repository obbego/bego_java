import frontEnd.FrontEnd;

import java.util.Scanner;

import static utility.Tools.menu;

public class Main {
    public static void main(String[] args) {
        FrontEnd catalogo = new FrontEnd();
        String[] opzioniMenu =
                {"NEGOZIO ELETTRONICA",
                        "Inserisci Smatphone",
                        "Rimuovere un prodotto",
                        "Cercare prodotto dal codice",
                        "Modifica prezzo prodotto",
                        "Visualizzare l'elenco completo dei prodotti",
                        "ESCI"};
        Scanner keyboard = new Scanner(System.in);
        boolean fine = true;

        do {
            switch (menu(opzioniMenu, keyboard)) {
                case 1: {
                    try {
                        catalogo.leggiSmartphone(keyboard);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    try {
                        catalogo.controllaSeVuoto();
                        catalogo.removeProdotto(catalogo.leggiCodiceProdotto(keyboard));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 3: {
                    try {
                        catalogo.controllaSeVuoto();
                        catalogo.ricercaProdotto(catalogo.leggiCodiceProdotto(keyboard));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    try {
                        catalogo.controllaSeVuoto();
                        catalogo.modificaPrezzo(catalogo.leggiCodiceProdotto(keyboard), catalogo.leggiPrezzoProdotto(keyboard));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 5: {
                    try {
                        catalogo.controllaSeVuoto();
                        catalogo.visualizzaProdotti();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 6: {
                    fine = false;
                    break;
                }
            }
        } while (fine);
    }
}