package negocio.controle;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.CPFInvalidoException;
import excecoes.ElementoJaExisteException;
import excecoes.UsuarioJaCadastradoException;
import negocio.beans.Usuario;
import negocio.beans.ValidaCPF;


public class ControladorUsuario {

    private static ControladorUsuario instance;
    
    private IRepositorioGenerico<Usuario> repositorioUsuario;

    
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

    
    
    /**
     * Método para cadastrar usuário e inserir no repositorioUsuario.
     * Verifica se o CPF é válido utilizando a classe ValidaCPF.
     * Gera um Hash para a senha do usuário (utilizando o algoritmo SHA-256) 
     * e guarda em formato hexadecimal.
     * @param usuario
     * @throws NoSuchAlgorithmException
     * @throws UsuarioJaCadastradoException
     * @throws CPFInvalidoException
     */
    public void cadastrarUsuario(Usuario usuario) throws 
        NoSuchAlgorithmException, UsuarioJaCadastradoException, CPFInvalidoException {
        
        if(usuario == null) return;

        String cpfUsuario = usuario.getIdentificacao();
        String senhaUsuario = usuario.getSenha();

        
        //verificar se CPF é válido
        if(!ValidaCPF.isCPF(cpfUsuario)) {
            throw new CPFInvalidoException(cpfUsuario);
        }

        //gerar hash das senhas
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte senhaDigest[] = algoritmo.digest(senhaUsuario.getBytes(StandardCharsets.UTF_8));

        //guardar senha em formato hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : senhaDigest) {
            hexString.append(String.format("%02X", 0xFF & b));            
        }

        String senhaHex = hexString.toString();
        usuario.setSenha(senhaHex);


        //adicionar usuario ao repositorioUsuario
        try {
            this.repositorioUsuario.inserir(usuario);
        } catch(ElementoJaExisteException e) {
            throw new UsuarioJaCadastradoException(e);
        }
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

