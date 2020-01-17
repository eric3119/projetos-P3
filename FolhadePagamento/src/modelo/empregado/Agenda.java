package modelo.empregado;

import modelo.Pagamento;

public class Agenda{
    private int tipo;
    private int dia;

    Agenda(int tipo, int dia) {
        this.tipo = tipo;
        this.dia = dia;
    }

    public void pagar(){

        switch (tipo){
            case 1:
                Pagamento.horista();
                break;
            case 2:
                Pagamento.mensal();
                break;
            case 3:
                Pagamento.comissionado();
        }
    }
}
