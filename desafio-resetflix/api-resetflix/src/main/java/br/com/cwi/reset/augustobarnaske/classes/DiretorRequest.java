package br.com.cwi.reset.augustobarnaske.classes;

import java.time.LocalDate;

public class DiretorRequest extends Diretor{

    public DiretorRequest(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        super(nome, dataNascimento, anoInicioAtividade);
    }
}
