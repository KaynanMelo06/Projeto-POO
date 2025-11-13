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
        for (Maquina m : etapas) {
            try {
                m.processar(p);
            } catch (maquinaQuebradaException e) {
                System.out.println("Erro: " + e.getMessage());
                break;
            }
        }
    }
}
