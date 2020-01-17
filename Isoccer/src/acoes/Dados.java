package acoes;

import modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Dados {

    private static Dados dado = new Dados();
    private Dados() {}
    public static Dados getInstance(){
        return dado;
    }

    private ArrayList<Socio> socios = new ArrayList<>();
    private ArrayList<Funcionarios> funcionarios = new ArrayList<>();
    private ArrayList<RecFisicos> recursos = new ArrayList<>();

    public void salvarNovoFunc(Funcionarios novo){

        if(novo.getCargo() == 1 && existePresidente()) {
            for (int i = 0; i < funcionarios.size(); i++) {
                if (funcionarios.get(i).getCargo() == 1)
                    funcionarios.remove(i);
            }
        }

        funcionarios.add(novo);
    }

    public void salvarNovoSocio(Socio novo) {
        socios.add(novo);
    }

    public void salvarNovoOnibus(Onibus novo){
        recursos.add(novo);
    }

    public void salvarNovoEstadio(Estadio novo){
        recursos.add(novo);
    }

    public void salvarNovoCt(CT novo){
        recursos.add(novo);
    }

    public boolean existePresidente(){

        for (Funcionarios x: funcionarios) {
            if(x.getCargo() == 1)
                return true;
        }
        return false;
    }

    public void mostrarStatus(int opcao){

        switch (opcao){
            case 1:
                EstadoAtual.estadoFunc(funcionarios);
                break;
            case 2:
                EstadoAtual.estadoRec(recursos);
                break;
            case 3:
                EstadoAtual.estadoSoc(socios);
                break;
            case 4:
                EstadoAtual.estadoFunc(funcionarios);
                EstadoAtual.estadoRec(recursos);
                EstadoAtual.estadoSoc(socios);
        }

    }
}
