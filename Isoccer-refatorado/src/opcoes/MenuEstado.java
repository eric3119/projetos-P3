package opcoes;

import acoes.Abstracoes.OpTodosRecursos;
import acoes.Abstracoes.Operacoes;
import acoes.Implementacoes.DadosArray;
import acoes.Erros;

public class MenuEstado {

    Operacoes op = new OpTodosRecursos(new DadosArray());
    public void mostrarStatus(){

        System.out.println("\n1-Funcionarios\n" +
                "2-Recursos Físicos\n" +
                "3-Sócios\n" +
                "4-Tudo\n" +
                "0-Voltar");

        int opcao = Erros.entradaInt(0, 4);

        op.estado(opcao);
    }
}
