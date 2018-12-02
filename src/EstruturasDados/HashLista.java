package EstruturasDados;

import Util.ComparadorElementoFrase;
import Util.ElementoFrase;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gabriel Haddad
 */

public class HashLista {
    private int tamanhoVetorHash;
    private Lista tabela[];
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

    public void zerarTabela() {
        for (int i = 0; i < tabela.length; i++) {
            this.tabela[i] = null;
        }
    }
    
    private void inicializarListasTabela(){
        for (int i = 0; i < tabela.length; i++) {
            this.tabela[i] = new Lista();
        }
    }

    private int hash(ElementoFrase k) {
        int hash = k.getPalavra().hashCode();
        return hash % tamanhoVetorHash * (hash >= 0 ? 1 : -1);
    }

    public void inserir(ElementoFrase elemento) throws Exception {
        int pos = hash(elemento);
        System.out.println("------------------------------");
        System.out.println("Adicionando: \"" + elemento.getPalavra() + "\"");
        tabela[pos].inserirFim(elemento);
        comparacoes = tabela[pos].getComparacoes();
        tempoGasto = tabela[pos].getTempoGasto();
        System.out.println(obterInformacoesPesquisa());

    }

    public void remover(ElementoFrase elemento) throws Exception {
        int pos = hash(elemento);
        tabela[pos].removerPorPalavra(elemento.getPalavra());
    }

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
    
    public String obterInformacoesPesquisa(){
        return "Comparações: " + getComparacoes() + "\nTempo Gasto: " + getTempoGasto() + " ms";
    }

}
