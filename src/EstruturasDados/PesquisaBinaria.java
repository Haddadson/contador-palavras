/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            comparacoes = 0;
            long tempoInicial = System.currentTimeMillis();
            
            System.out.println("------------------------------");
            System.out.println("Adicionando: \"" + palavra.getPalavra() + "\"");

            if(listaPalavras.isEmpty()){
                comparacoes++;
                listaPalavras.add(palavra);
                System.out.println("Quantidade: " + palavra.getQuantidade());
            } else {
                arrayElementoFrase = listaPalavras.toArray(new ElementoFrase[listaPalavras.size()]);
                int posicaoElemento = pesquisaBinaria(arrayElementoFrase, palavra.getPalavra());
                if (posicaoElemento == -1) {
                    listaPalavras.add(palavra);
                    System.out.println("Quantidade: " + palavra.getQuantidade());
                } else {
                    arrayElementoFrase[posicaoElemento].setQuantidade(arrayElementoFrase[posicaoElemento].getQuantidade() + 1);
                    List<ElementoFrase> listaAuxiliar = Arrays.asList(arrayElementoFrase);
                    listaPalavras = new ArrayList<>(listaAuxiliar);
                    
                    System.out.println("Quantidade: " + palavra.getQuantidade());
                }
            }
            setTempoGasto(System.currentTimeMillis() - tempoInicial);

            System.out.println(obterInformacoesPesquisa());
        }
    }

    public int pesquisaBinaria(ElementoFrase arr[], String palavra) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].getPalavra().compareToIgnoreCase(palavra) < 0) {
                comparacoes++;
                high = mid - 1;
            } else if (arr[mid].getPalavra().compareToIgnoreCase(palavra) > 0) {
                comparacoes++;
                low = mid + 1;
            } else {
                comparacoes++;
                return mid;
            }
        }

        return -1;
    }
}
