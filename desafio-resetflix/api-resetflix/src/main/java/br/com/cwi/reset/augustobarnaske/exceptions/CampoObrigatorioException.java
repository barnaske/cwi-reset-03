package br.com.cwi.reset.augustobarnaske.exceptions;

import br.com.cwi.reset.augustobarnaske.classes.AtorService;

import java.text.MessageFormat;
import java.util.List;

public class CampoObrigatorioException extends Exception {

    public CampoObrigatorioException(List<String> camposFaltantes) {
        for (int i = 0; i < camposFaltantes.size(); i++) {
            System.out.println("Campo obrigatório não informado. Favor informar o campo %s.".formatted(camposFaltantes.get(i)));
        }
    }

}
