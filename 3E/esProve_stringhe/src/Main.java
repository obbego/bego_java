public class Main {
    public static void main(String[] args) {
        /*String linea = "la mamma va al mercato a comprare i pomodori";
        String linea2 = "gino, maria, giovanni";
        String[] nomi;
        String[] parole;
        parole=linea.split(" ");
        for (String s : parole) {
            System.out.println(s);
        }
        System.out.println("\n");
        nomi=linea2.split(", ");
        for (String s : nomi) {
            System.out.println(s);
        }*/
        /*String s1 = "b";
        String s2 = "L";
        if(s1.compareTo(s2)>0){
            System.out.println("s1 è, maggiore di s2");
        }
        else if(s2.compareTo(s1)>0) {
            System.out.println("s2 è, maggiore di s1");
        }
        else {
            System.out.println("sono uguali");
        }*/
        String frase = "la mamma di martina va al mercato per comprare le fragole per fare la macedonia";
        System.out.println(frase.length());
        String[] fraseDivisa = new String[2];
        int endIndex;
        int i=0;
        //dividere la frase in 2 frasi
        /*if (" ".equals(frase.charAt(frase.length()/2))){
            fraseDivisa[0] = frase.substring(frase.length()/2);
            fraseDivisa[1] = frase.substring(frase.length()/2, frase.length());
        }
        else
        {*/
        do{
                i++;
                endIndex = (frase.length() - i) / 2;
            }while (" ".equals(frase.charAt(endIndex)));
            fraseDivisa[0] = frase.substring(0, endIndex);
            fraseDivisa[1] = frase.substring(endIndex, frase.length());
        //}
        System.out.println(fraseDivisa[0]);
        System.out.println(fraseDivisa[1]);
    }
}