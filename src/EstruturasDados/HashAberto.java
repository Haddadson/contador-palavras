package EstruturasDados;

import Util.ComparadorElementoFrase;
import Util.ElementoFrase;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que representa a estrutura de dados Hash com Endereçamento Aberto
 *
 * @author Gabriel Haddad
 */

public class HashAberto {
    private int tamanhoVetorHash;
    private int proximaPosicaoAreaReserva;
    private int reserva;
    private ElementoFrase tabela[];
    private int comparacoes;
    private long tempoGasto;
 
    public HashAberto() {
        this.tamanhoVetorHash = 5;
        this.proximaPosicaoAreaReserva = 5;
        this.reserva = 0;
        this.tabela = new ElementoFrase[tamanhoVetorHash + proximaPosicaoAreaReserva];
    }
 
    public HashAberto(int m, int t) {
        this.tamanhoVetorHash = m;
        this.proximaPosicaoAreaReserva = t;
        this.reserva = 0;
        this.tabela = new ElementoFrase[m + t];
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
        for (int i = 0; i < tabela.length; i++)
            this.tabela[i] = null;
    }
 
    /**
     * Método para cálculo do hash, obtendo a posição onde o elemento deve ser inserido
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - elemento a ser inserido na estrutura
     * @return retorna a posição que o elemento será inserido no vetor 
     * após calcular o hash
     */
    private int hash(ElementoFrase elemento) {
        int hash = elemento.getPalavra().hashCode();
        return hash % tamanhoVetorHash * (hash >= 0 ? 1 : -1);
    }
 
    /**
     * Método para inserir uma palavra na estrutura de dados, verificando se a mesma 
     * já está presente e incrementando-a caso esteja<br>
     * Se um elemento diferente já estiver na posição, o elemento é direcionado para 
     * a área de reserva
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - elemento a ser inserido na estrutura de dados
     * @throws java.lang.Exception - Lança exceção caso algum erro ocorra na inserção
     */
    public void inserir(ElementoFrase elemento) throws Exception {
        comparacoes = 0;
        System.out.println("------------------------------");
        System.out.println("Adicionando: \"" + elemento.getPalavra() + "\"");
        
        int pos = hash(elemento);
 
        if (tabela[pos] == null) {
            comparacoes++;
            tabela[pos] = elemento;
        } else if (tabela[pos].getPalavra().equals(elemento.getPalavra())){
            comparacoes++;                        
            tabela[pos].setQuantidade(tabela[pos].getQuantidade() + 1);
        }else if ((tamanhoVetorHash + reserva) < tabela.length) {
            comparacoes++;
            tabela[tamanhoVetorHash + reserva] = elemento;
            reserva++;
        } else {
            throw new Exception("::ERRO:: Area de reserva cheia");
        }
        System.out.println(obterInformacoesPesquisa());
    }
 
    /**
     * Método para calcular a porcentagem de colisões que ocorreram ao inserir
     * os elementos
     *
     * @author Gabriel Haddad
     * @return retorna a porcentagem de elementos na área de reserva em relação
     * ao tamanho do vetor
     */
    private double colisoes() {
        return reserva / tamanhoVetorHash * 100;
    }
 
    /**
     * Método para remover um elemento da estrutura de dados<br>
     * Caso um elemento referente a posição alterada esteja na área de reserva, ele
     * será transferido para esta posição da estrutura
     *
     * @author Gabriel Haddad
     * @param elemento ElementoFrase - Elemento a ser removido da estrutura
     * @throws java.lang.Exception - Lança exceção caso um erro ocorra na remoção
     */
    public void remover(ElementoFrase elemento) throws Exception {
        int pos = hash(elemento);
 
        if (tabela[pos] == elemento) {
            tabela[pos] = null;
            for (int i = tamanhoVetorHash; i < tamanhoVetorHash + reserva; i++) {
                int hash = tabela[i].hashCode();
                if ((hash % tamanhoVetorHash * ((hash > 0) ? 1 : -1)) == pos) {
                    tabela[pos] = tabela[i];
                    for (int j = i; j < tamanhoVetorHash + reserva - 1; j++)
                        tabela[j] = tabela[j + 1];
                    reserva--;
                    i = tamanhoVetorHash + reserva;
                }
            }
        } else if (tabela[pos] == null) {
            throw new Exception("ERRO:: NAO EXISTE ELEMENTO");
 
        } else {
            for (int i = tamanhoVetorHash; i < tamanhoVetorHash + reserva; i++) {
                if (tabela[i] == elemento) {
                    for (int j = i; j < tamanhoVetorHash + reserva - 1; j++)
                        tabela[j] = tabela[j + 1];
                    reserva--;
                    i = tamanhoVetorHash + reserva;
                }
            }
        }
    }
    
    /**
     * Método para imprimir todos elementos da estrutura de dados, transferindo 
     * todos elementos para um ArrayList e ordenando-os antes de imprimi-los
     *
     * @author Gabriel Haddad
     */
    public void imprimirHashOrdenado(){
        ArrayList<ElementoFrase> listaElementos = new ArrayList();
        for (ElementoFrase elemento : tabela){
            if(elemento != null){
                listaElementos.add(elemento);
            }
        }
        
        Collections.sort(listaElementos, new ComparadorElementoFrase());
        listaElementos.forEach((elemento) -> {
            System.out.println(elemento.toString());
        });
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
