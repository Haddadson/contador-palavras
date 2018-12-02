package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;

/**
 * Classe para representar a estrutura de dados <b>Lista Encadeada</b>, utilizada na
 * estrutura Hash - Lista Encadeada
 *
 * @author Gabriel Haddad
 */

public class Lista {

    private Celula primeiro, ultimo;
    private int qtdItens;
    private int comparacoes;
    private long tempoGasto;

    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
        this.qtdItens = 0;
        this.comparacoes = 0;
        this.tempoGasto = 0;
    }

    public Lista(ElementoFrase elemento) {
        this.primeiro = this.ultimo = new Celula(elemento);
        this.qtdItens++;
        this.comparacoes = 0;
        this.tempoGasto = 0;
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
     * Método para inserir um elemento no início da lista, verificando se o elemento
     * já está presente na lista e incrementando-o caso esteja<br>
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - elemento a ser inserido no início da estrutura
     */
    public void inserirInicio(ElementoFrase elemento) {
        if(validarAdicaoPalavra(elemento)){
            if (primeiroEstaNulo()) {
                primeiro = new Celula(elemento);
            } else if (!pesquisarEIncrementarQuantidadePalavra(elemento.getPalavra())) {
                Celula tmp = new Celula(elemento);

                tmp.ant = primeiro;
                tmp.prox = primeiro.prox;
                primeiro.prox = tmp;
                if (primeiro == ultimo) {
                    ultimo = tmp;
                } else {
                    tmp.prox.ant = tmp;
                }
                tmp = null;
                this.qtdItens++;
            }
        }
        
    }

    
    /**
     * Método para inserir um elemento no fim da lista, verificando se o
     * elemento já está presente na lista e incrementando-o caso esteja<br>
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - elemento a ser inserido no fim da
     * estrutura
     */
    public void inserirFim(ElementoFrase elemento) {
        if (validarAdicaoPalavra(elemento)) {
            if (primeiroEstaNulo()) {
                comparacoes++;
                primeiro = new Celula(elemento);
            } else if (!pesquisarEIncrementarQuantidadePalavra(elemento.getPalavra())) {
                ultimo.prox = new Celula(elemento);
                ultimo.prox.ant = ultimo;
                ultimo = ultimo.prox;
                this.qtdItens++;
            }
        }
    }

    
    /**
     * Método para remover o elemento do início da lista
     *
     * @author Gabriel Haddad
     * @return ElementoFrase - retorna o elemento removido
     * @throws java.lang.Exception - Lança exceção caso a lista esteja vazia
     */
    public ElementoFrase removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro!");
        }
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        ElementoFrase elemento = primeiro.getElemento();
        tmp.prox = primeiro.ant = null;
        tmp = null;
        this.qtdItens--;
        return elemento;
    }

    /**
     * Método para remover o elemento do fim da lista
     *
     * @author Gabriel Haddad
     * @return ElementoFrase - retorna o elemento removido
     * @throws java.lang.Exception - Lança exceção caso a lista esteja vazia
     */
    public ElementoFrase removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro!");
        }
        ElementoFrase elemento = ultimo.getElemento();
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        this.qtdItens--;
        return elemento;
    }

    /**
     * Método para remover o elemento específico da lista
     *
     * @author Gabriel Haddad
     * @param palavra String - palavra a ser removida da lista
     * @return ElementoFrase - retorna o elemento removido
     * @throws java.lang.Exception - Lança exceção caso a lista esteja vazia
     */
    public ElementoFrase removerPorPalavra(String palavra) throws Exception {
        Celula aux = primeiro.prox;
        ElementoFrase elemento;
        while (aux != null && (!aux.getElemento().getPalavra().equalsIgnoreCase(palavra))) {
            aux = aux.prox;
        }

        if (aux != null) {
            if (aux.prox == null && aux.ant != null) {
                elemento = removerFim();
            } else if (aux.ant == null && aux.prox != null) {
                elemento = removerInicio();
            } else {
                aux.ant.prox = aux.prox;
                aux.prox.ant = aux.ant;
                elemento = aux.getElemento();
                aux.prox = aux.ant = null;
                aux = null;
            }
            return elemento;
        }
        return null;
    }
    
    
    /**
     * Método para limpar a estrutura de dados
     *
     * @author Gabriel Haddad
     * @throws java.lang.Exception - Lança exceção caso a lista já esteja vazia
     */
    public void limparLista() throws Exception {
        while (primeiro != ultimo) {
            removerFim();
        }
    }

    
    /**
     * Método para buscar elemento na estrutura por palavra
     *
     * @author Gabriel Haddad
     * @param palavra String - palavra a ser buscada na estrutura
     * @return ElementoFrase - retorna o elemento encontrado na estrutura, caso não encontre
     * retorna <i>null</i>
     */
    public ElementoFrase pesquisarPorPalavraElementoFrase(String palavra) {
        Celula aux = primeiro;

        while (aux != null && (!palavra.equalsIgnoreCase(aux.getElemento().getPalavra()))) {
            aux = aux.prox;
        }

        if (aux != null) {
            return aux.getElemento();
        }
        return null;
    }

    
    /**
     * Método para buscar elemento na estrutura por palavra, incrementando-o caso o encontre
     *
     * @author Gabriel Haddad
     * @param palavra String - palavra a ser buscada na estrutura
     * @return boolean - retorna <i>true</i> caso encontre o elemento e 
     * <i>false</i> caso não encontre
     */
    public boolean pesquisarEIncrementarQuantidadePalavra(String palavra){
        Celula aux = primeiro;
        long tempoInicial = System.currentTimeMillis();
        while (aux != null && aux.getElemento() != null 
               && !palavra.equalsIgnoreCase(aux.getElemento().getPalavra())) {
            comparacoes += 2;
            aux = aux.prox;
        }

        if (aux != null && aux.getElemento() != null) {
            comparacoes++;
            setTempoGasto(System.currentTimeMillis() - tempoInicial);
            aux.getElemento().setQuantidade(aux.getElemento().getQuantidade() + 1);
            return true;
        }
        setTempoGasto(System.currentTimeMillis() - tempoInicial);
        return false;
    }

    
    /**
     * Método preencher ArrayList com todos elementos da lista
     *
     * @author Gabriel Haddad
     * @return ArrayList: ElementoFrase - retorna ArrayList com todos elementos da estrutura
     *
     */
    public ArrayList<ElementoFrase> obterListaComTodos(){
        Celula i = primeiro;
        ArrayList<ElementoFrase> listaElementos = new ArrayList<>();
        while (i != null) {
            if (i.getElemento() != null) {
                listaElementos.add(i.getElemento());
            }
            i = i.prox;
        
        }
        return listaElementos;
    }
    
    
    /**
     * Método para verificar se a estrutura está vazia
     *
     * @author Gabriel Haddad
     * @return boolean - retorna <i>true</i> caso esteja e <i>false</i> caso não esteja
     */
    public boolean isEmpty() {
        return primeiro == ultimo;
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
        return qtdItens <= 1024
                && palavra != null && palavra.getPalavra() != null
                && palavra.getPalavra().length() <= 20
                && palavra.getPalavra().length() > 0;
    }    

    
    /**
     * Método para verificar se o primeiro elemento da estrutura está nulo
     *
     * @author Gabriel Haddad
     * @return boolean - retorna <i>true</i> caso esteja e <i>false</i> caso não
     * esteja
     */    
    private boolean primeiroEstaNulo(){
        return primeiro.getElemento() == null;
    }

    public int getQtdItens() {
        return qtdItens;
    }
}
