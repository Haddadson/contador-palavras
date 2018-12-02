package EstruturasDados;

import Util.ComparadorElementoFrase;
import Util.ElementoFrase;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que representa a estrutura de dados Hash com Lista Encadeada
 *
 * @author Gabriel Haddad
 */

public class HashLista {
    private final int tamanhoVetorHash;
    private final Lista tabela[];
    private int comparacoes;
    private long tempoGasto;

    public HashLista() {
        this.tamanhoVetorHash = 5;
        this.tabela = new Lista[tamanhoVetorHash];
        inicializarListasTabela();
    }

    public HashLista(int m) {
        this.tamanhoVetorHash = m;
        this.tabela = new Lista[m];
        inicializarListasTabela();
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

    /**
     * Método para limpar a estrutura de dados
     *
     * @author Gabriel Haddad
     */
    public void zerarTabela() {
        for (int i = 0; i < tabela.length; i++) {
            this.tabela[i] = null;
        }
    }
    
    /**
     * Método para inicializar as listas encadeadas de cada posição da estrutura
     * de dados
     *
     * @author Gabriel Haddad
     */
    private void inicializarListasTabela(){
        for (int i = 0; i < tabela.length; i++) {
            this.tabela[i] = new Lista();
        }
    }

    /**
     * Método para cálculo do hash, obtendo a posição onde o elemento deve ser
     * inserido
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - elemento a ser inserido na estrutura
     * @return retorna a posição que o elemento será inserido no vetor após
     * calcular o hash
     */
    private int hash(ElementoFrase elemento) {
        int hash = elemento.getPalavra().hashCode();
        return hash % tamanhoVetorHash * (hash >= 0 ? 1 : -1);
    }

    /**
     * Método para inserir uma palavra na estrutura de dados, verificando se a
     * mesma já está presente e incrementando-a caso esteja<br>
     * Os elementos são inseridos na lista encadeada de cada posição
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - elemento a ser inserido na estrutura de
     * dados
     * @throws java.lang.Exception - Lança exceção caso algum erro ocorra na
     * inserção
     */
    public void inserir(ElementoFrase elemento) throws Exception {
        if(validarAdicaoPalavra(elemento)){
            int pos = hash(elemento);
            System.out.println("------------------------------");
            System.out.println("Adicionando: \"" + elemento.getPalavra() + "\"");
            tabela[pos].inserirFim(elemento);
            comparacoes = tabela[pos].getComparacoes();
            tempoGasto = tabela[pos].getTempoGasto();
            System.out.println(obterInformacoesPesquisa());
        }
    }

    /**
     * Método para remover um elemento da estrutura de dados<br>
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - Elemento a ser removido da estrutura
     * @throws java.lang.Exception - Lança exceção caso um erro ocorra na
     * remoção
     */
    public void remover(ElementoFrase elemento) throws Exception {
        int pos = hash(elemento);
        tabela[pos].removerPorPalavra(elemento.getPalavra());
    }

    /**
     * Método para imprimir todos elementos da estrutura de dados, transferindo
     * todos elementos das listas de cada posição para um ArrayList e 
     * ordenando-os antes de imprimi-los
     *
     * @author Gabriel Haddad
     */
    public void imprimirHashOrdenado() {
        ArrayList<ElementoFrase> listaElementos = new ArrayList();
        for (Lista lista : tabela) {
            if (lista != null && !lista.isEmpty()) {
                listaElementos.addAll(lista.obterListaComTodos());
            }
        }

        Collections.sort(listaElementos, new ComparadorElementoFrase());
        listaElementos.forEach((elemento) -> {
            System.out.println(elemento.toString());
        });
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
        return tabela.length <= 1024
                && palavra != null && palavra.getPalavra() != null
                && palavra.getPalavra().length() <= 20
                && palavra.getPalavra().length() > 0;
    }
    
    
    /**
     * Método para obter o número de comparações e o tempo gasto na pesquisa
     *
     * @author Gabriel Haddad
     * @return String - retorna o número de comparações e o tempo gasto na
     * pesquisa em uma String
     */   
    public String obterInformacoesPesquisa(){
        return "Comparações: " + getComparacoes() + "\nTempo Gasto: " + getTempoGasto() + " ms";
    }

}
