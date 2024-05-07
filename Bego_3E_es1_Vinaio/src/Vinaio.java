/*consengna:
barbera in bottiglioni, 1 bottiglia ha capienza di 1.5L,
costo al litro: 1$, Iva: 21.

Output: nBottiglioni acquistati, prezzo senza iva, prezzo con iva*/

import java.util.Scanner;
public class Vinaio
    {

        public static void main(String[] args)
        {

            Scanner keyboard = new Scanner (System.in);

            int nBottiglie, nClienti = 0;
            double nL, prezzo, iva, prezzoTot = 0;
            final double capienza = 1.5, costoL = 1;
            String risposta;

            System.out.println("Benvenuto nel nostro negozio di vino");
            do
            {
                System.out.println("Quante bottiglie vuole acquistare");
                nBottiglie = keyboard.nextInt();


                while (nBottiglie < 0)
                {
                    System.out.println("Valore inserito non valido");
                    System.out.println("Quante bottiglie vuole acquistare");
                    nBottiglie = keyboard.nextInt();
                }

                nL = capienza*nBottiglie;
                prezzo = nL * costoL;
                iva = (prezzo*21)/100 + prezzo;
                prezzoTot = prezzoTot + iva;

                System.out.println("N bottiglie acquistate: " +nBottiglie);
                System.out.println("prezzo senza iva = \n " +nBottiglie +"x" +capienza +"x"+costoL +"= "+prezzo);
                System.out.println("prezzo con iva: " +iva);

                risposta = keyboard.nextLine().toUpperCase();
                System.out.println("Altro cliente? (S/N)");
                risposta = keyboard.nextLine().toUpperCase();

                nClienti = nClienti+1;
            }

            while (risposta.equals("S"));
            System.out.println("-----------------------------------");
           System.out.println("\nCassa Chiusa");
           System.out.println("Numero di clienti: "+nClienti);
           System.out.println("Spesa Totale: "+prezzoTot);
        }
    }

