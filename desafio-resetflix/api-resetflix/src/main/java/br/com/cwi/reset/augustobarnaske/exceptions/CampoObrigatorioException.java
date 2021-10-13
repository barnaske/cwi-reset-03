package br.com.cwi.reset.augustobarnaske.exceptions;

public class CampoObrigatorioException extends Exception{

    public CampoObrigatorioException() {
        super("Campo obrigatório não informado. Favor informar o campo {campo}.");
    }
}
