package br.com.cwi.reset.augustobarnaske;

import java.util.List;

public class Filme {

    private static int filmeIdCounter = 0;
    private Integer filmeId;
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private ListGenero genero;
    private Diretor diretor;
    private List<PersonagemAtor> personagens;
    private String resumo;

    public Filme(String nome, Integer anoLancamento, String capaFilme, ListGenero genero, Diretor diretor, String resumo) {
        this.filmeId = filmeIdCounter++;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.genero = genero;
        this.diretor = diretor;
        this.resumo = resumo;
    }
}
