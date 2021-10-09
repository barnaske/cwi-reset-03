package br.com.cwi.reset.exercicios.aula2;

import java.time.LocalDate;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor1 = new Diretor("Jovem", LocalDate.of(1996,10,02), EnumGenero.FEMININO, 1);
        Diretor segundoDir = new Diretor("Agora ta salvando certo!", LocalDate.of(1969,3,27), EnumGenero.NAO_BINARIO, 2);
        Ator ator1 = new Ator("Leonardo Dicaprio", LocalDate.of(1942,3,19), EnumGenero.MASCULINO, 3);

        try{
            Filme filme1 = new Filme("Hangover","4 amigos em uma aventura mutcho louca", 30, 2021, 5, diretor1);
        } catch (AvaliacaoForaDoPadraoException e) {
            System.out.println(e.getMessage());;
        }

        try{
            Filme filme2 = new Filme("Madagascar","Bixarada tudo solta", 76, 2021, 4.7, segundoDir);
        } catch (AvaliacaoForaDoPadraoException e){
            System.out.println(e.getMessage());
        }



//        filme1.reproduzir(/*);
//        System.out.println("---------");
//        filme2.reproduzir();
//        System.out.println("---------");
        ator1.pessoaStatus();
        ator1.calcularIdade();
        System.out.println("---------");
        diretor1.pessoaStatus();
        diretor1.calcularIdade();
        System.out.println("---------");
        segundoDir.pessoaStatus();
        segundoDir.calcularIdade();
    }
}
