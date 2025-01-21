import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.util.Scanner;

import static utility.Tools.*;
public class Main {
    public static void main(String[] args) {
        try {
            // Creazione dei piloti
            Pilota p1 = new Pilota("Mario", "Rossi", "Italia", 30);
            Pilota p2 = new Pilota("Luigi", "Verdi", "Italia", 28);
            Pilota p3 = new Pilota("Giovanni", "Bianchi", "Italia", 32);

            // Creazione delle auto
            Auto a1 = new Auto("Ferrari", p1, 3000);
            Auto a2 = new Auto("Mercedes", p2, 3500);
            Auto a3 = new Auto("Red Bull", p3, 4000);

            // Creazione della gara e aggiunta delle auto
            Gara gara = new Gara("Gran Premio di Monza");
            gara.aggiungiAuto(a1);
            gara.aggiungiAuto(a2);
            gara.aggiungiAuto(a3);

            // Stampa della griglia di partenza
            System.out.println(gara.toString());

            // Salvataggio della griglia di partenza in formato JSON


            // Salvataggio della griglia di partenza in formato CSV
            salvaGrigliaInCsv(gara);

            // Esecuzione della gara
            gara.corriGara();
            System.out.println("Vincitore della gara: " + gara.getVincitore().toString());


        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        Gara gara2 = new Gara("Gara2",leggiGrigliaInJson());
        System.out.println(gara2.getAutoInGara());

        String UseDirectory=System.getProperty("user.dir");  //permette ddi stampare la direcotry di lavoro che sta utilizzando il programma
        System.out.println(UseDirectory);
        File directory = new File(UseDirectory);
        String[] files = directory.list();

        Scanner scanner = new Scanner(System.in);
        String filtro;
        System.out.println("Inserisci l'estensione del file\n");
        filtro=scanner.nextLine();
        String[] file= fileFilter(files,filtro);
        switch (Menu(file, scanner)) {
            case 1:
                System.out.println(file[0]);
                break;
            case 2:
                System.out.println(file[1]);
                break;
        }

    }

    // Metodo per salvare la griglia di partenza in formato JSON
    private static void salvaGrigliaInJson(Gara gara) {
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Gson gson = new Gson();
        List<Auto> griglia = gara.getAutoInGara(); // Otteniamo la lista delle auto

        // Serializza la lista delle auto in formato JSON
        String jsonContent = gson.toJson(griglia);

        try {
            Files.write(Path.of("griglia.json"), jsonContent.getBytes());
            System.out.println("Griglia salvata in griglia.json");
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio del file JSON: " + e.getMessage());
        }
    }

    private static ArrayList<Auto> leggiGrigliaInJson(){
        Gson gson = new Gson();
        ArrayList<Auto> newArchivio = null;
        Type listType = new TypeToken<ArrayList<Auto>>(){}.getType();
        try {
            //deserializzazione
            FileReader leggi = new FileReader("griglia.json");
            newArchivio = gson.fromJson(leggi, listType);
            System.out.println("Archivio 2 visualizzato con successo");
            System.out.println(newArchivio);
            return newArchivio;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return newArchivio;
    }

    // Metodo per salvare la griglia di partenza in formato CSV
    private static void salvaGrigliaInCsv(Gara gara) {
        List<Auto> griglia=gara.getAutoInGara(); // Otteniamo la lista delle auto
        StringBuilder csvContent = new StringBuilder();

        // Aggiungiamo l'intestazione del CSV
        csvContent.append("Scuderia, Pilota, Nazione, Età, Cilindrata\n");

        // Aggiungiamo i dati delle auto
        for (Auto auto : griglia) {
            Pilota pilota = auto.getPilota();
            csvContent.append(auto.getScuderia())
                    .append(", ")
                    .append(pilota.getNome())
                    .append(" ")
                    .append(pilota.getCognome())
                    .append(", ")
                    .append(pilota.getNazionalita())
                    .append(", ")
                    .append(pilota.getEta())
                    .append(", ")
                    .append(auto.getCilindrata())
                    .append("\n");
        }

        // Scriviamo il contenuto nel file CSV
        try {
            Files.write(Path.of("griglia.csv"), csvContent.toString().getBytes());
            System.out.println("Griglia salvata in griglia.csv");
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio del file CSV: " + e.getMessage());
        }
    }
}