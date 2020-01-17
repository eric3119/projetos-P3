package opcoes;

import acoes.Abstracoes.Operacoes;
import acoes.Erros;

import acoes.Abstracoes.OpTodosRecursos;
import acoes.Implementacoes.DadosArray;

public class MenuAdc {
    Operacoes op = new OpTodosRecursos(new DadosArray());

    public void adcRec() {
        System.out.printf("\n1-Onibus\n"+
                "2-Estádio\n"+
                "3-Centro de Treinamento\n"+
                "0-Sair\n>> ");

        int opcao = Erros.entradaInt(0, 3);

        op.novoRecurso(opcao);

    }

    public void adcFunc() {
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

        if(cargo == 1 && op.verifPresidente()){
            System.out.printf("\nAlterar Presidente (S/N): ");

            if(!Erros.entradaString().equals("S"))
                return;
        }

        op.novoFunc(cargo);
    }

    public void adcSocio(){
        op.novoSocio();
    }
}
