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

    public void addBook(Libro libro) throws Exception {
        if (!this.checkSpace())
            throw new Exception("Mensola piena");

        this.mensola.add(libro);
        numeroLibri++;
    }

    public void removeLibro(Libro libro) {
        mensola.remove(libro);
        numeroLibri--;
    }

    public void setInto(Libro libro, int posizione) throws IndexOutOfBoundsException {
        if (posizione < 0 || posizione > this.mensola.size())
            throw new IndexOutOfBoundsException("Posizione non valida");

        this.mensola.add(posizione, libro);
    }

    public boolean containsBook(Libro libro) {
        return mensola.contains(libro);
    }

    public boolean isEmpty() {
        return mensola.isEmpty();
    }

    public int findLibro(Libro libro) {
        return this.mensola.indexOf(libro);
    }

    public ArrayList<Libro> getVolumi() {
        ArrayList<Libro> copiaMensola = new ArrayList<>();
        for (Libro libro : this.mensola)
            copiaMensola.add(libro.clone());

        return copiaMensola; //ritorno la copia della mensola
    }
}