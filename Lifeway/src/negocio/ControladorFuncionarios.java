package negocio;

import java.util.List;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ObjetoNaoExisteException;
import negocio.beans.Funcionario;

public class ControladorFuncionarios {
    
    private IRepositorioGenerico<Funcionario> repositorioFuncionarios;
    private static ControladorFuncionarios instance;

    private ControladorFuncionarios() {
        this.repositorioFuncionarios = new RepositorioGenerico<>();
    }


        public ControladorFuncionarios getInstance() {
        if (instance == null) {
            instance = new ControladorFuncionarios();
        }
        return instance;
    }
    

    public List<Funcionario> listar() {
        return repositorioFuncionarios.listar();
    }

    public void remover(Funcionario obj) throws ObjetoNaoExisteException {
        //TODO
    }

}
