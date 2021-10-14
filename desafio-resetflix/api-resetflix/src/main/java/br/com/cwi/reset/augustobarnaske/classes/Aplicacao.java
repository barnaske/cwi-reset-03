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

        AtorRequest segundoAtorRequest = new AtorRequest(
                "Testando inserir duas pessoas com mesmo nome",
                LocalDate.of(1950, 10, 2),
                StatusCarreira.EM_ATIVIDADE,
                1996);

        AtorRequest terceiro = new AtorRequest(
                "Testando inserir duas pessoas com mesmo nome",
                LocalDate.of(1951, 10, 2),
                StatusCarreira.EM_ATIVIDADE,
                1996);

        AtorRequest quarto = new AtorRequest(
                "Sónome",
                LocalDate.of(1951, 10, 2),
                StatusCarreira.EM_ATIVIDADE,
                1996);

        atorService.criarAtor(atorRequest);
//        System.out.println("------Imprimindo status para o Ator Request------");
//        Ator.getAtorStatus(atorRequest);

        atorService.criarAtor(segundoAtorRequest);
//        System.out.println("------Imprimindo status para o Ator Request 2------");
//        Ator.getAtorStatus(segundoAtorRequest);

        atorService.criarAtor(terceiro);
//        System.out.println("------Imprimindo status para o Ator Request 3------");
//        Ator.getAtorStatus(terceiro);

        atorService.criarAtor(quarto);
//        System.out.println("------Imprimindo status para o Ator Request 3------");
////        Ator.getAtorStatus(quarto);

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
        for (int i = 0; i < atores.size(); i++){
            System.out.println("Nome: "+atores.get(i).getNome());
            System.out.println("ID: "+atores.get(i).getAtorId());
        }
    }
}