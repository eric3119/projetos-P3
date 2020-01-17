package modelo.empregado;

public class CartaodePonto{
    private String chegada;
    private String saida;

    public CartaodePonto(String chegada, String saida) {
        this.chegada = chegada;
        this.saida = saida;
    }

    public String getChegada() {
        return chegada;
    }

    public String getSaida() {
        return saida;
    }
}
