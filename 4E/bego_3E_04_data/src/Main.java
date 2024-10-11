import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        LocalDate dataLocale = LocalDate.now();
        System.out.println("Data toString: " + dataLocale.toString());
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yy");
        System.out.println("______________________________________");
        System.out.println("Data format: " +dataLocale.format(dt));
        System.out.printf("Data F: %s" + "\n", dataLocale.format(DateTimeFormatter.ofPattern("dd_MM_yy")));
        System.out.println("______________________________________");
        String dataString = dataLocale.format(dt);
        dataLocale = LocalDate.parse(dataString, dt);
        System.out.println("Data parse: " + dataString);
        System.out.println("______________________________________");
        //////////////////////////////////////////////////////////////////////////
        /*System.out.println("INSERISCI UNA DATA NEL FORMATO: gg/mm/aa");
        String input = keyboard.nextLine();
        LocalDate dataInput = LocalDate.parse(input, dt);
        System.out.println("Data input: " + dataInput);*/
        //////////////////////////////////////////////////////////////////////////
        System.out.println("______________________________________");
        String timeString = "10:32:01";
        LocalTime ora = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("Orario locale: " + ora);
        ///////////////////////////////////////////////////////////////////////////
        System.out.println("______________________________________");
        dataLocale = LocalDate.of(2023, 10, 8);
        int anno, mese, giorno;
        anno = dataLocale.getYear();
        mese = dataLocale.getMonthValue();
        giorno = dataLocale.getDayOfMonth();
        System.out.println("Data: " + anno + "/" + mese + "/" + giorno + "\nGiorni mese: " + dataLocale.lengthOfMonth());
        if(dataLocale.isLeapYear())
            System.out.println("é bisestile");
        else
            System.out.println("Non è bisestile");
        //////////////////////////////////////////////////////////////////////////
        System.out.println("______________________________________");
        LocalDate dataConfronto = LocalDate.now();
        if (dataConfronto.equals(LocalDate.now()))
            System.out.println("Le date sono uguali");
        else
            System.out.println("Le date sono diverse");
    }
}