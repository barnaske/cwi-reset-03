package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();
        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1958, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);
        System.out.println("------Imprimindo status para o Ator Request------");
        Ator.getAtorStatus(atorRequest);

        AtorRequest segundoAtorRequest = new AtorRequest(
                "Testando inserir duas pessoas",
                LocalDate.of(1950, 10, 2),
                StatusCarreira.EM_ATIVIDADE,
                1996);

        atorService.criarAtor(segundoAtorRequest);
        System.out.println("------Imprimindo status para o Ator Request 2------");
        Ator.getAtorStatus(segundoAtorRequest);

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
        for (int i = 0; i < atores.size(); i++){
            System.out.println("Nome: "+atores.get(i).getNome());
            System.out.println("ID: "+atores.get(i).getAtorId());
        }
    }
}