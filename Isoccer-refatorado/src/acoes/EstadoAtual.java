package acoes;

import modelo.*;
import modelo.Recursos.CT;
import modelo.Recursos.Estadio;
import modelo.Recursos.Onibus;

import java.util.ArrayList;

public class EstadoAtual {

    public static void estadoFunc(ArrayList<Funcionarios> funcionarios){

        System.out.println("Presidente");
        for (Funcionarios x: funcionarios) {
            if(x.getCargo() == 1){
                System.out.println(x);
                break;
            }
        }

        System.out.println("Time\n\nTreinadores\n");
        funcionariosLista(funcionarios, 3);

        System.out.println("\nJogadores\n");
        funcionariosLista(funcionarios, 2);

        System.out.println("\nServiços Gerais\n");
        for (int i = 4; i <= 8; i++) {
            funcionariosLista(funcionarios, i);
            System.out.println();
        }
    }

    public static void estadoRec(ArrayList<RecFisicos> recursos){
        System.out.println("Recursos Físicos");

        System.out.println("\nTransporte");

        boolean nExiste = true;

        for (RecFisicos x:recursos) {
            if(x instanceof Onibus){
                nExiste = false;
                System.out.println(x);
            }
        }
        if(nExiste)
            System.out.println("Não cadastrado");

        nExiste = true;

        System.out.println("\nCentro de treinamento");

        for (RecFisicos x:recursos) {
            if(x instanceof CT){
                nExiste = false;
                System.out.println(x);
            }
        }
        if(nExiste)
            System.out.println("Não cadastrado");

        System.out.println("\nEstádio");

        nExiste = true;

        for (RecFisicos x:recursos) {
            if(x instanceof Estadio){
                nExiste = false;
                System.out.println(x);
            }
        }
        if(nExiste)
            System.out.println("Não cadastrado");

    }

    public static void estadoSoc(ArrayList<Socio> socios){
        System.out.println("Socios\n");
        System.out.println("Quantidade: "+socios.size());

        int cont = 0;
        int cont2 = 0;
        for (Socio x : socios) {
            if(x.isAdimplente()) {
                cont++;
            }else{
                cont2++;
            }
        }

        System.out.println("Adimplentes: "+cont);

        System.out.println("Inadimplentes: "+cont2);

        System.out.println("\nLista\n");

        for (Socio x : socios) {
            System.out.println(x);
        }
    }

    private static void funcionariosLista(ArrayList<Funcionarios> lista, int cargo){

        if(lista == null || lista.size() == 0){
            System.out.println("Não Cadastrado");
            return;
        }

        int aux = 1;

        for (Funcionarios x : lista) {

            if(x.getCargo() == cargo) {
                System.out.println(x);
                aux = 0;
            }
        }
        if(aux == 1)
            System.out.println("Não Cadastrado");
    }
}
