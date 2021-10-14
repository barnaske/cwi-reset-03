package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorRequest b = new AtorRequest("Maico Smith", LocalDate.of(1988, Month.SEPTEMBER, 25), StatusCarreira.APOSENTADO, 2000);

//        String nome = "Will Smith";
//        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
//        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
//        Integer anoInicioAtividade = 1986;
//        AtorRequest a = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

//        String nome2 = "Maico Smith";
//        LocalDate dataNascimento2 = LocalDate.of(1988, Month.SEPTEMBER, 25);
//        StatusCarreira statusCarreira2 = StatusCarreira.EM_ATIVIDADE;
//        Integer anoInicioAtividade2 = 1996;

        AtorService atorService = new AtorService(fakeDatabase);

//        atorService.criarAtor(a);
        atorService.criarAtor(b);

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
        for (int i = 0; i < atores.size(); i++){
            System.out.println(atores.get(i));
        }
    }
}