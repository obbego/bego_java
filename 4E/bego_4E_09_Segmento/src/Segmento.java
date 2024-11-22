public class Segmento {
    private Punto p1;
    private Punto p2;

    public Segmento(Punto pn1, Punto pn2) {
        this.p1 = pn1;
        this.p2 = pn2;
    }

    public Punto getP1() {
        return p1;
    }
    public Punto getP2() {
        return p2;
    }
    public double determinaLunghezza(Punto p1, Punto p2) {
        return Math.sqrt(Math.pow(p1.getX()- p2.getX(), 2) + Math.pow(p1.getY()- p2.getY(), 2));
    }
}
