
package EstruturasDados;

import Util.ComparadorElementoFrase;
import Util.ElementoFrase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Gabriel Haddad
 */
public class PesquisaSequencial {
    
    private List<ElementoFrase> listaPalavras;
    private int comparacoes;
    
    public PesquisaSequencial(){
        listaPalavras = new ArrayList<>();
        comparacoes = 0;
    }
    
    public void adicionarEmLista(ElementoFrase palavra){
        if(listaPalavras.size() <= 1024 
           && palavra != null && palavra.getPalavra() != null
           && palavra.getPalavra().length() <= 20
           && palavra.getPalavra().length() > 0){
            if(verificarSeListaContemPalavra(palavra.getPalavra())){
                listaPalavras.stream()
                            .filter(o -> o.getPalavra().equals(palavra.getPalavra()))
                            .forEach(o -> {
                                o.setQuantidade(o.getQuantidade() + 1);
                            });
            }
            else
                listaPalavras.add(palavra);
        }
    }
    
    public boolean verificarSeListaContemPalavra(String palavra){
        return listaPalavras.stream()
                            .filter(o -> o.getPalavra().equals(palavra))
                            .findAny().isPresent();
    }    
        
    public void ordenarLista(){
        Collections.sort(this.listaPalavras, new ComparadorElementoFrase());
    }
    
    public void imprimirLista(){
        listaPalavras.forEach((elemento) -> {
            System.out.println(elemento.toString() + "\n");
        });
    }
}
