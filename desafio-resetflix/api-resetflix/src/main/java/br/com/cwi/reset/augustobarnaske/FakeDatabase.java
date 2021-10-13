package br.com.cwi.reset.augustobarnaske;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase{

    private static List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    public static void persisteAtor(Ator ator) {
        atores.add(ator);
    }

    public List<Ator> recuperaAtores() {
        return atores;
    }

    public void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores() {
        return diretores;
    }
}