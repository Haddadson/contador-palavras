/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstruturasDados;

import Util.ComparadorElementoFrase;
import Util.ElementoFrase;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gabriel Haddad
 */

public class HashAberto {
    private int tamanhoVetorHash;
    private int proximaPosicaoAreaReserva;
    private int reserva;
    private ElementoFrase tabela[];
    private int comparacoes;
    private long tempoGasto;
 
    public HashAberto() {
        this.tamanhoVetorHash = 5;
        this.proximaPosicaoAreaReserva = 5;
        this.reserva = 0;
        this.tabela = new ElementoFrase[tamanhoVetorHash + proximaPosicaoAreaReserva];
    }
 
    public HashAberto(int m, int t) {
        this.tamanhoVetorHash = m;
        this.proximaPosicaoAreaReserva = t;
        this.reserva = 0;
        this.tabela = new ElementoFrase[m + t];
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
 
    public void zerarTabela() {
        for (int i = 0; i < tabela.length; i++)
            this.tabela[i] = null;
    }
 
    private int hash(ElementoFrase k) {
        int hash = k.getPalavra().hashCode();
        return hash % tamanhoVetorHash * (hash >= 0 ? 1 : -1);
    }
 
    public void inserir(ElementoFrase elemento) throws Exception {
        comparacoes = 0;
        int pos = hash(elemento);
 
        if (tabela[pos] == null) {
            comparacoes++;
            tabela[pos] = elemento;
        } else if (tabela[pos].getPalavra().equals(elemento.getPalavra())){
            comparacoes++;                        
            tabela[pos].setQuantidade(tabela[pos].getQuantidade() + 1);
        }else if ((tamanhoVetorHash + reserva) < tabela.length) {
            comparacoes++;
            tabela[tamanhoVetorHash + reserva] = elemento;
            reserva++;
        } else {
            throw new Exception("::ERRO:: Area de reserva cheia");
        }
    }
 
    private double colisoes() {
        return reserva / tamanhoVetorHash * 100;
    }
 
    public void remover(ElementoFrase elemento) throws Exception {
        int pos = hash(elemento);
 
        if (tabela[pos] == elemento) {
            tabela[pos] = null;
            for (int i = tamanhoVetorHash; i < tamanhoVetorHash + reserva; i++) {
                int hash = tabela[i].hashCode();
                if ((hash % tamanhoVetorHash * ((hash > 0) ? 1 : -1)) == pos) {
                    tabela[pos] = tabela[i];
                    for (int j = i; j < tamanhoVetorHash + reserva - 1; j++)
                        tabela[j] = tabela[j + 1];
                    reserva--;
                    i = tamanhoVetorHash + reserva;
                }
            }
        } else if (tabela[pos] == null) {
            throw new Exception("ERRO:: NAO EXISTE ELEMENTO");
 
        } else {
            for (int i = tamanhoVetorHash; i < tamanhoVetorHash + reserva; i++) {
                if (tabela[i] == elemento) {
                    for (int j = i; j < tamanhoVetorHash + reserva - 1; j++)
                        tabela[j] = tabela[j + 1];
                    reserva--;
                    i = tamanhoVetorHash + reserva;
                }
            }
        }
    }
    
    public void imprimirHashOrdenado(){
        ArrayList<ElementoFrase> listaElementos = new ArrayList();
        for (ElementoFrase elemento : tabela){
            if(elemento != null){
                listaElementos.add(elemento);
            }
        }
        
        Collections.sort(listaElementos, new ComparadorElementoFrase());
        listaElementos.forEach((elemento) -> {
            System.out.println(elemento.toString());
        });
    }

}
