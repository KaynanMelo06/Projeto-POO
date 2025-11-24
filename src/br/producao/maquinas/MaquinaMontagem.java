package br.producao.maquinas;

import br.producao.produtos.Produto;
import br.producao.excecoes.maquinaQuebradaException;

public class MaquinaMontagem extends Maquina implements Runnable{

    public MaquinaMontagem(String id, int tempoProcesso) {
        super(id, tempoProcesso);
    }

    @Override
    public void processar(Produto p) throws maquinaQuebradaException {
        System.out.println("[Montagem] Montando: " + p.getNome());

        try {
            // Simula o tempo de processo (conversão de segundos para milissegundos)
            Thread.sleep(tempoProcesso * 1000);

            if (Math.random() < 0.05) {
                throw new maquinaQuebradaException("Erro na montagem do " + p.getNome() + "!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[Montagem] Finalizado: " + p.getNome());
    }

    public void run(){

    }

}
