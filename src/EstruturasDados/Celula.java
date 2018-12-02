/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDados;

import Util.ElementoFrase;

/**
 *
 * @author Gabriel Haddad
 */

public class Celula {
	private ElementoFrase elemento;
	public Celula prox;
	public Celula ant;

	public Celula() {
		this.elemento = null;
		this.prox = null;
		this.ant = null;
	}
	
	public Celula(ElementoFrase x) {
		this.elemento = x;
		this.prox = null;
	}

	public ElementoFrase getElemento() {
		return elemento;
	}

	public void setElemento(ElementoFrase elemento) {
		this.elemento = elemento;
	}

	public Celula getProx() {
		return prox;
	}

	public void setProx(Celula prox) {
		this.prox = prox;
	}

	public Celula getAnt() {
		return ant;
	}

	public void setAnt(Celula ant) {
		this.ant = ant;
	}
	
}
