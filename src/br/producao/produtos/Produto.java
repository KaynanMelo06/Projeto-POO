package br.producao.produtos;

public class Produto {
    static int contador;
    int id;
    String nome;
    boolean aprovado;

    public Produto(String nome){
        this.nome = nome;
    }

    void registrarEmArquivo(){

    }
}
