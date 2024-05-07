/* Dato un valore binario composto da n cifre, determinare se è un byte
(8 bit e deve contenere solo valori binari) e trasformalo in un numero decimale*/

import java.util.Scanner;

public class Byte
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        String nBin;
        boolean flagByte = true;
        int valChar = '0';
        int decimale = 0;
        int i;
        int base=2;
        char valInt;

        System.out.println("Inserisci un numero binario\n Ovvero composto da 1/0 e da 8 cifre");
        nBin = keyboard.nextLine();

        if (nBin.length()==8)
        {

            for(i=0; i<nBin.length(); i++)
            {
                if (!(nBin.charAt(i) == '0'  || nBin.charAt(i) == '1'))
                {
                    flagByte = false;
                }
            }
            if (flagByte)
            {
                System.out.println("è un byte");
                for(i=0; i<nBin.length(); i++)
                {
                    valInt = nBin.charAt(i);
                    valChar = valInt - '0';
                    decimale = decimale * base + valChar;
                }
                System.out.println("e corrisponde al numero: "+decimale+" in decimale");
            }
            else
            {
                System.out.println("non è un byte");
            }
        }

        else
            System.out.println("Non è un byte");

    }
}