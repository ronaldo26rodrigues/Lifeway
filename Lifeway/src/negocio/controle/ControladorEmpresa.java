package negocio.controle;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ElementoJaExisteException;
import negocio.beans.Empresa;
import negocio.beans.Usuario;

public class ControladorEmpresa {

    private static ControladorEmpresa instance;
    
    private IRepositorioGenerico<Empresa> repositorioEmpresa;

    
    ControladorEmpresa() {
        this.repositorioEmpresa = new RepositorioGenerico<>();
    }

    public ControladorEmpresa getInstance() {
        if(instance == null){
            instance = new ControladorEmpresa();
        }
        return instance;
    }

    public void criarNovaEmpresa(Empresa empresa) throws ObjetoJaExisteException {
        repositorioEmpresa.inserir(empresa);
    }

    public void excluirEmpresa(Empresa empresa) throws ObjetoJaExisteException {
        repositorioEmpresa.remover(empresa);
    }

    public List<Empresa> listarEmpresas() {
        return repositorioEmpresa.listar();
    }

    
    //throws CPFInvalidoException, ClienteJaCadastradoException
    public void cadastrarEmpresa(Empresa empresa) throws NoSuchAlgorithmException {
    if (empresa == null) return; // >>> Tratar erros para GUI


}
}
