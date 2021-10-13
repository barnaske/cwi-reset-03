package br.com.cwi.reset.augustobarnaske.enums;

public enum StatusCarreira {
    EM_ATIVIDADE ("Em Atividade"),
    APOSENTADO ("Aposentado");

    private String descricao;

    StatusCarreira(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
