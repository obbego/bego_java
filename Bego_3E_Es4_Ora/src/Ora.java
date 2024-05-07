/*Inserire un numero intero che rappresenta i secondi trascorsi dall’inizio di oggi e mostra in
uscita l’ora attuale espressa in hh:mm:ss (ore:minuti:secondi).
Se l’utente inserisce un valore nullo o un valore superiore ad un giorno chiedere il
reinserimento.
Esempio 1:
102(secondi) = 0(ore):1(minuto):42(secondi);
Esempio 2:
6662(secondi) = 1(ora):51(minuti):2(secondi)*/

import java.util.Scanner; //import libreria per leggere i dati
public class Ora
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in); //creazione oggetto scanner
        int secondi=0, minuti=0, ore=0, numero=0; //dichiarazione variabili

        System.out.println("Inserisci il numero che rappresenta i secondi trascorsi"); //input dati
        secondi = keyboard.nextInt(); //asscociazione dati
        numero = secondi;
        while (numero>86400 || numero<=0) //condizioni di accettabilità
        {
            //comunicare l'errrore e rinserire il dato
            System.out.println("Numero non valido, \n superiore ad un giorno o nullo\n rinserire un altro valore: ");
            secondi = keyboard.nextInt();
            numero = secondi;
        }

            //ciclo per trasformare secondi in minuti
            while (secondi >= 60) {
                secondi = secondi - 60;
                minuti = minuti + 1;
            }
            //ciclo per trasformare minuti in ore
            while (minuti >= 60)
            {
                minuti = minuti - 60;
                ore = ore + 1;

            }
            //outuput risultati
            System.out.println("Il numero: "+numero+ " Corrispondono alle ore: "+ore+":"+minuti+":"+secondi+"\n In formato hh:mm:ss ");
    }
}