package br.com.cwi.reset.augustobarnaske.exceptions.atores;

public class NomeSobrenomeException extends Exception {

    public NomeSobrenomeException(){
        super("É necessário informar nome e sobrenome.\n");
    }
}
