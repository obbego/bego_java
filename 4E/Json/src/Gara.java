import java.util.ArrayList;
import java.util.List;

public class Gara {
    private String nome;
    private Pilota vincitore;
    private List<Auto> autoInGara;

    public Gara(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Il nome della gara non può essere nullo o vuoto.");
        }
        this.nome = nome;
        this.autoInGara = new ArrayList<>();
    }
    public Gara(String nome, ArrayList<Auto> auto){
        this(nome);
        this.autoInGara = auto;
    }



    public void aggiungiAuto(Auto auto) {
        for (Auto a : autoInGara) {
            if (a.getPilota().equals(auto.getPilota())) {
                throw new IllegalArgumentException("Non possono esserci due piloti con lo stesso nome, cognome ed età.");
            }
        }
        autoInGara.add(auto);
    }

    public void corriGara() {
        if (autoInGara.isEmpty()) {
            throw new IllegalStateException("Non ci sono auto in gara.");
        }

        // Logica semplificata per determinare il vincitore in base alla cilindrata
        Auto vincitoreAuto = autoInGara.get(0);
        for (Auto a : autoInGara) {
            if (a.getCilindrata() > vincitoreAuto.getCilindrata()) {
                vincitoreAuto = a;
            }
        }
        this.vincitore = vincitoreAuto.getPilota();
    }

    public String getNome() {
        return nome;
    }

    public Pilota getVincitore() {
        return vincitore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gara: ").append(nome).append("\n");
        sb.append("Auto in gara:\n");
        for (Auto a : autoInGara) {
            sb.append(a.toString()).append("\n");
        }
        sb.append("Vincitore: ").append(vincitore != null ? vincitore.toString() : "Non ancora determinato");
        return sb.toString();
    }

    public List<Auto> getAutoInGara() {
        return autoInGara;
    }

    public void setAutoInGara(List<Auto> autoInGara) {
        this.autoInGara = autoInGara;
    }

}
