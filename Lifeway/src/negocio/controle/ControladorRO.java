package negocio.controle;

import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ElementoJaExisteException;
//import jdk.vm.ci.code.RegisterAttributes;
import negocio.beans.RegistroDeOcorrencia;

public class ControladorRO {

    private static ControladorRO instance;
    

    private IRepositorioGenerico<RegistroDeOcorrencia> repositorioRO;

    private ControladorRO() {
        repositorioRO = new RepositorioGenerico<>();
    }

    public static ControladorRO getInstance() {
        if(instance == null) {
            instance = new ControladorRO();
        }
        return instance;
    }

    public void criarNovaOcorrencia(RegistroDeOcorrencia registroDeOcorrencia) throws ElementoJaExisteException {
        repositorioRO.inserir(registroDeOcorrencia);
    }
    public void excluirOcorrencia(RegistroDeOcorrencia registroDeOcorrencia) throws ElementoJaExisteException {
        repositorioRO.remover(registroDeOcorrencia);
    }

    public List<RegistroDeOcorrencia> listarROcorrencias() {
        return repositorioRO.listar();
    }
        

    
}



