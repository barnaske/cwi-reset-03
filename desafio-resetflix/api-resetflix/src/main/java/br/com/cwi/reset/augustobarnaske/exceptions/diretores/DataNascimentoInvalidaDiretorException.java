package br.com.cwi.reset.augustobarnaske.exceptions.diretores;

public class DataNascimentoInvalidaDiretorException extends Exception {

    public DataNascimentoInvalidaDiretorException(){
        super("Não é possível cadastrar diretores não nascidos.\n");
    }

}
