package br.com.cwi.reset.augustobarnaske.exceptions;

public class ListaAtoresEmAtividadeSemCorrespondenciaException extends Exception {

    public ListaAtoresEmAtividadeSemCorrespondenciaException(String filtroNome){
        super("Ator não encontrato com o filtro '%s', favor informar outro filtro.".formatted(filtroNome));
    }
}
