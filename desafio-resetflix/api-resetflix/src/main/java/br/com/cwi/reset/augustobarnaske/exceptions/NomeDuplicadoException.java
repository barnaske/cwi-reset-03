package br.com.cwi.reset.augustobarnaske.exceptions;

public class NomeDuplicadoException extends Exception {

    public NomeDuplicadoException(){
        super("Já existe um ator cadastrado para o nome {nome}.");
    }
}
