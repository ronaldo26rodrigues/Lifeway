package negocio.controle;

import java.time.LocalDate;
import java.util.List;

import Excecoes.ElementoJaExisteException;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.RegistroDeOcorrencia;
import negocio.beans.Usuario;

public class Fachada {
    
    
    private static Fachada instance;

    private static ControladorUsuario controladorUsuario;
    private static ControladorRO controladorRO;
    private static ControladorPropriedade controladorPropriedade;
    

    private Fachada() {
        controladorUsuario = ControladorUsuario.getInstance();
        controladorRO = ControladorRO.getInstance();
        controladorPropriedade = ControladorPropriedade.getInstance();
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

    public void criarNovaOcorrencia(String assunto, String mensagem, Empresa empresa, Usuario cliente, LocalDate data, Endereco endereco) {
        controladorRO.criarNovaOcorrencia(assunto, mensagem, empresa, cliente, data, endereco);
    }


    public void resolverOcorrencia(RegistroDeOcorrencia ocorrencia) {
        controladorRO.resolverOcorrencia(ocorrencia);
    }


    public void criarNovaOcorrencia(RegistroDeOcorrencia registroDeOcorrencia) throws ElementoJaExisteException {
        controladorRO.criarNovaOcorrencia(registroDeOcorrencia);
    }


    public void excluirOcorrencia(RegistroDeOcorrencia registroDeOcorrencia) throws ElementoJaExisteException {
        controladorRO.excluirOcorrencia(registroDeOcorrencia);
    }

        
    public List<RegistroDeOcorrencia> listarROcorrencias() {
        return controladorRO.listarROcorrencias();
    }

    
 
}
