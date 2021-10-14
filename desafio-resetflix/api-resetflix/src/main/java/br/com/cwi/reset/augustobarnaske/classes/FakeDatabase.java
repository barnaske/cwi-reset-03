package br.com.cwi.reset.augustobarnaske.classes;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase{

    private static List<Ator> atores = new ArrayList<>();
    private static List<Diretor> diretores = new ArrayList<>();

    public static void persisteAtor(Ator ator) {
        atores.add(ator);
    }

    public static List<Ator> recuperaAtores() {
        return atores;
    }

    public static void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public static List<Diretor> recuperaDiretores() {
        return diretores;
    }
}