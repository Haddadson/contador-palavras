package EstruturasDados;

import Util.ComparadorElementoFrase;
import Util.ElementoFrase;
import java.util.Collections;
import java.util.List;

/**
 * Classe pai para pesquisas em vetor, permitindo reutilização de código
 *
 * @author Gabriel Haddad
 */
public class PesquisaArray {

    protected List<ElementoFrase> listaPalavras;
    protected int comparacoes;
    protected long tempoGasto;

    public PesquisaArray() {

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

    /**
     * Método para validar se a palavra pode ser adicionada na estrutura de
     * dados
     *
     * @author Gabriel Haddad
     * @param palavra ElementoFrase - objeto que encapsula a palavra a ser
     * inserida e a quantidade de vezes que ela aparece no texto
     * @return boolean - Retorna true caso a palavra esteja válida para
     * inserção, caso contrário retorna false
     */
    public boolean validarAdicaoPalavra(ElementoFrase palavra) {
        return listaPalavras.size() <= 1024
                && palavra != null && palavra.getPalavra() != null
                && palavra.getPalavra().length() <= 20
                && palavra.getPalavra().length() > 0;
    }

    /**
     * Método para imprimir a lista de palavras
     *
     * @author Gabriel Haddad
     */
    public void imprimirLista() {
        listaPalavras.forEach((elemento) -> {
            System.out.println(elemento.toString());
        });
    }

    /**
     * Método para ordenar a lista de palavras por palavra
     *
     * @author Gabriel Haddad
     */
    public void ordenarLista() {
        Collections.sort(this.listaPalavras, new ComparadorElementoFrase());
    }

    /**
     * Método para obter o número de comparações e o tempo gasto na pesquisa
     *
     * @author Gabriel Haddad
     * @return String - retorna o número de comparações e o tempo gasto na
     * pesquisa em uma String
     */
    public String obterInformacoesPesquisa() {
        return "Comparações: " + getComparacoes() + "\nTempo Gasto: " + getTempoGasto() + " ms";
    }
}
