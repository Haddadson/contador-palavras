package EstruturasDados;

import Util.ElementoFrase;

/**
 *
 * @author Gabriel Haddad
 */
public class EstruturasDados {
    private final PesquisaSequencial pseq;
    private final PesquisaBinaria pbinaria;
    private final ArvoreBinaria arvore;

    public EstruturasDados(){
        pseq = new PesquisaSequencial();
        pbinaria = new PesquisaBinaria();
        arvore = new ArvoreBinaria();
    }
    
    public void popularPesquisaSequencial(String[] palavras){
        System.out.println("Preenchendo lista para Pesquisa Sequencial");
        for (String palavra : palavras) {
            pseq.adicionarEmLista(new ElementoFrase(palavra));
        }
    }
    
    public void imprimirListaPesquisaSequencial(){
        System.out.println("\nImprimindo Lista - Pesquisa Sequencial");
        pseq.ordenarLista();
        pseq.imprimirLista();
    }
    
    public void popularPesquisaBinaria(String[] palavras){
        System.out.println("Preenchendo lista para Pesquisa Binária");
        for (String palavra : palavras) {
            pbinaria.adicionarEmLista(new ElementoFrase(palavra));
        }
    }
    
    public void imprimirListaPesquisaBinaria(){
        System.out.println("\nImprimindo Lista - Pesquisa Binária");
        pbinaria.ordenarLista();
        pbinaria.imprimirLista();
    }
    
     public void popularArvoreBinaria(String[] palavras){
        System.out.println("Preenchendo Árvore Binária de Pesquisa");
        try {
           for (String palavra : palavras) {
               arvore.inserir(new ElementoFrase(palavra));
           }
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao inserir: "  + ex);
        }
    }
    
    public void imprimirArvoreBinaria(){
        System.out.println("\nImprimindo Árvore Binária de Pesquisa");
        System.out.println(arvore.imprimirArvoreBinariaPesquisa(arvore.getRaiz()));
    }
}
