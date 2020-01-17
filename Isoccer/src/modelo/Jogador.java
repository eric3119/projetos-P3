package modelo;

public class Jogador extends Funcionarios{
    private int tipo;
    private boolean apto;

    public Jogador(int cargo, String nome, String email, String cpf, double salario,
                   String telefone, int tipo, boolean apto) {
        super(cargo, nome, email, cpf, salario, telefone);
        this.tipo = tipo;
        this.apto = apto;
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
}
