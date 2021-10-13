package br.com.cwi.reset.augustobarnaske.enums;

public enum ListGenero {
    ACAO ("Ação"),
    AVENTURA ("Aventura"),
    COMEDIA ("Comédia"),
    DOCUMENTARIO ("Documentário"),
    DRAMA ("Drama"),
    ESPIONAGEM ("Espionagem"),
    FICCAO_CIENTIFICA ("Ficção Científica"),
    GUERRA ("Guerra"),
    MISTERIO ("Mistério"),
    MUSICAL ("Musical"),
    POLICIAL ("Policial"),
    ROMANCE ("Romance"),
    TERROR ("Terror");

    private String descricao;

    ListGenero(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
