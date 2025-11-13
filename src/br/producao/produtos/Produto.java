package br.producao.produtos;

public class Produto implements Registravel {
    private static int contador = 0;
    private int id;
    private String nome;
    private boolean aprovado;

    public Produto(String nome) {
        this.id = ++contador;
        this.nome = nome;
        this.aprovado = true;
    }

    @Override
    public void registrarEmArquivo() {
        // escreve dados do produto em arquivo
    }
}
