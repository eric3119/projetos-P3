package modelo.empregado;

public class Comissionado extends Empregado{

    private double comissao;

    public Comissionado(String nome, String endereco, int tipoDeAgenda, int diaPagamento, double salario, double comissao) {
        super(nome, endereco, tipoDeAgenda, diaPagamento, salario);
        this.comissao = comissao;
    }
}
