package br.com.cwi.reset.exercicios.aula2;

public class Filme {

    private String nome;
    private String desc;
    private Integer duracao;
    private int anoLanc;
    private double aval;
    public String diretor;

    public Filme(String nome, String desc, Integer duracao, int anoLanc, double aval, String nomeDiretor) {
        this.nome = nome;
        this.desc = desc;
        this.duracao = duracao;
        this.anoLanc = anoLanc;
        this.aval = aval;
        this.diretor = Diretor.getNomeDiretor();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public int getAnoLanc() {
        return anoLanc;
    }

    public void setAnoLanc(int anoLanc) {
        this.anoLanc = anoLanc;
    }

    public double getAval() {
        return aval;
    }

    public void setAval(double aval) {
        this.aval = aval;
    }

    public void reproduzir(){
        System.out.println("Iniciando a sessão!");
        System.out.println("Filme: "+this.getNome());
        System.out.println("Descrição: "+this.getDesc());
        System.out.println("Duração: "+this.getDuracao());
        System.out.println("Diretor: "+Diretor.getNomeDiretor());
    }

}
