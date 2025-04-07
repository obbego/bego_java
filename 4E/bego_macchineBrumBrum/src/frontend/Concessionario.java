package frontend;

import backend.Automobili.Auto;

import java.util.ArrayList;

public class Concessionario {
    ArrayList<Auto> collezione = new ArrayList<>();


    public ArrayList<Auto> Ricerca(String marca) {
        ArrayList<Auto> collezioneMarca = new ArrayList<>();

        collezione.forEach(a -> {
            if (a.getMarca().equals(marca)) {
                collezioneMarca.add(a);
            }
        });

        return collezioneMarca;
    }

    public void visualizzaDaAnno(int anno) {
        collezione.forEach(a -> {
            if (a.getAnno() >= anno) {
                System.out.println(a.mostraDettagli());
            }
        });
    }

    public void visualizza() {
        collezione.forEach(a -> System.out.println(a.mostraDettagli()));
    }
}
