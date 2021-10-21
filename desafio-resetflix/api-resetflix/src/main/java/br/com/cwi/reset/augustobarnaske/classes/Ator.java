package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;

import java.time.LocalDate;

public class Ator {

//    private static int atorIdCounter = 0;

    // *Caso fosse usar uma aplicação multithread seria um problema imenso usar um counter,
    // o ideal seria usar private static AtomicInteger atomicInteger = new AtomicInteger(0), o que seria threadsafe;
    // como não entendo essa implementação irei usar o counter e corrijo caso os monitores achem coerente.
//    O int atorIdCounter só foi movido pra AtorService pq interpreto pela leitura das regras de negócio que o id deve ser gerado e contado lá
//    Mas esse comentário ainda vai ficar aqui pois ele explica o motivo de usar essa implementação.

    private Integer atorId;
    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public Ator(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setStatusCarreira(StatusCarreira statusCarreira) {
        this.statusCarreira = statusCarreira;
    }

    public void setAnoInicioAtividade(Integer anoInicioAtividade) {
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public StatusCarreira getStatusCarreira(){
        return statusCarreira;
    }

    public StatusCarreira getStatusCarreiraCrude(){
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade(){
        return this.anoInicioAtividade;
    }

    public Integer getAtorId(){
        return atorId;
    }

    public void setAtorId(Integer id){
        this.atorId = id;
    }

    public static void getAtorStatus(AtorRequest atorRequest){
        System.out.println("Nome: "+atorRequest.getNome());
        System.out.println("Data Nasc: "+atorRequest.getDataNascimento());
        System.out.println("Ano Inicio: "+atorRequest.getAnoInicioAtividade());
        System.out.println("ID: "+atorRequest.getAtorId());
        System.out.println("------Fim das Caracteristicas------\n");
    }
}
