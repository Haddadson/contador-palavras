package EstruturasDados;

import Util.ElementoFrase;

/**
 *
 * @author Gabriel Haddad
 */
public class No {

    public ElementoFrase elemento;
    public No esq;
    public No dir;

    public No(ElementoFrase elemento) {
        this(elemento, null, null);
    }

    public No(ElementoFrase elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}
