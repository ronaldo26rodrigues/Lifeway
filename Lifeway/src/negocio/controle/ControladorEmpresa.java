package negocio.controle;

import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ObjetoJaExisteException;
import negocio.beans.Empresa;

public class ControladorEmpresa {
    

    private static ControladorEmpresa instance;

    private IRepositorioGenerico<Empresa> repositorioEmpresa;

    ControladorEmpresa() {
        this.repositorioEmpresa = new RepositorioGenerico<>();
    }

    public ControladorEmpresa getInstance() {
        if(instance == null) {
            instance = new ControladorEmpresa();
        }
        return instance;
    }

    public void criarNovaEmpresa(Empresa empresa) throws ObjetoJaExisteException {
        repositorioEmpresa.inserir(empresa);
    }

    public void excluirEmpresa(Empresa empresa) {
        repositorioEmpresa.remover(empresa);
    }

    public List<Empresa> listarEmpresas() {
        return repositorioEmpresa.listar();
    }

}
