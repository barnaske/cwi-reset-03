package br.com.cwi.reset.augustobarnaske.exceptions;

import br.com.cwi.reset.augustobarnaske.classes.AtorRequest;
import br.com.cwi.reset.augustobarnaske.classes.DiretorRequest;

public class NomeDuplicadoDiretorException extends Exception {

    public NomeDuplicadoDiretorException(DiretorRequest diretorRequest){
        super("Já existe um diretor cadastrado para o nome %s. \n".formatted(diretorRequest.getNome()));
    }
}

