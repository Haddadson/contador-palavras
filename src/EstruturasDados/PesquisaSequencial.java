
package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Haddad
 */
public class PesquisaSequencial extends PesquisaArray{
    
    public PesquisaSequencial(){
        super.listaPalavras = new ArrayList<>();
        super.comparacoes = 0;
        super.tempoGasto = 0;
    }
    
    public void adicionarEmLista(ElementoFrase palavra){
        if(validarAdicaoPalavra(palavra)){
            ordenarLista();
            System.out.println("------------------------------");
            System.out.println("Adicionando: \"" + palavra.getPalavra() + "\"");
            if(pesquisaSequencial(palavra.getPalavra()) != null){
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

    public boolean verificarSeListaContemPalavra(String palavra){
        return listaPalavras.stream()
                            .filter(o -> o.getPalavra().equals(palavra))
                            .findAny().isPresent();
    }    
           
    public ElementoFrase pesquisaSequencial(String palavraBusca){
        ElementoFrase resultado = null;
        comparacoes = 0;
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

}
