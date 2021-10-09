package br.com.cwi.reset.exercicios.aula2;

public class Ator {
    private String nome;
    private int idade;
    private int numOscar;
    private EnumGenero genero;

    public Ator(String nome, int idade, int numOscar, EnumGenero genero) {
        this.nome = nome;
        this.idade = idade;
        this.numOscar = numOscar;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void atorStatus() {
        System.out.println("Nome: "+this.getNome());
        System.out.println("Idade: "+idade);
        System.out.println("Quantidade de Oscars: "+numOscar);
        System.out.println("Genero: "+genero.getDesc());
    }
}
