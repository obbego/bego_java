import static tools.Utility.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean fine = true;
        Scanner keyboard = new Scanner(System.in);
        String [] operazioni = {"VODAFONE",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Fine"};

        contatto[] gestore = 

        do {
            switch (printMenu(operazioni, keyboard)) {
                case 1 -> {
                }
                case 2 -> {
                }
                case 3 -> {
                }
                default -> fine = false;
            }
        }while
    }
}