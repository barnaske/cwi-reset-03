package br.com.cwi.reset.augustobarnaske.exceptions.atores;

import java.util.List;

public class ListaAtoresEmAtividadeVaziaException extends Exception {

    public ListaAtoresEmAtividadeVaziaException(){
        super("Nenhum ator cadastrado, favor cadastrar atores.");
    }
}
