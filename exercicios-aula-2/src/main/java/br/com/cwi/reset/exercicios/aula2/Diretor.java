package br.com.cwi.reset.exercicios.aula2;

public class Diretor {
    private String nome;
    private int idade;
    private int quantFilmes;
    private EnumGenero genero;

    public Diretor(String nome, int idade, int quantFilmes, EnumGenero EnumGenero) {
        this.nome = nome;
        this.idade = idade;
        this.quantFilmes = quantFilmes;
        this.genero = EnumGenero;
    }

    public String getNome() {
        return nome;
    }

    public void diretorStatus() {
        System.out.println("Nome: "+this.getNome());
        System.out.println("Idade: "+idade);
        System.out.println("Quantidade de Filmes: "+quantFilmes);
        System.out.println("Genero: "+genero.getDesc());
    }
}
