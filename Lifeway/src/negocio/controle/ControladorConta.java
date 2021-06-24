package negocio.controle;

import java.util.List;

import Excecoes.ElementoJaExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Conta;

public class ControladorConta {

    private static ControladorConta instance;
    
    private IRepositorioGenerico<Conta> repositorioContas;

    
    ControladorConta() {
        this.repositorioContas = new RepositorioGenerico<>();
    }

    public ControladorConta getInstance() {
        if(instance == null){
            instance = new ControladorConta();
        }
        return instance;
    }

    public void criarNovaConta(Conta conta) throws ElementoJaExisteException {
        repositorioContas.inserir(conta);
    }

    public void excluirConta(Conta conta) throws ElementoJaExisteException {
        repositorioContas.remover(conta);
    }

    public List<Conta> listarContas() {
        return repositorioContas.listar();
    }

    //Método para gerar histórico de contas?
    //Gerar conta

    
}
