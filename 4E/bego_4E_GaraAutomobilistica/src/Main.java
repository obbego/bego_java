import java.io.*;
import java.nio.file.*;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;

import static utility.Tools.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        /* definisco le opzioni */
        String[] opzioni = {
                "GARA AUTOMOBILISTICA",
                "Inserisci pilota",
                "Inserisci auto",
                "Visualizza piloti",
                "Visualizza classifica",
                "Inizia misurazione tempo",
                "Concludi misurazione tempo",
                "Dettagli gara in corso",
                "Salva dati gara corrente CSV / JSON",
                "Cambia gara",
                "Fine"
        };
        /* dichiarazione variabili */
        int scelta;
        Pilota pilotaInput;
        Scuderia scuderiaInput, scuderiaScelta;
        /* istanza delle liste da utilizzare */
        ArrayList<Pilota> listaPiloti = new ArrayList<>();
        ArrayList<Gara> listaGare = new ArrayList<>();
        /* istanza degli oggetti da utilizzare */
        Scanner keyboard = new Scanner(System.in);
        Gson gsonFile = new Gson(); //nuovo oggetto GSON da utilizzare per il salvataggio su file
        /* costanti per il salvataggio file */
        final String directoryPath = "data/";

        try{
            FrontScreen.leggiGara(listaGare, keyboard);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        do{
            scelta = menu(opzioni, keyboard);
            try{
                switch (scelta){
                    /* INSERISCI PILOTA */
                    case 1 -> {
                        pilotaInput = FrontScreen.leggiPilota(keyboard, false);
                        if(listaPiloti.contains(pilotaInput))
                            throw new Exception("Pilota già inserito");

                        listaPiloti.add(pilotaInput);
                    }
                    /* INSERISCI AUTO */
                    case 2 -> {
                        scuderiaInput = FrontScreen.leggiScuderia(keyboard, listaPiloti);
                        listaGare.getLast().addScuderia(scuderiaInput);
                    }
                    /* VISUALIZZA PILOTI */
                    case 3 -> {
                        if(listaPiloti.isEmpty())
                            throw new Exception("Nessun pilota inserito");
                        listaPiloti.forEach(x -> System.out.println(x.toString())); //visualizzo le auto
                    }
                    /* VISUALIZZA CLASSIFICA */
                    case 4 -> {
                        if(listaGare.getLast().getGriglia().isEmpty())
                            throw new Exception("Nessuna auto inserita");

                        printArrayStringValues(listaGare.getLast().getClassifica());
                        Wait(5);
                    }
                    /* INIZIO MISURAZIONE AUTO */
                    case 5 -> {
                        if(listaGare.getLast().getGriglia().isEmpty()) //controllo se la lista esiste
                            throw new Exception("Nessuna auto inserita");
                        listaGare.getLast().getCronometro().setStartTime(LocalTime.now());
                    }
                    /* FINE MISURAZIONE AUTO */
                    case 6 -> {
                        if(listaGare.getLast().getGriglia().isEmpty()) //controllo se la lista esiste
                            throw new Exception("Nessuna auto inserita");
                        scuderiaInput = FrontScreen.leggiScuderia(keyboard, listaPiloti);
                        if(!listaGare.getLast().getGriglia().contains(scuderiaInput)) //controllo se l'auto esiste
                            throw new Exception("Auto non trovata");

                        listaGare.getLast().getCronometro().setEndTime(LocalTime.now());
                        listaGare.getLast().setTempo(scuderiaInput);
                    }
                    /* INFORMAZIONI GARA IN CORSO */
                    case 7 -> {
                        System.out.println(listaGare.getLast().toString());
                        Wait(3);
                    }
                    /* SALVATAGGIO DATI GARA */
                    case 8 -> {
                        writeOnFile(directoryPath+listaGare.getLast().getNome()+".csv", listaGare.getLast().toCSV());
                        writeOnFile(directoryPath+listaGare.getLast().getNome()+".json", gsonFile.toJson(listaGare.getLast().getClassifica()));
                        System.out.println("Dati salvati con successo");
                        Wait(3);
                    }
                    /* CAMBIO GARA */
                    case 9 -> {
                        FrontScreen.leggiGara(listaGare, keyboard); //aggiungo la nuova gara
                    }
                    default -> {
                        System.out.println("Fine programma");
                        Wait(3);
                    }
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
                Wait(3);
            }
        }while(scelta != opzioni.length-1);
    }

    /* metodo per scrivere all'interno di un file */
    private static void writeOnFile(String path, String content){
        try{
            /* controllo se la cartella è già stata
            creata, altrimenti viene generata */
            if(!Files.exists(Path.of(path).getParent()))
                Files.createDirectories(Path.of(path).getParent());
            FileWriter file = new FileWriter(path);
            file.write(content);
            file.flush();
            file.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}