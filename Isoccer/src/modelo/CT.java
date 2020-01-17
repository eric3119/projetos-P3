package modelo;

public class CT extends RecFisicos {

    private String nome;
    private int nDorm;

    public CT(boolean disp,String nome, int nDorm) {
        super(disp);
        this.nome = nome;
        this.nDorm = nDorm;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("\nNome: %s" +
                                                "\nQuantidade de dormitórios: %d", nome, nDorm);
    }
}
