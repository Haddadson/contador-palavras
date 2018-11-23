
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
    
    private final List<ElementoFrase> listaPalavras;
    private int comparacoes;
    private long tempoGasto;
    
    public PesquisaSequencial(){
        listaPalavras = new ArrayList<>();
        comparacoes = 0;
        tempoGasto = 0;
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
    
    //TODO: verificarSeListaContemPalavra deve ser trocado por pesquisa
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
        System.out.println("Lista - Pesquisa Sequencial");
        listaPalavras.forEach((elemento) -> {
            System.out.println(elemento.toString());
        });
    }
    
    public ElementoFrase pesquisaSequencial(String palavraBusca){
        ElementoFrase resultado = null;
        long tempoInicial = System.currentTimeMillis();
        for (ElementoFrase elemento : listaPalavras){
            if(elemento != null && elemento.getPalavra().equals(palavraBusca.toLowerCase())){
                resultado = elemento;
            }
            comparacoes++;
        }
        setTempoGasto(System.currentTimeMillis() - tempoInicial);
        return resultado;
    }
    
    public String obterInformacoesPesquisa(){
        return "Comparações: " + getComparacoes() + "\nTempo Gasto: " + getTempoGasto() + " ms";
    }
}
