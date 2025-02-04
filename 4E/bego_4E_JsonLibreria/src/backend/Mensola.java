/*- numeroLibri : int
- maxLibri : int
- mensola : ArrayList<Libro>
+ Mensola(int numeroLibri)
+ getNumeroLibri() : ArrayList<Libro>

+ getMensola() : ArrayList<Libro>
+ checkSpace() : boolean
+ addLibro(Libro l)
+ removeBook(Libro l)
+ setInto(Libro l, int posizione)
+ containsBook(Libro l) : boolean
+ getVolumi() : ArrayList<Libro>
+ isEmpty() : boolean
+ findLibro(Libro l)	*/
package backend;

import java.util.ArrayList;

public class Mensola {
    private int numeroLibri;
    private int maxLibri = 20;
    private ArrayList<Libro> mensola = new ArrayList<>();

    public Mensola(int numeroLibri) {
        this.numeroLibri = numeroLibri;
    }

    public int getNumeroLibri() {
        return numeroLibri;
    }

    public void setNumeroLibri(int numeroLibri) {
        this.numeroLibri = numeroLibri;
    }

    public ArrayList<Libro> getMensola() {
        return mensola;
    }

    public void setMensola(ArrayList<Libro> mensola) {
        this.mensola = mensola;
    }

    public int getMaxLibri() {
        return maxLibri;
    }

    public void setMaxLibri(int maxLibri) {
        this.maxLibri = maxLibri;
    }

    public boolean checkSpace() {
        return mensola.size() < maxLibri;
    }

    public void addLibro(Libro libro) {
        mensola.add(libro);
        numeroLibri++;
    }

    public void removeLibro(Libro libro) {
        mensola.remove(libro);
        numeroLibri--;
    }

    public boolean containsBook(Libro libro) {
        return mensola.contains(libro);
    }

    public boolean isEmpty() {
        return mensola.isEmpty();
    }

    public void add(Libro libro) throws IllegalArgumentException {
        if (!mensola.contains(libro)) {
            mensola.add(libro);
            numeroLibri++;
        } else {
            throw new IllegalArgumentException("Il Libro è già presente correttamente");
        }
    }
}