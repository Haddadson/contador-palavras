package Util;

import java.util.Comparator;

/**
 * Classe filha de Comparator para possibilitar a comparações de ElementoFrase
 * através da propriedade <i>palavra</i>
 *
 * @author Gabriel Haddad
 */
public class ComparadorElementoFrase implements Comparator<ElementoFrase> {
    
    @Override
    public int compare(ElementoFrase o1, ElementoFrase o2) {
        return o1.getPalavra().compareToIgnoreCase(o2.getPalavra());
    }
}
