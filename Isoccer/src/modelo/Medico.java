package modelo;

public class Medico extends Funcionarios {
    private String CRM;

    public Medico(int cargo, String nome, String email, String cpf, double salario, String telefone, String CRM) {
        super(cargo, nome, email, cpf, salario, telefone);
        this.CRM = CRM;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("\nCRM: %s", this.CRM);
    }
}
