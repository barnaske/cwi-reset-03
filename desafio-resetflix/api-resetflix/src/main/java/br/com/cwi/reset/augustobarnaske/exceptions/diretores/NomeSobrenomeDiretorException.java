package br.com.cwi.reset.augustobarnaske.exceptions.diretores;

public class NomeSobrenomeDiretorException extends Exception {

    public NomeSobrenomeDiretorException(){
        super("Deve ser informado no mínimo nome e sobrenome para o diretor.\n");
    }

}
