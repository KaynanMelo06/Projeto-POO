package br.producao.produtos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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

    public String getNome() { 
        return nome;
    }
    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    @Override
    public void registrarEmArquivo() {
        Path caminho = Paths.get("relatorio_producao.txt");
        String status;
        if (aprovado) {
            status = "APROVADO";
        } else {
            status = "REJEITADO";
        }
        String conteudo = String.format("Produto ID: %d | Nome: %s | Status: %s%n", id, nome, status);

        try {
            Files.writeString(caminho, conteudo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("[Arquivo] Relatório gravado para: " + nome);
        } catch (IOException e) {
            System.err.println("Erro ao gravar arquivo: " + e.getMessage());
        }
    }
}