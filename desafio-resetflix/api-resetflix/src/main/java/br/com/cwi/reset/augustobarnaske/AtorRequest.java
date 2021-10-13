package br.com.cwi.reset.augustobarnaske;

import java.time.LocalDate;

public class AtorRequest extends Ator {

//    private static FakeDatabase atores;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        super(nome, dataNascimento, statusCarreira, anoInicioAtividade);
    }

    public static void criarAtor(AtorRequest atorRequest) {
        FakeDatabase.persisteAtor(atorRequest);
    }

}
