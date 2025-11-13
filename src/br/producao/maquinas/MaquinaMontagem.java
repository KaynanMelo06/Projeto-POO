package br.producao.maquinas;

import br.producao.produtos.Produto;
import br.producao.excecoes.maquinaQuebradaException;

public class MaquinaMontagem extends Maquina implements Runnable{

    public MaquinaMontagem(String id, int tempoProcesso) {
        super(id, tempoProcesso);
    }

    @Override
    public void processar(Produto p) throws maquinaQuebradaException {

    }

    public void run(){

    }

}
