public class QuantidadeMinimaItem {

    public static boolean precisaReposicao(String item) {
        if ("paes".equals(item)) {
            if (ItensPorQuantidade.pao < 600){
                return true;
            }
        }

        if ("torta".equals(item)) {
            if (ItensPorQuantidade.tortaFatias < 10){
                return true;
            }
        }

        if ("sanduba".equals(item)) {
            if (ItensPorQuantidade.sanduiche <= 1){
                return true;
            }
        }

        if ("cafe".equals(item)) {
            if (ItensPorQuantidade.cafe < 12){
                return true;
            }
        }

        if ("leite".equals(item)) {
            if (ItensPorQuantidade.leite < 12) {
                return true;
            }
        }
        return false;
    }
}
