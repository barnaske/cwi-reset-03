package br.com.cwi.reset.augustobarnaske;

import java.time.LocalDate;

public class Ator {

    private static int atorIdCounter = 0;
    // *Caso fosse usar uma aplicação multithread seria um problema imenso usar um counter,
    // o ideal seria usar private static AtomicInteger atomicInteger = new AtomicInteger(0), o que seria threadsafe;
    // como não entendo essa implementação irei usar o counter e corrijo caso os monitores achem coerente.
    private Integer atorId;
    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public Ator(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.atorId = atorIdCounter++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }
}
