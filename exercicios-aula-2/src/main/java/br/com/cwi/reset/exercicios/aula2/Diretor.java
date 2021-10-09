package br.com.cwi.reset.exercicios.aula2;

public class Diretor {
    private static String nomeDiretor;
    private int idade;
    private int quantFilmes;

    public Diretor(String nomeDiretor, int idade, int quantFilmes) {
        this.nomeDiretor = nomeDiretor;
        this.idade = idade;
        this.quantFilmes = quantFilmes;
    }

    public static String getNomeDiretor() {
        return nomeDiretor;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getQuantFilmes() {
        return quantFilmes;
    }

    public void setQuantFilmes(int quantFilmes) {
        this.quantFilmes = quantFilmes;
    }

    public void diretorStatus() {
        System.out.println("Nome: "+getNomeDiretor());
        System.out.println("Idade: "+getIdade());
        System.out.println("Quantidade de Filmes: "+getQuantFilmes());
    }
}
