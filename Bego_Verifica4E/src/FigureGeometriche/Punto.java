package FigureGeometriche;
/*DOMANDA 2
Scrivi una classe chiamata Punto con i seguenti attributi e metodi:
Due attributi privati x e y di tipo double, che rappresentano le coordinate del punto.
Un costruttore che accetta come parametri i valori di x e y.
Metodi getter e setter per gli attributi.
Un metodo double distanza(Punto altro) che calcola e restituisce la distanza tra il punto corrente e un altro punto passato come parametro.*/

public class Punto {
    private double x;
    private double y;

    /* Costruttore: passati come parameteri 2 valori double vengono impostati rispettivamente
     * 1) come cordinata x dell'oggetto
     * 2) come cordinata y dell'oggetto */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    /* Calcola la distanza, con un'oggetto della classe Punto passato come parametro
     * usando la formula: dis = radice[(x1 -x2)^2 + (y1 -y2)^2]) */
    public double distanza(Punto punto2) {
        return Math.sqrt(Math.pow(this.x - punto2.getX(), 2) + Math.pow(this.y - punto2.getY(), 2));
    }

    //Ritorna una stringa formattata con gli attributi della classe
    public String getInformazioni() {
        return String.format("Punto con cordinata x: %.2f - y: %.2f", x, y);
    }
}


