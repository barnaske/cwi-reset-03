package br.com.cwi.reset.augustobarnaske.exceptions.atores;

import br.com.cwi.reset.augustobarnaske.classes.AtorRequest;

public class NomeDuplicadoException extends Exception {
    public NomeDuplicadoException(AtorRequest atorRequest){
        super("Já existe um ator cadastrado para o nome %s. \n".formatted(atorRequest.getNome()));
    }
}
