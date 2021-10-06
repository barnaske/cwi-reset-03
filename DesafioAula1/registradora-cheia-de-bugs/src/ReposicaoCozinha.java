public class ReposicaoCozinha {

    static void reporItem(String item) {
        if ("pao".equals(item)) {
            if (!DataProjeto.cozinhaEmFuncionamento()) {
                System.out.println("Não é possível repor no momento, a cozinha não está aberta!");
            } else {
                ItensPorQuantidade.pao = ItensPorQuantidade.pao+ 3600;
            }

            if ("torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento()) {
                    System.out.println("Não é possível repor no momento, a cozinha não está aberta!");
                } else {
                    ItensPorQuantidade.torta = ItensPorQuantidade.torta + 4;
                }
            }

            if ("sanduba".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento()) {
                    System.out.println("Não é possível repor no momento, a cozinha não está aberta!");
                } else {
                    ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche + 20;
                }
            }
        }
    }

    static void reporItemQtdCozinha(String item, int qtd) {
        if ("paes".equals(item)) {
            ItensPorQuantidade.pao = ItensPorQuantidade.pao + qtd;
        }

        if ("torta".equals(item)) {
            ItensPorQuantidade.torta = ItensPorQuantidade.torta + qtd;
        }

        if ("sanduba".equals(item)) {
            ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche + qtd;
        }
    }
}