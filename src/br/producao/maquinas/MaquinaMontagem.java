package br.producao.maquinas;

import br.producao.produtos.Produto;

public class MaquinaMontagem extends Maquina {

    public MaquinaMontagem(String id, int tempoProcesso) {
        super(id, tempoProcesso);
    }

    @Override
    public void processar(Produto p) {
        System.out.println("[Montagem] A montar: " + p.getNome());
        try {
            Thread.sleep(tempoProcesso * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("s[Montagem] Finalizado: " + p.getNome());
    }
}