package negocio;

import java.util.List;

import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import excecoes.ObjetoNaoExisteException;
import negocio.beans.Consumidor;

public class ControladorConsumidores {
    
    private IRepositorioGenerico<Consumidor> repositorioConsumidores;
    private static ControladorConsumidores instance;

    private ControladorConsumidores() {
        this.repositorioConsumidores = new RepositorioGenerico<>();
    }

    public ControladorConsumidores getInstance() {
        if (instance == null) {
            instance = new ControladorConsumidores();
        }
        return instance;
    }

    public List<Consumidor> listar() {
        return repositorioConsumidores;
    }

    public void remover(Consumidor obj) throws ObjetoNaoExisteException {
        //TODO
    }
}
