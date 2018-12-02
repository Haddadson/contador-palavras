package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;

/**
 * Classe que representa a estrutura de dados <b>Árvore Binária</b>
 *
 * @author Gabriel Haddad
 */

public class ArvoreBinaria {
    private No raiz;
    private int comparacoes;
    private long tempoGasto;
    private final ArrayList<ElementoFrase> values;

    public ArvoreBinaria() {
        raiz = null;
        values = new ArrayList<>();
    }

    public No getRaiz() {
        return raiz;
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
     * Método para adicionar uma palavra na estrutura, validando se a mesma já está
     * presente para incrementar sua quantidade e adicionando-a caso não esteja
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - objeto que encapsula a palavra a ser 
     * inserida e a quantidade de vezes que ela aparece no texto
     * @throws java.lang.Exception - lança exceção caso ocorra um erro na inserção
     */
    public void inserir(ElementoFrase elemento) throws Exception {
        System.out.println("------------------------------");
        System.out.println("Adicionando: \"" + elemento.getPalavra() + "\"");
        if(!pesquisar(elemento)){
            raiz = inserir(elemento, raiz);
        }
    }

    /**
     * Método recursivo para adicionar uma palavra na estrutura, percorrendo a estrutura
     * para encontrar a posição do novo elemento
     * 
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - objeto que encapsula a palavra a ser 
     * inserida e a quantidade de vezes que ela aparece no texto
     * @param i No - objeto utilizado para percorrer a árvore para a esquerda e direita
     * @throws java.lang.Exception - lança exceção caso ocorra um erro na inserção
     */
    private No inserir(ElementoFrase elemento, No i) throws Exception {
        
        if (i == null) {
            i = new No(elemento);
        } else if (elemento.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) < 0) {
            i.esq = inserir(elemento, i.esq);
        } else if (elemento.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) > 0) {
            i.dir = inserir(elemento, i.dir);
        } else {
            throw new Exception("Erro!");
        }

        return i;
    }
    
    
    /**
     * Método para enconrar uma palavra na estrutura, disparando outro
     * método recursivo para percorrer a árvore
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - objeto que encapsula a palavra a ser
     * inserida e a quantidade de vezes que ela aparece no texto
     * @return retorna true caso encontre o elemento, false caso não encontre
     */
    public boolean pesquisar(ElementoFrase elemento) {
        long tempoInicial = System.currentTimeMillis();
        comparacoes = 0;
        boolean resultado = pesquisar(elemento, raiz);
        setTempoGasto(System.currentTimeMillis() - tempoInicial);
        System.out.println(obterInformacoesPesquisa());
        return resultado;
    }

    
    /**
     * Método recursivo para enconrar uma palavra na estrutura, percorrendo a
     * árvore binária e comparando os elementos com a palavra a ser buscada<br>
     * Caso encontre o elemento, sua quantidade é incrementada
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - objeto que encapsula a palavra a ser
     * inserida e a quantidade de vezes que ela aparece no texto
     * @param i No - objeto utilizado para percorrer a árvore para a esquerda e direita
     * @return boolean - retorna true caso encontre o elemento, false caso não encontre
     */
    private boolean pesquisar(ElementoFrase x, No i) {
        boolean resp;
        if (i == null) {
            comparacoes++;
            resp = false;
        } else if (x.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) == 0) {
            comparacoes++;
            i.elemento.setQuantidade(i.elemento.getQuantidade() + 1);
            resp = true;
        } else if (x.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) < 0) {
            comparacoes++;
            resp = pesquisar(x, i.esq);
        } else {
            comparacoes++;
            resp = pesquisar(x, i.dir);
        }
        return resp;
    }

    /**
     * Método para executar a recursão que preenche uma lista com todos elementos
     * da árvore
     *
     * @author Gabriel Haddad
     * @param raiz No - Primeiro elemento da árvore, utilizado como ponto de partida
     * para percorrer a árvore
     * @return ArrayList: ElementoFrase - lista com todos elementos da árvore
     */
    public ArrayList<ElementoFrase> armazenarValoresArvore(No raiz) {
        percorrerArvore(raiz);
        return values;
    }

    /**
     * Método para percorrer a árvore binária, adicionando os elementos em um ArrayList
     *
     * @author Gabriel Haddad
     * @param node No - elemento utilizado como ponto de partida para percorrer a árvore
     */
    private void percorrerArvore(No node) {
        if (node != null) {
            percorrerArvore(node.esq);
            values.add(node.elemento);
            percorrerArvore(node.dir);
        }
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
