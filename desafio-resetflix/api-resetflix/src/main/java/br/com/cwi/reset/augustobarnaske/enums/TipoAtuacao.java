package br.com.cwi.reset.augustobarnaske.enums;

public enum TipoAtuacao {
    PRINCIPAL ("Principal"),
    COADJUVANTE ("Coadjuvante");

    private String descricao;

    TipoAtuacao (String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
