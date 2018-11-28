package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;

/**
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
    
    public void inserir(ElementoFrase x) throws Exception {
        System.out.println("------------------------------");
        System.out.println("Adicionando: \"" + x.getPalavra() + "\"");
        if(!pesquisar(x)){
            raiz = inserir(x, raiz);
        }
        System.out.println(obterInformacoesPesquisa());
    }

    private No inserir(ElementoFrase x, No i) throws Exception {
        
        if (i == null) {
            i = new No(x);
        } else if (x.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) < 0) {
            i.esq = inserir(x, i.esq);
        } else if (x.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) > 0) {
            i.dir = inserir(x, i.dir);
        } else {
            throw new Exception("Erro!");
        }

        return i;
    }

    public boolean pesquisar(ElementoFrase x) {
        long tempoInicial = System.currentTimeMillis();
        comparacoes = 0;
        boolean resultado = pesquisar(x, raiz);
        setTempoGasto(System.currentTimeMillis() - tempoInicial);
        System.out.println();
        return resultado;
    }

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

    public ArrayList<ElementoFrase> armazenarValoresArvore(No raiz) {
        percorrerArvore(raiz);
        return values;
    }

    private void percorrerArvore(No node) {
        if (node != null) {
            percorrerArvore(node.esq);
            values.add(node.elemento);
            percorrerArvore(node.dir);
        }
    }
    
    public String obterInformacoesPesquisa(){
        return "Comparações: " + getComparacoes() + "\nTempo Gasto: " + getTempoGasto() + " ms";
    }
}
