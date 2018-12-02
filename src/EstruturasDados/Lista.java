/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDados;

import Util.ElementoFrase;
import java.util.ArrayList;

/**
 *
 * @author Gabriel Haddad
 */

public class Lista {

    private Celula primeiro, ultimo;
    private int qtdItens;
    private int comparacoes;
    private long tempoGasto;

    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
        this.qtdItens = 0;
        this.comparacoes = 0;
        this.tempoGasto = 0;
    }

    public Lista(ElementoFrase elemento) {
        this.primeiro = this.ultimo = new Celula(elemento);
        this.qtdItens++;
        this.comparacoes = 0;
        this.tempoGasto = 0;
    }
    
    public int getComparacoes() {
        return comparacoes;
    }

    public void setTempoGasto(long tempoGasto) {
        this.tempoGasto = tempoGasto;
    }

    public long getTempoGasto() {
        return tempoGasto;
    }

    public void inserirInicio(ElementoFrase x) {
        if (primeiroEstaNulo()) {
            primeiro = new Celula(x);
        } else if (!pesquisarEIncrementarQuantidadePalavra(x.getPalavra())) {
            Celula tmp = new Celula(x);

            tmp.ant = primeiro;
            tmp.prox = primeiro.prox;
            primeiro.prox = tmp;
            if (primeiro == ultimo) {
                ultimo = tmp;
            } else {
                tmp.prox.ant = tmp;
            }
            tmp = null;
            this.qtdItens++;
        }
    }

    public void inserirFim(ElementoFrase x) {
        if(primeiroEstaNulo()){
            comparacoes++;
            primeiro = new Celula(x);
        } else if (!pesquisarEIncrementarQuantidadePalavra(x.getPalavra())) {
            ultimo.prox = new Celula(x);
            ultimo.prox.ant = ultimo;
            ultimo = ultimo.prox;
            this.qtdItens++;
        }
    }

    public void inserir(ElementoFrase x, int pos) throws Exception {
        if (pos == 0 && primeiroEstaNulo()) {
            primeiro = new Celula(x);
        } else if(!pesquisarEIncrementarQuantidadePalavra(x.getPalavra())){
            if (pos < 0 || pos > qtdItens) {
                throw new Exception("Erro!");
            } else if (pos == 0) {
                inserirInicio(x);
            } else if (pos == qtdItens) {
                inserirFim(x);
            } else {
                Celula i = primeiro;
                for (int j = 0; j < pos; j++, i = i.prox)
				;
                Celula tmp = new Celula(x);
                tmp.ant = i;
                tmp.prox = i.prox;
                tmp.ant.prox = tmp.prox.ant = tmp;
                tmp = i = null;
            }
            this.qtdItens++;
        }
    }

    public ElementoFrase removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro!");
        }
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        ElementoFrase elemento = primeiro.getElemento();
        tmp.prox = primeiro.ant = null;
        tmp = null;
        this.qtdItens--;

        return elemento;
    }

    public ElementoFrase removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro!");
        }
        ElementoFrase elemento = ultimo.getElemento();
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        this.qtdItens--;
        return elemento;
    }

    public ElementoFrase remover(int pos) throws Exception {
        ElementoFrase elemento;
        if (primeiro == ultimo) {
            throw new Exception("Erro!");
        } else if (pos < 0 || pos >= qtdItens) {
            throw new Exception("Erro!");
        } else if (pos == 0) {
            elemento = removerInicio();
        } else if (pos == qtdItens - 1) {
            elemento = removerFim();
        } else {
            Celula i = primeiro.prox;
            for (int j = 0; j <= pos; j++, i = i.prox);
            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            elemento = i.getElemento();
            i.prox = i.ant = null;
            i = null;
        }
        return elemento;
    }
    
    public ElementoFrase removerPorPalavra(String palavra) throws Exception {
        Celula aux = primeiro.prox;
        ElementoFrase elemento;
        while (aux != null && (!aux.getElemento().getPalavra().equalsIgnoreCase(palavra))) {
            aux = aux.prox;
        }

        if (aux != null) {
            if (aux.prox == null && aux.ant != null) {
                elemento = removerFim();
            } else if (aux.ant == null && aux.prox != null) {
                elemento = removerInicio();
            } else {
                aux.ant.prox = aux.prox;
                aux.prox.ant = aux.ant;
                elemento = aux.getElemento();
                aux.prox = aux.ant = null;
                aux = null;
            }
            return elemento;
        }
        return null;
    }
    
    public void limparLista() throws Exception {
        while (primeiro != ultimo) {
            removerFim();
        }
    }

    public ElementoFrase pesquisarPorPosicao(int pos) throws Exception {
        Celula aux;

        if (!posicaoExiste(pos)) {
            throw new Exception("A posição informada não existe !");
        }

        aux = primeiro;
        for (int i = pos; i > 0; i--) {
            aux = aux.prox;
        }
        return aux.getElemento();
    }

    public ElementoFrase pesquisarPorPalavraElementoFrase(String nome) {
        Celula aux = primeiro;

        while (aux != null && (!nome.equalsIgnoreCase(aux.getElemento().getPalavra()))) {
            aux = aux.prox;
        }

        if (aux != null) {
            return aux.getElemento();
        }
        return null;
    }

    public boolean pesquisarEIncrementarQuantidadePalavra(String nome){
        Celula aux = primeiro;
        long tempoInicial = System.currentTimeMillis();
        while (aux != null && aux.getElemento() != null 
               && !nome.equalsIgnoreCase(aux.getElemento().getPalavra())) {
            comparacoes += 2;
            aux = aux.prox;
        }

        if (aux != null && aux.getElemento() != null) {
            comparacoes++;
            setTempoGasto(System.currentTimeMillis() - tempoInicial);
            aux.getElemento().setQuantidade(aux.getElemento().getQuantidade() + 1);
            return true;
        }
        setTempoGasto(System.currentTimeMillis() - tempoInicial);
        return false;
    }
    
    public void mostrar() {
        Celula i = primeiro;
        while (i != null) {
            if (i.getElemento() != null) {
                System.out.println(i.getElemento().toString());
            }
            i = i.prox;
        }
    }

    public String preencherString() {
        Celula i = primeiro;
        String stringPreenchido = "";
        while (i != null) {
            if (i.getElemento() != null) {
                stringPreenchido += i.getElemento().toString() + "\n";
            }
            i = i.prox;
        }
        return stringPreenchido;
    }

    public ArrayList<ElementoFrase> obterListaComTodos(){
        Celula i = primeiro;
        ArrayList<ElementoFrase> listaElementos = new ArrayList<>();
        while (i != null) {
            if (i.getElemento() != null) {
                listaElementos.add(i.getElemento());
            }
            i = i.prox;
        
        }
        return listaElementos;
    }
    
    public boolean isEmpty() {
        return primeiro == ultimo;
    }

    private boolean posicaoExiste(int posicao) {
        return posicao >= 0 && posicao < qtdItens;
    }
    
    private boolean primeiroEstaNulo(){
        return primeiro.getElemento() == null;
    }

    public int getQtdItens() {
        return qtdItens;
    }
}
