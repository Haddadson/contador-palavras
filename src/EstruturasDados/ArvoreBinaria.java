package EstruturasDados;

import Util.ElementoFrase;

/**
 *
 * @author Gabriel Haddad
 */

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }
    
    public void inserir(ElementoFrase x) throws Exception {
        if(!pesquisar(x)){
            raiz = inserir(x, raiz);
        }
    }

    private No inserir(ElementoFrase x, No i) throws Exception {
        
        if (i == null) {
            i = new No(x);
        } else if (x.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) < 0) {
            i.esq = inserir(x, i.esq);
        } else if (x.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) > 0) {
            i.dir = inserir(x, i.dir);
        } else {
            throw new Exception("Erro!");
        }

        return i;
    }

    public boolean pesquisar(ElementoFrase x) {
        return pesquisar(x, raiz);
    }

    private boolean pesquisar(ElementoFrase x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (x.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) == 0) {
            x.setQuantidade(x.getQuantidade() + 1);
            resp = true;
        } else if (x.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) < 0) {
            resp = pesquisar(x, i.esq);
        } else {
            resp = pesquisar(x, i.dir);
        }
        return resp;
    }

    public void remover(ElementoFrase x) throws Exception {
        raiz = remover(x, raiz);
    }

    private No remover(ElementoFrase x, No i) throws Exception {
        if (i == null) {
            throw new Exception("Erro!");
        } else if (x.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) < 0) {
            i.esq = remover(x, i.esq);
        } else if (x.getPalavra().compareToIgnoreCase(i.elemento.getPalavra()) > 0) {
            i.dir = remover(x, i.dir);
        } else if (i.dir == null) {
            i = i.esq;
        } else if (i.esq == null) {
            i = i.dir;
        } else {
            i.esq = anterior(i, i.esq);
        }
        return i;
    }

    private No anterior(No i, No j) {
        if (j.dir != null) {
            j.dir = anterior(i, j.dir);
        } else {
            i.elemento = j.elemento;
            j = j.esq;
        }
        return j;
    }

    public void mostrarCentral() {
        mostrarCentral(raiz);
    }

    private void mostrarCentral(No i) {
        if (i != null) {
            mostrarCentral(i.esq);
            System.out.print(i.elemento + " ");
            mostrarCentral(i.dir);
        }
    }

    public void mostrarPre() {
        mostrarPre(raiz);
    }

    private void mostrarPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + " ");
            mostrarPre(i.esq);
            mostrarPre(i.dir);
        }
    }

    public void mostrarPos() {
        mostrarPos(raiz);
    }

    private void mostrarPos(No i) {
        if (i != null) {
            mostrarPos(i.esq);
            mostrarPos(i.dir);
            System.out.print(i.elemento
                    + " ");
        }
    }
    
    //Ao chamar, passar raiz como parâmetro
    public String imprimirArvoreBinariaPesquisa(No aux) {
        String retorno = "";
        if (aux != null) {
            retorno += aux.elemento.toString();
            retorno += System.lineSeparator();
            retorno += imprimirArvoreBinariaPesquisa(aux.esq);
            retorno += System.lineSeparator();
            retorno += imprimirArvoreBinariaPesquisa(aux.dir);
            retorno += System.lineSeparator();

        }
        return retorno;
    }
}
