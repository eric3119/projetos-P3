package acoes.Implementacoes;

import modelo.Funcionarios;
import modelo.RecFisicos;
import modelo.Socio;

public abstract class DadosImpl {

    public abstract void salvarNovoFunc(Funcionarios novo);
    public abstract void salvarNovoRecurso(RecFisicos novo);
    public abstract void salvarNovoSocio(Socio novo);
    public abstract boolean existePresidente();
    public abstract void mostrarStatus(int opcao);
}
