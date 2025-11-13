package br.producao.maquinas;

import br.producao.produtos.Produto;

public class Maquina {
    String id;
    int tempoProcesso;


    public Maquina(String id, int tempoProcesso){
        this.id = id;
        this.tempoProcesso = tempoProcesso;
    }

    void processar(Produto p){

    }
}
