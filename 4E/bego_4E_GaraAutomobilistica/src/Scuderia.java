public class Scuderia implements Comparable<Scuderia> {

    private String nome;
    private Pilota p;
    private int numeroAuto;
    private Integer tempoGiro;

    public Scuderia(String nome, Pilota p, int numeroAuto, Integer tempoGiro) {
        this.nome = nome;
        this.p = p;
        this.numeroAuto = numeroAuto;
        this.tempoGiro = tempoGiro;
    }

    public Scuderia(String nome, Pilota p, int numeroAuto) {
        this.nome = nome;
        this.p = p;
        this.numeroAuto = numeroAuto;
        this.tempoGiro = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pilota getP() {
        return p;
    }

    public void setP(Pilota p) {
        this.p = p;
    }

    public int getNumeroAuto() {
        return numeroAuto;
    }

    public void setNumeroAuto(int numeroAuto) {
        this.numeroAuto = numeroAuto;
    }

    public Integer getTempoGiro() {
        return tempoGiro;
    }

    public void setTempoGiro(Integer tempoGiro) {
        this.tempoGiro = tempoGiro;
    }

    @Override
    public String toString() {
        return "Scuderia{" +
                "nome='" + nome + '\'' +
                ", p=" + p +
                ", numeroAuto=" + numeroAuto +
                ", tempoGiro=" + tempoGiro +
                '}';
    }

    @Override
    public int compareTo(Scuderia o) {
        if (this.tempoGiro > o.tempoGiro) {
            return 1;
        }
        else if (this.tempoGiro < o.tempoGiro) {
            return -1;
        }
        return 0;
    }

    public String toCSV(){
        return String.format("%d,%s,%s,%d", this.numeroAuto,this.p.toCSV(), this.nome, this.tempoGiro);
    }
}

