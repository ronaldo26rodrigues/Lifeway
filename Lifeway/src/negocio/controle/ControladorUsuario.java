package negocio.controle;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import Excecoes.CPFInvalidoException;
import Excecoes.ElementoJaExisteException;
import Excecoes.UsuarioJaCadastradoException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Usuario;
import negocio.beans.ValidaCPF;


public class ControladorUsuario {

    private static ControladorUsuario instance;
    
    private IRepositorioGenerico<Usuario> repositorioUsuario;
    private Usuario usuarioLogado;

    
    ControladorUsuario() {
        this.repositorioUsuario = new RepositorioGenerico<>();
    }

    public static ControladorUsuario getInstance() {
        if(instance == null){
            instance = new ControladorUsuario();
        }
        return instance;
    }

    public void criarNovoUsuario(Usuario usuario) throws ElementoJaExisteException {
        repositorioUsuario.inserir(usuario);
    }

    public void excluirPerfil(Usuario usuario) throws ElementoJaExisteException {
        repositorioUsuario.remover(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return repositorioUsuario.listar();
    }

    public void login(Usuario usuario) {
        this.usuarioLogado = usuario;
    }
    
    /**
     * @return the usuarioLogado
     */
    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    /**
     * Método para cadastrar usuário e inserir no repositorioUsuario.
     * Verifica se o CPF é válido utilizando a classe ValidaCPF.
     * Chama o método gerarSenhaHex para guardar a senha do usuário
     * em formato hexadecimal.
     * @param usuario
     * @throws NoSuchAlgorithmException
     * @throws UsuarioJaCadastradoException
     * @throws CPFInvalidoException
     */
    public void cadastrarUsuario(Usuario usuario) throws 
        NoSuchAlgorithmException, UsuarioJaCadastradoException, CPFInvalidoException {
        
        if(usuario == null) return;

        String cpfUsuario = usuario.getIdentificacao();
        
        //verificar se CPF é válido
        //boolean cpfValido;
        if(!ValidaCPF.isCPF(cpfUsuario)) {
            //cpfValido = false;
            throw new CPFInvalidoException(cpfUsuario);
        } //else {
            //cpfValido = true;
        //}

        String senhaHex = gerarSenhaHex(usuario.getSenha());
        usuario.setSenha(senhaHex);

        //adicionar usuario ao repositorioUsuario
        try {
            this.repositorioUsuario.inserir(usuario);
        } catch(ElementoJaExisteException e) {
            throw new UsuarioJaCadastradoException(e);
        }
    }

    /**
     * Método para gerar um Hash para a senha do usuário (utilizando o algoritmo SHA-256)
     * e guardá-la em formato hexadecimal (senhaHex)
     * @param senha
     * @return senhaHex
     * @throws NoSuchAlgorithmException
     */
    public static String gerarSenhaHex(String senha) throws NoSuchAlgorithmException {

        //String senhaUsuario = usuario.getSenha();
        
        //gerar hash das senhas
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte senhaDigest[] = algoritmo.digest(senha.getBytes(StandardCharsets.UTF_8));

        //guardar senha em formato hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : senhaDigest) {
            hexString.append(String.format("%02X", 0xFF & b));            
        }

        String senhaHex = hexString.toString();
        //usuario.setSenha(senhaHex);
        return senhaHex;

    }

    //public boolean autenticarUsuario()
    //public String informacoesPessoais()?
    //public void alterarCadastro()

    /**
     * 
     * @return repositorioUsuario
     */
    public IRepositorioGenerico<Usuario> getRepositorioUsuario() {
        return repositorioUsuario;
    }
}

