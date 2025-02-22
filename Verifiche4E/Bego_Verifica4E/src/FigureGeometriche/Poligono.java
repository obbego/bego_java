package FigureGeometriche;

/*DOMANDA 4
Scrivi una classe chiamata Poligono con i seguenti requisiti:
Un attributo privato numeroLati (di tipo int) che rappresenta il numero di lati del poligono.
Un attributo privato lunghezzaLato (di tipo double) che rappresenta la lunghezza di ciascun lato.
Un costruttore che accetta numeroLati e lunghezzaLato come parametri.
Un metodo double calcolaPerimetro() che restituisce il perimetro del poligono.
Scrivi anche un metodo toString() che restituisca una descrizione testuale del poligono, ad esempio:
"Poligono con 5 lati di lunghezza 3.0, perimetro: 15.0"*/

public class Poligono {
    private int numeroLati;
    private double lunghezzaLato;

    /* Costruttore: passati come parameteri 1 valore int e 1 valore double vengono impostati rispettivamente
     * 1) come numero dei lati dell'oggetto
     * 2) come lunghezza dei lati dell'oggetto
     *
     * (i lati hanno tutti la stessa dimensione perchè nella consegna specifica:
     * UN attributo che rappresenta la lunghezza di ciascun lato
     * invece di: un attributo che rappresenta la lunghezza per ciascun lato)*/
    public Poligono(int numeroLati, double lunghezzaLato) {
        this.numeroLati = numeroLati;
        this.lunghezzaLato = lunghezzaLato;
    }

    public int getNumeroLati() {
        return numeroLati;
    }

    public double getLunghezzaLato() {
        return lunghezzaLato;
    }

    public void setNumeroLati(int numeroLati) {
        this.numeroLati = numeroLati;
    }

    public void setLunghezzaLato(double lunghezzaLato) {
        this.lunghezzaLato = lunghezzaLato;
    }

    /* Calcola il perimetro usando gli attributi numeroLati e lunghezzaLato della classe
     * usando la formula P = lL * nL */
    public double calcolaPerimetro() {
        return lunghezzaLato * numeroLati;
    }

    //Ritorna una stringa formattata con gli attributi ed elementi calcolabili della classe
    public String toString() {
        return String.format("Poligono con %d lati di lunghezza %.2f, perimetro: %.2f  ", numeroLati,lunghezzaLato, calcolaPerimetro() );
    }

}
