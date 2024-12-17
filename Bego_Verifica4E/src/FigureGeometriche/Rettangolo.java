package FigureGeometriche;

/*DOMANDA 3
Modifica la classe Rettangolo aggiungendo un metodo chiamato calcolaPerimetro() che restituisce il perimetro del rettangolo.
Scrivi il codice per il metodo e spiega il motivo per cui è utile avere metodi di calcolo in una classe.*/

public class Rettangolo {
    private double base;
    private double altezza;

    /* Costruttore: passati come parameteri 2 valori double vengono impostati rispettivamente
    * 1) come base dell'oggetto
    * 2) come altezza dell'oggetto */
    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    /*DOMANDA 3:
    * Avere metodi di calcolo in una classe è utile perchè:
    * 1) se il metodo è programmato correttamente, il risultato è sempre corretto, a eccezione di errori di sistema
    * 2) è un metodo che varrà per tutti gli oggetti di quella classe,
    *    quindi per qualsiasi oggetto della classe verrà calcolato senza dover essere inserito da input,
    *    risparmiando tempo */

    /* Calcola l'area usando gli attributi base e altezza della classe
     * usando la formula A = b * a */
    public double calcolaArea() {
        return base * altezza;
    }

    /* Calcola il perimetro usando gli attributi base e altezza della classe
     * usando la formula P = b*2 + a*2 */
    public double calcolaPerimetro() {
        return base * 2 + altezza * 2;
    }

    /* Dato come parametro un oggetto di tipo Rettangolo calcolarne l'area e confrontarla con quella dell'oggetto attuale
     * Ritorna 1 se l'area del Rettangolo attuale è maggiore
     * Ritorna -1 e l'area del Rettangolo attuale è minore
     * Ritorna 0 se l'area del Rettangolo attuale è uguale a quella del quadrato passata come parametro */
    public double compareTo(Rettangolo a) {
        if (this.calcolaArea() > a.calcolaArea()) {
            return 1;
        } else if (this.calcolaArea() < a.calcolaArea()) {
            return -1;
        }
        return 0;
    }

    /* Dato come parametro un valore double rappresentante l'area di una qualsiasi altra figura
     * Ritorna 1 se l'area del Rettangolo attuale è maggiore
     * Ritorna -1 e l'area del Rettangolo attuale è minore
     * Ritorna 0 se l'area del Rettangolo attuale è uguale a quella dell'area passata come parametro */
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
        return String.format("Rettangolo con base: %.2f, altezza: %.2f, perimetro: %.2f, area: %.2f  ", base, altezza, calcolaPerimetro(), calcolaArea());
    }
}
