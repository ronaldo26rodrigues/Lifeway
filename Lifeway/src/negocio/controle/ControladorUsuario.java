package negocio.controle;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import excecoes.IDInvalidoException;
import excecoes.ElementoJaExisteException;
import excecoes.UsuarioJaCadastradoException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import negocio.beans.Usuario;
import negocio.beans.ValidaCPF;

public class ControladorUsuario {

    private static ControladorUsuario instance;

    private IRepositorioGenerico<Usuario> repositorioUsuario;
    private Usuario usuarioLogado;

    ControladorUsuario() {
        this.repositorioUsuario = new RepositorioGenerico<>("usuarios.dat");
    }

    public static ControladorUsuario getInstance() {
        if (instance == null) {
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

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    /**
     * Método para cadastrar usuário e inserir no repositorioUsuario. Verifica se o
     * CPF é válido utilizando a classe ValidaCPF. Chama o método gerarSenhaHex para
     * guardar a senha do usuário em formato hexadecimal.
     * 
     * @param usuario
     * @throws NoSuchAlgorithmException
     * @throws UsuarioJaCadastradoException
     * @throws IDInvalidoException
     */
    public void cadastrarUsuario(Usuario usuario)
<<<<<<< HEAD
            throws NoSuchAlgorithmException, UsuarioJaCadastradoException, IDInvalidoException, MenorDeIdadeException {
=======
            throws NoSuchAlgorithmException, UsuarioJaCadastradoException, IDInvalidoException {
>>>>>>> parent of b0d172b (IdadeInvalida)

        if (usuario == null)
            return;

        if (maiorDeDeizoto(usuario.getDataDeNascimeto()) == false) {
            throw new MenorDeIdadeException();
        }

        String cpfUsuario = usuario.getIdentificacao();

        // verificar se CPF é válido
        if (!ValidaCPF.isCPF(cpfUsuario)) {
            throw new IDInvalidoException(cpfUsuario);
        }

        String senhaHex = gerarSenhaHex(usuario.getSenha());
        usuario.setSenha(senhaHex);

        // adicionar usuario ao repositorioUsuario
        try {
            this.repositorioUsuario.inserir(usuario);
        } catch (ElementoJaExisteException e) {
            throw new UsuarioJaCadastradoException(e);

        }
    }

<<<<<<< HEAD
    private boolean maiorDeDeizoto(LocalDate dataNascimento) {
        long idade = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());

        boolean maiorDeDezoito = false;
        if (idade >= 18)
            maiorDeDezoito = true;
        return maiorDeDezoito;
    }

=======
>>>>>>> parent of b0d172b (IdadeInvalida)
    /**
     * Método para gerar um Hash para a senha do usuário (utilizando o algoritmo
     * SHA-256) e guardá-la em formato hexadecimal (senhaHex)
     * 
     * @param senha
     * @return senhaHex
     * @throws NoSuchAlgorithmException
     */
    public static String gerarSenhaHex(String senha) throws NoSuchAlgorithmException {

        // gerar hash da senha
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        byte senhaDigest[] = algoritmo.digest(senha.getBytes(StandardCharsets.UTF_8));

        // guardar senha em formato hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : senhaDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }

        String senhaHex = hexString.toString();
        return senhaHex;

    }

    public IRepositorioGenerico<Usuario> getRepositorioUsuario() {
        return repositorioUsuario;
    }
}
