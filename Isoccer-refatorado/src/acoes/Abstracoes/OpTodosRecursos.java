package acoes.Abstracoes;

import acoes.Erros;
import acoes.Implementacoes.DadosImpl;
import modelo.Funcionario.Jogador;
import modelo.Funcionario.Medico;
import modelo.Funcionario.Motorista;
import modelo.Funcionarios;
import modelo.Recursos.CT;
import modelo.Recursos.Estadio;
import modelo.Recursos.Onibus;
import modelo.Socio;

import java.util.Scanner;

public class OpTodosRecursos extends Operacoes{

    public OpTodosRecursos(DadosImpl dados) {
        super(dados);
    }

    public void novoRecurso(int opcao){

        Scanner input = new Scanner(System.in);

        switch (opcao){
            case 1:
                System.out.println("Id");
                String id = input.nextLine();

                System.out.println("Disponível (S/N)");
                boolean disp = input.nextLine().equals("S");

                dados.salvarNovoRecurso(new Onibus(disp, id));
            case 2:
                System.out.println("Nome: ");
                String nome = input.nextLine();

                System.out.println("Capacidade: ");
                int nTorc = Erros.entradaInt();

                System.out.println("Quantidade de banheiros: ");
                int nBanh = Erros.entradaInt();

                System.out.println("Quantidade de lanchonetes: ");
                int nLanc = Erros.entradaInt();

                System.out.println("Disponível (S/N)");
                disp = input.nextLine().equals("S");

                dados.salvarNovoRecurso(new Estadio(disp, nome, nTorc, nBanh, nLanc));
            case 3:
                System.out.println("Nome: ");
                nome = input.nextLine();

                System.out.println("Quantidade de dormitorios: ");
                int nDorm = Erros.entradaInt();

                System.out.println("Disponível (S/N)");
                disp = input.nextLine().equals("S");

                dados.salvarNovoRecurso(new CT(disp, nome, nDorm));
        }
    }

    public void novoFunc(int cargo) {
        switch (cargo){
            case 2:
                dados.salvarNovoFunc(new Jogador.JogadorBuilder().build());
                break;
            case 5:
                dados.salvarNovoFunc(new Motorista.MotoristaBuilder().build());
                break;
            case 8:
                dados.salvarNovoFunc(new Medico.MedicoBuilder().build());
                break;
            default:
                dados.salvarNovoFunc(new Funcionarios.FuncionariosBuilder().build(cargo));
        }
    }

    public void novoSocio() {


        System.out.println("Novo Socio\n");

        System.out.printf("Nome: ");
        String nome = Erros.entradaString();

        System.out.printf("\nEmail: ");
        String email = Erros.entradaString();

        System.out.printf("\nCPF: ");
        String cpf = Erros.entradaString();

        System.out.printf("\nTelefone: ");
        String telefone = Erros.entradaString();

        System.out.printf("\nEndereço: ");
        String endereco = Erros.entradaString();

        System.out.printf("\nValor de contribuição: ");
        double valContr = Erros.entradaDouble();

        System.out.printf("\nAdimplente (S/N): ");
        boolean adimplente = (Erros.entradaString().equals("S"));

        System.out.printf("\nTipo: \n1-Junior\n2-Senior\n3-Elite\n>> ");
        int tipo = Erros.entradaInt(1,3);

        dados.salvarNovoSocio(new Socio(nome, email, cpf, telefone, endereco, valContr, adimplente, tipo));
    }

    public boolean verifPresidente(){
        return dados.existePresidente();
    }

    @Override
    public void estado(int opcao) {
        dados.mostrarStatus(opcao);
    }
}
