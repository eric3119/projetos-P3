package modelo;

import modelo.empregado.Empregado;
import modelo.empregado.Horista;

import java.util.ArrayList;

public class Pagamento{

    public static void folhaDia(int dia){
        ArrayList<Empregado> lista = Dados.getInstance().buscaPagamentoDia(dia);

        System.out.println("Pagamentos: ");

        for (Empregado x :
                lista) {
            System.out.printf("Nome: %s\nValor do pagamento: %f\n\n",
                        x.getNome(), valorPagamento(x, x.getTipoDeAgenda()));
        }
    }

    private static double valorPagamento(Empregado x, int tipo) {

        switch (tipo){
            case 1:
                return ((Horista) x).getPagamento();
            case 2:
            case 3:
        }

        return 0;
    }
}
