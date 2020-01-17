package modelo.Funcionario;

import acoes.Erros;
import modelo.Funcionarios;

public class Jogador extends Funcionarios {
    private int tipo;
    private boolean apto;

    public Jogador(JogadorBuilder builder) {
        super(builder);
        this.apto = builder.apto;
        this.tipo = builder.tipo;
    }

    private String getTipo() {
        switch (tipo){
            case 1:
                return "Volante";
            case 2:
                return "Zagueiro";
            case 3:
                return "Meia";
            case 4:
                return "Goleiro";
            case 5:
                return "Atacante";
            case 6:
                return "Lateral Esquerdo";
            case 7:
                return "Lateral Direito";
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return super.toString()+String.format("\nTipo: %s\n%s", getTipo(), (apto)? "Apto":"Departamento Médico");
    }

    public static class JogadorBuilder extends FuncionariosBuilder{

        private int tipo;
        private boolean apto;

        public JogadorBuilder setTipo(int tipo) {
            this.tipo = tipo;
            return this;
        }

        public JogadorBuilder setApto(boolean apto) {
            this.apto = apto;
            return this;
        }

        public Jogador build(){
            super.setAll(2);
            System.out.printf("\nTipo: "+
                                "\n1-Volante"+
                                "\n2-Zagueiro"+
                                "\n3-Meia"+
                                "\n4-Goleiro"+
                                "\n5-Atacante"+
                                "\n6-Lateral Esquerdo"+
                                "\n7-Lateral Direito\n");

            this.setTipo(Erros.entradaInt());

            System.out.println("\nApto (S/N): ");

            this.setApto(Erros.entradaString().equals("S"));

            return new Jogador(this);
        }
    }
}
