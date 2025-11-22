package br.producao.simulacao;

import br.producao.maquinas.Maquina;
import br.producao.produtos.Produto;

public class Simulador {

    public static void iniciarProcesso(String nomeProduto, Maquina[] etapas) {
        System.out.println(">> Thread iniciada para: " + nomeProduto);

        Produto p = new Produto(nomeProduto);
        LinhaProducao linha = new LinhaProducao(etapas);

        linha.iniciar(p);      // Passa por todas as máquinas
        p.registrarEmArquivo(); // Grava no fim
    }
}