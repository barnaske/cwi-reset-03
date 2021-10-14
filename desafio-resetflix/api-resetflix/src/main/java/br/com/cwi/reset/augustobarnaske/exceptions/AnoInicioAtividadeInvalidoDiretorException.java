package br.com.cwi.reset.augustobarnaske.exceptions;

public class AnoInicioAtividadeInvalidoDiretorException extends Exception {

    public AnoInicioAtividadeInvalidoDiretorException(){
        super("Ano de início de atividade inválido para o diretor cadastrado.\n");
    }

}
