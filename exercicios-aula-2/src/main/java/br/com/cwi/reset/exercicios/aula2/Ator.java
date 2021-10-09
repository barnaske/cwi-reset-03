package br.com.cwi.reset.exercicios.aula2;

public class Ator extends Pessoa {

    private int numeroOscar;

    public Ator(String nome, int idade, EnumGenero genero, int numOscar) {
        super(nome, idade, genero);
        this.numeroOscar = numOscar;
    }

    @Override
    public void pessoaStatus() {
        super.pessoaStatus();
        System.out.println("Quantidade de Oscars: "+this.numeroOscar);
    }
}
