public class Bego_3E_Es017c_Week
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
                case "Lunedi","Mercoledi","Venerdi","Domenica":
                    System.out.print(" é un giorno dispari");
                    break;

                case "Martedi", "Giovedi", "Sabato":
                    System.out.print(" é un giorno pari");
                    break;
            }
        }
        System.out.print("\n\n");

        String risultato;
        String giorno = week[0];
        risultato = switch(giorno)
    {
        case "Lunedi","Mercoledi","Venerdi","Domenica" -> "dispari";



        case "Martedi", "Giovedi", "Sabato" -> "pari";
        default -> "valore sbagliato";
    };
    }
}