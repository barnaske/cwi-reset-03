package br.com.cwi.reset.exercicios.aula2;

public class Diretor extends Pessoa {

    private int quantidadeFilmes;

    public Diretor(String nome, int idade, EnumGenero genero, int quantFilmes) {
        super(nome, idade, genero);
        this.quantidadeFilmes = quantFilmes;
    }

    @Override
    public void pessoaStatus() {
        super.pessoaStatus();
        System.out.println("Quantidade de filmes: "+this.quantidadeFilmes);
    }
}
