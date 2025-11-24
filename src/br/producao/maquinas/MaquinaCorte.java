package br.producao.maquinas;

import br.producao.produtos.Produto;
import br.producao.excecoes.maquinaQuebradaException;

public class MaquinaCorte extends Maquina {

    public MaquinaCorte(String id, int tempoProcesso) {
        super(id, tempoProcesso);
    }

    @Override
    public void processar(Produto p) throws maquinaQuebradaException {
        System.out.println("[Corte] A cortar: " + p.getNome());

        try {
            // Simula o tempo de processo (conversão de segundos para milissegundos)
            Thread.sleep(tempoProcesso * 1000);

            // Simulação de Falha Mecânica (5% de chance)
            // Se falhar, lança a exceção que será capturada pela LinhaProducao
            if (Math.random() < 0.05) {
                throw new maquinaQuebradaException("Lâmina partiu ao cortar " + p.getNome() + "!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[Corte] Finalizado: " + p.getNome());
    }
}