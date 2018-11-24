/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Haddad
 */
public class PesquisaBinaria extends PesquisaArray {
     private ElementoFrase[] arrayElementoFrase;
    
    public PesquisaBinaria(){
        super.listaPalavras = new ArrayList<>();
        super.comparacoes = 0;
        super.tempoGasto = 0;
    }
    
    public void adicionarEmLista(ElementoFrase palavra){
        if(validarAdicaoPalavra(palavra)){
            System.out.println("------------------------------");
            System.out.println("Adicionando: \"" + palavra.getPalavra() + "\"");
            arrayElementoFrase = listaPalavras.toArray(new ElementoFrase[listaPalavras.size()]);
            if(efetuarPesquisaBinaria(arrayElementoFrase, 
                    palavra.getPalavra(), listaPalavras.size(), 0) != -1){
                listaPalavras.stream()
                        .filter(o -> o.getPalavra().equals(palavra.getPalavra()))
                        .forEach(o -> {
                            o.setQuantidade(o.getQuantidade() + 1);
                            System.out.println("Quantidade: " + o.getQuantidade());
                        });
            }
            else{
                listaPalavras.add(palavra);
                System.out.println("Quantidade: " + palavra.getQuantidade());
            }
            System.out.println(obterInformacoesPesquisa());
        }
    }
    
    public int efetuarPesquisaBinaria(ElementoFrase[] vetorPalavras, String palavraBuscada, int fim, int inicio){
        long tempoInicial = System.currentTimeMillis(); 
        int resultado = pesquisaBinaria((ElementoFrase[]) listaPalavras.toArray(), 
                    palavraBuscada, listaPalavras.size(), 0);
        setTempoGasto(System.currentTimeMillis() - tempoInicial);

        return resultado;
    }
    
    public int pesquisaBinaria(ElementoFrase[] vetorPalavras, String palavraBuscada, int fim, int inicio) {
        int meio = (fim + inicio) / 2;
        if (fim == inicio || inicio == meio || fim == meio) {
            comparacoes++;
            return -1;
        }
        if (vetorPalavras[meio].getPalavra().compareToIgnoreCase(palavraBuscada) < 0) {
            comparacoes++;
            return pesquisaBinaria(vetorPalavras, palavraBuscada, fim, meio);
        } else if (vetorPalavras[meio].getPalavra().compareToIgnoreCase(palavraBuscada) > 0) {
            comparacoes++;
            return pesquisaBinaria(vetorPalavras, palavraBuscada, meio, inicio);
        } else if (vetorPalavras[meio].getPalavra().compareToIgnoreCase(palavraBuscada) == 0) {
            comparacoes++;
            return meio;
        }
        return -1;
    }
    

    
}
