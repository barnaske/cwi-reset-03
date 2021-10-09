package br.com.cwi.reset.exercicios.aula2;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private EnumGenero genero;

    public Pessoa(String nome, LocalDate dataNascimento, EnumGenero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void pessoaStatus() {
        System.out.println("Nome: "+nome);
        System.out.println("Data de nascimento: "+ dataNascimento);
        System.out.println("Genero: "+genero.getDescricao());

    }

    public Period calcularIdade(){
        Period idade = Period.between(this.dataNascimento, LocalDate.now());
        return idade;
    }

}
