package br.com.cwi.reset.exercicios.aula2;

public class Filme {

    private String nome;
    private String descricao;
    private Integer duracao;
    private int anoLancamento;
    private double avaliacao;
    private Diretor diretor;

    public Filme(String nome, String desc, Integer duracao, int anoLanc, double aval, Diretor diretor) {
        this.nome = nome;
        this.descricao = desc;
        this.duracao = duracao;
        this.anoLancamento = anoLanc;
        this.avaliacao = aval;
        this.diretor = diretor;
    }

    public void reproduzir(){
        System.out.println("Iniciando a sessão!");
        System.out.println("Filme: "+this.nome);
        System.out.println("Descrição: "+this.descricao);
        System.out.println("Duração: "+this.duracao);
        System.out.println("Diretor: "+diretor.getNome());
    }

}
