
public class Registradora {

    public static void main(String[] args) {
      //  primeiroBug(); //OK

      //  segundoBug(); //OK

     //  terceiroBug(); //OK

     //   quartoBug();  //OK

    //    quintoBug();  //OK

        sextoBug(); //OK
    }

    public static double registrarItem(String item, int quantidade) {
        double precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);

        if (QuantidadeMinimaItem.precisaReposicao(item)) {
            if ("pao".equals(item) || "sanduba".equals(item) || "torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento()) {
                    System.out.println("Cozinha fechada!");
                }
                ReposicaoCozinha.reporItem(item);
            }

            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
            }
        }

        return precoItem;
    }

    public static void primeiroBug() {
        System.out.println("------ PRIMEIRO PEDIDO ------");
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduba";
        int quantidade = 4;

        if (quantidade > ItensPorQuantidade.sanduiche){
            if (DataProjeto.cozinhaEmFuncionamento()){
                ReposicaoCozinha.reporItemQtdCozinha("sanduba", 20);
            }else{
                System.out.println("Não há estoque para realizar a venda e não é possível repor pois a cozinha não está em funcionamento.");
            }
        }

        double precoTotal = registrarItem(item, quantidade);

        if (!DataProjeto.cozinhaEmFuncionamento()) {
            System.out.println("Cozinha fechada!");
        }else {
            System.out.println(String.format("Valor total: %.2f", precoTotal));
            ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche - quantidade;
            System.out.println("----- AINDA RESTAM "+ItensPorQuantidade.sanduiche+" SANDUICHES NO ESTOQUE. -----");
        }
    }

    public static void segundoBug() {
        System.out.println("------ SEGUNDO PEDIDO ------");
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "torta";
        int quantidadeFatias = 10;

        if (quantidadeFatias > ItensPorQuantidade.tortaFatias){
            if (DataProjeto.cozinhaEmFuncionamento()){
                ReposicaoCozinha.reporItem("torta");
            }else{
                System.out.println("Não há estoque para realizar a venda e não é possível repor pois a cozinha não está em funcionamento.");
            }
        }

        double precoTotal = registrarItem(item, quantidadeFatias);

        if (!DataProjeto.cozinhaEmFuncionamento()) {
            System.out.println("Cozinha fechada!");
        }else {
            System.out.println(String.format("Valor total: %.2f", precoTotal));
            ItensPorQuantidade.tortaFatias = ItensPorQuantidade.tortaFatias - quantidadeFatias;
            System.out.println("----- AINDA RESTAM "+ItensPorQuantidade.tortaFatias+" FATIAS DE TORTA NO ESTOQUE. -----");
        }
    }

    public static void terceiroBug() {
        System.out.println("------ TERCEIRO PEDIDO ------");
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        if (quantidade > ItensPorQuantidade.cafe){
            System.out.println("Não há estoque para efetuar a venda, realizando a reposição e prosseguindo com o pedido.");
            ReposicaoFornecedor.reporItemQtd("cafe", quantidade);
        }

        double precoTotal = registrarItem(item, quantidade);

        if (!DataProjeto.cozinhaEmFuncionamento()) {
            System.out.println("Cozinha fechada!");
        }else {
            System.out.println(String.format("Valor total: %.2f", precoTotal));
            ItensPorQuantidade.cafe = ItensPorQuantidade.cafe - quantidade;
            System.out.println("----- AINDA RESTAM "+ItensPorQuantidade.cafe+" CAFÉ(S) NO ESTOQUE. -----");
        }
    }

    public static void quartoBug() {
        System.out.println("------ QUARTO PEDIDO | CLIENTE 1 ------");
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduba";
        int quantidade = 20;

        if (quantidade > ItensPorQuantidade.sanduiche){
            if (!DataProjeto.cozinhaEmFuncionamento()){
                System.out.println("Não há estoque para realizar a venda e não é possível repor pois a cozinha não está em funcionamento.");
            }else{
                ReposicaoCozinha.reporItemQtdCozinha("sanduba", 20);
                System.out.println("O estoque foi reposto para atender ao pedido corretamente.");
                System.out.println(ItensPorQuantidade.sanduiche);
            }
        }

        double precoTotal = registrarItem(item, quantidade);

        if (!DataProjeto.cozinhaEmFuncionamento()) {
            System.out.println("Cozinha fechada!");
        }else {
            System.out.println(String.format("Valor total: %.2f", precoTotal));
            ItensPorQuantidade.sanduiche -= quantidade;
            System.out.println("----- AINDA RESTAM "+ItensPorQuantidade.sanduiche+" SANDUICHES NO ESTOQUE. -----");
        }

        // Cliente 2
        System.out.println("------ QUARTO PEDIDO | CLIENTE 2 ------");
        String item2 = "sanduba";
        int quantidade2 = 5;

        if (quantidade2 > ItensPorQuantidade.sanduiche){
            if (!DataProjeto.cozinhaEmFuncionamento()){
                System.out.println("Não há estoque para realizar a venda e não é possível repor pois a cozinha não está em funcionamento.");
            }else{
                ReposicaoCozinha.reporItemQtdCozinha("sanduba", 20);
                System.out.println("O estoque foi reposto para atender ao pedido corretamente.");
            }
        }

        double precoTotal2 = registrarItem(item2, quantidade2);

        if (!DataProjeto.cozinhaEmFuncionamento()) {
            System.out.println("Cozinha fechada!");
        }else {
            System.out.println(String.format("Valor total: %.2f", precoTotal2));
            ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche - quantidade2;
            System.out.println("----- AINDA RESTAM "+ItensPorQuantidade.sanduiche+" SANDUICHES NO ESTOQUE. -----");
        }
    }

    public static void quintoBug() {
        System.out.println("------ QUINTO PEDIDO ------");
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        if (quantidade > (ItensPorQuantidade.pao/60)){
            if (!DataProjeto.cozinhaEmFuncionamento()){
                System.out.println("Não há estoque para realizar a venda e não é possível repor pois a cozinha não está em funcionamento.");
            }else {
                ReposicaoCozinha.reporItem(item);
                System.out.println("O estoque foi reposto para atender ao pedido sem produtos faltantes.");
            }
        }

        double precoTotal = registrarItem(item, quantidade);

        if (!DataProjeto.cozinhaEmFuncionamento()) {
            System.out.println("Cozinha fechada!");
        }else {
            System.out.println(String.format("Valor total: %.2f", precoTotal));
            ItensPorQuantidade.pao = ItensPorQuantidade.pao - (quantidade*60);
            System.out.println("----- AINDA RESTAM "+(ItensPorQuantidade.pao/60)+" PÃES NO ESTOQUE. -----");
        }
    }

    public static void sextoBug() {
        System.out.println("------ SEXTO PEDIDO | CLIENTE 1 ------");
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduba";
        int quantidade = 20;

        if (quantidade > ItensPorQuantidade.sanduiche){
            if (!DataProjeto.cozinhaEmFuncionamento()){
                System.out.println("Não há estoque para realizar a venda e não é possível repor pois a cozinha não está em funcionamento.");
            }else{
                ReposicaoCozinha.reporItem("sanduba");
                System.out.println("O estoque foi reposto para atender ao pedido corretamente.");
            }
        }

        double precoTotal = registrarItem(item, quantidade);
            System.out.println(String.format("Valor total: %.2f", precoTotal));
            ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche - quantidade;
            System.out.println("----- AINDA RESTAM "+ItensPorQuantidade.sanduiche+" SANDUICHES NO ESTOQUE. -----");


        // Cliente 2
        System.out.println("------ SEXTO PEDIDO | CLIENTE 2 ------");
        String item2 = "sanduba";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);
        if (quantidade2 > ItensPorQuantidade.sanduiche){
            System.out.println("Reposição indisponível no momento, quantidade restante em estoque é "+ItensPorQuantidade.sanduiche+".");
        }else{
            System.out.println(String.format("Valor total: %.2f", precoTotal2));
            ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche - quantidade2;
            System.out.println("----- AINDA RESTAM "+ItensPorQuantidade.sanduiche+" SANDUICHES NO ESTOQUE. -----");
        }
    }
}