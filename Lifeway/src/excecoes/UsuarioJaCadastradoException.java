package excecoes;


import negocio.beans.Usuario;

public class UsuarioJaCadastradoException extends Exception {
    
    private Usuario usuario;
    private ElementoJaExisteException e;

    public UsuarioJaCadastradoException(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException();
        }
        this.usuario = usuario;
    }

    public UsuarioJaCadastradoException(ElementoJaExisteException e) {
        if (e == null) {
            throw new IllegalArgumentException();
        }
        this.e = e;
    }

    @Override
    public String getMessage(){
        String mensagem = "Usuário já cadastrado no sistema.";
        if(this.usuario != null) {
            mensagem = String.format("O CPF %s já está cadastrado." , usuario.getIdentificacao());
        }
        return mensagem;
    }
}
