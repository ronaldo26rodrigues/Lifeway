package negocio.controle;

import java.util.List;

import excecoes.ElementoJaExisteException;
import negocio.beans.Usuario;

public class Fachada {
    
    
    private static Fachada instance;

    private static ControladorUsuario controladorUsuario;
    

    private Fachada() {
        controladorUsuario = ControladorUsuario.getInstance();
    }

    public static Fachada getInstance() {
        if(instance == null) {
            instance = new Fachada();
        }
        return instance;
    } 

    public void criarNovoUsuario(Usuario usuario) throws ElementoJaExisteException {
        controladorUsuario.criarNovoUsuario(usuario);
    }

    public void excluirPerfil(Usuario usuario) throws ElementoJaExisteException {
        controladorUsuario.excluirPerfil(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return controladorUsuario.listarUsuarios();
    }

    public void login(Usuario usuario) {
        controladorUsuario.login(usuario);
    }
    
    /**
     * @return the usuarioLogado
     */
    public Usuario getUsuarioLogado() {
        return controladorUsuario.getUsuarioLogado();
    }

}
