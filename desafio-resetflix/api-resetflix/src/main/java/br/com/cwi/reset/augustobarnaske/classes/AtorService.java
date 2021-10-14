package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;
import br.com.cwi.reset.augustobarnaske.exceptions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AtorService{

    private FakeDatabase fakeDatabase;
    private Integer atorIdCounter = 0;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe

    public void criarAtor(AtorRequest atorRequest){

//        O fluxo começa fazendo a checagem das regras dentro do bloco de try e se passar ele cria o ator
//        cada exceção é tratada por um catch especifico seu, largando a mensagem na tela e não inserindo o ator
//        por meio do FakeDatabase.persisteAtor().
//        Precisei de algumas mensagens explicitando cada passo, pra entender o que estava acontecendo de problemas e conseguir corrigir
//        Também imprimi o estado de todos os campos para garantir o sucesso

        try{
            System.out.println("Iniciando a inserção de um novo ator agora!");
            System.out.println("Iniciando a testagem das regras:");
            checaCamposObrigatorios(atorRequest);
            checaNomeSobrenome(atorRequest);
            checaDataNascimento(atorRequest);
            checaAnoInicioAtividade(atorRequest);
            nomeDuplicado(atorRequest);
            System.out.println("----------Checagem Concluida---------");
            Integer atorId = gerarAtorId();
            System.out.println("Gerado Id do Ator como: "+ atorId);
            System.out.println("Nome como: "+atorRequest.getNome());
            System.out.println("Data Nasc como: "+atorRequest.getDataNascimento());
            System.out.println("Ano Inicio como: "+atorRequest.getAnoInicioAtividade());
            System.out.println("Status Carreira como: "+atorRequest.getStatusCarreira());
            System.out.println("---Se não houve exceção, o ator será inserido agora.---");
            atorRequest.setAtorId(atorId);
            FakeDatabase.persisteAtor(atorRequest);
            System.out.println("-------------Em teoria o ator foi inserido com sucesso-------------");
            System.out.println("-------------FINALIZANDO INSERÇÃO DE ATOR------------- \n");
        } catch (CampoObrigatorioException | NomeSobrenomeException | DataNascimentoInvalidaException | AnoInicioAtividadeInvalidoException | NomeDuplicadoException e){
            System.out.println(e.getMessage());
        }
    }

    public void checaCamposObrigatorios(AtorRequest atorRequest) throws CampoObrigatorioException {

//        O método vai buscar as informações que precisa chegar do Ator e, caso encontre uma vazia
//        ele vai adicionar na lista dos campos faltantes, se a lista não estiver vazia a exception é lançada

        String nome = atorRequest.getNome();
        LocalDate dataNascimento = atorRequest.getDataNascimento();
        String statusCarreira = atorRequest.getStatusCarreira();
        Integer anoInicioAtividade = atorRequest.getAnoInicioAtividade();

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

    public void checaNomeSobrenome(AtorRequest atorRequest) throws NomeSobrenomeException {

//      O método vai lançar o nome do ator pra nome e depois vai usar um split com \\s+ de regex, que representa mais
//      de um espaçamento dentro da variável, se o tamanho da variável onde rolou o split for menor que 2, lança a exceção

        String nome = atorRequest.getNome();
        String[] nomeSobrenome = nome.split("\\s+");

        if (nomeSobrenome.length < 2) {
            throw new NomeSobrenomeException();
        }
    }

    public void checaDataNascimento(AtorRequest atorRequest) throws DataNascimentoInvalidaException {
//      O método lança a data de hoje em uma variável e usar a função isAfter na dataNascimento
//      se confirmar lança a exceção
        LocalDate hoje = LocalDate.now();
        LocalDate dataNascimento = atorRequest.getDataNascimento();

        if (dataNascimento.isAfter(hoje)){
            throw new DataNascimentoInvalidaException();
        }
    }

    public void checaAnoInicioAtividade(AtorRequest atorRequest) throws AnoInicioAtividadeInvalidoException {
//      O metodo usar a função getYear na data de nascimento do ator para lançar somente o ano em uma int
//      Se o ano inicio menor que o nascimento lança uma exceção

        int anoNascimento = atorRequest.getDataNascimento().getYear();
        Integer anoInicioAtividade = atorRequest.getAnoInicioAtividade();

        if (anoInicioAtividade < anoNascimento){
            throw new AnoInicioAtividadeInvalidoException();
        }

    }

    public void nomeDuplicado(AtorRequest atorRequest) throws NomeDuplicadoException {

//      O método importa pra dentro de uma lista nessa classe a lista que vem do fakedatabase e faz a checagem
//      Para saber se o nome sendo inserido já consta nela, se constar, não executa o FakeDatabase.persisteAtor()
//      para inserir essa pessoa na lista

        List<Ator> atoresCadastrados = new ArrayList<>();
        atoresCadastrados = FakeDatabase.recuperaAtores();
        String nomeSendoInserido = atorRequest.getNome();
        int nomesCounter = 0;

        for (int i = 0; i < atoresCadastrados.size(); i++){
            if (nomeSendoInserido.equals(atoresCadastrados.get(i).getNome())){
                nomesCounter++;
            }
        }

        if (nomesCounter >= 1) {
            throw new NomeDuplicadoException(atorRequest);
        }
    }

    public static List<Ator> listarAtoresEmAtividade(String filtroNome) throws ListaAtoresEmAtividadeVaziaException, ListaAtoresEmAtividadeSemCorrespondenciaException{
//      Esse método insere os atores da FakeDatabase.recuperaAtores em uma lista usável dentro dessa classe e trabalha um stream em cima dela
//      A stream roda duas filtragens para separar pelo filtro usado e por EM_ATIVIDADE (fiz um getter para pegar o
//      própri enum e não a descrição) e depois imprimi os valores encontrados
//      Se por ventura ela estiver vazia ou não for encontrado nenhuma correspondencia pelo filtro, ela lança exceção para cada uma dessas situações

        List<Ator> atoresCadastrados = new ArrayList<>();
        atoresCadastrados = FakeDatabase.recuperaAtores();

        atoresCadastrados.stream()
                .filter(x -> x.getNome().contains(filtroNome))
                .filter(x -> x.getStatusCarreiraCrude().equals(StatusCarreira.EM_ATIVIDADE))
                .forEach(x -> System.out.println("ID: "+x.getAtorId()+" | ID: "+x.getNome()+" | Data Nascimento: "+x.getDataNascimento()));

        if (atoresCadastrados.isEmpty()){
            throw new ListaAtoresEmAtividadeVaziaException();
        }

        Stream<Ator> atoresFiltradosPorNome = Stream.of();
        atoresFiltradosPorNome = atoresCadastrados.stream()
                .filter(x -> x.getNome().contains(filtroNome));

        if(atoresFiltradosPorNome.toList().isEmpty()){
            throw new ListaAtoresEmAtividadeSemCorrespondenciaException(filtroNome);
        }


        return atoresCadastrados;
    }

    public List<Ator> consultarAtor(Integer id) throws ConsultaAtorException{
//      Esse método ficou um pouco bagunçado, acredito que há mil formas de otimizar ele, mas como preferi usar stream, ficou funcional dessa forma
//      Pra começar o retorno solicitado foi Ator, porém como trabalhei com Stream retornei uma lista com o ator encontrado ou a exceção que foi lançada
//      Instanciei a lista da FakeDatabase.recuperaAtores() em atoresCadastrados e criei um Stream<Ator> Stream.of para conseguir checar diretamente
//      Se o id passado como parametro está dentro dos atoresCadastrados, faço um toList().isEmpty() para checar se a lista está vazia logo
//      de cara para já lançar a exceção. Se não tiver vazia, faço uma segunda rodada de stream, porém em cima de atoresCadastrados
//      e filtrando pelo ID e imprimindo quem foi encontrado, no final retorno a lista atoresCadastrados streamada

        List<Ator> atoresCadastrados = new ArrayList<>();
        atoresCadastrados = FakeDatabase.recuperaAtores();

        Stream<Ator> atorConsultado = Stream.of();
        atorConsultado = atoresCadastrados.stream()
                .filter(x -> x.getAtorId().equals(id));


        if (atorConsultado.toList().isEmpty()){
            throw new ConsultaAtorException(id);
        }

        atoresCadastrados.stream()
                .filter(x -> x.getAtorId().equals(id))
                .forEach(x -> System.out.println("ID: "+x.getAtorId()+" | Nome: "+x.getNome()+" | Data Nasc: "+x.getDataNascimento()+" | Status Carreira: "+x.getStatusCarreira()));

        return atoresCadastrados;
    }

    public List<Ator> consultarAtores() throws ListaAtoresEmAtividadeVaziaException{
//      Instanciada a lista todosAtores usando o recupera atores e usado um
//      stream com foreach para imprimir na tela todos os presentes
        List<Ator> todosAtores = FakeDatabase.recuperaAtores();

        todosAtores.stream()
                .forEach(x -> System.out.println("ID: "+x.getAtorId()+" | Nome: "+x.getNome()+" | Data Nasc: "+x.getDataNascimento()+" | Ano Inicio Atividade: "+x.getAnoInicioAtividade()+" | Status Carreira: "+x.getStatusCarreira()));

        return todosAtores;
    }
}