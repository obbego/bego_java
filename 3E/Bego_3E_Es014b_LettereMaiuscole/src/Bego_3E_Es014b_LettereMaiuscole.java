public class Bego_3E_Es014b_LettereMaiuscole
{
    public static void main(String[] args)
    {
        String[] disney= {"Pippo", "pluto", "Topolino", "minnie"};
        String[] maiuscole = new String[disney.length];

        getUpWord(disney,maiuscole);
        print(maiuscole);
    }

    private static void getUpWord (String [] disney, String[] maiuscole)
    {
        for (int i = 0; i < disney.length; i++) {
            if (disney[i].charAt(0) > 'A' && disney[i].charAt(0) < 'Z') {
                maiuscole[i] = disney[i];
            }
        }
    }

    private static void print (String [] maiuscole)
    {
        for (int i = 0; i < maiuscole.length; i++)
            if (maiuscole[i] != null)
            {
                System.out.println(maiuscole[i]);
            }
    }
}