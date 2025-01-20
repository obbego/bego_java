import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Cronometro {

    private LocalTime startTime;
    private LocalTime endTime;
    private int tempoGiro;

    public Cronometro(LocalTime startTime, LocalTime endTime, int tempoGiro) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.tempoGiro = tempoGiro;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = LocalTime.ofSecondOfDay(LocalTime.now().getSecond());
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = LocalTime.ofSecondOfDay(LocalTime.now().getSecond());
    }

    public int getTempoGiro() {
        return tempoGiro;
    }

    private void setTempoGiro(int tempoGiro) {
        this.tempoGiro = tempoGiro;
    }

    private LocalTime calcularTempoGiro() {
        return LocalTime.ofSecondOfDay(endTime.minus(tempoGiro, ChronoUnit.SECONDS).getSecond());
    }

    public void resetTime(){
        this.startTime = null;
        this.endTime = null;
        this.tempoGiro = -1;
    }

}
