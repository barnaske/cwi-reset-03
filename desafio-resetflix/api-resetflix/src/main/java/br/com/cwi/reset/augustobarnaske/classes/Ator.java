package br.com.cwi.reset.augustobarnaske.classes;

import br.com.cwi.reset.augustobarnaske.enums.StatusCarreira;

import java.time.LocalDate;

public class Ator {

//    private static int atorIdCounter = 0;

    // *Caso fosse usar uma aplicação multithread seria um problema imenso usar um counter,
    // o ideal seria usar private static AtomicInteger atomicInteger = new AtomicInteger(0), o que seria threadsafe;
    // como não entendo essa implementação irei usar o counter e corrijo caso os monitores achem coerente.

    private static Integer atorId;
    private static String nome;
    private static LocalDate dataNascimento;
    private static StatusCarreira statusCarreira;
    private static Integer anoInicioAtividade;

    public Ator(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public static String getNome() {
        return nome;
    }

    public static LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public static StatusCarreira getStatusCarreira(){
        return statusCarreira;
    }

    public static Integer getAnoInicioAtividade(){
        return anoInicioAtividade;
    }

    public static Integer getAtorId(){
        return atorId;
    }

    public void setAtorId(int id){
        this.atorId = id;
    }

    public static void getAtorStatus(AtorRequest atorRequest){
        System.out.println(getNome());
        System.out.println(getDataNascimento());
        System.out.println(getAnoInicioAtividade());
        System.out.println(getAtorId());
    }
}
