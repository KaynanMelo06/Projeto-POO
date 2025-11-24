package br.producao.simulacao;

import br.producao.maquinas.Maquina;
import br.producao.produtos.Produto;
import br.producao.excecoes.maquinaQuebradaException;

public class LinhaProducao {
    private Maquina[] etapas;

    public LinhaProducao(Maquina[] etapas) {
        this.etapas = etapas;
    }

    public void iniciar(Produto p) {
        for (int i = 0; i < etapas.length; i++) {
            Maquina m = etapas[i];
            try {
                m.processar(p);
            } catch (maquinaQuebradaException e) {
                System.out.println("Erro: " + e.getMessage());
                break;
            }
        }
    }
}
