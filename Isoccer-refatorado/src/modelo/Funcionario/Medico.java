package modelo.Funcionario;

import acoes.Erros;
import modelo.Funcionarios;

public class Medico extends Funcionarios {
    private String CRM;

    public Medico(MedicoBuilder builder) {
        super(builder);
        this.CRM = builder.CRM;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("\nCRM: %s", this.CRM);
    }

    public static class MedicoBuilder extends FuncionariosBuilder{
        private String CRM;

        public MedicoBuilder setCRM(String CRM) {
            this.CRM = CRM;
            return this;
        }

        public Medico build(){

            super.setAll(8);

            System.out.printf("\nCRM: ");
            this.setCRM(Erros.entradaString());

            return new Medico(this);
        }
    }
}
