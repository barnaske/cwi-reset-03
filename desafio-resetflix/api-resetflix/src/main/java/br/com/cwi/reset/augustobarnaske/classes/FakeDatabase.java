package br.com.cwi.reset.augustobarnaske.classes;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase{

    private static List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    public static void persisteAtor(Ator ator) {
        atores.add(ator);
        System.out.println("Adicionando ator com ID:"+Ator.getAtorId());
        System.out.println("Com nome: "+Ator.getNome());
    }

    public static List<Ator> recuperaAtores() {
        return atores;
    }

    public void persisteDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Diretor> recuperaDiretores() {
        return diretores;
    }
}