//cucina uovo

public class Bego_3E_Es06_Ovo //creazione classe
{
    public static void main (String[]args) //creazione main
    {
        //serie di system.out.println per rappresentare il cuoco
        System.out.println("                           (c)___c____(c)");
        System.out.println("                             |........../");
        System.out.println("                             |.........|");
        System.out.println("                             |.........|");
        System.out.println("                             |.........|");
        System.out.println("                              |=======|");
        System.out.println("                              |=======|                               ------------------");
        System.out.println("                            __o)''''::?                               |CUOCO:           |");
        System.out.println("                           C__    c)::;   --------------------->      | Oggi cucineremo |");
        System.out.println("                              >--   ::                                | un bell'uovo    |");
        System.out.println("                              (____/                                  ------------------");
        System.out.println("                              } /'')");
        System.out.println("                   __/       (|V ^ )| ");
        System.out.println("                   o | _____/ |#/ / | ");
        System.out.println("                   o_|}|_____/|/ /  |");
        System.out.println("                              / /   |");
        System.out.println("             ======ooo}{|______)#   |");
        System.out.println("         ~~~~ ;    ;          ###---|8");
        System.out.println("       ____;_____;____        ###====");
        System.out.println("      (///0///@///@///)       ###@@@@/");
        System.out.println("      |~~~~~~~~~~~~~~~|       ###@@@@|");
        System.out.println("       |             /        ###@@@@|");
        System.out.println("        |___________/         ###xxxxx");
        System.out.println("         H H   H  H          ###|| |");
        System.out.println("         H H   H  H           | || |");
        System.out.println("         H H   H  H           C |C |");
        System.out.println("         H H   H  H            || ||");
        System.out.println("         H(o) (o) H            || ::");
        System.out.println("        (o)      (o)        Ccc__)__)");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        InserisciUovo(); // richiamo della funzione "InserisciUovo" per aspettare il tempo determinato

        System.out.println("\n\n____________________________________________________________\n\n");
        System.out.println("                       .-~-.");
        System.out.println("                     .'     '.");
        System.out.println("                    /          )       Scegliamo 1 delle 3 uova");
        System.out.println("            .-~-.  :           ;       Questo xe veramente un bell'ovo");
        System.out.println("          .'     '.|           |");
        System.out.println("         /         |           :");
        System.out.println("        :           ; .-~''~-,/");
        System.out.println("        |           /`        `'");
        System.out.println("        :          |              | ");
        System.out.println("         |         |             / ");
        System.out.println("          `.     .' |          .'");
        System.out.println("            `~~~`    '-.____.-' ");

        ScegliUovo(); // richiamo della funzione "ScegliUovo" per aspettare il tempo determinato

        System.out.println("\n\n____________________________________________________________\n\n");
        System.out.println("      ,''`.");
        System.out.println("     /     )");
        System.out.println("    :       :               Uovo inserito nella pentola per essere cucinato");
        System.out.println("    :       :               Basta solo aspettare i 3 minuti di cottura");
        System.out.println("     `.___,'");
        System.out.println(" ____;_____;____ ");
        System.out.println("(///0///@///@///)");
        System.out.println("|~~~~~~~~~~~~~~~|");

        ScegliUovo(); // richiamo della funzione "ScegliUovo" per aspettare il tempo determinato

        System.out.println("\n\n____________________________________________________________\n\n");
        System.out.println("         .--.");
        System.out.println("    .-._;.--.;_.-.");
        System.out.println("   (_.'_..--.._'._)");
        System.out.println("    /.' . 60 . '.| ");
        System.out.println("   // .      / . ||");
        System.out.println("  |; .      /   . |;");
        System.out.println("  ||45    ()    15||");
        System.out.println("  |; .          . |;");
        System.out.println("   || .        . //");
        System.out.println("    |'._' 30 '_.'/");
        System.out.println("     '-._'--'_.-'");
        System.out.println("         `''` ");


        for (int min =3 ; min>=0 ; min--)
        {
            System.out.print("Mancano: "+min + " minuti a fine cottura \r");
            UovoMinuti();     // richiamo della funzione "UovoMinuti" per aspettare il tempo determinato
        }

        System.out.println("\n\n____________________________________________________________\n\n");
        System.out.println("                  ▒▒ ");
        System.out.println("      ▓▓██░░▒▒▓▓▓▓░░░░██ ");
        System.out.println("      ▓▓                ██              Perfetto ora è pronto.");
        System.out.println("    ▓▓░░▓▓██              ▓▓██          Possiamo Mangiare");
        System.out.println("    ██░░░░██                  ████");
        System.out.println("  ▓▓░░░░▓▓░░                  ░░██");
        System.out.println("  ██░░░░░░██░░                    ▓▓██ ");
        System.out.println("  ██░░░░░░░░██░░░░                    ██████████ ");
        System.out.println("██░░░░░░▒▒██░░░░░░░░░░░░                        ██ ");
        System.out.println("██░░░░▒▒░░░░██░░░░░░░░░░░░░░░░  ░░░░        ░░░░██ ");
        System.out.println("██░░░░░░░░░░░░▓▓░░░░░░░░░░░░░░░░░░░░  ░░░░░░░░▓▓██");
        System.out.println("██░░░░░░░░░░░░██████████░░░░░░░░░░░░░░░░░░░░██░░██ ");
        System.out.println("██░░░░░░░░░░░░░░▒▒░░░░░░██░░░░▓▓████░░░░░░██░░██                ████████████        ");
        System.out.println("  ██░░░░░░░░▒▒░░░░▒▒░░░░░░░░░░░░▒▒░░░░░░░░██      ████                              ██");
        System.out.println("    ██░░░░░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░██  ██████                                    ██ ");
        System.out.println("    ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██  ██                                          ██");
        System.out.println("    ░░▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓██▓▓░░              ██░░░░██████████            ██");
        System.out.println("        ████░░░░░░░░░░░░░░░░░░░░████                ██████░░░░░░░░░░░░░░░░████        ██      ");
        System.out.println("        ████░░░░░░░░░░░░░░░░░░░░████                ██████░░░░░░░░░░░░░░░░████        ██      ");
        System.out.println("            ██▓▓██░░░░░░░░██████                ████░░░░░░░░░░░░░░░░░░░░░░░░░░██        ██");
        System.out.println("                  ████████                  ████░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░    ██");
        System.out.println("                  ░░░░██                  ██▒▒▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██░░    ░░██");
        System.out.println("                    ██                  ░░██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒██░░        ██");
        System.out.println("                    ██                  ░░░░▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒██░░      ░░██");
        System.out.println("                    ██                  ░░░░▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒██░░      ░░██");
        System.out.println("                  ██                      ░░██░░░░░░░░░░░░░░░░░░░░░░░░░░▒▒▒▒▒▒▒▒██        ░░██");
        System.out.println("                  ██                          ██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒██        ░░██");
        System.out.println("                  ██                            ████▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒████          ░░██");
        System.out.println("                  ██                                ██████████▒▒▒▒▒▒████████░░          ░░░░██");
        System.out.println("                  ██                                  ░░░░░░  ██████░░░░░░░░░░        ░░░░░░██");
        System.out.println("                  ██                                          ░░░░                    ░░░░░░██");
        System.out.println("                  ██                                                              ░░░░░░░░░░██");
        System.out.println("                  ██░░                      ░░░░░░░░░░                ░░░░░░░░░░░░░░░░░░░░░░██");
        System.out.println("                    ▓▓░░  ░░    ░░░░░░░░░░  ░░░░░░░░    ░░      ░░░░░░░░░░░░░░░░░░░░░░░░░░███");
        System.out.println("                      ████░░░░░░░░░░░░░░░░██████████▓▓██▓▓████████░░░░░░░░░░░░░░░░░░██████");
        System.out.println("                          ▓▓▓▓▓▓▓▓▓▓██▓▓██░░                      ██████▓▓▒▒▓▓▓▓▒▒▓▓    ░░");

        Mangiare(); // richiamo della funzione "UovoCheBolle" per aspettare il tempo determinato

        System.out.println("\n\n____________________________________________________________\n\n");
        System.out.println("GNAM GNAM");
        System.out.println("Veramente squisito");
    }

    private static void InserisciUovo() //creazione funzione InserisciUovo
    {
        try //gestione errori
        {
            Thread.sleep( 6000); //"Blocca" l'esecuzione per il tempo indicato (millisecondi)
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    private static void ScegliUovo() //creazione funzione InserisciUovo
    {
        try //gestione errori
        {
            Thread.sleep( 6000); //"Blocca" l'esecuzione per il tempo indicato (millisecondi)
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static void UovoMinuti()  //creazione funzione UovoCheBolle
    {
        try
        {
            Thread.sleep( 5000); //"Blocca" l'esecuzione per il tempo indicato (millisecondi)
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    private static void Mangiare() //creazione funzione Mangiare
    {
        try
        {
            Thread.sleep( 6000); //"Blocca" l'esecuzione per il tempo indicato (millisecondi)
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    private static void ClrScr () // creazione funzione ClrScr per cancellare lo schermo
    {
        try				//gestisce eccezioni  (Non fa interrompere i programmi)
        {
            new ProcessBuilder ("cmd", "/c", "cls").inheritIO ().start ().waitFor ();	//comandi dos da eseguire
        }
        catch (Exception e)		//gestisce eccezioni (Non fa interrompere i programmi)
        {
            e.printStackTrace ();
        }
    }
}