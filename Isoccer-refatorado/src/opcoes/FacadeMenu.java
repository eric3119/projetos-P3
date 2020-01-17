package opcoes;

import acoes.Erros;

public class FacadeMenu {

    MenuAdc menuAdc= new MenuAdc();
    MenuEstado menuEstado = new MenuEstado();

    public boolean principal(){

        System.out.printf("\n\n1-Adicionar funcionario\n" +
                "2-Adicionar socio\n" +
                "3-Adicionar Recurso\n"+
                "4-Estado atual de recursos\n" +
                "0-Sair\n>> ");

        int opcao = Erros.entradaInt(0,4);

        switch (opcao) {
            case 1:
                menuAdc.adcFunc();
                break;
            case 2:
                menuAdc.adcSocio();
                break;
            case 3:
                menuAdc.adcRec();
                break;
            case 4:
                menuEstado.mostrarStatus();
                break;
            case 0:
                return false;
        }

        return true;
    }
}
