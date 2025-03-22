package frontEnd;

import elettronica.ProdottoElettronico;
import elettronica.Smartphone;

import java.util.ArrayList;
import java.util.Scanner;

public class FrontEnd {
    private static ArrayList<ProdottoElettronico> catalogo = new ArrayList<>();

    public ArrayList<ProdottoElettronico> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<ProdottoElettronico> catalogo) {
        this.catalogo = catalogo;
    }

    public static boolean verificaCodiceProdotto(String codiceProdotto) {
        for (ProdottoElettronico prodotto : catalogo) {
            if (prodotto.getCodiceProdotto().equals(codiceProdotto)) {
                return true;
            }
        }
        return false;
    }


    public void addProdotto(ProdottoElettronico prodotto) throws Exception {
        if (verificaCodiceProdotto(prodotto.getCodiceProdotto())) {
            throw new Exception("Il prodotto è già stato inserito");
        }
        catalogo.add(prodotto);
    }

    public void removeProdotto(ProdottoElettronico prodotto) {
        catalogo.remove(prodotto);
    }

    public void removeProdotto(String codiceprodotto) throws Exception {
        int x = ricercaProdotto(codiceprodotto);
        catalogo.remove(catalogo.get(x));
    }

    public int ricercaProdotto(ProdottoElettronico prodotto) {
        return catalogo.indexOf(prodotto);
    }

    public int ricercaProdotto(String codiceProdotto) throws Exception {
        for (ProdottoElettronico prodotto : catalogo) {
            if (prodotto.getCodiceProdotto().equals(codiceProdotto)) {
                return catalogo.indexOf(prodotto);
            }
        }
        throw new Exception("Non è stato trovato nessun prodotto");
    }

    public void modificaPrezzo(String codiceProdotto, double prezzo) throws Exception {
        int x = ricercaProdotto(codiceProdotto);
        catalogo.get(x).setPrezzo(prezzo);
    }

    public void visualizzaProdotti() {
        catalogo.forEach(prodotto -> {
            System.out.println(prodotto.toString());
        });
    }

    public void leggiSmartphone(Scanner keyboard) throws Exception {
        System.out.println("Inserisci il codice prodotto");
        String codiceP = keyboard.nextLine();
        System.out.println("Inserisci la marca prodotto");
        String marca = keyboard.nextLine();
        System.out.println("Inserisci prezzo prodotto");
        double prezzo = Double.parseDouble(keyboard.nextLine());
        System.out.println("Inserisci il modello prodotto");
        String modello = keyboard.nextLine();
        System.out.println("Inserisci la qta di memoria");
        int memoria = Integer.parseInt(keyboard.nextLine());

        Smartphone smartphone = new Smartphone(codiceP, marca, prezzo, modello, memoria);
        catalogo.add(smartphone);
    }

    public String leggiCodiceProdotto(Scanner keyboard) {
        System.out.println("Inserisci codice prodotto");
        String codiceP = keyboard.nextLine();
        return codiceP;
    }

    public int leggiPrezzoProdotto(Scanner keyboard) throws Exception {
        System.out.println("Inserisci il nuovo prezzo prodotto");
        int prezzo = Integer.parseInt(keyboard.nextLine());
        if (prezzo <= 0) {
            throw new Exception("Il prezzo non può essere nullo o negativo");
        }
        return prezzo;
    }

    public void controllaSeVuoto() throws Exception {
        if (catalogo.isEmpty()) {
            throw new Exception("Devi prima inserire un prodotto");
        }
    }
}
