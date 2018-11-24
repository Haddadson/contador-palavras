
import EstruturasDados.EstruturasDados;
import EstruturasDados.PesquisaSequencial;
import Util.ElementoFrase;
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
            String textoArquivo = LeitorArquivo.lerArquivo(args[1]).toLowerCase();
            String[] palavras = textoArquivo.split("\\r?\\n|[\\p{Punct}\\s]+");
            
            switch(args[0]){
                case "pseq":
                    estruturas.popularPesquisaSequencial(palavras);
                    estruturas.imprimirListaPesquisaSequencial();
                break;
                case "pbinaria":
                    estruturas.popularPesquisaBinaria(palavras);
                    estruturas.imprimirListaPesquisaBinaria();
                break;
            }
        }
    }
    

}
