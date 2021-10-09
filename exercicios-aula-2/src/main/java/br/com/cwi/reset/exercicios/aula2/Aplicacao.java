package br.com.cwi.reset.exercicios.aula2;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor1 = new Diretor("Jovem", 31, 1, EnumGenero.FEMININO);
        Diretor segundoDir = new Diretor("Agora ta salvando certo!", 44, 3, EnumGenero.NAO_BINARIO);
        Ator ator1 = new Ator("Leonardo Dicaprio", 43, 0, EnumGenero.MASCULINO);

        Filme filme1 = new Filme("Hangover","4 amigos em uma aventura mutcho louca", 30, 2021, 5, diretor1);
        Filme filme2 = new Filme("Madagascar","Bixarada tudo solta", 76, 2021, 4.7, segundoDir);

        filme1.reproduzir();
        System.out.println("---------");
        filme2.reproduzir();
        System.out.println("---------");
        ator1.atorStatus();
        System.out.println("---------");
        diretor1.diretorStatus();
        System.out.println("---------");
        segundoDir.diretorStatus();
    }
}
