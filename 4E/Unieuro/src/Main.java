import FrontEnd.GestoreNegozio;
import Backend.Elettronica.Pc;
import Backend.Elettronica.Smartphone;

public class Main {
    public static void main(String[] args) {

        GestoreNegozio negozio = new GestoreNegozio("Marchesini shop");

        Smartphone smartphone1 = new Smartphone("1c982", "apple", 900, "iphone 16", 100);
        Pc pc1 = new Pc("1c982", "asus", 900, "ryzon", 100);

        try {
            negozio.aggiungiProdotto(smartphone1);
            negozio.aggiungiProdotto(pc1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        negozio.visualizza();
    }
}
