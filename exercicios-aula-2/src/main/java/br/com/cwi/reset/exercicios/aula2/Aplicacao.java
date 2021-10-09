package br.com.cwi.reset.exercicios.aula2;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor1 = new Diretor("Jovem", 31, 1);
        Diretor segundoDir = new Diretor("Pq não salva certo?", 44, 0);

        Filme filme1 = new Filme("Hangover","4 amigos em uma aventura mutcho louca", 30, 2021, 5, diretor1.getNomeDiretor());
        Filme filme2 = new Filme("Madagascar","Bixarada tudo solta", 76, 2021, 4.7, segundoDir.getNomeDiretor());

        filme1.reproduzir();
        diretor1.diretorStatus();
        System.out.println("---------");
        filme2.reproduzir();
        diretor1.diretorStatus();
    }
}
