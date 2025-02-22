package FigureGeometriche;

public class Circonferenza {
    private double raggio;

    //Costruttore: passato come parametero un valore double viene impostato come raggio dell'oggetto
    public Circonferenza(double raggio) {
        this.raggio = raggio;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    /* Calcola l'area usando l'attributo raggio della classe
     * usando la formula A = PI * r^2 */
    public double calcolaArea() {
        return Math.PI * raggio * raggio;
    }

    /* Data come parametro un oggetto di tipo Circonferenza calcolarne l'area e confrontarla con quella dell'oggetto attuale
     * Ritorna 1 se l'area della circonferenza attuale è maggiore
     * Ritorna -1 e l'area della circonferenza attuale è minore
     * Ritorna 0 se l'area della circonferenza attuale è uguale a quella della circonferenza passata come parametro */
    public double compareTo(Circonferenza a) {
        if (this.calcolaArea() > a.calcolaArea()) {
            return 1;
        } else if (this.calcolaArea() < a.calcolaArea()) {
            return -1;
        }
        return 0;
    }

    /* Dato come parametro un valore double rappresentante l'area di una qualsiasi altra figura
     * Ritorna 1 se l'area della circonferenza attuale è maggiore
     * Ritorna -1 e l'area della circonferenza attuale è minore
     * Ritorna 0 se l'area della circonferenza attuale è uguale a quella dell'area passata come parametro */
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
        return String.format("Circonferenza con raggio: %.2f, Area: %.2f", raggio, calcolaArea());
    }

}
