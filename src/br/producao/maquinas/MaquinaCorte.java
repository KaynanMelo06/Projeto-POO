package br.producao.maquinas;

import br.producao.produtos.Produto;

public class MaquinaCorte extends Maquina {

    public MaquinaCorte(String id, int tempoProcesso) {
        super(id, tempoProcesso);
    }

    @Override
    public void processar(Produto p) {
        System.out.println("[Corte] A cortar: " + p.getNome());
        try {
            Thread.sleep(tempoProcesso * 1000);
            // 10% de chance da máquina quebrar a cada produto
            if (Math.random() < 0.10) {
                throw new br.producao.excecoes.maquinaQuebradaException("Lâmina partiu ao cortar " + p.getNome() + "!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("[Corte] Finalizado: " + p.getNome());
    }
}