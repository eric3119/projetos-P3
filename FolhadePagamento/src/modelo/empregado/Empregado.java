package modelo.empregado;

import modelo.Dados;

import java.util.ArrayList;
import java.util.Date;

public class Empregado {

    private int id;
    private String nome;
    private String endereco;
    private int tipoDeAgenda;
    private int diaPagamento;
    private double salario;

    private ArrayList<CartaodePonto> cartao = new ArrayList<>();
    private Agenda agenda = new Agenda(tipoDeAgenda, diaPagamento);
    private ArrayList<Venda> vendas = new ArrayList<>();
    private ArrayList<TaxaServico> taxas = new ArrayList<>();

    Empregado(String nome, String endereco, int tipoDeAgenda, int diaPagamento, double salario) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeAgenda = tipoDeAgenda;
        this.diaPagamento = diaPagamento;
        this.salario = salario;
        this.id = Dados.getInstance().novoId();
    }

    public int getId() {
        return id;
    }

    public void adicionarCartao(CartaodePonto novo){
        cartao.add(novo);
    }

    public void adicionarVenda(Venda novo){
        vendas.add(novo);
    }

    public void novaTaxa(TaxaServico taxaServico) {
        taxas.add(taxaServico);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\n", nome);
    }

    public String getNome() {
        return nome;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public int getTipoDeAgenda() {
        return tipoDeAgenda;
    }

    public void editarDados(String nome, String endereco, int tipoDeAgenda, int diaPagamento, double salario){
        if(!nome.equals("n"))
            this.nome = nome;
        if(!endereco.equals("n"))
            this.endereco = endereco;
        if(tipoDeAgenda>0)
            this.tipoDeAgenda = tipoDeAgenda;
        if(diaPagamento>0)
            this.diaPagamento = diaPagamento;
        if(salario>0)
            this.salario = salario;
    }
}