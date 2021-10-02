package br.com.cwi.reset.projeto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {
        int soma = 0;

        for (Integer numero : numeros){
            soma += numero;
        }

        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        double media;
        double somaNum = 0;
        for (Integer numero : numeros){
            somaNum += numero;
        }

        media = somaNum / numeros.size();

        return media;
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        Integer maior = Integer.MIN_VALUE;

        for (Integer numero : numeros){
            if (numero > maior){
                maior = numero;
            }
        }

        return maior;
    }

    public String obterPalavraInvertida(String palavra) {

        char[] tempPalavra = new char[palavra.length()];
        char[] palavraInv = new char[palavra.length()];

        for (Integer i = 0; i < palavra.length(); i++){
            tempPalavra[i] = palavra.charAt(i);
        }

        for (Integer j = 0; j < palavra.length(); j++){
            palavraInv[j] = tempPalavra[palavra.length() - 1 - j];
        }

        String palavaInvertida = new String(palavraInv);

        return palavaInvertida;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {

//        List<Integer> ordenados = new ArrayList<>();
//
//        for (Integer i=0; i<numeros.size() - 1; i++){
//            for (Integer j=0; j<numeros.size() - 1; j++){
//                if (numeros.get(j) > numeros.get(j + 1)){
//                    int aux = numeros[j];
//                    numeros[j] = numeros[j+1];
//                    numeros[j+1] = aux;
//                }
//            }
//        }

//        Consegui fazer sem transformar em array, nao sei se podia
//        usando numeros.set(i, numeros.get(i) )
//        int pos1 = numeros.get(i);
//        int pos2 = numeros.get(i+1);
//        numeros.set(i, pos2);
//        numeros.set(i+1, pos1);


        return numeros;
    }
}



