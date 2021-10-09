package br.com.cwi.reset.exercicios.aula2;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private EnumGenero genero;

    public Pessoa(String nome, int idade, EnumGenero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void pessoaStatus() {
        System.out.println("Nome: "+nome);
        System.out.println("Idade: "+idade);
        System.out.println("Genero: "+genero.getDescricao());

    }

}
