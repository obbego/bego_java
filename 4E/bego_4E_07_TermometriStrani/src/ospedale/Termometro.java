package ospedale;

import java.util.Scanner;
public class Termometro {
    public double temperatura = 36.00;
    public void resetTemperatura() {
        temperatura = 36.00;
    }
    public void eseguiMisura(Scanner keyboard) throws Exception {
        System.out.println("Inserisci il risultato della misura: ");
        float nMisura = Float.parseFloat(keyboard.nextLine());
        setTemperatura(nMisura);
    }
    public void setTemperatura(float x){
        temperatura = x;
    }

    /*public Ospedale.Termometro (float temperatura){

    } */
}

