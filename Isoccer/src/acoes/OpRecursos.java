package acoes;

import modelo.CT;
import modelo.Estadio;
import modelo.Onibus;
import java.util.Scanner;

public class OpRecursos {

    public static void novoRecurso(int opcao){

        Scanner input = new Scanner(System.in);

        switch (opcao){
            case 1:
                System.out.println("Id");
                String id = input.nextLine();

                System.out.println("Disponível (S/N)");
                boolean disp = input.nextLine().equals("S");

                Dados.getInstance().salvarNovoOnibus(new Onibus(disp, id));
                break;
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

                Dados.getInstance().salvarNovoEstadio(new Estadio(disp, nome, nTorc, nBanh, nLanc));
                break;
            case 3:
                System.out.println("Nome: ");
                nome = input.nextLine();

                System.out.println("Quantidade de dormitorios: ");
                int nDorm = Erros.entradaInt();

                System.out.println("Disponível (S/N)");
                disp = input.nextLine().equals("S");

                Dados.getInstance().salvarNovoCt(new CT(disp, nome, nDorm));
                break;
        }
    }
}
