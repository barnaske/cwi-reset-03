package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;
import br.com.cwi.reset.augustobarnaske.exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;
    private Integer atorIdCounter = 0;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest){

//        O fluxo começa fazendo a checagem das regras dentro do bloco de try e se passar ele cria o ator
//        cada exceção é tratada por um catch especifico seu, largando a mensagem na tela

        try{
            checaCamposObrigatorios();
            checaNomeSobrenome();
            checaDataNascimento();
            checaAnoInicioAtividade();
            nomeDuplicado();
            Integer atorId = gerarAtorId();
            System.out.println("Setando Id do Ator como: "+ atorId);
            atorRequest.setAtorId(atorId);
            FakeDatabase.persisteAtor(atorRequest);
        } catch (CampoObrigatorioException e){
            System.out.println(e.getMessage());
        } catch (NomeSobrenomeException e){
            System.out.println(e.getMessage());
        } catch (DataNascimentoInvalidaException e){
            System.out.println(e.getMessage());
        } catch (AnoInicioAtividadeInvalidoException e){
            System.out.println(e.getMessage());
        } catch (NomeDuplicadoException e){
            System.out.println(e.getMessage());
        }

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

    private Integer gerarAtorId(){
        return ++atorIdCounter;
    }

    public void checaNomeSobrenome() throws NomeSobrenomeException {

//      O método vai lançar o nome do ator pra nome e depois vai usar um split com \\s+ de regex, que representa mais
//      de um espaçamento dentro da variável, se o tamanho da variável onde rolou o split for menor que 2, lança a exceção

        String nome = Ator.getNome();
        String[] nomeSobrenome = nome.split("\\s+");

        if (nomeSobrenome.length < 2) {
            throw new NomeSobrenomeException();
        }
    }

    public void checaDataNascimento() throws DataNascimentoInvalidaException {
//      O método lança a data de hoje em uma variável e usar a função isAfter na dataNascimento
//      se confirmar lança a exceção
        LocalDate hoje = LocalDate.now();
        LocalDate dataNascimento = Ator.getDataNascimento();

        if (dataNascimento.isAfter(hoje)){
            throw new DataNascimentoInvalidaException();
        }
    }

    public void checaAnoInicioAtividade() throws AnoInicioAtividadeInvalidoException {
//      O metodo usar a função getYear na data de nascimento do ator para lançar somente o ano em uma int
//      Se o ano inicio menor que o nascimento lança uma exceção

        int anoNascimento = Ator.getDataNascimento().getYear();
        Integer anoInicioAtividade = Ator.getAnoInicioAtividade();

        if (anoInicioAtividade < anoNascimento){
            throw new AnoInicioAtividadeInvalidoException();
        }

    }

    public void nomeDuplicado() throws NomeDuplicadoException {
        List<Ator> atoresCadastrados = new ArrayList<>();
        atoresCadastrados = FakeDatabase.recuperaAtores();
        String nomeSendoInserido = Ator.getNome();
        int nomesCounter = 0;

        for (Ator nome : atoresCadastrados){
            if (nomeSendoInserido.equals(nome)){
                nomesCounter++;
            }
        }

        if (nomesCounter > 1) {
            throw new NomeDuplicadoException();
        }
    }

}