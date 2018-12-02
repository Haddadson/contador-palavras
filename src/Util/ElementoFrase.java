package Util;

/**
 * Classe para encapsular a palavra e a quantidade de vezes que ela aparece no
 * texto a ser lido
 *
 * @author Gabriel Haddad
 */
public class ElementoFrase {
   private String palavra;
   private int quantidade;
   
   public ElementoFrase(){
       palavra = "";
       quantidade = 1;
   }
   
   public ElementoFrase(String palavra){
       this.palavra = palavra;
       quantidade = 1;
   }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
   
   @Override
    public String toString(){
        return getPalavra() + "\t\t" + getQuantidade();
    }
}
