package gerencia;

import modelo.Dados;
import modelo.Pagamento;
import modelo.empregado.*;
import modelo.Erros;

import java.util.Scanner;

public class Gerenciar{

    private static Scanner input = new Scanner(System.in);

    public static void adcEmpregado(){

        System.out.println("Nome: ");
        String nome = input.nextLine();

        System.out.println("Endereco: ");
        String endereco = input.nextLine();

        System.out.println("Tipo de agenda: ");
        int tipoAgenda = Erros.entradaInt();

        System.out.println("Dia do pagamento: ");
        int diaPagamento = Erros.entradaInt();

        System.out.println("Salário: ");
        double salario = Erros.entradaDouble();

        switch (tipoAgenda){
            case 1:
                Dados.getInstance().salvarEmpregado(new Horista(nome, endereco, tipoAgenda, diaPagamento, salario));
                break;
            case 2:
                Dados.getInstance().salvarEmpregado(new Assalariado(nome, endereco, tipoAgenda, diaPagamento, salario));
                break;
            case 3:
                System.out.println("Comissão: ");
                double comissao = Erros.entradaDouble();
                Dados.getInstance().salvarEmpregado(new Comissionado(nome, endereco, tipoAgenda, diaPagamento, salario, comissao));
        }
    }

    public static void rmEmpregado(){

        System.out.println("ID do empregado: ");
        int id = Erros.entradaInt();

        Dados.getInstance().removerEmpregado(id);

    }

    public static void lancCartao(){

        Empregado x = Dados.getInstance().buscaEmpregadoID();
        if(x == null)
            return;

        String entrada = input.nextLine();
        String saida = input.nextLine();

        x.adicionarCartao(new CartaodePonto(entrada, saida));
    }

    public static void resultVenda(){

        Empregado x = Dados.getInstance().buscaEmpregadoID();
        if(x == null)
            return;

        String data = input.nextLine();
        double valor = Erros.entradaDouble();

        x.adicionarVenda(new Venda(data, valor));
    }

    public static void taxaServico(){
        Empregado x = Dados.getInstance().buscaEmpregadoID();
        if(x == null)
            return;

        String nomeServ = input.nextLine();
        double taxa = Erros.entradaDouble();

        x.novaTaxa(new TaxaServico(nomeServ, taxa));
    }

    public static void editarEmpregado(){
        Empregado x = Dados.getInstance().buscaEmpregadoID();

        if(x == null)
            return;

        System.out.println("Editar Nome: ");
        String nome = input.nextLine();

        System.out.println("Editar Endereco: ");
        String endereco = input.nextLine();

        System.out.println("Tipo de agenda: ");
        int tipoAgenda = Erros.entradaInt();

        System.out.println("Dia do pagamento: ");
        int diaPagamento = Erros.entradaInt();

        System.out.println("Salário: ");
        double salario = Erros.entradaDouble();

        x.editarDados(nome, endereco, tipoAgenda, diaPagamento, salario);

    }

    public static void rodarFolha(){
        Pagamento.folhaDia(Erros.entradaInt());
    }


}