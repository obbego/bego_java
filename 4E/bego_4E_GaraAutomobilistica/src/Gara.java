import java.util.ArrayList;
import java.util.Collections;

public class Gara {
    /*Nome:Stringa
    Nazionalità:Stringa
    griglia:ArrayList<>Scuderia
    cronometro:Cronometro
    vincitore:String
    Gara(String nome,String nazionalità, ArrayList<>Scuderia.,Cronometro conometro,String vincitore)
    inserire metodi getter e setter: (il metodo getGriglia deve ritornare una copia della griglia)
    addScuderia():Scuderia scuderiaAggiunta
    getClassifica(): ci ritorna un arraylist ordinata in base al tempo del giro
    setTempo(Scuderia scuderia)	*/

    private String nome;
    private String nazionalita;
    private int numAutoGara;
    private ArrayList<Scuderia> griglia = new ArrayList<>();
    private Cronometro cronometro;
    private String vincitore;

    public Gara(String nome, String nazionalita, ArrayList<Scuderia> griglia, Cronometro cronometro, String vincitore) {
        this.nome = nome;
        this.nazionalita = nazionalita;
        this.griglia = griglia;
        this.cronometro = cronometro;
        this.vincitore = vincitore;
    }

    public Gara(String nome, String nazionalita, int numAutoGara) {
        this.nome = nome;
        this.nazionalita = nazionalita;
        this.numAutoGara = numAutoGara;

        this.griglia = new ArrayList<>();
        this.cronometro = new Cronometro(null, null, -1);
        this.vincitore = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public ArrayList<Scuderia> getGriglia() {
        return new ArrayList<>(griglia);
    }

    public void setGriglia(ArrayList<Scuderia> griglia) {
        this.griglia = griglia;
    }

    public Cronometro getCronometro() {
        return cronometro;
    }

    public void setCronometro(Cronometro cronometro) {
        this.cronometro = cronometro;
    }

    /* metodo che setta ad una scuderia un determinato tempo */
    public void setTempo(Scuderia scuderia) throws Exception {
        if (this.cronometro.getTempoGiro() < 0)
            throw new Exception("Nessuna rilevazione effettuata");
        this.griglia.get(this.griglia.indexOf(scuderia)).setTempoGiro(this.cronometro.getTempoGiro());

        this.cronometro.resetTime(); //resetto il cronometro
    }

    public String getVincitore() {
        return vincitore;
    }

    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }

    public void addScuderia(Scuderia scuderia) {
        griglia.add(scuderia);
    }

    public ArrayList<Scuderia> getClassifica() {
        ArrayList<Scuderia> classifica = new ArrayList<>(griglia);
        Collections.sort(classifica);
        return classifica;
    }

    public static String headerCSV() {
        return String.format("Numero auto,Pilota,Scuderia,Tempo");
    }

    /* ritorna la classifica della gara
     * in un formato valido per essere scritto su file CSV */
    public String toCSV() {
        ArrayList<Scuderia> classifica = this.getClassifica();
        StringBuilder text = new StringBuilder(headerCSV() + "\n"); //StringBuilder è più sicuro nella concatenazione in loop rispetto ad una semplice stringq

        for (int i = 0; i < classifica.size(); i++)
            text.append(classifica.get(i).toCSV()).append("\n");

        return text.toString(); //converto alla fine in stringa
    }
}
