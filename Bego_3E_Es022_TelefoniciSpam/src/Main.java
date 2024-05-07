import static tools.utility.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Modifica contratto esistente",
                "[5] Fine"};
        //boolean Sitel=true;
        final int nMax = 3;
        int contrattiVenduti = 0, modContratto = 0;
        Contatto[] gestore = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);

        boolean fine = true;
        do {
            switch (menu(operazioni, keyboard)) {
                case 1:

                    if (contrattiVenduti < nMax) {
                        //firma contratto
                        gestore[contrattiVenduti]=leggiPersona(keyboard);
                        if(controllaPersona(gestore[contrattiVenduti], gestore, contrattiVenduti)>-1)
                        System.out.println("La persona ha gia un contratto, il "+controllaPersona(gestore[contrattiVenduti], gestore, contrattiVenduti)+" numero di contratto, \nRINSERIRE");
                        else
                            contrattiVenduti++;
                    }
                    else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;
                case 2: {
                    visualizza(gestore, contrattiVenduti);
                    break;
                }

                case 3: {
                    break;
                }

                case 4: {
                    System.out.println("Quale contratto vuole modificare?\n Da 1 a "+contrattiVenduti);
                    modContratto = keyboard.nextInt()-1;
                    gestore[modContratto]=leggiPersona(keyboard);
                    break;
                }
                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }


    private static int controllaPersona(Contatto contatto, Contatto[] gestore, int contrattiVenduti) {
        for(int i = 0; i < contrattiVenduti;i++)
        {
            if(contatto.nome.equals(gestore[i].nome) && contatto.cognome.equals(gestore[i].cognome))
                return i;
        }
        return -1;
    }

    private static void visualizza(Contatto [] gestore, int contrattiVenduti) {
        ClrScr();

        /* controllo se hanno
         * stipulato contratti */
        if (contrattiVenduti > 0) {
            for (int i = 0; i < contrattiVenduti; i++)
                System.out.println(gestore[i].stampa()); //stampo i contatti
        }
        /* altrimenti restituisco un
         * messaggio di errore */
        else
            System.out.println("Nessun contratto è stato ancora firmato per oggi");
    }
    private static Contatto leggiPersona(Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        boolean Sitel = false;
        String sceltaTel;
        String[] tipoC = {"Telefono","1]abitazione", "2]cellulare", "3]aziendale"};
        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();

        System.out.println("\nInserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();
        System.out.println("Vuole inserire il numero di telefono?\nDIGITARE si O no");
        sceltaTel = keyboard.nextLine().toLowerCase();
        if (sceltaTel.equals("si")){
            Sitel = true;
        }
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
    }
}