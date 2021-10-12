package br.com.cwi.reset.augustobarnaske;

public class Estudio {

    private static int estudioIdCounter = 0;
    private Integer estudioId;
    private String nome;
    private String descricao;
    private Integer dataCriacao;
    private StatusAtividade statusAtividade;

    public Estudio(String nome, String descricao, Integer dataCriacao, StatusAtividade statusAtividade) {
        this.estudioId = estudioIdCounter++;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
    }
}
