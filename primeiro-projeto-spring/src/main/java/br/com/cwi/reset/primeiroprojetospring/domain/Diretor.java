package br.com.cwi.reset.exercicios.aula2;

import java.time.LocalDate;

public class Diretor extends Pessoa {

    private int quantidadeFilmes;

    public Diretor(String nome, LocalDate dataNascimento, EnumGenero genero, int quantFilmes) {
        super(nome, dataNascimento, genero);
        this.quantidadeFilmes = quantFilmes;
    }

    @Override
    public void pessoaStatus() {
        super.pessoaStatus();
        System.out.println("Quantidade de filmes: "+this.quantidadeFilmes);
    }
}
