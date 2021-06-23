package negocio.controle;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    
    //throws CPFInvalidoException, ClienteJaCadastradoException
    public void cadastrarUsuario(Usuario usuario, String senhaUsuario) throws NoSuchAlgorithmException {
    if (usuario == null || senhaUsuario == null) return; // >>> Tratar erros para GUI

    //verificar se CPF é válido
    //criar função para isso em cliente?

    //gerar hash das senhas
    MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
    byte senhaDigest[] = algoritmo.digest(senhaUsuario.getBytes(StandardCharsets.UTF_8));

    //guardar em formato hexadecimal
    StringBuilder hexString = new StringBuilder();
    for (byte b : senhaDigest) {
        hexString.append(String.format("%02X", 0xFF & b));            
    }

    String senhaHex = hexString.toString();
    usuario.setSenha(senhaHex);


    //adicionar cliente ao repositorioCliente

}
}
