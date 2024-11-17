/*Creare
un programma per gestire gli accessi a un luna park.

Funzionalità richieste:
 1- gestione dell' entrata /uscita di un persona considerando che il luna
park può contenere un numero massimo di persone (da scegliere a piacere);
 2- visualizzazione quante e quali giostre ha provato una determinata
persona (identificata dal LunaPark.biglietto) quando si trova all'interno del luna
park;
3- visualizzare il giorno e l'ora di accesso alle diverse giostre di una data
persona;
4-visualizzazione del tempo di permanenza nel luna park di una determinata
persona (OPZIONALE);

Requisiti:
a) Alle persone che entrano viene rilasciato un LunaPark.biglietto con un numero unico
generato automaticamente dal programma;
b)Le tipologie di giostre sono: ruota panoramica, autoscontro, ottovolante,
tagadà;
c)L'applicativo deve cancellare (in automatico) i dati relativi ai giri in
giostra fatti da una determinata persona quando questa lascia il luna park.
d)Il programma deve gestire eventuali situazioni di errore.*/

import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

import static utility.Tools.*;

import LunaPark.*;

import static frontEnd.FrontEnd.*;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int nMaxPersone = 1;
        int nPersone = 0, personaAttuale;
        String[] opzioniMenu = {
                "BEGOLANDIA",
                "aggiungi persona/LunaPark",
                "esci dal parco",
                "fai una giostra",
                "visualizza ora ingressi",
                "visualizza permanenza",
                "esci"
        };
        String[] opzioniGiostre = new String[5];
        opzioniGiostre = valoriGiostre();

        ArrayList<Biglietto> personeLunaPark = new ArrayList<>();
        boolean fine = true;

        do {
            switch (menu(opzioniMenu, keyboard)) {
                case 1 -> {
                    try {
                        personeLunaPark.add(inserisciBiglietto(keyboard, nMaxPersone, nPersone));
                        nPersone++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    try {
                        personeLunaPark.remove(cercaBiglietto(keyboard, personeLunaPark));
                        System.out.println("Persona rimossa dall'elenco");
                        nPersone--;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        personaAttuale = cercaBiglietto(keyboard, personeLunaPark);
                        switch (menu(opzioniGiostre, keyboard)) {
                            case 1: {
                                personeLunaPark.get(personaAttuale).giostrFatte.add(Giostre.RUOTA_PANORAMICA);
                                personeLunaPark.get(personaAttuale).oraGiostre.add(LocalTime.now());
                                personeLunaPark.get(personaAttuale).nGiostreFatte++;
                                break;
                            }
                            case 2: {
                                personeLunaPark.get(personaAttuale).giostrFatte.add(Giostre.AUTOSCONTRO);
                                personeLunaPark.get(personaAttuale).oraGiostre.add(LocalTime.now());
                                personeLunaPark.get(personaAttuale).nGiostreFatte++;
                                break;
                            }
                            case 3: {
                                personeLunaPark.get(personaAttuale).giostrFatte.add(Giostre.OTTOVOLANTE);
                                personeLunaPark.get(personaAttuale).oraGiostre.add(LocalTime.now());
                                personeLunaPark.get(personaAttuale).nGiostreFatte++;
                                break;
                            }
                            case 4: {
                                personeLunaPark.get(personaAttuale).giostrFatte.add(Giostre.TAGADà);
                                personeLunaPark.get(personaAttuale).oraGiostre.add(LocalTime.now());
                                personeLunaPark.get(personaAttuale).nGiostreFatte++;
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        visualizzaOrari(cercaBiglietto(keyboard, personeLunaPark), personeLunaPark);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    try {
                        visualizzaPermanenza(cercaBiglietto(keyboard, personeLunaPark), personeLunaPark);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                default -> {
                    fine = false;
                }
            }
        }while (fine);
    }

    public static int cercaBiglietto(Scanner keyboard, ArrayList<Biglietto> persone) throws Exception {
        System.out.println("Inserisci Nome: ");
        String nomeCercare = keyboard.nextLine();
        System.out.println("Inserisci Cognome: ");
        String cognomeCercare = keyboard.nextLine();
        for (Biglietto x : persone) {
            if (x.equals(nomeCercare, cognomeCercare))
                return persone.indexOf(x);
        }
        throw new Exception("Nessuna Persona trovata");
    }

    public static String[] valoriGiostre() {
        Giostre[] giostre = Giostre.values();
        String[] opzioniGiostre = new String[giostre.length + 1];
        opzioniGiostre[0] = "GIOSTRE DISPONIBILI";
        for (int i = 0; i < giostre.length; i++) {
            opzioniGiostre[i + 1] = giostre[i].toString();
        }
        return opzioniGiostre;
    }
}