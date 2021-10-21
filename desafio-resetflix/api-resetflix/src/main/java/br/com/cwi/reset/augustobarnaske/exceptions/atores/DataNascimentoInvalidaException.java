package br.com.cwi.reset.augustobarnaske.exceptions.atores;

public class DataNascimentoInvalidaException extends Exception {

    public DataNascimentoInvalidaException(){
        super("Não é possível cadastrar atores não nascidos.\n");
    }

}
