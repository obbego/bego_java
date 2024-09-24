//cucina uovo

import java.util.Scanner;
public class CucinaOvo
{
    public static void main (String[]args)
    {
        Scanner keyboard = new Scanner(System.in);
        for (int i=0; i<100; i++)
        {
            System.out.print("°_°");
            Wait();
        }
    }
    private static void Wait()
    {
        try
        {
            Thread.sleep( 70000);
        }
        catch (InterruptedException e)
        {
           e.printStackTrace();
        }
    }
    private static void UovoNonBolle()
    {
        try
        {
            Thread.sleep( 70000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    private static void UovoCheBolle()
    {
        try
        {
            Thread.sleep( 70000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}