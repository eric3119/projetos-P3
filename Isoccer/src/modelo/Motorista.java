package modelo;

public class Motorista extends Funcionarios{

    private String cnh;

    public Motorista(int cargo, String nome, String email, String cpf, double salario, String telefone, String cnh) {
        super(cargo, nome, email, cpf, salario, telefone);
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("\nCNH: %s", this.cnh);
    }
}
