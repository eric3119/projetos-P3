package modelo.Recursos;

import modelo.RecFisicos;

public class Estadio extends RecFisicos {

    private String nome;
    private int nTorc;
    private int nBanh;
    private int nLanc;

    public Estadio(boolean disp, String nome, int nTorc, int nBanh, int nLanc) {
        super(disp);
        this.nome = nome;
        this.nTorc = nTorc;
        this.nBanh = nBanh;
        this.nLanc = nLanc;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("\nNome: %s" +
                                                "\nCapacidade: %d torcedores" +
                                                "\nQuantidade de banheiros: %d" +
                                                "\nQuantidade de lanchonetes: %d", nome, nTorc, nBanh, nLanc);
    }
}
