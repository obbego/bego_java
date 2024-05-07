public class Bego_3E_Es017_Week
{
    public static void main(String[] args)
    {
        String[] week =
                {"Lunedi",
                "Martedi",
                "Mercoledi",
                "Giovedi",
                "Venerdi",
                "Sabato",
                "Domenica"};

        for(int i = 0; i < week.length; i++)
        {
            String giorno = week[i];
            System.out.print("\n"+week[i]+":");
            switch (giorno)
            {
                case "Lunedi":
                    System.out.print(" é un giorno dispari");
                    break;

                case "Martedi":
                    System.out.print(" é un giorno pari");
                    break;

                case "Mercoledi":
                    System.out.print(" é un giorno dispari");
                    break;

                case "Giovedi":
                    System.out.print(" é un giorno pari");
                    break;

                case "Venerdi":
                    System.out.print(" é un giorno dispari");
                    break;

                case "Sabato":
                    System.out.print(" é un giorno pari");
                    break;

                case "Domenica":
                    System.out.print(" é un giorno dispari");
                    break;
            }
        }
        System.out.print("\n\n");
    }
}