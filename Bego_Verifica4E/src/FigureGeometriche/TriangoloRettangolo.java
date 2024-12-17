package FigureGeometriche;

public class TriangoloRettangolo {
    private double base;
    private double altezza;

    /* Costruttore: passati come parameteri 2 valori double vengono impostati rispettivamente
     * 1) come base dell'oggetto
     * 2) come altezza dell'oggetto */
    public TriangoloRettangolo(double base, double altezza) {
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

    /* Calcola l'area usando gli attributi base e altezza della classe
     * usando la formula A = (b * a)/2 */
    public double calcolaArea() {
        return (base * altezza) / 2;
    }

    /* Dato come parametro un oggetto di tipo TriangoloRettangolo calcolarne l'area e confrontarla con quella dell'oggetto attuale
     * Ritorna 1 se l'area del TriangoloRettangolo attuale è maggiore
     * Ritorna -1 e l'area del TriangoloRettangolo attuale è minore
     * Ritorna 0 se l'area del TriangoloRettangolo attuale è uguale a quella del quadrato passata come parametro */
    public double compareTo(TriangoloRettangolo a) {
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
        return String.format("Triangolo Rettangolo con base: %.2f, altezza: %.2f, area: %.2f  ", base, altezza, calcolaArea());
    }
}
