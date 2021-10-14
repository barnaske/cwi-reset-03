package br.com.cwi.reset.augustobarnaske.exceptions;

public class ListaDiretoresSemCorrespondenciaException extends Exception {

    public ListaDiretoresSemCorrespondenciaException(String filtroNome){
        super("Diretor não encontrato com o filtro '%s', favor informar outro filtro.".formatted(filtroNome));
    }

}
