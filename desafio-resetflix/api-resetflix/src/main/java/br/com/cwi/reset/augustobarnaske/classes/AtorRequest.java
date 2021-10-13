package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;

import java.time.LocalDate;

public class AtorRequest extends Ator{

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        super(nome, dataNascimento, statusCarreira, anoInicioAtividade);
    }

    public static void criarAtor(AtorRequest atorRequest){
        FakeDatabase.persisteAtor(atorRequest);
    }


}
