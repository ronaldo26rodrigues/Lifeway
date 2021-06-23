package negocio.controle;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ElementoJaExisteException;
import excecoes.PropriedadeJaCadastrada;
import negocio.beans.Propriedade;


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

    public void criarNovaPropriedade(Propriedade propriedade) throws ElementoJaExisteException {
        repositorioPropriedade.inserir(propriedade);
    }

    public void excluirPropriedade(Propriedade propriedade) throws ElementoJaExisteException {
        repositorioPropriedade.remover(propriedade);
    }

    public List<Propriedade> listarPropriedade() {
        return repositorioPropriedade.listar();
    }

    /**
     * Método para cadastrar propriedade no perfil do usuário cliente.
     * @param propriedade
     * @throws NoSuchAlgorithmException
     * @throws PropriedadeJaCadastrada
     */
    public void cadastrarPropriedade(Propriedade propriedade) throws NoSuchAlgorithmException, PropriedadeJaCadastrada {
        if (propriedade == null) return; // >>> Tratar erros para GUI

        //adicionar propriedade ao repositorioPropriedade
        try {
            this.repositorioPropriedade.inserir(propriedade);
            } catch(ElementoJaExisteException e) {
                throw new PropriedadeJaCadastrada(e);
        }
    }
}
