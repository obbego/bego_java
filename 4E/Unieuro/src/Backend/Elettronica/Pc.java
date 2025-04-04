package Backend.Elettronica;

public class Pc extends ProdottoElettronico {
    private String processore;
    private int hardDisk;
    private static int prezzoHardDisk = 10;

    public Pc(String prodotto, String marca, double prezzo, String processore, int hardDisk) {
        super(prodotto, marca, prezzo);
        this.processore = processore;
        this.hardDisk = hardDisk;
    }

    public String getProcessore() {
        return processore;
    }

    public void setProcessore(String processore) {
        this.processore = processore;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }

    public static int getPrezzoHardDisk() {
        return prezzoHardDisk;
    }

    public static void setPrezzoHardDisk(int prezzoHardDisk) {
        Pc.prezzoHardDisk = prezzoHardDisk;
    }

    public int costoMemoria(){
        int prezzoHD = 0;
        return  prezzoHD = hardDisk * prezzoHardDisk;
    }


    @Override
    public String toString(){
        return super.toString() + String.format("processore: " + processore + "hard disk" + hardDisk + "prezzo HD" + costoMemoria());
    }

}
