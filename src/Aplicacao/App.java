package Aplicacao;


import EstruturasDados.EstruturasDados;
import Util.LeitorArquivo;

/**
 *
 * Necessário informar argumentos para execução
 * @author Gabriel Haddad
 */

public class App {
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
                }
            } else {
                System.out.println("O arquivo informado está vazio.");
            }
            
        }
    }
    

}
