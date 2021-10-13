package br.com.cwi.reset.augustobarnaske;

import java.time.LocalDate;

public class AtorService extends Ator {

    private FakeDatabase fakeDatabase;
//

    public AtorService(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade, FakeDatabase fakeDatabase) {
        super(nome, dataNascimento, statusCarreira, anoInicioAtividade);
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest){
        AtorRequest.criarAtor(atorRequest);
    }
}