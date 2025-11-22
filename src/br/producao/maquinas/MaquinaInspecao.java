package br.producao.maquinas;

import br.producao.produtos.Produto;
import java.util.Random;

public class MaquinaInspecao extends Maquina {

    public MaquinaInspecao(String id, int tempoProcesso) {
        super(id, tempoProcesso);
    }

    @Override
    public void processar(Produto p) {
        System.out.println("[Inspeção] A verificar: " + p.getNome());
        try {
            Thread.sleep(tempoProcesso * 1000);
            // 10% de hipótese de reprovar
            if (new Random().nextInt(100) < 10) {
                p.setAprovado(false);
                System.out.println("[Inspeção] REJEITADO: " + p.getNome());
            } else {
                p.setAprovado(true);
                System.out.println("[Inspeção] APROVADO: " + p.getNome());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}