import java.util.Scanner;
import java.util.Random;

public class Bego_3E_Es012_BallaLaFresca {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        Random caso = new Random();
        int scelta;
        int conteggio, nGiusti = 0;
        int[] nEstratti = new int[5];
        int[] nG1 = new int[5];
        boolean ordine = false;

        do {
            // Opzioni del menu
            String[] opzioni = {"=== Gioco Dadi === ",
                    "[1] Estrazioni ruota di Venezia",
                    "[2] Giocata utente",
                    "[3] Verifica vincita",
                    "[4] Visualizza giocate",
                    "[5] Uscite"
            };

            // Mostra il menu e ottieni la scelta dell'utente
            scelta = Menu(opzioni, tastiera);
            Wait(5000);

            switch (scelta) {
                case 1:
                    // Estrai i numeri casuali
                    for (int i = 0; i < nEstratti.length; i++) {
                        nEstratti[i] = Estrazione(caso, nEstratti, i);
                        System.out.println(nEstratti[i]);
                    }
                    System.out.println("\nnumeri estratti");
                    break;

                case 2:
                    // Input dell'utente per la giocata
                    for (int i = 0; i < nG1.length; i++) {
                        do {
                            System.out.println("Inserisci il " + (i + 1) + " numero");
                            nG1[i] = tastiera.nextInt();

                            // Controllo se il numero è compreso tra 1 e 90
                            // e se è già stato inserito in precedenza
                            for (int j = 0; j < i; j++) {
                                if (nG1[i] == nG1[j]) {
                                    System.out.println("Numero già inserito. Riprova.");
                                    break;
                                }
                            }
                        } while (!(nG1[i] >= 1 && nG1[i] <= 90));
                    }
                    System.out.println("\nnumeri inseriti");
                    break;

                case 3:
                    // Verifica vincita
                    if (nG1[0] == 0) {
                        System.out.println("Devi prima inserire i numeri giocati.");
                        break;
                    }
                    ordine = true;

                    for (int i = 0; i < nG1.length; i++) {
                        conteggio = VerificaVincita(i, nEstratti, nG1);
                        nGiusti = nGiusti + conteggio;
                    }
                    break;

                case 4:
                    // Visualizza risultati delle giocate
                    if (ordine==false)
                    {
                        System.out.println("Devi prima verificare la vincità.");
                        break;
                    }
                    if (nGiusti > 0)
                        System.out.println("\nHai indovinato " + nGiusti + " numeri");
                    else
                        System.out.println("\n Non è stato indovinato nessun numero");

                    nGiusti = 0;
                    break;

                case 5:
                    // Uscita dal gioco
                    break;
            }
        } while (scelta != 5);

        Wait(5000);
    }

    // Funzione per gestire il menu e ottenere la scelta dell'utente
    private static int Menu(String[] opzioni, Scanner tastiera) {
        int scelta;

        do {
            ClrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = tastiera.nextInt();

            // Controllo se la scelta è valida
            if (scelta < 1 || scelta > opzioni.length) {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        } while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }

    // Funzione per l'estrazione dei numeri
    private static int Estrazione(Random caso, int[] nEstratti, int i) {
        nEstratti[i] = caso.nextInt(0,90) + 1;

        // Controllo e reimposto il numero in caso di duplicazione
        for (int j = 0; j < i; j++) {
            while (nEstratti[i] == nEstratti[j]) {
                nEstratti[i] = caso.nextInt(0,90) + 1;
                j = 0;
            }
        }

        return nEstratti[i];
    }

    // Funzione per la verifica della vincita
    private static int VerificaVincita(int i, int[] nEstratti, int[] nG1) {
        int contaGiusti = 0;
        for (int j = 0; j < nEstratti.length; j++) {
            if (nG1[i] == nEstratti[j]) {
                contaGiusti++;
            }
        }
        return contaGiusti;
    }

    // Funzione per pulire la console
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Funzione per la pausa
    private static void Wait(int attesa) {
        try {
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
