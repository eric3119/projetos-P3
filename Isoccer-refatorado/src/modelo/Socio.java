package modelo;

public class Socio {

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String endereco;
    private double valContr;
    private boolean adimplente;
    private int tipo;

    //{ JUNIOR, SENIOR, ELITE }

    public Socio(String nome, String email, String cpf, String telefone,
                 String endereco, double valContr, boolean adimplente, int tipo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.valContr = valContr;
        this.tipo = tipo;
        this.adimplente = adimplente;
    }

    public boolean isAdimplente() {
        return adimplente;
    }

    @Override
    public String toString() {
        return String.format("\nNome: "+nome+
                "\nEmail: "+email+
                "\nCPF: "+cpf+
                "\nTelefone: "+telefone+
                "\nEndereço: "+endereco+
                "\nValor de contribuição: "+valContr+
                ((adimplente)?"\nAdimplente":"\nInadimplente"));
    }
}
