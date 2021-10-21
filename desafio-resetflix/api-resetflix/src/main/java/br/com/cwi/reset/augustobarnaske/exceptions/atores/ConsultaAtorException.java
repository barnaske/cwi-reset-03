package br.com.cwi.reset.augustobarnaske.exceptions.atores;

public class ConsultaAtorException extends Exception {

    public ConsultaAtorException(Integer id){
        super("Nenhum ator encontrado com o parâmetro ID = %s, favor verifique os parâmetros informados.".formatted(id));
    }
}
