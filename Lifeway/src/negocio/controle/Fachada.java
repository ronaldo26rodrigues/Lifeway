package negocio.controle;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import excecoes.ElementoJaExisteException;
import excecoes.ElementoNaoExisteException;
import excecoes.PropriedadeJaCadastradaException;
import negocio.beans.Empresa;
import negocio.beans.Endereco;
import negocio.beans.Propriedade;
import negocio.beans.RegistroDeOcorrencia;
import negocio.beans.Usuario;

public class Fachada {

    private static Fachada instance;

    private static ControladorUsuario controladorUsuario;
    private static ControladorRO controladorRO;
    private static ControladorPropriedade controladorPropriedade;
    private static ControladorEmpresa controladorEmpresa;

    private Fachada() {
        controladorEmpresa = ControladorEmpresa.getInstance();
        controladorUsuario = ControladorUsuario.getInstance();
        controladorRO = ControladorRO.getInstance();
        controladorPropriedade = ControladorPropriedade.getInstance();
    }

    public static Fachada getInstance() {
        if (instance == null) {
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

    public void criarNovaOcorrencia(String assunto, String mensagem, Empresa empresa, Usuario cliente, LocalDate data,
            Endereco endereco) {
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

    public void excluirPropriedade(Propriedade propriedade) throws ElementoJaExisteException {
        controladorPropriedade.excluirPropriedade(propriedade);
        ;
    }

    public List<Propriedade> listarPropriedade() {
        return controladorPropriedade.listarPropriedade();
    }

    public void cadastrarPropriedade(Propriedade propriedade)
            throws NoSuchAlgorithmException, PropriedadeJaCadastradaException {
        controladorPropriedade.cadastrarPropriedade(propriedade);
    }

    public void criarNovaEmpresa(Empresa empresa) throws ElementoJaExisteException {
        controladorEmpresa.criarNovaEmpresa(empresa);
    }

    public void excluirEmpresa(Empresa empresa) throws ElementoNaoExisteException {
        controladorEmpresa.excluirEmpresa(empresa);
    }

    public List<Empresa> listarEmpresas() {
        return controladorEmpresa.listarEmpresas();
    }

}
