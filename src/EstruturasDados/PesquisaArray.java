/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDados;

import Util.ComparadorElementoFrase;
import Util.ElementoFrase;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author DTI
 */
public class PesquisaArray {
    protected List<ElementoFrase> listaPalavras;
    protected int comparacoes;
    protected long tempoGasto;

    public PesquisaArray(){
        
    }
    
    public PesquisaArray(List<ElementoFrase> listaPalavras, int comparacoes, long tempoGasto) {
        this.listaPalavras = listaPalavras;
        this.comparacoes = comparacoes;
        this.tempoGasto = tempoGasto;
    }
    
    
    public int getComparacoes() {
        return comparacoes;
    }   

    public void setTempoGasto(long tempoGasto) {
        this.tempoGasto = tempoGasto;
    }
    
    public long getTempoGasto() {
        return tempoGasto;
    }

    public List<ElementoFrase> getListaPalavras() {
        return listaPalavras;
    }
    
    public boolean validarAdicaoPalavra(ElementoFrase palavra) {
        return listaPalavras.size() <= 1024 
                && palavra != null && palavra.getPalavra() != null
                && palavra.getPalavra().length() <= 20
                && palavra.getPalavra().length() > 0;
    }
    
    public void imprimirLista(){
        listaPalavras.forEach((elemento) -> {
            System.out.println(elemento.toString());
        });
    }
    
    public void ordenarLista(){
        Collections.sort(this.listaPalavras, new ComparadorElementoFrase());
    }
    
    public String obterInformacoesPesquisa(){
        return "Comparações: " + getComparacoes() + "\nTempo Gasto: " + getTempoGasto() + " ms";
    }
}
