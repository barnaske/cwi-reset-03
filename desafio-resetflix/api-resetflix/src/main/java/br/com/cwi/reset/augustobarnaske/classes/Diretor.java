package br.com.cwi.reset.augustobarnaske.classes;

import java.time.LocalDate;

public class Diretor {

    private static int diretorIdCounter = 0;
    // *Caso fosse usar uma aplicação multithread seria um problema imenso usar um counter,
    // o ideal seria usar private static AtomicInteger atomicInteger = new AtomicInteger(0), o que seria threadsafe;
    // como não entendo essa implementação irei usar o counter e corrijo caso os monitores achem coerente.
    private Integer diretorId;
    private String nome;
    private LocalDate dataNascimento;
    private Integer anoInicioAtividade;

    public Diretor(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.diretorId = diretorIdCounter++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }
}
