package br.com.cwi.reset.exercicios.aula2;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private int numeroOscar;

    public Ator(String nome, LocalDate dataNascimento, EnumGenero genero, int numOscar) {
        super(nome, dataNascimento, genero);
        this.numeroOscar = numOscar;
    }

    @Override
    public void pessoaStatus() {
        super.pessoaStatus();
        System.out.println("Quantidade de Oscars: "+this.numeroOscar);
    }
}
