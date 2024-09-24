import java.util.Scanner;

public class Bego_3E_Es018_PrendiParole {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String frase = "";

        do {
            System.out.println("Inserisci una frase: ");
            frase = tastiera.nextLine();

            if (frase.length()==0) {
                System.out.println("Non hai inserito nessuna stringa.\nRinserire:\n");
            }
        } while (frase.length()==0);

        int qtaParole = contaParole(frase);
        String[] parole = scomposizione(frase, qtaParole);

        System.out.println("Numero di parole: " + qtaParole);
        for (int i = 0; i < qtaParole; i++) {
            System.out.println("parole " + (i+1) + ": " + parole[i]);
        }
    }

    private static int contaParole(String frase) {
        int qtaParole = 0;
        boolean inParola = false;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) != 32) {
                if (!inParola) {
                    inParola = true;
                    qtaParole++;
                }
            } else {
                inParola = false;
            }
        }

        return qtaParole;
    }

    private static String[] scomposizione(String frase, int qtaParole) {
        int j = 0;
        String[] parole = new String[qtaParole];

        for (int i = 0; i < qtaParole; i++) {
            parole[i] = "";

            while (j < frase.length() && frase.charAt(j) == 32) {
                j++;
            }

            while (j < frase.length() && frase.charAt(j) != 32) {
                parole[i] += frase.charAt(j);
                j++;
            }
        }

        return parole;
    }
}
