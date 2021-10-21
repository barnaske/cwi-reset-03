package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.exceptions.*;
import br.com.cwi.reset.augustobarnaske.exceptions.diretores.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DiretorService {

    private FakeDatabase fakeDatabase;
    private Integer diretorIdCounter = 0;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarDiretor(DiretorRequest diretorRequest){

//        O fluxo começa fazendo a checagem das regras dentro do bloco de try e se passar ele cria o ator
//        cada exceção é tratada por um catch especifico seu, largando a mensagem na tela e não inserindo o ator
//        por meio do FakeDatabase.persisteAtor().
//        Precisei de algumas mensagens explicitando cada passo, pra entender o que estava acontecendo de problemas e conseguir corrigir
//        Também imprimi o estado de todos os campos para garantir o sucesso

        try{
            System.out.println("Iniciando a inserção de um novo diretor agora!");
            System.out.println("Iniciando a testagem das regras:");
            checaCamposObrigatorios(diretorRequest);
            checaNomeSobrenome(diretorRequest);
            checaDataNascimento(diretorRequest);
            checaAnoInicioAtividade(diretorRequest);
            nomeDuplicado(diretorRequest);
            System.out.println("----------Checagem Concluida---------");
            Integer diretorId = gerarDiretorId();
            System.out.println("Gerado Id do Diretor como: "+ diretorId);
            System.out.println("Nome como: "+diretorRequest.getNome());
            System.out.println("Data Nasc como: "+diretorRequest.getDataNascimento());
            System.out.println("Ano Inicio como: "+diretorRequest.getAnoInicioAtividade());
            System.out.println("---Se não houve exceção, o diretor será inserido agora.---");
            diretorRequest.setDiretorId(diretorId);
            FakeDatabase.persisteDiretor(diretorRequest);
            System.out.println("-------------Em teoria o diretor foi inserido com sucesso-------------");
            System.out.println("-------------FINALIZANDO INSERÇÃO DE DIRETOR------------- \n");
        } catch (CampoObrigatorioException | NomeSobrenomeDiretorException | DataNascimentoInvalidaDiretorException | AnoInicioAtividadeInvalidoDiretorException | NomeDuplicadoDiretorException e){
            System.out.println(e.getMessage());
        }

    }

    public void checaCamposObrigatorios(DiretorRequest diretorRequest) throws CampoObrigatorioException {

//        O método vai buscar as informações que precisa chegar do Ator e, caso encontre uma vazia
//        ele vai adicionar na lista dos campos faltantes, se a lista não estiver vazia a exception é lançada

        String nome = diretorRequest.getNome();
        LocalDate dataNascimento = diretorRequest.getDataNascimento();
        Integer anoInicioAtividade = diretorRequest.getAnoInicioAtividade();

        List<String> camposFaltantes = new ArrayList<>();

        if (nome.isEmpty()){
            camposFaltantes.add("Nome");
        }

        if (dataNascimento == null){
            camposFaltantes.add("Data de Nascimento");
        }

        if (anoInicioAtividade == null){
            camposFaltantes.add("Ano de Início da Atividade");
        }

        if (!camposFaltantes.isEmpty()){
            throw new CampoObrigatorioException(camposFaltantes);
        }
    }

    private Integer gerarDiretorId(){
        return ++diretorIdCounter;
    }

    public void checaNomeSobrenome(DiretorRequest diretorRequest) throws NomeSobrenomeDiretorException {

//      O método vai lançar o nome do ator pra nome e depois vai usar um split com \\s+ de regex, que representa mais
//      de um espaçamento dentro da variável, se o tamanho da variável onde rolou o split for menor que 2, lança a exceção

        String nome = diretorRequest.getNome();
        String[] nomeSobrenome = nome.split("\\s+");

        if (nomeSobrenome.length < 2) {
            throw new NomeSobrenomeDiretorException();
        }
    }

    public void checaDataNascimento(DiretorRequest diretorRequest) throws DataNascimentoInvalidaDiretorException {
//      O método lança a data de hoje em uma variável e usar a função isAfter na dataNascimento
//      se confirmar lança a exceção
        LocalDate hoje = LocalDate.now();
        LocalDate dataNascimento = diretorRequest.getDataNascimento();

        if (dataNascimento.isAfter(hoje)){
            throw new DataNascimentoInvalidaDiretorException();
        }
    }

    public void checaAnoInicioAtividade(DiretorRequest diretorRequest) throws AnoInicioAtividadeInvalidoDiretorException {
//      O metodo usar a função getYear na data de nascimento do ator para lançar somente o ano em uma int
//      Se o ano inicio menor que o nascimento lança uma exceção

        int anoNascimento = diretorRequest.getDataNascimento().getYear();
        Integer anoInicioAtividade = diretorRequest.getAnoInicioAtividade();

        if (anoInicioAtividade < anoNascimento){
            throw new AnoInicioAtividadeInvalidoDiretorException();
        }

    }

    public void nomeDuplicado(DiretorRequest diretorRequest) throws NomeDuplicadoDiretorException {

//      O método importa pra dentro de uma lista nessa classe a lista que vem do fakedatabase e faz a checagem
//      Para saber se o nome sendo inserido já consta nela, se constar, não executa o FakeDatabase.persisteAtor()
//      para inserir essa pessoa na lista

        List<Diretor> diretoresCadastrados = new ArrayList<>();
        diretoresCadastrados = FakeDatabase.recuperaDiretores();
        String nomeSendoInserido = diretorRequest.getNome();
        int nomesCounter = 0;

        for (int i = 0; i < diretoresCadastrados.size(); i++){
            if (nomeSendoInserido.equals(diretoresCadastrados.get(i).getNome())){
                nomesCounter++;
            }
        }

        if (nomesCounter >= 1) {
            throw new NomeDuplicadoDiretorException(diretorRequest);
        }
    }

    public static List<Diretor> listarDiretores(String filtroNome) throws ListaDiretoresVaziaException, ListaDiretoresSemCorrespondenciaException {
//      Esse método insere os atores da FakeDatabase.recuperaAtores em uma lista usável dentro dessa classe e trabalha um stream em cima dela
//      A stream roda duas filtragens para separar pelo filtro usado e por EM_ATIVIDADE (fiz um getter para pegar o
//      própri enum e não a descrição) e depois imprimi os valores encontrados
//      Se por ventura ela estiver vazia ou não for encontrado nenhuma correspondencia pelo filtro, ela lança exceção para cada uma dessas situações

        List<Diretor> diretoresCadastrados = new ArrayList<>();
        diretoresCadastrados = FakeDatabase.recuperaDiretores();

        diretoresCadastrados.stream()
                .filter(x -> x.getNome().contains(filtroNome))
                .forEach(x -> System.out.println("ID: "+x.getDiretorId()+" | ID: "+x.getNome()+" | Data Nascimento: "+x.getDataNascimento()));

        if (diretoresCadastrados.isEmpty()){
            throw new ListaDiretoresVaziaException();
        }

        Stream<Diretor> diretoresFiltradosPorNome = Stream.of();
        diretoresFiltradosPorNome = diretoresCadastrados.stream()
                .filter(x -> x.getNome().contains(filtroNome));

        if(diretoresFiltradosPorNome.toList().isEmpty()){
            throw new ListaDiretoresSemCorrespondenciaException(filtroNome);
        }

        return diretoresCadastrados;
    }

    public List<Diretor> consultarDiretor(Integer id) throws ConsultaDiretorException {
//      Esse método ficou um pouco bagunçado, acredito que há mil formas de otimizar ele, mas como preferi usar stream, ficou funcional dessa forma
//      Pra começar o retorno solicitado foi Ator, porém como trabalhei com Stream retornei uma lista com o ator encontrado ou a exceção que foi lançada
//      Instanciei a lista da FakeDatabase.recuperaAtores() em atoresCadastrados e criei um Stream<Ator> Stream.of para conseguir checar diretamente
//      Se o id passado como parametro está dentro dos atoresCadastrados, faço um toList().isEmpty() para checar se a lista está vazia logo
//      de cara para já lançar a exceção. Se não tiver vazia, faço uma segunda rodada de stream, porém em cima de atoresCadastrados
//      e filtrando pelo ID e imprimindo quem foi encontrado, no final retorno a lista atoresCadastrados streamada

        List<Diretor> diretoresCadastrados = new ArrayList<>();
        diretoresCadastrados = FakeDatabase.recuperaDiretores();

        Stream<Diretor> diretorConsultado = Stream.of();
        diretorConsultado = diretoresCadastrados.stream()
                .filter(x -> x.getDiretorId().equals(id));


        if (diretorConsultado.toList().isEmpty()){
            throw new ConsultaDiretorException(id);
        }

        diretoresCadastrados.stream()
                .filter(x -> x.getDiretorId().equals(id))
                .forEach(x -> System.out.println("ID: "+x.getDiretorId()+" | Nome: "+x.getNome()+" | Data Nasc: "+x.getDataNascimento()+" | Ano Inicio Atividade: "+x.getAnoInicioAtividade()));

        return diretoresCadastrados;
    }
}
