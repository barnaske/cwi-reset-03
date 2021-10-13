package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;
import br.com.cwi.reset.augustobarnaske.exceptions.CampoObrigatorioException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }



    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest){

//        O fluxo começa fazendo a checagem das regras dentro dos blocos de trycatch

        try{
            checaCamposObrigatorios();
        } catch (CampoObrigatorioException e){
            System.out.println(e.getMessage());
        }

        AtorRequest.criarAtor(atorRequest);
    }

    public void checaCamposObrigatorios() throws CampoObrigatorioException {

//        O método vai buscar as informações que precisa chegar do Ator e, caso encontre uma vazia
//        ele vai adicionar na lista dos campos faltantes, se a lista não estiver vazia a exception é lançada

        String nome = Ator.getNome();
        LocalDate dataNascimento = Ator.getDataNascimento();
        StatusCarreira statusCarreira = Ator.getStatusCarreira();
        Integer anoInicioAtividade = Ator.getAnoInicioAtividade();

        List<String> camposFaltantes = new ArrayList<>();

        if (nome.isEmpty()){
            camposFaltantes.add("Nome");
        }

        if (dataNascimento == null){
            camposFaltantes.add("Data de Nascimento");
        }

        if (statusCarreira == null){
            camposFaltantes.add("Status da Carreira");
        }

        if (anoInicioAtividade == null){
            camposFaltantes.add("Ano de Início da Atividade");
        }

        if (!camposFaltantes.isEmpty()){
            throw new CampoObrigatorioException(camposFaltantes);
        }

    }

}