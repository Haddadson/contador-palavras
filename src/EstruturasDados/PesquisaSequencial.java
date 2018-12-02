package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;

/**
 * Classe para representar a estrutura de dados que utiliza pesquisa sequencial
 * para checar se o elemento já existe
 *
 * @author Gabriel Haddad
 */
public class PesquisaSequencial extends PesquisaArray {

    public PesquisaSequencial() {
        super.listaPalavras = new ArrayList<>();
        super.comparacoes = 0;
        super.tempoGasto = 0;
    }

    /**
     * Método para adicionar uma palavra na estrutura, validando se a mesma já
     * está presente para incrementar sua quantidade e adicionando-a caso não
     * esteja
     *
     * @author Gabriel Haddad
     * @param palavra ElementoFrase - objeto que encapsula a palavra a ser
     * inserida e a quantidade de vezes que ela aparece no texto
     */
    public void adicionarEmLista(ElementoFrase palavra) {
        if (validarAdicaoPalavra(palavra)) {
            ordenarLista();
            System.out.println("------------------------------");
            System.out.println("Adicionando: \"" + palavra.getPalavra() + "\"");
            if (pesquisaSequencial(palavra.getPalavra()) != null) {
                listaPalavras.stream()
                        .filter(o -> o.getPalavra().equals(palavra.getPalavra()))
                        .forEach(o -> {
                            o.setQuantidade(o.getQuantidade() + 1);
                        });
            } else {
                listaPalavras.add(palavra);
            }
            System.out.println(obterInformacoesPesquisa());
        }
    }

    /**
     * Método para verificar se a lista contem a palavra
     *
     * @author Gabriel Haddad
     * @param palavra String - palavra a ser buscada na estrutura de dados
     * @return boolean - true caso a estrutura contenha a palavra, false caso
     * contrário
     */
    public boolean verificarSeListaContemPalavra(String palavra) {
        return listaPalavras.stream()
                .filter(o -> o.getPalavra().equals(palavra))
                .findAny().isPresent();
    }

    /**
     * Método para realizar a pesquisa sequencial, percorrendo a estruturas de
     * dados tentando encontrar a palavra informada
     *
     * @author Gabriel Haddad
     * @param palavraBusca String - palavra a ser buscada na estrutura de dados
     * @return ElementoFrase - retorna o objeto que encapsula a palavra na
     * estrutura de dados, contendo a quantidade de aparições dessa palavra no
     * texto
     */
    public ElementoFrase pesquisaSequencial(String palavraBusca) {
        ElementoFrase resultado = null;
        comparacoes = 0;
        long tempoInicial = System.currentTimeMillis();
        for (ElementoFrase elemento : listaPalavras) {
            if (elemento != null && elemento.getPalavra().equals(palavraBusca.toLowerCase())) {
                resultado = elemento;
            }
            comparacoes++;
        }
        setTempoGasto(System.currentTimeMillis() - tempoInicial);
        return resultado;
    }
}
