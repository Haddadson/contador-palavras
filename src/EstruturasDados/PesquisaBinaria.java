/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDados;

import Util.ComparadorElementoFrase;
import Util.ElementoFrase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
            System.out.println("------------------------------");
            System.out.println("Adicionando: \"" + palavra.getPalavra() + "\"");
            if(listaPalavras.isEmpty()){
                listaPalavras.add(palavra);
                System.out.println("Quantidade: " + palavra.getQuantidade());

            }else {
                arrayElementoFrase = listaPalavras.toArray(new ElementoFrase[listaPalavras.size()]);
                int posicaoElemento = binarySearch(arrayElementoFrase, palavra.getPalavra());
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
            System.out.println(obterInformacoesPesquisa());
        }
    }
    
    public int pesquisaBinariaRecursiva(ElementoFrase arr[], int inicio, int fim, String x) {
        
        if (fim >= inicio) {
            int meio = inicio + (fim - inicio) / 2;

            if (arr[meio].getPalavra().equals(x)) {
                return meio;
            }

            if (arr[meio].getPalavra().compareToIgnoreCase(x) > 0) {
                return pesquisaBinariaRecursiva(arr, inicio, meio - 1, x);
            }

            return pesquisaBinariaRecursiva(arr, meio + 1, fim, x);
        }

        return -1;
    }
    
    int binarySearch(ElementoFrase arr[], String x) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid].getPalavra().compareToIgnoreCase(x) < 0) {
                hi = mid - 1;
            } else if (arr[mid].getPalavra().compareToIgnoreCase(x) > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
