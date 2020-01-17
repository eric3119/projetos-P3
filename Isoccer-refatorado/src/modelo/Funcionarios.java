package modelo;

import acoes.Erros;

public class Funcionarios {

    private int cargo;
    private String nome;
    private String email;
    private String cpf;
    private double salario;
    private String telefone;

    public Funcionarios(FuncionariosBuilder builder){
        this.cargo = builder.cargo;
        this.nome = builder.nome;
        this.email = builder.email;
        this.cpf = builder.cpf;
        this.salario = builder.salario;
        this.telefone = builder.telefone;
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

    public static class FuncionariosBuilder{

        private int cargo;
        private String nome;
        private String email;
        private String cpf;
        private double salario;
        private String telefone;

        public FuncionariosBuilder setAll(int cargo){
            this.setCargo(cargo);

            System.out.printf("\nNome: ");
            this.setNome(Erros.entradaString());

            System.out.printf("\nEmail: ");
            this.setEmail(Erros.entradaString());

            System.out.printf("\nCPF: ");
            this.setCpf(Erros.entradaString());

            System.out.printf("\nSalario: ");
            this.setSalario(Erros.entradaDouble());

            System.out.printf("\nTelefone: ");
            this.setTelefone(Erros.entradaString());

            return this;
        }
        public FuncionariosBuilder setCargo(int cargo) {
            this.cargo = cargo;
            return this;
        }

        public FuncionariosBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public FuncionariosBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public FuncionariosBuilder setCpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public FuncionariosBuilder setSalario(double salario) {
            this.salario = salario;
            return this;
        }

        public FuncionariosBuilder setTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Funcionarios build(int cargo){

            setAll(cargo);

            return new Funcionarios(this);
        }

    }
}