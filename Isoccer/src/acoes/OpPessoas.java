package acoes;

import modelo.*;
import opcoes.Menu;

import java.util.Scanner;

public class OpPessoas {
    private static Scanner input = new Scanner(System.in);

    public static void novoFunc(int cargo) {

        System.out.printf("\nNome: ");
        String nome = input.nextLine();

        System.out.printf("\nEmail: ");
        String email = input.nextLine();

        System.out.printf("\nCPF: ");
        String cpf = input.nextLine();

        System.out.printf("\nSalario: ");
        double salario = Erros.entradaDouble();

        System.out.printf("\nTelefone: ");
        String telefone = input.nextLine();

        switch (cargo){
            case 1:
                Dados.getInstance().salvarNovoFunc(new Funcionarios(cargo, nome, email, cpf, salario, telefone));
                break;
            case 2:
                System.out.printf("\nTipo: "+
                                    "\n1-Volante"+
                                    "\n2-Zagueiro"+
                                    "\n3-Meia"+
                                    "\n4-Goleiro"+
                                    "\n5-Atacante"+
                                    "\n6-Lateral Esquerdo"+
                                    "\n7-Lateral Direito\n");
                int tipo = Erros.entradaInt();

                System.out.println("\nApto (S/N): ");
                boolean apto = Menu.input.nextLine().equals("S");

                Dados.getInstance().salvarNovoFunc(new Jogador(cargo, nome, email, cpf, salario, telefone, tipo, apto));
                break;
            case 5:
                System.out.printf("\nCNH: ");
                String cnh = Menu.input.nextLine();

                Dados.getInstance().salvarNovoFunc(new Motorista(cargo, nome, email, cpf, salario, telefone, cnh));
                break;
            case 8:
                System.out.printf("\nCRM: ");
                String CRM = Menu.input.nextLine();

                Dados.getInstance().salvarNovoFunc(new Medico(cargo, nome, email, cpf, salario, telefone, CRM));
                break;
            default:
                Dados.getInstance().salvarNovoFunc(new Funcionarios(cargo, nome, email, cpf, salario, telefone));
        }
    }

    public static void novoSocio(){

        System.out.println("Novo Socio\n");

        System.out.printf("Nome: ");
        String nome = input.nextLine();

        System.out.printf("\nEmail: ");
        String email = input.nextLine();

        System.out.printf("\nCPF: ");
        String cpf = input.nextLine();

        System.out.printf("\nTelefone: ");
        String telefone = input.nextLine();

        System.out.printf("\nEndereço: ");
        String endereco = input.nextLine();

        System.out.printf("\nValor de contribuição: ");
        double valContr = Erros.entradaDouble();

        System.out.printf("\nAdimplente (S/N): ");
        boolean adimplente = (input.nextLine().equals("S"));

        System.out.printf("\nTipo: \n1-Junior\n2-Senior\n3-Elite\n>> ");
        int tipo = Erros.entradaInt(1,3);

        Dados.getInstance().salvarNovoSocio(new Socio(nome, email, cpf, telefone, endereco, valContr, adimplente, tipo));
    }

    public static boolean verifPresidente(){
        return Dados.getInstance().existePresidente();
    }
}
