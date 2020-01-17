package opcoes;

import gerencia.Gerenciar;
import modelo.Erros;

public class Menu {
    public static void principal() {
        System.out.println("1-Adicionar empregado\n" +
                            "2-Remover empregado\n" +
                            "3-Lançar cartão de ponto\n" +
                            "4-Lançar resultado de venda\n" +
                            "5-Lançar taxa de serviço\n" +
                            "6-Editar empregado\n" +
                            "7-Rodar folha\n" +
                            "8-undo/redo\n" +
                            "9-Agenda de pagamento\n" +
                            "10-Nova agenda\n");

        int opcao = Erros.entradaInt(1, 10);

        switch (opcao){
            case 1: Gerenciar.adcEmpregado(); break;
            case 2: Gerenciar.rmEmpregado(); break;
            case 3: Gerenciar.lancCartao(); break;
            case 4: Gerenciar.resultVenda(); break;
            case 5: Gerenciar.taxaServico(); break;
            case 6: Gerenciar.editarEmpregado(); break;
            case 7: Gerenciar.rodarFolha(); break;
            case 8: break;
            case 9: break;
            case 10: break;
        }
    }
}
