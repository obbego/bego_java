package FigureGeometriche;

public class Quadrato {
    private double lato;

    //Costruttore: passato come parametero un valore double viene impostato come lato dell'oggetto
    public Quadrato(double lato) {
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }

    /* Calcola l'area usando l'attributo lato della classe
     * usando la formula A = l^2 */
    public double calcolaArea() {
        return lato * lato;
    }

    /* Calcola il perimetro usando l'attributo lato della classe
     * usando la formula P = l*4 */
    public double calcolaPerimetro() {
        return lato * 4;
    }

    /* Dato come parametro un oggetto di tipo Quadrato calcolarne l'area e confrontarla con quella dell'oggetto attuale
     * Ritorna 1 se l'area del quadrato attuale è maggiore
     * Ritorna -1 e l'area del quadrato attuale è minore
     * Ritorna 0 se l'area del quadrato attuale è uguale a quella del quadrato passata come parametro */
    public double compareTo(Quadrato a) {
        if (this.calcolaArea() > a.calcolaArea()) {
            return 1;
        } else if (this.calcolaArea() < a.calcolaArea()) {
            return -1;
        }
        return 0;
    }

    /* Dato come parametro un valore double rappresentante l'area di una qualsiasi altra figura
     * Ritorna 1 se l'area del quadrato attuale è maggiore
     * Ritorna -1 e l'area del quadrato attuale è minore
     * Ritorna 0 se l'area del quadrato attuale è uguale a quella dell'area passata come parametro */
    public double compareTo(double a) {
        if (this.calcolaArea() > a) {
            return 1;
        } else if (this.calcolaArea() < a) {
            return -1;
        }
        return 0;
    }

    //Ritorna una stringa formattata con gli attributi ed elementi calcolabili della classe
    public String getInformazioni() {
        return String.format("Quadrato con lato: %.2f, perimetro: %.2f, area: %.2f  ", lato, calcolaPerimetro(), calcolaArea());
    }
}
