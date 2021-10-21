package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;
import br.com.cwi.reset.augustobarnaske.exceptions.atores.ConsultaAtorException;
import br.com.cwi.reset.augustobarnaske.exceptions.atores.ListaAtoresEmAtividadeSemCorrespondenciaException;
import br.com.cwi.reset.augustobarnaske.exceptions.atores.ListaAtoresEmAtividadeVaziaException;
import br.com.cwi.reset.augustobarnaske.exceptions.diretores.ConsultaDiretorException;
import br.com.cwi.reset.augustobarnaske.exceptions.diretores.ListaDiretoresSemCorrespondenciaException;
import br.com.cwi.reset.augustobarnaske.exceptions.diretores.ListaDiretoresVaziaException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class Aplicacao {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Aplicacao.class, args);

/*
        FakeDatabase fakeDatabase = new FakeDatabase();
        AtorService atorService = new AtorService(fakeDatabase);
        DiretorService diretorService = new DiretorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1958, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        AtorRequest segundoAtorRequest = new AtorRequest(
                "Jansen Smith 2",
                LocalDate.of(1950, 10, 2),
                StatusCarreira.EM_ATIVIDADE,
                1996);

        AtorRequest terceiro = new AtorRequest(
                "Rofl Smith 3",
                LocalDate.of(1951, 10, 2),
                StatusCarreira.EM_ATIVIDADE,
                1996);

        AtorRequest quarto = new AtorRequest(
                "Papapa Smith 4",
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
        }catch (ListaAtoresEmAtividadeVaziaException | ListaAtoresEmAtividadeSemCorrespondenciaException e){
            System.out.println(e.getMessage());
        }

        System.out.println("");
        System.out.println("---Fim da listagem de atores---\n");
        int id = 3;
        System.out.println("Tentando consultar um Ator pelo ID, usando ID %s!".formatted(id));
        System.out.println("");

        try{
            atorService.consultarAtor(id);
        }catch (ConsultaAtorException e){
            System.out.println(e.getMessage());
        }

        System.out.println("");
        System.out.println("---Fim da consulta---\n");

        System.out.println("Tentando consultar todos os atores cadastrados:");
        System.out.println("");

        try{
            atorService.consultarAtores();
        }catch (ListaAtoresEmAtividadeVaziaException e){
            System.out.println(e.getMessage());
        }

        System.out.println("");
        System.out.printf("---Fim da Consulta---\n\n");

        String nomeDiretor = "Steven Spielberg";
        LocalDate dataNascimentoDiretor = LocalDate.of(1946, Month.DECEMBER, 18);
        Integer anoInicioAtividadeDiretor = 1959;
        DiretorRequest diretorRequest = new DiretorRequest(nomeDiretor, dataNascimentoDiretor, anoInicioAtividadeDiretor);

        DiretorRequest segundoDiretorRequest = new DiretorRequest(
                "Steven Spielberg 2.0",
                LocalDate.of(1946, 12, 18),
                1996);

        DiretorRequest terceiroDiretor = new DiretorRequest(
                "Steven Spielberg 3.0",
                LocalDate.of(1946, 12, 18),
                1996);

        diretorService.criarDiretor(diretorRequest);
        diretorService.criarDiretor(segundoDiretorRequest);
        diretorService.criarDiretor(terceiroDiretor);

        System.out.println("Listagem de Diretores:");
        System.out.println("");

        try{
            diretorService.listarDiretores("St");
        }catch (ListaDiretoresSemCorrespondenciaException | ListaDiretoresVaziaException e){
            System.out.println(e.getMessage());
        }

        System.out.println("");
        System.out.println("---Fim da listagem de Diretores---\n");

        int idDiretor = 5;
        System.out.println("Tentando consultar um Diretor pelo ID, usando ID %s!".formatted(idDiretor));
        System.out.println("");

        try{
            diretorService.consultarDiretor(idDiretor);
        }catch (ConsultaDiretorException e){
            System.out.println(e.getMessage());
        }

        System.out.println("");
        System.out.println("---Fim da consulta---\n");

        List<Ator> atores = fakeDatabase.recuperaAtores();
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        System.out.println("----------Impressão da lista de atores----------\n");
        System.out.println("Deve conter 4 atores, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
        for (int i = 0; i < atores.size(); i++){
            System.out.println("Nome: "+atores.get(i).getNome()+" | ID: "+atores.get(i).getAtorId());
        }
        System.out.println("");
        System.out.println("----------Impressão da lista de atores finalizada----------\n");

        System.out.println("----------Impressão da lista de diretores finalizada----------\n");
        System.out.println("Deve conter 3 atores, quantidade encontrada: " + diretores.size());
        System.out.println("Primeiro ator deve ser 'Steven Spielberg', valor encontrado: " + diretores.get(0).getNome());
        for (int i = 0; i < diretores.size(); i++){
            System.out.println("Nome: "+diretores.get(i).getNome()+" | ID: "+diretores.get(i).getDiretorId());
        }
        System.out.println("");
        System.out.println("----------Impressão da lista de atores finalizada----------\n");
        */

    }
}