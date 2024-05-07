import java.util.Scanner;
public class AreaPerimetro
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        double altezza, base, area, perimetro;

        System.out.println("\ninserisci Altezza");
        altezza = keyboard.nextDouble();
        if (altezza>0)
        {
            System.out.println("\ninserisci Base");
            base = keyboard.nextDouble();
            if (base>0)
            {
                area= base*altezza;
                perimetro= (base+altezza)*2;

                System.out.println("\nL'area corrisponde a: "+area);
                System.out.println("\nIl preimetro corrisponde a: "+perimetro);
            }
            else System.out.println("Base negativa, impossibile calcolare");
        }
        else System.out.println("Altezza negativa, impossibile calcolare");

    }
}
