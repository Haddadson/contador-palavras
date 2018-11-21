
import EstruturasDados.PesquisaSequencial;
import Util.ElementoFrase;
import Util.LeitorArquivo;

/**
 *
 * @author Gabriel Haddad
 */

public class App {
    public static void main(String[] args){
        PesquisaSequencial pseq = new PesquisaSequencial();
        String textoArquivo = LeitorArquivo.lerArquivo().toLowerCase();
        
        
        System.out.println(textoArquivo + "\n\n");
        
        String[] palavras = textoArquivo.split("[\\p{Punct}\\s]+");
        System.out.println("Aqui: " + palavras.length);
        
        for(String palavra : palavras){
            System.out.println(palavra);
            pseq.adicionarEmLista(new ElementoFrase(palavra));
        }
        System.out.println("\n\n");
        pseq.imprimirLista();
        
        
    }
}
