package br.com.cwi.reset.augustobarnaske;

public enum StatusAtividade {
    EM_ATIVIDADE ("Em Atividade"),
    ENCERRADO ("Encerrado");

    private String descricao;

    StatusAtividade(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
