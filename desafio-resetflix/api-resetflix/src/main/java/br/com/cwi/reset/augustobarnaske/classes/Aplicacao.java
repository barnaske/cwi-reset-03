package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;
import br.com.cwi.reset.augustobarnaske.exceptions.ListaAtoresEmAtividadeSemCorrespondenciaException;
import br.com.cwi.reset.augustobarnaske.exceptions.ListaAtoresEmAtividadeVaziaException;

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
                "Will Smith 2",
                LocalDate.of(1950, 10, 2),
                StatusCarreira.EM_ATIVIDADE,
                1996);

        AtorRequest terceiro = new AtorRequest(
                "Will Smith 3",
                LocalDate.of(1951, 10, 2),
                StatusCarreira.EM_ATIVIDADE,
                1996);

        AtorRequest quarto = new AtorRequest(
                "Will Smith 4",
                LocalDate.of(1951, 10, 2),
                StatusCarreira.APOSENTADO,
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
//        Ator.getAtorStatus(quarto);

        //TESTANDO IMPLEMENTAÇÃO DO LISTAR ATORES

        System.out.println("Listagem de atores:");
        System.out.println("");

        try{
            atorService.listarAtoresEmAtividade("Smith");
        }catch (ListaAtoresEmAtividadeVaziaException e){
            System.out.println(e.getMessage());
        }catch (ListaAtoresEmAtividadeSemCorrespondenciaException e){
            System.out.println(e.getMessage());
        }

        System.out.println("");
        System.out.println("---Fim da listagem de atores---\n");

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 4 atores, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
        for (int i = 0; i < atores.size(); i++){
            System.out.println("Nome: "+atores.get(i).getNome()+" | ID: "+atores.get(i).getAtorId());
        }
    }
}