package modelo.empregado;

public class TaxaServico {
    private String nome;
    private double taxa;

    public TaxaServico(String nome, double taxa) {
        this.nome = nome;
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }

    public String getNome() {
        return nome;
    }
}
