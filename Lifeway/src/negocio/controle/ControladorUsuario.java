package negocio.controle;

import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ObjetoJaExisteException;
import negocio.beans.Usuario;

public class ControladorUsuario {

    private static ControladorUsuario instance;
    
    private IRepositorioGenerico<Usuario> repositorioUsuario;

    
    ControladorUsuario() {
        this.repositorioUsuario = new RepositorioGenerico<>();
    }

    public ControladorUsuario getInstance() {
        if(instance == null){
            instance = new ControladorUsuario();
        }
        return instance;
    }

    public void criarNovoUsuario(Usuario usuario) throws ObjetoJaExisteException {
        repositorioUsuario.inserir(usuario);
    }

    public void excluirPerfil(Usuario usuario) throws ObjetoJaExisteException {
        repositorioUsuario.remover(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repositorioUsuario.listar();
    }
}
