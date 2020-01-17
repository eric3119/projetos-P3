package modelo;

public class Funcionarios {

    private int cargo;
    private String nome;
    private String email;
    private String cpf;
    private double salario;
    private String telefone;

    public Funcionarios(int cargo, String nome, String email, String cpf, double salario, String telefone) {
        this.cargo = cargo;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.salario = salario;
        this.telefone = telefone;
    }

    public int getCargo() {
        return cargo;
    }

    @Override
    public String toString() {

        return String.format("\nNome: %s" +
                                    "\nEmail: %s"+
                                    "\nCPF: %s"+
                                    "\nTel: %s"+
                                    "\nSalário: %f",
                                    this.nome, this.email, this.cpf, this.telefone, this.salario);
    }
}