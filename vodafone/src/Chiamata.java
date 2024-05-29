import  java.time.LocalDateTime;
import java.util.Random;

public class Chiamata {
    public String numero;
    public LocalDateTime dataChiamata;
    int durata;

    @Override
    public String toString(){
        dataChiamata = LocalDateTime.now();
        return String.format("%s %s %d", numero, dataChiamata.toString());
    }
    public int durataChiamata(){
        Random random = new Random();
        return random.nextInt(0, 60)+1;
    }
}
