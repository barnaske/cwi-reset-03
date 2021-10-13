package br.com.cwi.reset.augustobarnaske.exceptions;

import br.com.cwi.reset.augustobarnaske.classes.AtorService;

import java.text.MessageFormat;
import java.util.List;

public class CampoObrigatorioException extends Exception {

    public CampoObrigatorioException(List<String> camposFaltantes) {

//        Usando um for pra ler o que tem dentro da campos faltantes e imprimir na tela quando for coletada a exceção.

        for (int i = 0; i < camposFaltantes.size(); i++) {
            System.out.println("Campo obrigatório não informado. Favor informar o campo %s.".formatted(camposFaltantes.get(i)));
        }
    }

}
