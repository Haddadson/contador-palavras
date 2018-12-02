package Aplicacao;


import EstruturasDados.EstruturasDados;
import Util.LeitorArquivo;

/**
 * Classe principal para execução do contador de palavras<br>
 * É necessário informar a estrutura desejada e o caminho para o arquivo de texto
 * a ser lido através dos argumentos
 * 
 * @author Gabriel Haddad
 */

public class ContadorPalavras {
    
    /**
     * Método principal
     *
     * @author Gabriel Haddad
     * @param args String[] - Utilizados para definir a estrutura de dados a ser utilizada
     * e o caminho do arquivo a ser lido<br>
     * As estruturas são: <br>
     * <ul>
     *  <li><b>pseq</b> - Pesquisa Sequencial</li>
     *  <li><b>pbinaria</b> - Pesquisa Binária</li>
     *  <li><b>arvore</b> - Árvore Binária de Pesquisa</li>
     *  <li><b>haberto</b> - Hash com Endereçamento Aberto</li>
     *  <li><b>hlista</b> - Hash com Lista Encadeada</li>
     * </ul>
     * <br><br> 
     * Exemplo de chamada:
     * <b>java ContadorPalavras pseq src/util/texto.txt</b>
     */
    public static void main(String[] args){
        if(args.length > 0 ){
            EstruturasDados estruturas = new EstruturasDados();
            String textoArquivo;
            
            if(args.length > 1)
                textoArquivo = LeitorArquivo.lerArquivo(args[1]).toLowerCase();
            else {
                textoArquivo = LeitorArquivo.lerArquivo("").toLowerCase();
            }
            String[] palavras = textoArquivo.split("\\r?\\n|[\\p{Punct}\\s]+");
            if(palavras.length > 0){
                switch (args[0]) {
                    case "pseq":
                        estruturas.popularPesquisaSequencial(palavras);
                        estruturas.imprimirListaPesquisaSequencial();
                        break;
                    case "pbinaria":
                        estruturas.popularPesquisaBinaria(palavras);
                        estruturas.imprimirListaPesquisaBinaria();
                        break;
                    case "arvore":
                        estruturas.popularArvoreBinaria(palavras);
                        estruturas.imprimirArvoreBinaria();
                        break;
                    case "haberto":
                        estruturas.popularHashAberto(palavras);
                        estruturas.imprimirHashAberto();
                        break;
                    case "hlista":
                        estruturas.popularHashLista(palavras);
                        estruturas.imprimirHashLista();
                        break;
                    default:
                        System.out.println("O valor informado não se refere a" +
                                           " nenhuma estrutura de dados! Tente novamente");
                        break;
                }
            } else {
                System.out.println("O arquivo informado está vazio.");
            }
        } else {
            System.out.println("Necessário informar a estrutura de dados a ser "
                               + "utilizada e o caminho do arquivo a ser lido "
                               + "nos argumentos");
        }
    }
}
