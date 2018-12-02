package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;

/**
 * Classe para controle das estruturas de dados, populando-as e imprimindo-as
 *
 * @author Gabriel Haddad
 */
public class EstruturasDados {

    private final PesquisaSequencial pseq;
    private final PesquisaBinaria pbinaria;
    private final ArvoreBinaria arvore;
    private final HashAberto haberto;
    private final HashLista hlista;
    private long tempoGastoTotal;
    private int comparacoesTotais;

    public EstruturasDados() {
        pseq = new PesquisaSequencial();
        pbinaria = new PesquisaBinaria();
        arvore = new ArvoreBinaria();
        haberto = new HashAberto(1024, 100);
        hlista = new HashLista(1024);
        tempoGastoTotal = 0;
        comparacoesTotais = 0;
    }

    public long getTempoGastoTotal() {
        return tempoGastoTotal;
    }

    public void setTempoGastoTotal(long tempoGastoTotal) {
        this.tempoGastoTotal = tempoGastoTotal;
    }

    /**
     * Método para preencher um vetor, verificando se os elementos já existem
     * através de pesquisa sequencial
     *
     * @author Gabriel Haddad
     * @param palavras String[] - vetor de palavras a serem inseridas
     */
    public void popularPesquisaSequencial(String[] palavras) {
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Preenchendo lista para Pesquisa Sequencial");
        for (String palavra : palavras) {
            pseq.adicionarEmLista(new ElementoFrase(palavra));
            comparacoesTotais += pseq.getComparacoes();
        }
        setTempoGastoTotal(System.currentTimeMillis() - tempoInicial);
    }

    /**
     * Método para exibir o vetor com os dados preenchidos através da pesquisa
     * sequencial, exibindo também as comparações feitas pela pesquisa e o tempo
     * gasto
     *
     * @author Gabriel Haddad
     */
    public void imprimirListaPesquisaSequencial() {
        System.out.println("\nImprimindo Lista - Pesquisa Sequencial");
        pseq.ordenarLista();
        pseq.imprimirLista();
        System.out.println("--------------------------------------------");
        System.out.println("Comparaçoes totais para preencher estrutura: " + comparacoesTotais);
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }

    /**
     * Método para preencher um vetor, verificando se os elementos já existem
     * através de pesquisa binária
     *
     * @author Gabriel Haddad
     * @param palavras String[] - vetor de palavras a serem inseridas
     */
    public void popularPesquisaBinaria(String[] palavras) {
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Preenchendo lista para Pesquisa Binaria");
        for (String palavra : palavras) {
            pbinaria.adicionarEmLista(new ElementoFrase(palavra));
            comparacoesTotais += pbinaria.getComparacoes();
        }
        setTempoGastoTotal(System.currentTimeMillis() - tempoInicial);
    }

    /**
     * Método para exibir o vetor com os dados preenchidos através da pesquisa
     * binária, exibindo também as comparações feitas pela pesquisa e o tempo
     * gasto
     *
     * @author Gabriel Haddad
     */
    public void imprimirListaPesquisaBinaria() {
        System.out.println("\nImprimindo Lista - Pesquisa Binaria");
        pbinaria.ordenarLista();
        pbinaria.imprimirLista();
        System.out.println("--------------------------------------------");
        System.out.println("Comparaçoes totais para preencher estrutura: " + comparacoesTotais);
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }

    /**
     * Método para preencher uma árvore binária, verificando se os elementos já
     * existem
     *
     * @author Gabriel Haddad
     * @param palavras String[] - vetor de palavras a serem inseridas
     */
    public void popularArvoreBinaria(String[] palavras) {
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Preenchendo Arvore Binaria de Pesquisa");
        try {
            for (String palavra : palavras) {
                arvore.inserir(new ElementoFrase(palavra));
                comparacoesTotais += arvore.getComparacoes();
            }
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao inserir: " + ex);
        }
        setTempoGastoTotal(System.currentTimeMillis() - tempoInicial);
    }

    /**
     * Método para exibir a estrutura com os dados preenchidos através de uma
     * árvore binária, exibindo também as comparações feitas pela pesquisa e o
     * tempo gasto
     *
     * @author Gabriel Haddad
     */
    public void imprimirArvoreBinaria() {
        System.out.println("\nImprimindo Arvore Binaria de Pesquisa");
        ArrayList<ElementoFrase> valoresArvore = arvore.armazenarValoresArvore(arvore.getRaiz());
        valoresArvore.forEach((valor) -> {
            System.out.println(valor.toString());
        });
        System.out.println("--------------------------------------------");
        System.out.println("Comparaçoes totais para preencher estrutura: " + comparacoesTotais);
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }

    /**
     * Método para preencher um hash de endereçamento aberto, verificando se os
     * elementos já existem
     *
     * @author Gabriel Haddad
     * @param palavras String[] - vetor de palavras a serem inseridas
     */
    public void popularHashAberto(String[] palavras) {
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Preenchendo Hash - Enderecamento Aberto");
        try {
            for (String palavra : palavras) {
                haberto.inserir(new ElementoFrase(palavra));
                comparacoesTotais += haberto.getComparacoes();
            }
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao inserir: " + ex);
        }
        setTempoGastoTotal(System.currentTimeMillis() - tempoInicial);
    }

    /**
     * Método para exibir a estrutura com os dados preenchidos através de um
     * hash com endereçamento aberto, exibindo também as comparações feitas pela
     * pesquisa e o tempo gasto
     *
     * @author Gabriel Haddad
     */
    public void imprimirHashAberto() {
        System.out.println("\nImprimindo Hash - Enderecamento Aberto");
        haberto.imprimirHashOrdenado();
        System.out.println("--------------------------------------------");
        System.out.println("Comparaçoes totais para preencher estrutura: " + comparacoesTotais);
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }

    /**
     * * Método para preencher um hash com lista encadeada, verificando se os
     * elementos já existem
     *
     * @author Gabriel Haddad
     * @param palavras String[] - vetor de palavras a serem inseridas
     */
    public void popularHashLista(String[] palavras) {
        long tempoInicial = System.currentTimeMillis();
        System.out.println("Preenchendo Hash - Lista Encadeada");
        try {
            for (String palavra : palavras) {
                hlista.inserir(new ElementoFrase(palavra));
                comparacoesTotais += hlista.getComparacoes();
            }
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao inserir: " + ex);
        }
        setTempoGastoTotal(System.currentTimeMillis() - tempoInicial);
    }

    /**
     * Método para exibir a estrutura com os dados preenchidos através de um
     * hash com lista encadeada, exibindo também as comparações feitas pela
     * pesquisa e o tempo gasto
     *
     * @author Gabriel Haddad
     */
    public void imprimirHashLista() {
        System.out.println("\nImprimindo Hash - Lista Encadeada");
        hlista.imprimirHashOrdenado();
        System.out.println("--------------------------------------------");
        System.out.println("Comparaçoes totais para preencher estrutura: " + comparacoesTotais);
        System.out.println("Tempo total gasto para preencher estrutura: " + tempoGastoTotal + " ms");
    }
}
