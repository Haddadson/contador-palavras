package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Haddad
 */

public class EstruturasDados {
    
    private final PesquisaSequencial pseq;
    private final PesquisaBinaria pbinaria;
    private final ArvoreBinaria arvore;
    private final HashAberto haberto;
    private long tempoGastoTotal;
    
    public EstruturasDados(){
        pseq = new PesquisaSequencial();
        pbinaria = new PesquisaBinaria();
        arvore = new ArvoreBinaria();
        haberto = new HashAberto(1024, 100);
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
        System.out.println("Preenchendo lista para Pesquisa Binaria");
        for (String palavra : palavras) {
            pbinaria.adicionarEmLista(new ElementoFrase(palavra));
        }
        setTempoGastoTotal(System.currentTimeMillis() - tempoInicial);

    }
    
    public void imprimirListaPesquisaBinaria(){
        System.out.println("\nImprimindo Lista - Pesquisa Binaria");
        pbinaria.ordenarLista();
        pbinaria.imprimirLista();
        System.out.println("--------------------------------------------");
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }
    
     public void popularArvoreBinaria(String[] palavras){
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Preenchendo Arvore Binaria de Pesquisa");
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
        System.out.println("\nImprimindo Arvore Binaria de Pesquisa");
        ArrayList<ElementoFrase> valoresArvore = arvore.armazenarValoresArvore(arvore.getRaiz());
        valoresArvore.forEach((valor) -> {
            System.out.println(valor.toString());
        });
        System.out.println("--------------------------------------------");
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }
    
    public void popularHashAberto(String[] palavras) {
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Preenchendo lista para Hash Aberto");
        try {
            for (String palavra : palavras) {
                haberto.inserir(new ElementoFrase(palavra));
            }
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao inserir: " + ex);
        }
        setTempoGastoTotal(System.currentTimeMillis() - tempoInicial);

    }

    public void imprimirHashAberto() {
        System.out.println("\nImprimindo Hash Aberto");
        haberto.imprimirHashOrdenado();
        System.out.println("--------------------------------------------");
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }
}
