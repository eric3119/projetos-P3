package modelo.Funcionario;

import acoes.Erros;
import modelo.Funcionarios;

public class Motorista extends Funcionarios {

    private String cnh;

    public Motorista(MotoristaBuilder builder) {
        super(builder);
        this.cnh = builder.cnh;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("\nCNH: %s", this.cnh);
    }

    public static class MotoristaBuilder extends FuncionariosBuilder{
        private String cnh;

        public MotoristaBuilder setCnh(String cnh) {
            this.cnh = cnh;
            return this;
        }

        public Motorista build(){
            super.setAll(5);

            System.out.printf("\nCNH: ");

            this.setCnh(Erros.entradaString());

            return new Motorista(this);
        }

    }
}
