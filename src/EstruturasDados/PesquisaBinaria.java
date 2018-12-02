package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe para representar a estrutura de dados que utiliza pesquisa binária
 * para checar se o elemento já existe
 *
 * @author Gabriel Haddad
 */
public class PesquisaBinaria extends PesquisaArray {

    private ElementoFrase[] arrayElementoFrase;

    public PesquisaBinaria() {
        super.listaPalavras = new ArrayList<>();
        super.comparacoes = 0;
        super.tempoGasto = 0;
    }

    /**
     * Método para adicionar uma palavra na estrutura, validando se a mesma já
     * está presente para incrementar sua quantidade e adicionando-a caso não
     * esteja
     *
     * @author Gabriel Haddad
     * @param palavra ElementoFrase - objeto que encapsula a palavra a ser
     * inserida e a quantidade de vezes que ela aparece no texto
     */
    public void adicionarEmLista(ElementoFrase palavra) {
        if (validarAdicaoPalavra(palavra)) {
            comparacoes = 0;
            long tempoInicial = System.currentTimeMillis();

            System.out.println("------------------------------");
            System.out.println("Adicionando: \"" + palavra.getPalavra() + "\"");

            if (listaPalavras.isEmpty()) {
                comparacoes++;
                listaPalavras.add(palavra);
            } else {
                arrayElementoFrase = listaPalavras.toArray(new ElementoFrase[listaPalavras.size()]);
                int posicaoElemento = pesquisaBinaria(arrayElementoFrase, palavra.getPalavra());
                if (posicaoElemento == -1) {
                    listaPalavras.add(palavra);
                } else {
                    arrayElementoFrase[posicaoElemento].setQuantidade(arrayElementoFrase[posicaoElemento].getQuantidade() + 1);
                    List<ElementoFrase> listaAuxiliar = Arrays.asList(arrayElementoFrase);
                    listaPalavras = new ArrayList<>(listaAuxiliar);
                }
            }
            setTempoGasto(System.currentTimeMillis() - tempoInicial);

            System.out.println(obterInformacoesPesquisa());
        }
    }

    /**
     * Método para realizar a pesquisa binária no vetor, verificando se o
     * elemento já está presente
     *
     * @author Gabriel Haddad
     * @param arr ElementoFrase[] - vetor de ElementoFrase que representa a
     * estrutura de dados
     * @param palavra ElementoFrase - objeto que encapsula a palavra a ser
     * inserida e a quantidade de vezes que ela aparece no texto
     * @return -1 caso não encontre o elemento, a posição do elemento caso
     * encontre
     */
    public int pesquisaBinaria(ElementoFrase arr[], String palavra) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid].getPalavra().compareToIgnoreCase(palavra) < 0) {
                comparacoes++;
                high = mid - 1;
            } else if (arr[mid].getPalavra().compareToIgnoreCase(palavra) > 0) {
                comparacoes++;
                low = mid + 1;
            } else {
                comparacoes++;
                return mid;
            }
        }

        return -1;
    }
}
