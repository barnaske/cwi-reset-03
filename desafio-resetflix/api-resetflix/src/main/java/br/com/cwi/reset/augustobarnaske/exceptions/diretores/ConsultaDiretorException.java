package br.com.cwi.reset.augustobarnaske.exceptions.diretores;

public class ConsultaDiretorException extends Exception {

    public ConsultaDiretorException(Integer id){
        super("Nenhum diretor encontrado com o parâmetro ID = %s, favor verifique os parâmetros informados.".formatted(id));
    }
}
