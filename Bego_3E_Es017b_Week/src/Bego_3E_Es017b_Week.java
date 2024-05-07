public class Bego_3E_Es017b_Week
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
                case "Mercoledi":
                case "Venerdi":
                case "Domenica":
                    System.out.print(" é un giorno dispari");
                    break;

                case "Martedi":
                case "Giovedi":
                case "Sabato":
                    System.out.print(" é un giorno pari");
                    break;
            }
        }
        System.out.print("\n\n");
    }
}