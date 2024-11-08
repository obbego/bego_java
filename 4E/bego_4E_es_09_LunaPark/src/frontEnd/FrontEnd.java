package frontEnd;

import LunaPark.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class FrontEnd {
    public static Biglietto inserisciBiglietto(Scanner keyboard, int nMax, int nAttuale) throws Exception {
        Biglietto output = new Biglietto();
        Random random = new Random();
        boolean dataAcc;

        if (nAttuale == nMax) {
            throw new Exception("Non ce' più spazio nel parco");
        }

        System.out.println("Inserisci il NOME della persona da inserire nel biglietto: ");
        output.nome = keyboard.nextLine();
        System.out.println("Inserisci il COGNOME della persona da inserire nel biglietto: ");
        output.cognome = keyboard.nextLine();

        do {
            dataAcc = false;
            System.out.println("Inserisci la data di ingresso, seguendo il formato gg/mm/aaaa");
            String dataInput = keyboard.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                output.dataIngresso = LocalDate.parse(dataInput, formatter);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                dataAcc = true;
            }
        } while (dataAcc);

        do {
            dataAcc = false;
            System.out.println("Inserisci l'ora di ingresso, seguendo il formato xx:xx 24h");
            String oraInput = keyboard.nextLine();
            try {
                DateTimeFormatter formatterOra = DateTimeFormatter.ofPattern("HH:mm");
                output.oraIngresso = LocalTime.parse(oraInput, formatterOra);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                dataAcc = true;
            }
        } while (dataAcc);

        output.idBiglietto = random.nextInt(111111, 999999) + 1;

        return output;
    }

    public static void visualizzaOrari(int i, ArrayList<Biglietto> personeLunaPark) {
        System.out.println("Orari di: " + personeLunaPark.get(i).cognome);
        System.out.println("Accesso il giorno: " + personeLunaPark.get(i).dataIngresso);
        for (Giostre x : personeLunaPark.get(i).giostrFatte) {
            System.out.println(x.toString());
        }
        for (LocalTime x : personeLunaPark.get(i).oraGiostre) {
            System.out.println(x.toString());
        }
    }
    public static void visualizzaPermanenza(int i, ArrayList<Biglietto> personeLunaPark) {
        System.out.println("Permanenza di: " + personeLunaPark.get(i).cognome);
        Duration durata = Duration.between(LocalTime.now(), personeLunaPark.get(i).oraIngresso);
        System.out.println("Tempo: " + durata.toString());
    }
}
