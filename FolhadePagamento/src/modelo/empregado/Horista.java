package modelo.empregado;

public class Horista extends Empregado{
    public Horista(String nome, String endereco, int tipoDeAgenda, int diaPagamento, double salario) {
        super(nome, endereco, tipoDeAgenda, diaPagamento, salario);
    }

    public int getPagamento(){

        return 0;
    }
}
