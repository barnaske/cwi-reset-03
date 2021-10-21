package br.com.cwi.reset.exercicios.aula2;

public enum EnumGenero {
    MASCULINO ("Masculino"),
    FEMININO ("Feminino"),
    NAO_BINARIO ("Não Binário");

    private String descricao;

    EnumGenero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
