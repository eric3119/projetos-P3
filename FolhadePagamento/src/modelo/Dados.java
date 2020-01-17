package modelo;

import modelo.empregado.Agenda;
import modelo.empregado.Empregado;

import java.util.ArrayList;

public class Dados {

    private ArrayList<Empregado> empregados = new ArrayList<>();
    private ArrayList<Agenda> agendas = new ArrayList<>();

    private Dados() {}

    private static Dados dados = new Dados();

    public static Dados getInstance(){
        return dados;
    }

    public void salvarEmpregado(Empregado novo){
        empregados.add(novo);
    }
    public int novoId() {
        if(empregados.size() == 0)
            return 0;
        else
            return empregados.get(empregados.size()-1).getId()+1;
    }

    public void removerEmpregado(int id) {
        for (int i = 0; i<empregados.size(); i++) {
            if(empregados.get(i).getId() == id) {
                empregados.remove(i);
                break;
            }
        }
    }

    public Empregado buscaEmpregadoID(){

        System.out.print("\nID: ");

        int id = Erros.entradaInt();

        for (Empregado x :
                empregados) {
            if(id == x.getId())
                return x;
        }
        System.out.println("Nao encontrado");
        return null;
    }

    ArrayList<Empregado> buscaPagamentoDia(int dia) {
        ArrayList<Empregado> lista = new ArrayList<>();
        for (Empregado x :
                empregados) {
            if(x.getDiaPagamento() == dia){
                lista.add(x);
            }
        }
        return lista;
    }
}
