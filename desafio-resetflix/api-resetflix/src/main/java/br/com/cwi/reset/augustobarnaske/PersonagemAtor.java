package br.com.cwi.reset.augustobarnaske;

public class PersonagemAtor {

    private static int personagemIdCounter = 0;
    private Integer personagemId;
    private Ator ator;
    private String nomePersonagem;
    private String descricaoPersonagem;
    private TipoAtuacao tipoAtuacao;

    public PersonagemAtor(Ator ator, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.personagemId = personagemIdCounter++;
        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }
}
