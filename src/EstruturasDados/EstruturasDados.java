package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Haddad
 */

public class EstruturasDados {
    
    private final PesquisaSequencial pseq;
    private final PesquisaBinaria pbinaria;
    private final ArvoreBinaria arvore;
    private long tempoGastoTotal;
    
    public EstruturasDados(){
        pseq = new PesquisaSequencial();
        pbinaria = new PesquisaBinaria();
        arvore = new ArvoreBinaria();
        tempoGastoTotal = 0;
    }

    public long getTempoGastoTotal() {
        return tempoGastoTotal;
    }

    public void setTempoGastoTotal(long tempoGastoTotal) {
        this.tempoGastoTotal = tempoGastoTotal;
    }
    
    public void popularPesquisaSequencial(String[] palavras){
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Preenchendo lista para Pesquisa Sequencial");
        for (String palavra : palavras) {
            pseq.adicionarEmLista(new ElementoFrase(palavra));
        }
        setTempoGastoTotal(System.currentTimeMillis() - tempoInicial);

    }
    
    public void imprimirListaPesquisaSequencial(){
        System.out.println("\nImprimindo Lista - Pesquisa Sequencial");
        pseq.ordenarLista();
        pseq.imprimirLista();
        System.out.println("--------------------------------------------");
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }
    
    public void popularPesquisaBinaria(String[] palavras){
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Preenchendo lista para Pesquisa Binária");
        for (String palavra : palavras) {
            pbinaria.adicionarEmLista(new ElementoFrase(palavra));
        }
        setTempoGastoTotal(System.currentTimeMillis() - tempoInicial);

    }
    
    public void imprimirListaPesquisaBinaria(){
        System.out.println("\nImprimindo Lista - Pesquisa Binária");
        pbinaria.ordenarLista();
        pbinaria.imprimirLista();
        System.out.println("--------------------------------------------");
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }
    
     public void popularArvoreBinaria(String[] palavras){
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Preenchendo Árvore Binária de Pesquisa");
        try {
           for (String palavra : palavras) {
               arvore.inserir(new ElementoFrase(palavra));
           }
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao inserir: "  + ex);
        }
        setTempoGastoTotal(System.currentTimeMillis() - tempoInicial);

    }
    
    public void imprimirArvoreBinaria(){
        System.out.println("\nImprimindo Árvore Binária de Pesquisa");
        ArrayList<ElementoFrase> valoresArvore = arvore.armazenarValoresArvore(arvore.getRaiz());
        valoresArvore.forEach((valor) -> {
            System.out.println(valor.toString());
        });
        System.out.println("--------------------------------------------");
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }
}
