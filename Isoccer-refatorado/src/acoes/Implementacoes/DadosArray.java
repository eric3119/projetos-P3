package acoes.Implementacoes;

import acoes.EstadoAtual;
import modelo.*;

import java.util.ArrayList;

public class DadosArray extends DadosImpl{

    public void salvarNovoFunc(Funcionarios novo){

        if(novo.getCargo() == 1 && existePresidente()) {
            for (int i = 0; i < ArraysDados.funcionarios.size(); i++) {
                if (ArraysDados.funcionarios.get(i).getCargo() == 1)
                    ArraysDados.funcionarios.remove(i);
            }
        }

        ArraysDados.funcionarios.add(novo);
    }

    public void salvarNovoRecurso(RecFisicos novo){ArraysDados.recursos.add(novo);}

    public void salvarNovoSocio(Socio novo) {
        ArraysDados.socios.add(novo);
    }


    public void mostrarStatus(int opcao){

        switch (opcao){
            case 1:
                EstadoAtual.estadoFunc(ArraysDados.funcionarios);
                break;
            case 2:
                EstadoAtual.estadoRec(ArraysDados.recursos);
                break;
            case 3:
                EstadoAtual.estadoSoc(ArraysDados.socios);
                break;
            case 4:
                EstadoAtual.estadoFunc(ArraysDados.funcionarios);
                EstadoAtual.estadoRec(ArraysDados.recursos);
                EstadoAtual.estadoSoc(ArraysDados.socios);
        }

    }

    public boolean existePresidente(){

        for (Funcionarios x: ArraysDados.funcionarios) {
            if(x.getCargo() == 1)
                return true;
        }
        return false;
    }

    public static class ArraysDados{
        protected static ArrayList<Socio> socios = new ArrayList<>();
        protected static ArrayList<Funcionarios> funcionarios = new ArrayList<>();
        protected static ArrayList<RecFisicos> recursos = new ArrayList<>();
    }

}
