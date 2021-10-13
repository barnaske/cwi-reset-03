package br.com.cwi.reset.augustobarnaske.exceptions;

public class NomeSobrenomeException extends Exception {

    public NomeSobrenomeException(){
        super("É necessário informar nome e sobrenome.");
    }
}
