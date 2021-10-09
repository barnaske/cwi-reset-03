package br.com.cwi.reset.exercicios.aula2;

public class Filme {

    private String nome;
    private String desc;
    private Integer duracao;
    private int anoLanc;
    private double aval;
    private Diretor diretor;

    public Filme(String nome, String desc, Integer duracao, int anoLanc, double aval, Diretor diretor) {
        this.nome = nome;
        this.desc = desc;
        this.duracao = duracao;
        this.anoLanc = anoLanc;
        this.aval = aval;
        this.diretor = diretor;
    }

    public void reproduzir(){
        System.out.println("Iniciando a sessão!");
        System.out.println("Filme: "+this.nome);
        System.out.println("Descrição: "+this.desc);
        System.out.println("Duração: "+this.duracao);
        System.out.println("Diretor: "+diretor.getNome());
    }

}
