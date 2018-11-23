
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
            
            String textoArquivo = LeitorArquivo.lerArquivo(args[1]).toLowerCase();
            String[] palavras = textoArquivo.split("\\r?\\n|[\\p{Punct}\\s]+");
            
            switch(args[0]){
                case "pseq":
                    PesquisarSequencialmente(palavras);
                break;
            }
        }
    }
    
    //TODO: Criar classe para encapsular todas estruturas de dados
    private static void PesquisarSequencialmente(String[] palavras) {
        PesquisaSequencial pseq = new PesquisaSequencial();
        for (String palavra : palavras) {
            System.out.println(palavra);
            pseq.adicionarEmLista(new ElementoFrase(palavra));
        }
        System.out.println("\n\n");
        pseq.imprimirLista();
        
        System.out.println(pseq.pesquisaSequencial("menos").toString());
        System.out.println(pseq.obterInformacoesPesquisa());
    }
}
