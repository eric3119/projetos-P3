package acoes.Abstracoes;

import acoes.Implementacoes.DadosImpl;

public abstract class Operacoes {

    protected DadosImpl dados;

    public Operacoes(DadosImpl dados) {
        this.dados = dados;
    }

    public abstract void novoFunc(int cargo);
    public abstract void novoRecurso(int opcao);
    public abstract void novoSocio();
    public abstract boolean verifPresidente();
    public abstract void estado(int opcao);
}
