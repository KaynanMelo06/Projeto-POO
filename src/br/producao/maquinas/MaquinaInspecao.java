package br.producao.maquinas;

import br.producao.produtos.Produto;
import br.producao.excecoes.maquinaQuebradaException;

public class MaquinaInspecao extends Maquina implements Runnable{

    public MaquinaInspecao(String id, int tempoProcesso) {
        super(id, tempoProcesso);
    }

    @Override
    public void processar(Produto p) throws maquinaQuebradaException {

    }

    public void run(){

    }

}
