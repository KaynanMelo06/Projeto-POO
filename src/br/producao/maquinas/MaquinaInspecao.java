package br.producao.maquinas;

import br.producao.produtos.Produto;
import br.producao.excecoes.maquinaQuebradaException;

public class MaquinaInspecao extends Maquina implements Runnable{

    public MaquinaInspecao(String id, int tempoProcesso) {
        super(id, tempoProcesso);
    }

    @Override
    public void processar(Produto p) throws maquinaQuebradaException {
        System.out.println("[Inspecao] Inspecionar: " + p.getNome());

        try {
            // Simula o tempo de processo (conversão de segundos para milissegundos)
            Thread.sleep(tempoProcesso * 1000);

            if (Math.random() < 0.05) {
                throw new maquinaQuebradaException("Erro encontrado na inspecao " + p.getNome() + "!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[Inspecao] Finalizado: " + p.getNome());
    }

    public void run(){

    }

}
