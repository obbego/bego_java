/*Leggere una sequenza di numeri chiusa da 0 */

import java.util.Scanner;

public class Sequenza
{

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        int numero, qtaNum=0;

        System.out.println("Inserire una sequenza di numeri chiusa da 0");

        do
        {
            numero = keyboard.nextInt();
            qtaNum ++;

            if(numero==0)
                System.out.println("Fine sequenza");
        }
        while(numero != 0);
    }
}