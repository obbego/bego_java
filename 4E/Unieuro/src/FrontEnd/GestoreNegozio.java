package FrontEnd;

import Backend.Elettronica.ProdottoElettronico;

import java.util.ArrayList;

public class GestoreNegozio {
    private String nomeNegozio;

    private ArrayList<ProdottoElettronico> prodotti;

    public GestoreNegozio(String nomeNegozio) {
        this.nomeNegozio = nomeNegozio;
        prodotti = new ArrayList<>();
    }

   /* public void aggiungiProdotto(ProdottoElettronico prodotto) throws Exception{
       for(int i = 0; i < prodotti.size(); i++){
           if(prodotti.get(i).getProdotto().equals(prodotto.getProdotto())){
               throw new Exception ("codice già esistente");
           }
       }

        prodotti.add(prodotto);
    }*/

    /*public boolean codiceEsistente(ProdottoElettronico prodotto){
        for(ProdottoElettronico x : prodotti){
            if(x.getProdotto().equals(prodotto.getProdotto())){
                return true;
            }
        }
        return false;
    }

     */
    public boolean codiceEsistente(ProdottoElettronico prodotto){
        for(ProdottoElettronico x : prodotti){
            if(prodotti.contains(prodotto)){
                return true;
            }
        }
        return false;
    }
    public void aggiungiProdotto(ProdottoElettronico prodotto)throws Exception{
        if(codiceEsistente(prodotto)) {
            throw new Exception("Codice già presente");
        }
        prodotti.add(prodotto);
    }

    public void visualizza(){
        if(prodotti.isEmpty()){
            System.out.println("array vuoto");
        } else {
            prodotti.forEach(x -> System.out.println(x.toString()));
        }
    }
}