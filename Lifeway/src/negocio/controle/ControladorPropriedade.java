package negocio.controle;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ObjetoJaExisteException;
import negocio.beans.Propriedade;
import negocio.beans.Usuario;

public class ControladorPropriedade {

    private static ControladorPropriedade instance;
    
    private IRepositorioGenerico<Propriedade> repositorioPropriedade;

    
    ControladorPropriedade() {
        this.repositorioPropriedade = new RepositorioGenerico<>();
    }

    public static ControladorPropriedade getInstance() {
        if(instance == null){
            instance = new ControladorPropriedade();
        }
        return instance;
    }

    public void criarNovaPropriedade(Propriedade propriedade) throws ObjetoJaExisteException {
        repositorioPropriedade.inserir(propriedade);
    }

    public void excluirPropriedade(Propriedade propriedade) throws ObjetoJaExisteException {
        repositorioPropriedade.remover(propriedade);
    }

    public List<Propriedade> listarPropriedade() {
        return repositorioPropriedade.listar();
    }

    
    //throws CPFInvalidoException, PropriedadeJaCadastradaException
    public void cadastrarPropriedade(Propriedade propriedade) throws NoSuchAlgorithmException {
    if (propriedade == null) return; // >>> Tratar erros para GUI

    //verificar se CPF é válido
    //criar função para isso em cliente?

    //gerar hash das senhas

    //adicionar Propriedade ao repositorioCliente

}
}
