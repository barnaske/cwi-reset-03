package br.com.cwi.reset.exercicios.aula2;

public enum EnumGenero {
    MASCULINO ("Masculino"),
    FEMININO ("Feminino"),
    NAO_BINARIO ("Não Binário");

    private String desc;

    EnumGenero(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
