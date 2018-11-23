/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
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
