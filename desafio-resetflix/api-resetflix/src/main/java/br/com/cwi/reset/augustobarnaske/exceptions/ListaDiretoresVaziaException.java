package br.com.cwi.reset.augustobarnaske.exceptions;

public class ListaDiretoresVaziaException extends Exception {

    public ListaDiretoresVaziaException(){
        super("Nenhum diretor cadastrado, favor cadastrar atores.");
    }

}
