/*consengna:
vino bottiglioni, 1 bottiglia ha capienza di 1.5L, Iva: 21.
1-Barbera 1,5 Euro Litro
2-Lugana 2 Euro Litro
3-Merlot1Euro Litro.

Output: nBottiglioni acquistati, prezzo senza iva, prezzo con iva*/

import java.util.Scanner;

public class Vinaio
{


    public static void main (String[]args)
    {


        Scanner keyboard = new Scanner (System.in);


        int nBottiglie = 0, nClienti =0;

        double nL, prezzo, iva, prezzoTot = 0;

        final double capienza = 1.5, costoMerl = 1, costoBarb = 1.5, costoLug =5;

        String risposta, scelta;


        System.out.println ("Benvenuto nel nostro negozio di vino");

        do

        {

            System.out.
                    println
                            ("Che vino vuole aquistare?\nDigiti: \n BARBERA\n LUGANA \n MERLOT");

            scelta = keyboard.nextLine ().toUpperCase ();




            if (scelta.equals ("BARBERA"))

            {

                System.out.println ("Quante bottiglie vuole acquistare");

                nBottiglie = keyboard.nextInt ();



                while (nBottiglie < 0)

                {

                    System.out.println ("Valore inserito non valido");

                    System.out.println ("Quante bottiglie vuole acquistare");

                    nBottiglie = keyboard.nextInt ();

                }


                nL = capienza * nBottiglie;

                prezzo = nL * costoBarb;

                iva = (prezzo * 21) / 100 + prezzo;

                prezzoTot = prezzoTot + iva;


                System.out.println ("N bottiglie acquistate: " + nBottiglie);

                System.out.println ("prezzo senza iva = \n " + nBottiglie + "x" +
                        capienza + "x" + costoBarb + "= " + prezzo);

                System.out.println ("prezzo con iva: " + iva);


                nClienti = nClienti + 1;

            }


            else if (scelta.equals ("LUGANA"))

            {

                System.out.println ("Quante bottiglie vuole acquistare");

                nBottiglie = keyboard.nextInt ();



                while (nBottiglie < 0)

                {

                    System.out.println ("Valore inserito non valido");

                    System.out.println ("Quante bottiglie vuole acquistare");

                    nBottiglie = keyboard.nextInt ();

                }


                nL = capienza * nBottiglie;

                prezzo = nL * costoLug;

                iva = (prezzo * 21) / 100 + prezzo;

                prezzoTot = prezzoTot + iva;


                System.out.println ("N bottiglie acquistate: " + nBottiglie);

                System.out.println ("prezzo senza iva = \n " + nBottiglie + "x" +
                        capienza + "x" + costoLug + "= " + prezzo);

                System.out.println ("prezzo con iva: " + iva);


                nClienti = nClienti + 1;


            }


            else if (scelta.equals ("MERLOT"))

            {

                System.out.println ("Quante bottiglie vuole acquistare");

                nBottiglie = keyboard.nextInt ();



                while (nBottiglie < 0)

                {

                    System.out.println ("Valore inserito non valido");
                    ClrScr(); //pulisce lo schermo usando il metodo creato

                    System.out.println ("Quante bottiglie vuole acquistare");

                    nBottiglie = keyboard.nextInt ();

                }


                nL = capienza * nBottiglie;

                prezzo = nL * costoMerl;

                iva = (prezzo * 21) / 100 + prezzo;

                prezzoTot = prezzoTot + iva;


                System.out.println ("N bottiglie acquistate: " + nBottiglie);

                System.out.println ("prezzo senza iva = \n " + nBottiglie + "x" +
                        capienza + "x" + costoMerl + "= " + prezzo);

                System.out.println ("prezzo con iva: " + iva);


                nClienti = nClienti + 1;


            }



            else
            {
                System.out.println ("Nessn vino selezionato, digiti qualsiasi cosa per conferma");
            }


            risposta = keyboard.nextLine ().toUpperCase ();
            System.out.println ("Altro cliente? (S/N)");

            risposta = keyboard.nextLine ().toUpperCase ();


        }


        while (risposta.equals ("S"));

        System.out.println ("-----------------------------------");

        System.out.println ("\nCassa Chiusa");

        System.out.println ("Numero di clienti: " + nClienti);

        System.out.println ("Spesa Totale: " + prezzoTot);


    }
    //creazione metdo per cancellare schermo
    private static void ClrScr()
    {
        try //gestisce eccezioni  (Non fa interrompere i programmi)
        {
            new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor(); //comandi dos da eseguire
        }
        catch (Exception e) //gestisce eccezioni (Non fa interrompere i programmi)
        {
            e.printStackTrace();
        }
    }
}