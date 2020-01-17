package opcoes;

import acoes.*;

import java.util.Scanner;

public class Menu{

    public static Scanner input = new Scanner(System.in);

    public static boolean principal(){

        System.out.printf("\n\n1-Adicionar funcionario\n" +
                "2-Adicionar socio\n" +
                "3-Adicionar Recurso\n"+
                "4-Estado atual de recursos\n" +
                "0-Sair\n>> ");

        int opcao = Erros.entradaInt(0,4);

        switch (opcao) {
            case 1:
                adcFunc();
                break;
            case 2:
                adcSocio();
                break;
            case 3:
                adcRec();
                break;
            case 4:
                mostrarStatus();
                break;
            case 0:
                return false;
        }

        return true;
    }

    private static void adcRec() {
        System.out.printf("\n1-Onibus\n"+
                "2-Estádio\n"+
                "3-Centro de Treinamento\n"+
                "0-Sair\n>> ");

        int opcao = Erros.entradaInt(0, 3);

        OpRecursos.novoRecurso(opcao);

    }

    private static void adcFunc() {
        System.out.printf("\n1-Presidente\n" +
                "2-Jogador\n" +
                "3-Técnico\n" +
                "4-Preparador físico\n" +
                "5-Motorista\n" +
                "6-Cozinheiro\n" +
                "7-Advogado\n" +
                "8-Médico\n" +
                "0-Sair\n>> ");

        int cargo = Erros.entradaInt(0,8);
        if (cargo == 0) {
            return;
        }

        if(cargo == 1 && OpPessoas.verifPresidente()){
            System.out.printf("\nAlterar Presidente (S/N): ");

            if(!input.nextLine().equals("S"))
                return;
        }

        OpPessoas.novoFunc(cargo);
    }

    private static void adcSocio(){
        OpPessoas.novoSocio();
    }

    private static void mostrarStatus(){

        System.out.println("\n1-Funcionarios\n" +
                "2-Recursos Físicos\n" +
                "3-Sócios\n" +
                "4-Tudo\n" +
                "0-Voltar");

        int opcao = Erros.entradaInt(0, 4);

        Dados.getInstance().mostrarStatus(opcao);
    }
}

