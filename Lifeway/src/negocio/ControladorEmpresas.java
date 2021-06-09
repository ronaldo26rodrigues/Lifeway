package negocio;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ObjetoJaExisteException;
import negocio.beans.Empresa;

public class ControladorEmpresas {
    
    private IRepositorioGenerico<Empresa> repositorioEmpresas;
    private static ControladorEmpresas instance;

    private ControladorEmpresas() {
        this.repositorioEmpresas = new RepositorioGenerico<>();
    }

    public ControladorEmpresas getInstance() {
        if(instance == null) {
            instance = new ControladorEmpresas();
        }

        return instance;
    }

    //@Override
    public void inserir(Empresa obj) throws ObjetoJaExisteException {
        repositorioEmpresas.inserir(obj);
    }

    //@Override
    //public void remover(Empresa obj) throws ObjetoNaoExisteException {

    //}

    public void criarFuncionario()


}
