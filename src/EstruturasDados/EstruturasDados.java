/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDados;

import Util.ElementoFrase;

/**
 *
 * @author Gabriel Haddad
 */
public class EstruturasDados {
    private PesquisaSequencial pseq;
    private PesquisaBinaria pbinaria;

    public EstruturasDados(){
        pseq = new PesquisaSequencial();
        pbinaria = new PesquisaBinaria();
    }
    
    public void popularPesquisaSequencial(String[] palavras){
        System.out.println("Preenchendo lista para Pesquisa Sequencial");
        for (String palavra : palavras) {
            pseq.adicionarEmLista(new ElementoFrase(palavra));
        }
    }
    
    public void imprimirListaPesquisaSequencial(){
        System.out.println("\nImprimindo Lista - Pesquisa Sequencial");
        pseq.ordenarLista();
        pseq.imprimirLista();
    }
    
    public void popularPesquisaBinaria(String[] palavras){
        System.out.println("Preenchendo lista para Pesquisa Binária");
        for (String palavra : palavras) {
            pbinaria.adicionarEmLista(new ElementoFrase(palavra));
        }
    }
    
    public void imprimirListaPesquisaBinaria(){
        System.out.println("\nImprimindo Lista - Pesquisa Binária");
        pbinaria.ordenarLista();
        pbinaria.imprimirLista();
    }
    
    
}
